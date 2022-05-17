package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MotorVehicle extends Vehicle {

  private int kilometers;
  private LocalDate launchDate;
  private int power;

  public MotorVehicle(Vehicle vehicle) {
    super(vehicle.getId(), vehicle.getMark(), vehicle.getModel(), vehicle.getColor(),
        vehicle.getPrice(), vehicle.getPurshasePrice(), vehicle.getPurshaseDate(),
        vehicle.getDescription());
  }

  public int getKilometers() {
    return kilometers;
  }

  public LocalDate getLaunchDate() {
    return launchDate;
  }

  public int getPower() {
    return power;
  }

  public void setKilometers(int kilometers) {
    this.kilometers = kilometers;
  }

  public void setLaunchDate(LocalDate launchDate) {
    this.launchDate = launchDate;
  }

  public void setPower(int power) {
    this.power = power;
  }


}
