import { BikeType } from "../enum/BikeType";
import { CarType } from "../enum/CarType";
import { Door } from "../enum/Door";
import { GearBox } from "../enum/GearBox";
import { MotoType } from "../enum/MotoType";
import { VehicleType } from "../enum/VehicleType";

export class VehicleDto {

  constructor (
    public id: number,
    public mark: string,
    public model: string,
    public color: string,
    public price: number,
    public purshasePrice: number,
    public purshaseDate: Date,
    public description: string,
    public vehiculeType: VehicleType ,
    public cylinder: number,
    public kilometers: number,
    public launchDate: Date,
    public power: number,
    public motoType: MotoType,
    public door: Door,
    public gearBox: GearBox,
    public carType: CarType,
    public bikeType: BikeType,
    public chainrings: number,
    public antitheft: boolean ) {}
}
