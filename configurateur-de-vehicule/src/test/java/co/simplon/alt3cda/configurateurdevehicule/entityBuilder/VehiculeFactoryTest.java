package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.service.InitDatabase;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode =  ClassMode.BEFORE_EACH_TEST_METHOD)
public class VehiculeFactoryTest {

  @Autowired
  private InitDatabase initDatabase;

  @Autowired
  private VehiculeFactory vehiculeFactory;


  @BeforeEach
  @Commit
  void init() {
    initDatabase.init();
    
  }

  @Test
  void testGetCar() throws VehicleNotInEnumException, VehiculeNotInDatabaseException{
   assertEquals(CarType.SEDAN, ((Car)vehiculeFactory.getVehicle(1)).getCarType());
  }

  @Test
  void testGetBike() throws VehicleNotInEnumException, VehiculeNotInDatabaseException{
   assertEquals(BikeType.CITY, ((Bike)vehiculeFactory.getVehicle(3)).getVeloType());
  }

  @Test
  void testGetMoto() throws VehicleNotInEnumException, VehiculeNotInDatabaseException{
   assertEquals(MotoType.SPORT, ((Moto)vehiculeFactory.getVehicle(4)).getMotoType());
  }

  @Test
  void testNoElementInDatabaseException(){
    assertThrows(VehiculeNotInDatabaseException.class, () -> vehiculeFactory.getVehicle(-1));
  }

  @Test
  void saveCar() throws VehicleNotInEnumException{
    VehicleDTO vehicleDTO = new VehicleDTO(null, "mark", "model", "color", 19.0, 
                                            12.00, LocalDate.now(), "null", 
                                            VehiculeType.Car, 1, 1, LocalDate.now(), 
                                            1, MotoType.ROAD, 3, GearBox.MANUAL, CarType.CONVERTIBLE, 
                                            BikeType.RACE, 1, true);
    assertNotNull(vehiculeFactory.saveVehicule(vehicleDTO));
  }

  @Test
  void saveMoto() throws VehicleNotInEnumException{
    VehicleDTO vehicleDTO = new VehicleDTO(null, "mark", "model", "color", 19.0, 
                                            12.00, LocalDate.now(), "null", 
                                            VehiculeType.Moto, 1, 1, LocalDate.now(), 
                                            1, MotoType.ROAD, 3, GearBox.MANUAL, CarType.CONVERTIBLE, 
                                            BikeType.RACE, 1, true);
    assertNotNull(vehiculeFactory.saveVehicule(vehicleDTO));
  }

  @Test
  void saveBike() throws VehicleNotInEnumException{
    VehicleDTO vehicleDTO = new VehicleDTO(null, "mark", "model", "color", 19.0, 
                                            12.00, LocalDate.now(), "null", 
                                            VehiculeType.Bike, 1, 1, LocalDate.now(), 
                                            1, MotoType.ROAD, 3, GearBox.MANUAL, CarType.CONVERTIBLE, 
                                            BikeType.RACE, 1, true);
    assertNotNull(vehiculeFactory.saveVehicule(vehicleDTO));
  }

  @Test
  void testExceptionOnSave_When_VehicleTypeIsNull(){
    VehicleDTO vehicleDTO = new VehicleDTO(null, "mark", "model", "color", 19.0, 
                                        12.00, LocalDate.now(), "null", 
                                        null, 1, 1, LocalDate.now(), 
                                        1, MotoType.ROAD, 3, GearBox.MANUAL, CarType.CONVERTIBLE, 
                                        BikeType.RACE, 1, true);

    assertThrows(IllegalArgumentException.class, () -> vehiculeFactory.saveVehicule(vehicleDTO));
  }
  
}
