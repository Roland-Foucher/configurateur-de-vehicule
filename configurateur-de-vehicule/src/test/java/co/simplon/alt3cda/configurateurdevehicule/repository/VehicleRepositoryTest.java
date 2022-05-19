package co.simplon.alt3cda.configurateurdevehicule.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ActiveProfiles;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehiculeBuilder;
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

  Vehicle vehicle;

  @BeforeEach
  void init() {
    vehicle = new Vehicle(1, "mark", "model", "color", 10.20, 100.0, LocalDate.now(),
        "C'est un superbe vehicule", VehiculeType.Car);
  }

  @Test
  void testSaveVehicule() {

    vehicleRepository.save(vehicle);
    assertEquals(1, vehicleRepository.findById(1).get().getId());
    assertEquals(VehiculeType.Car, vehicleRepository.findById(1).get().getVehiculeType());

  }

  @Test
  void testsaveCar() {
    Car car = VehiculeBuilder.setCar(vehicle, 200, LocalDate.now(), 100, Door.N2, GearBox.AUTO,
        CarType.CONVERTIBLE);
    vehicleRepository.save(car);
    assertNotNull(vehicleRepository.findById(1).get());
    

  }

  @Test
  void testResetDatabaseTest() {
    assertNull(vehicleRepository.findById(1).orElse(null));
  }
}
