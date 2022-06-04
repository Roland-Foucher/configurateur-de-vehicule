import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { VehicleDto } from '../models/VehicleDto.models';
import { catchError, map, Observable, of } from 'rxjs';
import { SmallVehicleDTO } from '../models/SmallVehicleDTO.models';
import { VehicleType } from '../enum/VehicleType';
import { ImageUrl } from '../enum/ImageUrl';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url: string = "http://localhost:8080/api";

  constructor(private httpClient: HttpClient, private router:Router) { }

  getAllVehicle() : Observable<SmallVehicleDTO[]>
  {
    return this.httpClient.get<SmallVehicleDTO[]>(this.url)
  }

  getVehicleById(id: number) : Observable<VehicleDto>
  {
    return this.httpClient.get<VehicleDto>(`${this.url}/edit/${id}`);
  }

  saveVehicle(vehicleDto: VehicleDto) : boolean
  {
    this.httpClient
      .put(`${this.url}/edit`, vehicleDto)
      .subscribe({
        error: (e) => {
          console.error(e);
          return false;
        },
        complete: () => {
          console.log("vehicle saved")
          return true;
        }
      })
      return false;

  }

  deleteVehicle(id: number) : void
  {
    this.httpClient
      .delete(`${this.url}/edit/${id}`)
      .subscribe({
        error: (e) => console.error(e),
        complete: () => console.log("vehicle deleted")
      });
  }

  initDatabase(): void
  {
    this.httpClient
      .get(this.url + "/init-database")
      .subscribe({
        error: (e) => {
          console.error(e);

        },
        complete: () => {
          console.log("database init");
          location.reload();
        }
      });

  }

  selectImageUrl(vehicle: VehicleDto | SmallVehicleDTO) : string
  {
    return  vehicle.vehiculeType === VehicleType.CAR ? ImageUrl.CAR :
            vehicle.vehiculeType === VehicleType.MOTO ? ImageUrl.MOTO :
            vehicle.vehiculeType === VehicleType.BIKE ? ImageUrl.BIKE :
            ImageUrl.ERROR
  }

  public vehicleTypeFactory(vehicleType: string) : VehicleType | undefined
  {
    return  vehicleType === 'car' ? VehicleType.CAR :
            vehicleType === 'bike' ? VehicleType.BIKE :
            vehicleType === 'moto' ? VehicleType.MOTO :
            undefined
  }
}
