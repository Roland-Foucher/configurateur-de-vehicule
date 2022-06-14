package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;

/**
 * utilisation du pattern builder pour créer un Vehicule depuis un dto avant de
 * l'enregistrer dans la bdd
 */
public interface IDtoToEntity<T extends Vehicle> {
  T dtoToVehicle(VehicleDTO vehicleDTO);

}
