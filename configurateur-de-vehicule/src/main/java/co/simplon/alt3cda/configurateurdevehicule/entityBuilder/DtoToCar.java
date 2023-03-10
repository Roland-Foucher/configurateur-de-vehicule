package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;

public class DtoToCar extends InitVehicle implements IDtoToEntity<Car> {

  @Override
  public Car dtoToVehicle(VehicleDTO vehicleDTO) {
    return new Car.Builder(init(vehicleDTO), vehicleDTO.getCarType(), vehicleDTO.getDoor(), vehicleDTO.getGearBox())
        .setColor(vehicleDTO.getColor())
        .setDescription(vehicleDTO.getDescription())
        .setId(vehicleDTO.getId())
        .setKilometers(vehicleDTO.getKilometers())
        .setLaunchDate(vehicleDTO.getLaunchDate())
        .setPower(vehicleDTO.getPower())
        .setPurshaseDate(vehicleDTO.getPurshaseDate())
        .build();
  }
}
