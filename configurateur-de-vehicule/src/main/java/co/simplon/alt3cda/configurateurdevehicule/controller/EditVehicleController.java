package co.simplon.alt3cda.configurateurdevehicule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.simplon.alt3cda.configurateurdevehicule.entity.VehicleDTO;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehiculeFactory;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;

@RestController
public class EditVehicleController {
  
  @Autowired
  VehiculeFactory vehiculeFactory;
  
  @PostMapping("/save")
  public ResponseEntity<String> save(@RequestBody VehicleDTO vehicleDTO){
    Assert.notNull(vehicleDTO, "vehicule is null");
    try {
      if (vehiculeFactory.saveVehicule(vehicleDTO) != null){
        return ResponseEntity.ok().build();
      }else{
        return ResponseEntity.internalServerError().build();
      }
    } catch (VehicleNotInEnumException e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().body(e.getMessage());
      
    }
    
  }
}
