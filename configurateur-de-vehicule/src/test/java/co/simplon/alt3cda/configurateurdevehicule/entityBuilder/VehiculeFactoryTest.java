package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeEnum;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;

public class VehiculeFactoryTest {

  private Vehicle vehicle;

  @BeforeEach
  void init() {
    vehicle = new Vehicle(1, "mark", "model", "color", new BigDecimal(10.20), new BigDecimal(100),
        LocalDate.now(), "C'est un superbe vehicule");

  }

  @Test
  void testGetVehicule() throws Exception {

    // Vehicle velo = VehiculeFactory.getVehicule(vehicle, VehiculeEnum.Velo, );
    // assertEquals(5, ((Velo) velo).getChainrings());


  }
}
