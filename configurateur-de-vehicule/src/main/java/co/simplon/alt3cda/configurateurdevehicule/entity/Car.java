package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;

/**
 * Les entités utilisent le design pattern builder pour créer les instances
 */
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Car extends Vehicle {

  @Column(columnDefinition = "INT unsigned")
  private int kilometers;

  private LocalDate launchDate;

  @Column(columnDefinition = "TINYINT unsigned")
  private int power;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "ENUM('N2', 'N3', 'N5')", nullable = false)
  private Door door;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "ENUM('MANUAL', 'AUTO')", nullable = false)
  private GearBox gearBox;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "ENUM('SPORT', 'SUV', 'SEDAN', 'CONVERTIBLE', 'COUPE')", nullable = false)
  private CarType carType;

  public Car() {
  }

  public int getDoor() {
    return door.getValue();
  }

  public GearBox getGearBox() {
    return gearBox;
  }

  public CarType getCarType() {
    return carType;
  }

  public int getKilometers() {
    return kilometers;
  }

  public LocalDate getLaunchDate() {
    return launchDate;
  }

  public int getPower() {
    return power;
  }

  public static class Builder {

    private Car car;

    public Builder(Vehicle vehicle, CarType carType, Door door, GearBox gearBox) {

      Assert.notNull(vehicle, "vehicle is null");
      Assert.notNull(carType, "carType is null");
      Assert.notNull(door, "door is null");
      Assert.notNull(gearBox, "gearBox is null");

      car = new Car();
      car.setPrice(vehicle.getPrice());
      car.setPurshasePrice(vehicle.getPurshasePrice());
      car.setVehiculeType(vehicle.getVehiculeType());
      car.setMark(vehicle.getMark());
      car.setModel(vehicle.getModel());
      car.carType = carType;
      car.door = door;
      car.gearBox = gearBox;
    }

    public Builder setId(Integer id) {
      car.setId(id);
      return this;
    }

    public Builder setColor(String color) {
      car.setColor(color);
      return this;
    }

    public Builder setPurshaseDate(LocalDate purshaseDate) {
      car.setPurshaseDate(purshaseDate);
      return this;
    }

    public Builder setDescription(String description) {
      car.setDescription(description);
      return this;
    }

    public Builder setKilometers(int kilometers) {
      car.kilometers = kilometers;
      return this;

    }

    public Builder setLaunchDate(LocalDate launchDate) {
      car.launchDate = launchDate;
      return this;
    }

    public Builder setPower(int power) {
      car.power = power;
      return this;
    }

    public Car build() {
      return car;
    }
  }

}
