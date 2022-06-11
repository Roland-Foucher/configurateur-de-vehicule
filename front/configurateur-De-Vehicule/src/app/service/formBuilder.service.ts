import { Injectable } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { BikeType } from "../enum/BikeType";
import { CarType } from "../enum/CarType";
import { Door } from "../enum/Door";
import { GearBox } from "../enum/GearBox";
import { MotoType } from "../enum/MotoType";

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


  public buildVehicle(vehicleType: string) : FormGroup
  {
    return this.formBuilder.group({
      mark            : [null, Validators.required],
      model           : [null, Validators.required],
      color           : [null],
      price           : [null, [Validators.required, Validators.min(0)]],
      purshasePrice   : [null, [Validators.required, Validators.min(0)]],
      purshaseDate    : [null, Validators.required],
      description     : [null],
      kilometers      : [null, Validators.min(0)],
      launchDate      : [null],
      power           : [null, Validators.min(0)],
      door            : [null, () => vehicleType === 'CAR' ? Validators.required : null],
      gearBox         : [null, () => vehicleType === 'CAR' ? Validators.required : null],
      carType         : [null, () => vehicleType === 'CAR' ? Validators.required : null],
      bikeType        : [null, () => vehicleType === 'BIKE' ? Validators.required : null],
      chainrings      : [null, Validators.min(0)],
      antitheft       : [null],
      cylinder        : [null, Validators.min(0)],
      motoType        : [null, () => vehicleType === 'MOTO' ? Validators.required : null],
    })
  }
}
