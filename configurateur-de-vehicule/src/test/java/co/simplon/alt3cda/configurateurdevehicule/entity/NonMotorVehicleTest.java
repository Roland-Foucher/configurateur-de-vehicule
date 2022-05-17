package co.simplon.alt3cda.configurateurdevehicule.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.NonMotorVehiculeBuilder;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;

public class NonMotorVehicleTest {

  private Vehicle vehicle;
  private Bike velo;

  @BeforeEach
  void init() {
    vehicle = new Vehicle(1, "mark", "model", "color", new BigDecimal(10.20), new BigDecimal(100),
        LocalDate.now(), "C'est un superbe vehicule");
  }

  @Test
  void testBuildVelo_When_callMethodeBuild() {
    Bike velo = NonMotorVehiculeBuilder.getVelo(vehicle, 3, true, BikeType.CITY);
    assertNotNull(velo);
    assertEquals(3, velo.getChainrings());
    assertEquals(1, velo.getId());

  }

  @Test
  void testBuildVelo_When_vehiculeIsNull() {
    assertThrows(IllegalArgumentException.class,
        () -> NonMotorVehiculeBuilder.getVelo(null, 3, true, BikeType.CITY));
  }

}
