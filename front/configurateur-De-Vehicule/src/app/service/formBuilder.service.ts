import { Injectable } from "@angular/core";
import { FormArray, FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { BikeType } from "../enum/BikeType";
import { CarType } from "../enum/CarType";
import { Door } from "../enum/Door";
import { GearBox } from "../enum/GearBox";
import { ImageUrl } from "../enum/ImageUrl";
import { MotoType } from "../enum/MotoType";
import { VehicleType } from "../enum/VehicleType";
import { VehicleDto } from '../models/VehicleDto.models';

@Injectable({
  providedIn: 'root'
})
export class FormBuilderService {

  gearBoxes = [
    {id: 0, name: GearBox.MANUAL},
    {id: 1, name: GearBox.AUTO},
  ]

  doors = [
    {id: 2, name: Door.N2},
    {id: 3, name: Door.N3},
    {id: 5, name: Door.N5},
  ]

  bikeTypes = [
    {id: 0, name: BikeType.ROAD},
    {id: 1, name: BikeType.MOUNTAIN},
    {id: 2, name: BikeType.CITY},
    {id: 3, name: BikeType.RACE},
  ]

  motoTypes = [
    {id: 0, name: MotoType.SPORT},
    {id: 1, name: MotoType.ROAD},
    {id: 2, name: MotoType.ROADSTER},
  ]

  carTypes = [
    {id: 0, name: CarType.SPORT},
    {id: 1, name: CarType.SUV},
    {id: 2, name: CarType.SEDAN},
    {id: 3, name: CarType.CONVERTIBLE},
    {id: 4, name: CarType.COUPE},
  ]

  constructor (private formBuilder: FormBuilder) {}


  public buildVehicle(vehicleDto: VehicleDto, vehicleType: string) : FormGroup
  {
    return this.formBuilder.group({
      mark: [vehicleDto.mark, Validators.required],
      model: [vehicleDto.model, Validators.required],
      color: [vehicleDto.color],
      price: [vehicleDto.price, [Validators.required, Validators.min(0)]],
      purshasePrice: [vehicleDto.purshasePrice, [Validators.required, Validators.min(0)]],
      purshaseDate: [vehicleDto.purshaseDate, Validators.required],
      description: [vehicleDto.description],
      kilometers: [vehicleDto.kilometers, Validators.min(0)],
      launchDate: [vehicleDto.launchDate],
      power: [vehicleDto.power, Validators.min(0)],
      door: [vehicleDto.door, () => vehicleType === 'car' ? Validators.required : null],
      gearBox: [vehicleDto.gearBox, vehicleType === 'car' ? Validators.required : null],
      carType: [vehicleDto.carType, vehicleType === 'car' ? Validators.required : null],
      bikeType: [vehicleDto.bikeType, vehicleType === 'bike' ? Validators.required : null],
      chainrings: [vehicleDto.chainrings, Validators.min(2)],
      antitheft: [vehicleDto.antitheft],
      cylinder: [vehicleDto.cylinder, Validators.min(0)],
      motoType: [vehicleDto.motoType, vehicleType === 'moto' ? Validators.required : null],
    })
  }
}
