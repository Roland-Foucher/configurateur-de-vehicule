import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { VehicleDto } from '../models/VehicleDto.models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url: string = "localhost:8080/";

  constructor(private httpClient: HttpClient) { }

  getAllVehicle() : Observable<VehicleDto[]>
  {
    return this.httpClient.get<VehicleDto[]>(this.url);
  }

  getVehicleById(id: number) : Observable<VehicleDto>
  {
    return this.httpClient.get<VehicleDto>(this.url + id );
  }

  saveVehicle(vehicleDto: VehicleDto) : void
  {
    this.httpClient
      .put(this.url, vehicleDto)
      .subscribe({
        error: (e) => console.error(e),
        complete: () => console.log('save complete')
      })
  }

  deleteVehicle(id: number) : void
  {
    this.httpClient
      .delete(this.url + id)
      .subscribe({
        error: (e) => console.error(e),
        complete: () => console.log('delete complete')
      })
  }
}
