import { Component, Input, OnInit } from '@angular/core';
import { SmallVehicleDTO } from 'src/app/models/SmallVehicleDTO.models';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-vehicle-card',
  templateUrl: './vehicle-card.component.html',
  styleUrls: ['./vehicle-card.component.scss']
})
export class VehicleCardComponent implements OnInit {

  @Input()
  vehicle!: SmallVehicleDTO;

  imageSource!: String;

  constructor( private vehicleService: VehicleService) { }

  ngOnInit(): void {

    this.imageSource = this.vehicleService.selectImageUrl(this.vehicle);
  }

  delete(){
    if (confirm('Are you sure you want to delete this car?')) {
      this.vehicleService.deleteVehicle(this.vehicle.id);
    }
  }

}
