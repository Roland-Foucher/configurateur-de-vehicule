package co.simplon.alt3cda.configurateurdevehicule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehicleFactory;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;

@RestController
public class EditVehicleController {
  
  @Autowired
  VehicleFactory vehiculeFactory;

  @Autowired
  VehicleRepository vehicleRepository;
  
  @PostMapping("/save")
  public ResponseEntity<String> save(@RequestBody VehicleDTO vehicleDTO){
    Assert.notNull(vehicleDTO, "vehicule is null");
    try {
      if (vehiculeFactory.saveVehicle(vehicleDTO) != null){
        return ResponseEntity.ok().build();
      }else{
        return ResponseEntity.internalServerError().build();
      }
    } catch (VehicleNotInEnumException e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().body(e.getMessage());
      
    }
    
 }

  @GetMapping("/{id}")
  public ResponseEntity<Vehicle> getOne(@PathVariable int id){
    try {
      Vehicle vehicle = vehiculeFactory.getVehicle(id);
      return ResponseEntity.ok(vehicle);
    } catch (VehicleNotInEnumException e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().build();
    } catch (VehiculeNotInDatabaseException e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping("/delete/{id}")
  public ResponseEntity<String> deleteOne(@PathVariable int id){
    vehicleRepository.deleteById(id);
    if (vehicleRepository.findById(id).orElse(null) == null){
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.internalServerError().body("error when delete the vehicle");
  }
}
