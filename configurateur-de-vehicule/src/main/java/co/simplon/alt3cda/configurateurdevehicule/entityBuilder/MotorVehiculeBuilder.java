package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.MotorVehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.GearBox;

public class MotorVehiculeBuilder {

  public static MotorVehicle getMoto(int cylinder) {
    return new Moto(cylinder);
  }

  public static MotorVehicle getCar(Door door, GearBox gearBox) {
    Car motorVehicle = new Car();
    motorVehicle.setDoor(door);
    motorVehicle.setGearBox(gearBox);
    return motorVehicle;
  }
}
