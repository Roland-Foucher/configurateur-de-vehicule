package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.MotorVehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;


public class MotorVehiculeBuilderTest {

  private Vehicle vehicle;

  @BeforeEach
  void init() {
    vehicle = new Vehicle(1, "mark", "model", "color", new BigDecimal(10.20), new BigDecimal(100),
        LocalDate.now(), "C'est un superbe vehicule");
  }

  @Test
  void testBuildCar_When_calledMethode() {

    Car car = MotorVehiculeBuilder.getCar(vehicle, 1000, LocalDate.now(), 10, Door.N2, GearBox.AUTO,
        CarType.CONVERTIBLE);
    assertNotNull(car);
    assertEquals(1, car.getId());
    assertEquals(2, car.getDoor());
  }

  @Test
  void testBuildMoto_When_calledMethode() {
    Moto moto = MotorVehiculeBuilder.getMoto(vehicle, 1000, LocalDate.now(), 10, 80, MotoType.ROAD);
    assertNotNull(moto);
    assertEquals(80, moto.getCylinder());
  }

  @Test
  void testBuildCar_When_vehicleIsNull() {

    assertThrows(IllegalArgumentException.class, () -> MotorVehiculeBuilder.getCar(null, 1000,
        LocalDate.now(), 10, Door.N2, GearBox.AUTO, CarType.CONVERTIBLE));

    assertThrows(IllegalArgumentException.class, () -> MotorVehiculeBuilder.getCar(vehicle, 1000,
        LocalDate.now(), 10, Door.N2, null, CarType.CONVERTIBLE));

    assertThrows(IllegalArgumentException.class, () -> MotorVehiculeBuilder.getCar(vehicle, 1000,
        LocalDate.now(), 10, null, GearBox.AUTO, CarType.CONVERTIBLE));
  }

  @Test
  void testBuildMoto_When_VehicleIsNull() {
    assertThrows(IllegalArgumentException.class,
        () -> MotorVehiculeBuilder.getMoto(null, 1000, LocalDate.now(), 10, 80, MotoType.ROAD));
  }
}
