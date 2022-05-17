package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class NonMotorVehicle extends Vehicle {


  public NonMotorVehicle(Vehicle vehicle) {
    super(vehicle.getId(), vehicle.getMark(), vehicle.getModel(), vehicle.getColor(),
        vehicle.getPrice(), vehicle.getPurshasePrice(), vehicle.getPurshaseDate(),
        vehicle.getDescription());
  }

}
