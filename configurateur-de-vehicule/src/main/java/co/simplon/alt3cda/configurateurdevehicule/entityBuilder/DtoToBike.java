package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;

public class DtoToBike extends InitVehicle implements IDtoToEntity<Bike> {

  @Override
  public Bike dtoToVehicle(VehicleDTO vehicleDTO) {
    return new Bike.Builder(this.init(vehicleDTO), vehicleDTO.getBikeType())
                    .setColor(vehicleDTO.getColor())
                    .setDescription(vehicleDTO.getDescription())
                    .setId(vehicleDTO.getId())
                    .setPurshaseDate(vehicleDTO.getPurshaseDate())
                    .setAntitheft(vehicleDTO.isAntitheft())
                    .setChainrings(vehicleDTO.getChainrings())
                    .build();
  }


}
