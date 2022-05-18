package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;

public abstract class VehiculeBuilder {

  public static Vehicle setVehicule(Integer id, String mark, String model, String color,
      BigDecimal price, BigDecimal purchasePrice, LocalDate purshaseDate, String description) {
    Vehicle vehicle = new Vehicle();
    vehicle.setId(id);
    vehicle.setMark(mark);
    vehicle.setModel(model);
    vehicle.setColor(color);
    vehicle.setPrice(price);
    vehicle.setPurshaseDate(purshaseDate);
    vehicle.setDescription(description);
    return vehicle;

  }

  public static Bike setVelo(Vehicle vehicle, int chainrings, boolean antitheft, BikeType type) {
    Assert.notNull(vehicle, "vehicle is null");
    Assert.notNull(type, "type of bike is null");

    Bike bike = new Bike(vehicle);
    bike.setAntitheft(antitheft);
    bike.setChainrings(chainrings);
    bike.setVeloType(type);
    return bike;
  }

  public static Moto setMoto(Vehicle vehicle, int kilometers, LocalDate launchDate, int power,
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

  public static Car setCar(Vehicle vehicle, int kilometers, LocalDate launchDate, int power,
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
