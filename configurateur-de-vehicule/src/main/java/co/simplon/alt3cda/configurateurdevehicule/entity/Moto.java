package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;

@Entity
public class Moto extends MotorVehicle {
  private int Cylinder;

  public int getCylinder() {
    return Cylinder;
  }



}
