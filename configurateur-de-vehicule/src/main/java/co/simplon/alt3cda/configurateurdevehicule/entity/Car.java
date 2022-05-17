package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;

@Entity
public class Car extends MotorVehicle {
  private Door door;
  private GearBox gearBox;
  private CarType carType;

  public Car(Vehicle vehicle) {
    super(vehicle);
  }

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

}
