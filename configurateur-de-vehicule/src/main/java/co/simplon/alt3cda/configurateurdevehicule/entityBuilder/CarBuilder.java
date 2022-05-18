package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import java.time.LocalDate;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;

public class CarBuilder {
  Car car;

  public CarBuilder setKilometers(int kilometers) {
    car.setKilometers(kilometers);
    return this;
  }

  public CarBuilder setLaunchDate(LocalDate launchDate) {
    car.setLaunchDate(launchDate);
    return this;
  }

  public CarBuilder setPower(int power) {
    car.setPower(power);
    return this;
  }

  public CarBuilder setCarType(CarType carType) {
    car.setCarType(carType);
    return this;
  }

  public CarBuilder setDoor(Door door) {
    car.setDoor(door);
    return this;
  }

  public CarBuilder setGearBox(GearBox gearBox) {
    car.setGearBox(gearBox);
    return this;
  }

  public Car build() {
    return car;
  }

}
