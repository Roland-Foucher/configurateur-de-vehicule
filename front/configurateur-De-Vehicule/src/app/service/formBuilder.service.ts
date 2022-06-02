import { Injectable } from "@angular/core";
import { FormArray, FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ImageUrl } from "../enum/ImageUrl";
import { VehicleDto } from '../models/VehicleDto.models';

@Injectable({
  providedIn: 'root'
})
export class FormBuilderService {

  constructor (private formBuilder: FormBuilder, router: Router) {}


  private buildCar(vehicleDto: VehicleDto) : FormGroup
  {
    return this.formBuilder.group({
      mark: [vehicleDto.mark, Validators.required],
      model: [vehicleDto.model, Validators.required],
      color: [vehicleDto.model],
      price: [vehicleDto.price, [Validators.required, Validators.min(0)]],
      purshasePrice: [vehicleDto.purshasePrice, [Validators.required, Validators.min(0)]],
      purshaseDate: [vehicleDto.purshaseDate],
      vehicleType: [vehicleDto.vehiculeType],
      description: [vehicleDto.description],
      kilometers: [vehicleDto.kilometers, Validators.min(0)],
      launchDate: [vehicleDto.launchDate],
      power: [vehicleDto.power, Validators.min(0)],
      door: [vehicleDto.door, Validators.required],
      gearBox: [vehicleDto.gearBox, Validators.required],
      carType: [vehicleDto.carType, Validators.required]
    })
  }

  private buildBike(vehicleDto: VehicleDto) : FormGroup
  {
    return this.formBuilder.group({
      mark: [vehicleDto.mark, Validators.required],
      model: [vehicleDto.model, Validators.required],
      color: [vehicleDto.model],
      price: [vehicleDto.price, [Validators.required, Validators.min(0)]],
      purshasePrice: [vehicleDto.purshasePrice, [Validators.required, Validators.min(0)]],
      purshaseDate: [vehicleDto.purshaseDate],
      vehicleType: [vehicleDto.vehiculeType],
      description: [vehicleDto.description],
      bikeType: [vehicleDto.bikeType, Validators.required],
      chainrings: [vehicleDto.door, Validators.min(0)],
      antitheft: [vehicleDto.antitheft, Validators.required]
    })
  }

  private buildMoto(vehicleDto: VehicleDto) : FormGroup
  {
   return this.formBuilder.group({
      mark: [vehicleDto.mark, Validators.required],
      model: [vehicleDto.model, Validators.required],
      color: [vehicleDto.model],
      price: [vehicleDto.price, [Validators.required, Validators.min(0)]],
      purshasePrice: [vehicleDto.purshasePrice, [Validators.required, Validators.min(0)]],
      purshaseDate: [vehicleDto.purshaseDate],
      vehicleType: [vehicleDto.vehiculeType],
      description: [vehicleDto.description],
      cylinder: [vehicleDto.cylinder, Validators.min(0)],
      kilometers: [vehicleDto.kilometers, Validators.min(0)],
      launchDate: [vehicleDto.launchDate],
      power: [vehicleDto.power, Validators.min(0)],
      motoType: [vehicleDto.motoType, Validators.required],
    })
  }

  public buildFormFactory(vehicleType: string, vehicleDto: VehicleDto): FormGroup
  {

    switch (vehicleType) {
      case 'car':
        return this.buildCar(vehicleDto);
      case 'moto':
        return this.buildMoto(vehicleDto);
      case 'bike':
        return this.buildBike(vehicleDto);
      default:
        throw 'error vehicle does not exist'
    }
  }
}
