package co.simplon.alt3cda.configurateurdevehicule.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehiculeBuilder;

@SpringBootTest
@ActiveProfiles("test")
public class VehicleRepositoryTest {

  @Autowired
  VehicleRepository vehicleRepository;

  @Test
  void testSaveVehicule() {
    Vehicle vehicle = VehiculeBuilder.setVehicule(1, "mark", "model", "color", new BigDecimal(12),
        new BigDecimal(12), LocalDate.now(), "description");
    vehicleRepository.save(vehicle);
    assertEquals(1, vehicleRepository.findById(1));


  }
}
