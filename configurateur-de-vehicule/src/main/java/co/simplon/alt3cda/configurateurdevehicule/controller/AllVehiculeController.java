package co.simplon.alt3cda.configurateurdevehicule.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;

@RestController
public class AllVehiculeController {

  @Autowired
  VehicleRepository vehicleRepository;

  @GetMapping("")
  public ResponseEntity<List<Vehicle>> getAllVehicles() {

    return ResponseEntity.ok(vehicleRepository.findAll());
  }

}
