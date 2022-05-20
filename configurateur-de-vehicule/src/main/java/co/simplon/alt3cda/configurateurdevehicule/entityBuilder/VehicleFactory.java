package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.repository.BikeRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.CarRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.MotoRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;

/**
 * VehicleFactory permet de créer et de sauvegarder les enfants de vehicle.
 * Cette classe utilise les design pattern factory, factory methode et proxy
 */
@Service
public class VehicleFactory implements IVehicleFactory {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Autowired
  @Lazy // utilisation du pattern proxy avec lazy pour instancier les repo enfants que si on en a besoin
  private MotoRepository motoRepository;

  @Autowired
  @Lazy
  private BikeRepository bikeRepository;

  @Autowired
  @Lazy
  private CarRepository carRepository;

  /**
   * Factory pour initialiser le bon repository pour récupérer l'entité
   * Cette methode sert seulement pour l'exercice, le vehicleRepository parent le fait déjà automatiquement...
   */
  public Vehicle getVehicle(Integer id) throws VehicleNotInEnumException, VehiculeNotInDatabaseException {
    
    VehiculeType vehiculeType = vehicleRepository.findById(id)
                                                  .orElseThrow(VehiculeNotInDatabaseException::new)
                                                  .getVehiculeType();

    switch (vehiculeType) {
      case CAR:
        return carRepository.findById(id).orElseThrow(VehiculeNotInDatabaseException::new);

      case MOTO:
        return motoRepository.findById(id).orElseThrow(VehiculeNotInDatabaseException::new);

      case BIKE:
        return bikeRepository.findById(id).orElseThrow(VehiculeNotInDatabaseException::new);

      default:
        throw new VehicleNotInEnumException();
    }
  }

  /**
   * Factory methode pour créer le bon objet et le sauvegarder dans la bdd suivant son type
   */
  
  public Vehicle saveVehicle(VehicleDTO vehicleDTO) throws VehicleNotInEnumException{

    Assert.notNull(vehicleDTO.getVehiculeType(), "vehiculeType is null");

    VehiculeType vehiculeType = vehicleDTO.getVehiculeType();
    switch (vehiculeType) {
      case CAR:
        DtoToCar dtoTocar = new DtoToCar();
        return carRepository.save(dtoTocar.dtoToVehicle(vehicleDTO));
      case MOTO:
        DtoToMoto dtoToMoto = new DtoToMoto();
        return motoRepository.save(dtoToMoto.dtoToVehicle(vehicleDTO));
      case BIKE:
        DtoToBike dtoToBike = new DtoToBike();
        return bikeRepository.save(dtoToBike.dtoToVehicle(vehicleDTO));
      default:
        throw new VehicleNotInEnumException();
    }
  }

}
