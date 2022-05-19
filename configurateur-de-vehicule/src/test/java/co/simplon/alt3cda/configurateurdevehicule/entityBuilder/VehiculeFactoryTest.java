package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;
import co.simplon.alt3cda.configurateurdevehicule.service.InitDatabase;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode =  ClassMode.BEFORE_EACH_TEST_METHOD)
public class VehiculeFactoryTest {

  @Autowired
  private InitDatabase initDatabase;

  @Autowired
  private VehicleRepository vehicleRepository;

  @Autowired
  private VehiculeFactory vehiculeFactory;

  @BeforeEach
  @Commit
  void init() {
    initDatabase.init();
    
  }

  @Test
  void testGetCar() throws VehicleNotInEnumException, VehiculeNotInDatabaseException{
    assertEquals(Car.class, vehiculeFactory.getBikeCasted(1));
   
  }
}
