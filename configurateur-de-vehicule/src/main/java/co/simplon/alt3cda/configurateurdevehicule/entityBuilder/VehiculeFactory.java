package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import java.util.Map;
import java.util.Optional;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.repository.BikeRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.CarRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.MotoRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;

@Service
public class VehiculeFactory {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Autowired
  @Lazy
  private MotoRepository motoRepository;

  @Autowired
  @Lazy
  private BikeRepository bikeRepository;

  @Autowired
  @Lazy
  private CarRepository carRepository;

  public Vehicle getVehicle(Integer id) throws VehicleNotInEnumException, VehiculeNotInDatabaseException {
    
    VehiculeType vehiculeType = vehicleRepository.findById(id)
                                                  .orElseThrow(VehiculeNotInDatabaseException::new)
                                                  .getVehiculeType();

    switch (vehiculeType) {
      case Car:
        return carRepository.findById(id).orElseThrow(VehiculeNotInDatabaseException::new);

      case Moto:
        return motoRepository.findById(id).orElseThrow(VehiculeNotInDatabaseException::new);

      case Bike:
        return bikeRepository.findById(id).orElseThrow(VehiculeNotInDatabaseException::new);

      default:
        throw new VehicleNotInEnumException();
    }
  
  }

  public Vehicle saveVehicule(VehicleDTO vehicleDTO) throws VehicleNotInEnumException{
    Assert.notNull(vehicleDTO.getVehiculeType(), "vehiculeType is null");
    VehiculeType vehiculeType = vehicleDTO.getVehiculeType();
    switch (vehiculeType) {
      case Car:
        return carRepository.save(dtoToCar(vehicleDTO));
      case Moto:
        return motoRepository.save(dtoToMoto(vehicleDTO));
      case Bike:
        return bikeRepository.save(dtoToBike(vehicleDTO));
      default:
        throw new VehicleNotInEnumException();
    }
  }

  private Car dtoToCar(VehicleDTO vehicleDTO){
    return new Car.Builder(dtoToVehicle(vehicleDTO), vehicleDTO.getCarType(), vehicleDTO.getDoor(), vehicleDTO.getGearBox())
                  .setColor(vehicleDTO.getColor())
                  .setDescription(vehicleDTO.getDescription())
                  .setId(vehicleDTO.getId())
                  .setKilometers(vehicleDTO.getKilometers())
                  .setLaunchDate(vehicleDTO.getLaunchDate())
                  .setMark(vehicleDTO.getMark())
                  .setModel(vehicleDTO.getModel())
                  .setPower(vehicleDTO.getPower())
                  .setPurshaseDate(vehicleDTO.getPurshaseDate())
                  .build();
  }

  private Moto dtoToMoto(VehicleDTO vehicleDTO){
    return new Moto.Builder(dtoToVehicle(vehicleDTO), vehicleDTO.getMotoType())
                  .setColor(vehicleDTO.getColor())
                  .setDescription(vehicleDTO.getDescription())
                  .setId(vehicleDTO.getId())
                  .setKilometers(vehicleDTO.getKilometers())
                  .setLaunchDate(vehicleDTO.getLaunchDate())
                  .setMark(vehicleDTO.getMark())
                  .setModel(vehicleDTO.getModel())
                  .setPower(vehicleDTO.getPower())
                  .setPurshaseDate(vehicleDTO.getPurshaseDate())
                  .setCylinder(vehicleDTO.getCylinder())
                  .build();
  }

  private Bike dtoToBike(VehicleDTO vehicleDTO){
    return new Bike.Builder(dtoToVehicle(vehicleDTO), vehicleDTO.getBikeType())
                  .setColor(vehicleDTO.getColor())
                  .setDescription(vehicleDTO.getDescription())
                  .setId(vehicleDTO.getId())
                  .setMark(vehicleDTO.getMark())
                  .setModel(vehicleDTO.getModel())
                  .setPurshaseDate(vehicleDTO.getPurshaseDate())
                  .setAntitheft(vehicleDTO.isAntitheft())
                  .setChainrings(vehicleDTO.getChainrings())
                  .build();
  }

  private Vehicle dtoToVehicle(VehicleDTO vehicleDTO){
    return new Vehicle(vehicleDTO.getPrice(), vehicleDTO.getPurshasePrice(), vehicleDTO.getVehiculeType());
  }

  // public static Car castVehicleToCar(Vehicle vehicle){
    // if (vehicle.getClass().equals(obj));
  // }

}
