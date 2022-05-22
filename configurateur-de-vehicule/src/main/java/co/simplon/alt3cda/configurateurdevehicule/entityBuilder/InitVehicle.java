package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;

public class InitVehicle {

  protected Vehicle init (VehicleDTO vehicleDTO){
    return new Vehicle(vehicleDTO.getPrice(), 
                        vehicleDTO.getPurshasePrice(), 
                        vehicleDTO.getVehiculeType(),
                        vehicleDTO.getMark(),
                        vehicleDTO.getModel());
  }
}
