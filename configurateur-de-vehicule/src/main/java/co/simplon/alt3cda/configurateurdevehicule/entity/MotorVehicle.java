package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MotorVehicle extends Vehicle {

  private int kilometers;
  private LocalDate launchDate;
  private String Type;
  private int power;

  public int getKilometers() {
    return kilometers;
  }

  public LocalDate getLaunchDate() {
    return launchDate;
  }

  public String getType() {
    return Type;
  }

  public int getPower() {
    return power;
  }


}
