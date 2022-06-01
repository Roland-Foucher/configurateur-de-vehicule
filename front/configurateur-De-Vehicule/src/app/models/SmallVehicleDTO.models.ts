import { VehicleType } from "../enum/VehicleType";

export class SmallVehicleDTO{

  constructor (
    public id: number,
    public mark: string,
    public model: string,
    public vehiculeType :VehicleType,
    public price: number,
  ) {}
}
