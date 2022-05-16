package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;

@Entity
public class Velo extends Vehicle {
  private String type;
  private int chainrings;
  private boolean antitheft;

  public String getType() {
    return type;
  }

  public int getChainrings() {
    return chainrings;
  }

  public boolean isAntitheft() {
    return antitheft;
  }



}
