package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;

@Entity
public class Moto extends MotorVehicle {
  private int cylinder;


  public Moto(int cylinder) {
    this.cylinder = cylinder;
  }


  public int getCylinder() {
    return cylinder;
  }

}
