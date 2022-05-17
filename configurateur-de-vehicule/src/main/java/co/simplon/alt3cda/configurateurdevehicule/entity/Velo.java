package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;

@Entity
public class Velo extends NonMotorVehicle {

  private int chainrings;
  private boolean antitheft;

  public Velo() {}

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



}
