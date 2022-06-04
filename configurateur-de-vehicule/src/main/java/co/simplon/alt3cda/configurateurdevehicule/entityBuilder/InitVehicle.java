package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;

/**
 * utilisation du pattern builder pour créer un initialiser avec les attributs commun d'un Vehicule 
 * depuis un dto
 */
public class InitVehicle {

  protected Vehicle init (VehicleDTO vehicleDTO){
    return new Vehicle(vehicleDTO.getPrice(), 
                        vehicleDTO.getPurshasePrice(), 
                        vehicleDTO.getVehiculeType(),
                        vehicleDTO.getMark(),
                        vehicleDTO.getModel());
  }
}
