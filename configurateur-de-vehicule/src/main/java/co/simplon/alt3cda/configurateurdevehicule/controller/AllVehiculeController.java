package co.simplon.alt3cda.configurateurdevehicule.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehiculeFactory;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;
import co.simplon.alt3cda.configurateurdevehicule.service.InitDatabase;

@RestController
public class AllVehiculeController {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Autowired
  private InitDatabase initDatabase;


  @GetMapping("")
  public ResponseEntity<List<Vehicle>> getAllVehicles() throws VehicleNotInEnumException, VehiculeNotInDatabaseException {

    initDatabase.init();
    
    return ResponseEntity.ok(vehicleRepository.findAll());
  }

}
