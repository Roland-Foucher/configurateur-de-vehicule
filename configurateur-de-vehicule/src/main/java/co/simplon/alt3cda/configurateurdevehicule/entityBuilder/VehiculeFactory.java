package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;

@Service
public class VehiculeFactory {

  private Bike bike;
  private Moto moto;
  private Car car;

  @Autowired
  private VehicleRepository vehicleRepository;

  private void setVehicule(Integer id) throws VehicleNotInEnumException, VehiculeNotInDatabaseException {
    
    Optional<Vehicle> optVehicle = vehicleRepository.findById(id);
    VehiculeType vehiculeType = vehicleRepository.findById(id).get().getVehiculeType();

    switch (vehiculeType) {
      case Car:
        this.car =  optVehicle.map(el -> (Car) el).orElseThrow(VehiculeNotInDatabaseException::new);

      case Moto:
        this.moto = optVehicle.map(el -> (Moto) el).orElseThrow(VehiculeNotInDatabaseException::new);

      case Bike:
        this.bike = optVehicle.map(el -> (Bike) el).orElseThrow(VehiculeNotInDatabaseException::new);

      default:
        throw new VehicleNotInEnumException();
    }
  }

  public Bike getBikeCasted(int id) throws VehicleNotInEnumException, VehiculeNotInDatabaseException {
    setVehicule(id);
    return bike;
  }

  public Moto getMotoCasted(int id) throws VehicleNotInEnumException, VehiculeNotInDatabaseException {
    setVehicule(id);
    return moto;
  }

  public Car getCarCasted(int id) throws VehicleNotInEnumException, VehiculeNotInDatabaseException {
    setVehicule(id);
    return car;
  }

}
