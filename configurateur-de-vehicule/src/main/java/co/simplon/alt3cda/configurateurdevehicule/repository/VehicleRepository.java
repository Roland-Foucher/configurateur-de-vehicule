package co.simplon.alt3cda.configurateurdevehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {


}
