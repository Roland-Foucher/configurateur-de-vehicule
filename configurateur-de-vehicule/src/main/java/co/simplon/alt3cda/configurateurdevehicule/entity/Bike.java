package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;

@Entity
public class Bike extends NonMotorVehicle {

  private BikeType veloType;
  private int chainrings;
  private boolean antitheft;

  public Bike(Vehicle vehicle) {
    super(vehicle);
  }

  public int getChainrings() {
    return chainrings;
  }

  public boolean isAntitheft() {
    return antitheft;
  }

  public void setChainrings(int chainrings) {
    this.chainrings = chainrings;
  }

  public void setAntitheft(boolean antitheft) {
    this.antitheft = antitheft;
  }

  public BikeType getVeloType() {
    return veloType;
  }

  public void setVeloType(BikeType veloType) {
    this.veloType = veloType;
  }



}
