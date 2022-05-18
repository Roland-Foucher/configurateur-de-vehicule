package co.simplon.alt3cda.configurateurdevehicule.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehiculeBuilder;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;

@SpringBootTest
@ActiveProfiles("test")

public class CarRepositoryTest {

  @Autowired
  CarRepository carRepository;

  Vehicle vehicle;

  @BeforeEach
  void init() {
    vehicle = new Vehicle(1, "mark", "model", "color", new BigDecimal(10.20), new BigDecimal(100),
        LocalDate.now(), "C'est un superbe vehicule");
  }

  @Test
  void testsaveCar() {
    Car car = VehiculeBuilder.setCar(vehicle, 200, LocalDate.now(), 100, Door.N2, GearBox.AUTO,
        CarType.CONVERTIBLE);
    carRepository.save(car);
    assertNotNull(carRepository.findById(1).get());
    assertEquals(200, carRepository.findById(1).get().getKilometers());

  }

  @Test
  void testResetDatabaseTest() {
    assertNull(carRepository.findById(1).orElse(null));
  }



}
