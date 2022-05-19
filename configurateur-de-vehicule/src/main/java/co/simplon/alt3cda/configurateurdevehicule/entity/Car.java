package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;

@Entity
public class Car extends Vehicle {

  @Column(columnDefinition = "INT unsigned")
  private int kilometers;

  private LocalDate launchDate;

  @Column(columnDefinition = "TINYINT unsigned")
  private int power;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private Door door;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private GearBox gearBox;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private CarType carType;

  public Car(Vehicle vehicle) {
    super(vehicle.getId(), vehicle.getMark(), vehicle.getModel(), vehicle.getColor(),
        vehicle.getPrice(), vehicle.getPurshasePrice(), vehicle.getPurshaseDate(),
        vehicle.getDescription(), vehicle.getVehiculeType());
  }

  public Car() {}

  public int getDoor() {

    return door.getValue();
  }

  public GearBox getGearBox() {
    return gearBox;
  }

  public void setDoor(Door door) {
    this.door = door;
  }

  public void setGearBox(GearBox gearBox) {
    this.gearBox = gearBox;
  }

  public CarType getCarType() {
    return carType;
  }

  public void setCarType(CarType carType) {
    this.carType = carType;
  }

  public int getKilometers() {
    return kilometers;
  }

  public void setKilometers(int kilometers) {
    this.kilometers = kilometers;
  }

  public LocalDate getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(LocalDate launchDate) {
    this.launchDate = launchDate;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

}
