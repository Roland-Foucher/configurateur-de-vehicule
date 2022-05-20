package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import org.springframework.stereotype.Component;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;

public interface IDtoToEntity<T extends Vehicle> {
   T dtoToVehicle(VehicleDTO vehicleDTO);

}
