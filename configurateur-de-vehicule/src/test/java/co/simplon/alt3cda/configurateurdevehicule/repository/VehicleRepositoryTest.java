package co.simplon.alt3cda.configurateurdevehicule.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode =  ClassMode.BEFORE_EACH_TEST_METHOD)
public class VehicleRepositoryTest {

  @Autowired
  VehicleRepository vehicleRepository;

  private Car car;

  @BeforeEach
  void init() {
    car = new Car.Builder(new Vehicle(3000.0, 4000.0, VehiculeType.Car), 
                                  CarType.SEDAN, Door.N5, 
                                  GearBox.MANUAL)
                      .setId(1)
                      .setColor("red")
                      .setMark("Peugeot")
                      .setModel("306")
                      .setPurshaseDate(LocalDate.now())
                      .setLaunchDate(LocalDate.now())
                      .setKilometers(86000)
                      .setPower(100)
                      .build();
  }

  @Test
  void testSaveVehicule() {

    vehicleRepository.save(car);
    assertEquals(1, vehicleRepository.findById(1).get().getId());
    assertEquals(VehiculeType.Car, vehicleRepository.findById(1).get().getVehiculeType());
    assertEquals(CarType.SEDAN, ((Car)vehicleRepository.findById(1).get()).getCarType());
    

  }
    

  @Test
  void testResetDatabaseTest() {
    assertNull(vehicleRepository.findById(1).orElse(null));
  }
}
