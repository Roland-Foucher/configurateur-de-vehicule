import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SmallVehicleDTO } from 'src/app/models/SmallVehicleDTO.models';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.scss']
})
export class VehiclesComponent implements OnInit {

  vehicles$!: Observable<SmallVehicleDTO[]>;

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.vehicles$ = this.vehicleService.getAllVehicle();
  }

}
