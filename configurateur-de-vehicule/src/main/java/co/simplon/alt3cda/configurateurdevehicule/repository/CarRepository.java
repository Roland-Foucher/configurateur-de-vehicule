package co.simplon.alt3cda.configurateurdevehicule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
