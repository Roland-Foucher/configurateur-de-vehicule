package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class NonMotorVehicle extends Vehicle {

  private String type;

  public String getType() {
    return type;
  }
}
