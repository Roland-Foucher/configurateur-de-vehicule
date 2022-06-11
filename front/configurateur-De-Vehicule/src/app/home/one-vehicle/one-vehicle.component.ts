import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { VehicleDto } from 'src/app/models/VehicleDto.models';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-one-vehicle',
  templateUrl: './one-vehicle.component.html',
  styleUrls: ['./one-vehicle.component.scss']
})
export class OneVehicleComponent implements OnInit {

  imageSource!:string;

  vehicle$!: Observable<VehicleDto>;

  constructor(private vehicleService: VehicleService, private route:ActivatedRoute) { }

  ngOnInit(): void {

    const id: number = Number(this.route.snapshot.params['id']);

    this.vehicle$ = this.vehicleService.getVehicleById(id).pipe(
      tap(data => this.imageSource = this.vehicleService.selectImageUrl(data))
    )

  }

}
