import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Door } from '../enum/Door';
import { GearBox } from '../enum/GearBox';
import { ImageUrl } from '../enum/ImageUrl';
import { VehicleType } from '../enum/VehicleType';
import { VehicleDto } from '../models/VehicleDto.models';
import { FormBuilderService } from '../service/formBuilder.service';
import { VehicleService } from '../service/vehicle.service';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.scss']
})
export class VehicleFormComponent implements OnInit {

  vehicleForm!: FormGroup;
  vehicleType: any;
  vehicleId: any;

  gearBoxes: any;
  doors: any;
  bikeTypes: any;
  carTypes: any;
  motoTypes: any;

  errors!: string;

  constructor(
    private route: ActivatedRoute,
    private formBuilderService: FormBuilderService,
    private vehicleService: VehicleService,
    private router: Router) {
      this.doors = formBuilderService.doors;
      this.gearBoxes = formBuilderService.gearBoxes;
      this.bikeTypes = formBuilderService.bikeTypes;
      this.carTypes = formBuilderService.carTypes;
      this.motoTypes = formBuilderService.motoTypes;
    }

  ngOnInit(): void {
    this.vehicleType = this.route.snapshot.params['type'];
    this.route.paramMap.subscribe( result => {
      this.vehicleId = result.has('id') ? result.get('id') : null;
      this.vehicleType = result.get("type");
    }

    )
    this.initForm()
  }

  initForm(): void{
      console.log(this.vehicleType);
      this.vehicleForm = this.formBuilderService.buildVehicle(this.vehicleType);
      this.implementForm();
  }

  onSubmitForm(): void{
    if(this.vehicleForm.valid){
      const vehicleDto: VehicleDto = this.vehicleForm.value;
      vehicleDto.vehiculeType = this.vehicleService.vehicleTypeFactory(this.vehicleType);

      if (this.vehicleId != null){
        vehicleDto.id = this.vehicleId;
      }
      this.vehicleService.saveVehicle(this.vehicleForm.value)
      this.router.navigate(['/'])
    }
  }

  implementForm() : void{
    if (this.vehicleId != null) {
      this.vehicleService.getVehicleById(this.vehicleId)
        .subscribe(el => this.vehicleForm.patchValue(el));
    }
  }

  get f() { return this.vehicleForm.controls; }
}
