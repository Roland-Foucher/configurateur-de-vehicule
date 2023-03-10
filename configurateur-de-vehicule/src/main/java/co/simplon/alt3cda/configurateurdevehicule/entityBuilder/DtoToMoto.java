package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;

public class DtoToMoto extends InitVehicle implements IDtoToEntity<Moto> {

  @Override
  public Moto dtoToVehicle(VehicleDTO vehicleDTO) {
    return new Moto.Builder(init(vehicleDTO), vehicleDTO.getMotoType())
        .setColor(vehicleDTO.getColor())
        .setDescription(vehicleDTO.getDescription())
        .setId(vehicleDTO.getId())
        .setKilometers(vehicleDTO.getKilometers())
        .setLaunchDate(vehicleDTO.getLaunchDate())
        .setPower(vehicleDTO.getPower())
        .setPurshaseDate(vehicleDTO.getPurshaseDate())
        .setCylinder(vehicleDTO.getCylinder())
        .build();
  }
}
