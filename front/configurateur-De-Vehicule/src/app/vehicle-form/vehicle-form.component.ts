import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ImageUrl } from '../enum/ImageUrl';
import { VehicleDto } from '../models/VehicleDto.models';
import { FormBuilderService } from '../service/formBuilder.service';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.scss']
})
export class VehicleFormComponent implements OnInit {

  vehicleForm!: FormGroup;
  vehicleType!: string;
  vehicleDto!: VehicleDto;

  constructor(private route: ActivatedRoute, private formBuilderService: FormBuilderService) {}

  ngOnInit(): void {
    this.vehicleType = this.route.snapshot.params['type'];
    this.initForm()
  }

  initForm(){

    console.log(this.vehicleType === 'car' || 'moto')
    if (this.vehicleDto == null){
      this.vehicleDto = new VehicleDto();
    }

      this.vehicleForm = this.formBuilderService.buildFormFactory(this.vehicleType, this.vehicleDto);
      console.log(this.vehicleForm);
  }

  onSubmitForm(){

    const formValue = this.vehicleForm.value;
    console.log(formValue);
  }

  vehicleTypeCar() {
    return this.vehicleType === 'car';
  }
  vehicleTypeBike() {
    return this.vehicleType === 'bike';
  }
  vehicleTypeMoto() {
    return this.vehicleType === 'moto';
  }

}
