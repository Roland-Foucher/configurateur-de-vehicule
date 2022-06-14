package co.simplon.alt3cda.configurateurdevehicule.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.simplon.alt3cda.configurateurdevehicule.entity.SmallVehicleDTO;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehicleNotInEnumException;
import co.simplon.alt3cda.configurateurdevehicule.exception.VehiculeNotInDatabaseException;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;
import co.simplon.alt3cda.configurateurdevehicule.service.InitDatabase;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api")
public class AllVehicleController {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Autowired
  private InitDatabase initDatabase;

  /**
   * renvoie une liste de vehicules avec le minimum d'information pour afficher la
   * liste
   */
  @GetMapping("")
  public ResponseEntity<List<SmallVehicleDTO>> getAllVehicles()
      throws VehicleNotInEnumException, VehiculeNotInDatabaseException {

    List<SmallVehicleDTO> smallVehicleDTOs = vehicleRepository.findAll()
        .stream()
        .map(v -> new SmallVehicleDTO(
            v.getId(),
            v.getMark(),
            v.getModel(),
            v.getVehiculeType(),
            v.getPrice()))
        .collect(Collectors.toList());

    return smallVehicleDTOs.size() == 0 ? ResponseEntity.noContent().build() : ResponseEntity.ok(smallVehicleDTOs);

  }

  /**
   * initialise la base de donnée avec des valeurs de base
   */
  @GetMapping("/init-database")
  public ResponseEntity<String> initDatabase() {

    if (initDatabase.init()) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.internalServerError().build();
  }
}
