package co.simplon.alt3cda.configurateurdevehicule.entity;

import javax.persistence.Entity;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;

@Entity
public class Moto extends MotorVehicle {
  private int cylinder;
  private MotoType motoType;

  public Moto(Vehicle vehicle) {
    super(vehicle);
  }

  public int getCylinder() {
    return cylinder;
  }

  public void setCylinder(int cylinder) {
    this.cylinder = cylinder;
  }

  public MotoType getMotoType() {
    return motoType;
  }

  public void setMotoType(MotoType motoType) {
    this.motoType = motoType;
  }

}
