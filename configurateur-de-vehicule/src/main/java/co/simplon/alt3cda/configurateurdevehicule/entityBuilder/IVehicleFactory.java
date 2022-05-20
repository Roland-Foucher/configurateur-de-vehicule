package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;


public interface IVehicleFactory {
  Vehicle getVehicle(Integer id)  throws VehicleNotInEnumException, VehiculeNotInDatabaseException;
  Vehicle saveVehicle(VehicleDTO vehicleDTO) throws VehicleNotInEnumException;
}
