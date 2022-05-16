package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;
import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.GearBox;

@Entity
public class Car extends MotorVehicle {
  private int door;
  private GearBox gearBox;

  public int getDoor() {
    return door;
  }

  public GearBox getGearBox() {
    return gearBox;
  }

}
