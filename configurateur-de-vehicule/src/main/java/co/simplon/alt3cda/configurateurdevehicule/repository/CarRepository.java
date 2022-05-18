package co.simplon.alt3cda.configurateurdevehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
