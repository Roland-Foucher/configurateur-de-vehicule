package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;
import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.GearBox;

@Entity
public class Car extends MotorVehicle {
  private Door door;
  private GearBox gearBox;

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

}
