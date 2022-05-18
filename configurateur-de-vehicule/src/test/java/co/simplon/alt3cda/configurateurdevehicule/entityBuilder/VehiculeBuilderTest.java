package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;


public class VehiculeBuilderTest {

  private Vehicle vehicle;

  @BeforeEach
  void init() {
    vehicle = new Vehicle(1, "mark", "model", "color", new BigDecimal(10.20), new BigDecimal(100),
        LocalDate.now(), "C'est un superbe vehicule");
  }

  @Test
  void testBuildCar_When_calledMethode() {

    Car car = VehiculeBuilder.setCar(vehicle, 1000, LocalDate.now(), 10, Door.N2, GearBox.AUTO,
        CarType.CONVERTIBLE);
    assertNotNull(car);
    assertEquals(1, car.getId());
    assertEquals(2, car.getDoor());
  }

  @Test
  void testBuildMoto_When_calledMethode() {
    Moto moto = VehiculeBuilder.setMoto(vehicle, 1000, LocalDate.now(), 10, 80, MotoType.ROAD);
    assertNotNull(moto);
    assertEquals(80, moto.getCylinder());
  }

  @Test
  void testBuildCar_When_vehicleIsNull() {

    assertThrows(IllegalArgumentException.class, () -> VehiculeBuilder.setCar(null, 1000,
        LocalDate.now(), 10, Door.N2, GearBox.AUTO, CarType.CONVERTIBLE));

    assertThrows(IllegalArgumentException.class, () -> VehiculeBuilder.setCar(vehicle, 1000,
        LocalDate.now(), 10, Door.N2, null, CarType.CONVERTIBLE));

    assertThrows(IllegalArgumentException.class, () -> VehiculeBuilder.setCar(vehicle, 1000,
        LocalDate.now(), 10, null, GearBox.AUTO, CarType.CONVERTIBLE));
  }

  @Test
  void testBuildMoto_When_VehicleIsNull() {
    assertThrows(IllegalArgumentException.class,
        () -> VehiculeBuilder.setMoto(null, 1000, LocalDate.now(), 10, 80, MotoType.ROAD));
  }

  @Test
  void testBuildVelo_When_callMethodeBuild() {
    Bike velo = VehiculeBuilder.setVelo(vehicle, 3, true, BikeType.CITY);
    assertNotNull(velo);
    assertEquals(3, velo.getChainrings());
    assertEquals(1, velo.getId());

  }
}
