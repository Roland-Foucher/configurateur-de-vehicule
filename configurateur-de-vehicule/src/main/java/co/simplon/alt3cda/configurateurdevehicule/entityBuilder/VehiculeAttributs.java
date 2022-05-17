package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.GearBox;

public class VehiculeAttributs {
  private Door door;
  private GearBox gearBox;
  private int cylinder;
  private int chainrings;
  private boolean isAntitheft;

  public VehiculeAttributs() {}

  public VehiculeAttributs(Door door, GearBox gearBox, int cylinder, int chainrings,
      boolean isAntitheft) {
    this.door = door;
    this.gearBox = gearBox;
    this.cylinder = cylinder;
    this.chainrings = chainrings;
    this.isAntitheft = isAntitheft;
  }

  public Door getDoor() {
    return door;
  }

  public void setDoor(Door door) {
    this.door = door;
  }

  public GearBox getGearBox() {
    return gearBox;
  }

  public void setGearBox(GearBox gearBox) {
    this.gearBox = gearBox;
  }

  public int getCylinder() {
    return cylinder;
  }

  public void setCylinder(int cylinder) {
    this.cylinder = cylinder;
  }

  public int getChainrings() {
    return chainrings;
  }

  public void setChainrings(int chainrings) {
    this.chainrings = chainrings;
  }

  public boolean isAntitheft() {
    return isAntitheft;
  }

  public void setAntitheft(boolean isAntitheft) {
    this.isAntitheft = isAntitheft;
  }


}
