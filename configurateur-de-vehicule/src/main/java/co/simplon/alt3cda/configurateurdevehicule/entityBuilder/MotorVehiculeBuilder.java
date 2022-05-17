package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import java.time.LocalDate;
import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.MotorVehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;

public abstract class MotorVehiculeBuilder {

  public static Moto getMoto(Vehicle vehicle, int kilometers, LocalDate launchDate, int power,
      int cylinder, MotoType type) {
    Assert.notNull(vehicle, "vehicle is null");
    Assert.notNull(type, "type of moto is null");

    Moto moto = new Moto(vehicle);
    moto.setCylinder(cylinder);
    moto.setMotoType(type);
    moto.setKilometers(kilometers);
    moto.setLaunchDate(launchDate);
    moto.setPower(power);
    return moto;
  }

  public static Car getCar(Vehicle vehicle, int kilometers, LocalDate launchDate, int power,
      Door door, GearBox gearBox, CarType type) {
    Assert.notNull(vehicle, "vehicle is null");
    Assert.notNull(door, "no door configured for the car");
    Assert.notNull(gearBox, "no gearBox configured for the car");
    Assert.notNull(type, "type of car is null");


    Car car = new Car(vehicle);
    car.setKilometers(kilometers);
    car.setLaunchDate(launchDate);
    car.setPower(power);
    car.setDoor(door);
    car.setGearBox(gearBox);
    car.setCarType(type);
    return car;
  }
}
