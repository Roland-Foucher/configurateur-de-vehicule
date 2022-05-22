import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { VehicleDto } from '../models/VehicleDto.models';
import { catchError, Observable } from 'rxjs';
import { SmallVehicleDTO } from '../models/SmallVehicleDTO.models';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url: string = "http://localhost:8080/api";

  constructor(private httpClient: HttpClient) { }

  getAllVehicle() : Observable<SmallVehicleDTO[]>
  {
    return this.httpClient.get<SmallVehicleDTO[]>(this.url)
  }

  getVehicleById(id: number) : Observable<VehicleDto>
  {
    return this.httpClient.get<VehicleDto>(`${this.url}/edit/${id}`);
  }

  saveVehicle(vehicleDto: VehicleDto) : void
  {
    this.httpClient
      .put(`${this.url}/edit`, vehicleDto)
      .subscribe({
        error: (e) => console.error(e),
        complete: () => console.log("database init")
      });
  }

  deleteVehicle(id: number) : void
  {
    this.httpClient
      .delete(`${this.url}/edit/${id}`)
      .subscribe({
        error: (e) => console.error(e),
        complete: () => console.log("database init")
      });
  }

  initDatabase(): void{
    this.httpClient
      .get(this.url + "/init-database")
      .subscribe({
        error: (e) => console.error(e),
        complete: () => console.log("database init")
      });
  }
}
