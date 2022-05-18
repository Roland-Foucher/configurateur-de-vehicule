package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import java.time.LocalDate;
import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.IVehiculeOption;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;

public class VehicleBuilder {

  private Vehicle vehicle;

  public VehicleBuilder setId(Integer id) {
    vehicle.setId(id);
    return this;
  }

  public VehicleBuilder setMark(String mark) {
    vehicle.setMark(mark);
    return this;

  }

  public VehicleBuilder setModel(String model) {
    vehicle.setModel(model);
    return this;
  }

  public VehicleBuilder setColor(String color) {
    vehicle.setColor(color);
    return this;
  }

  public VehicleBuilder setPrice(Double price) {
    vehicle.setPrice(price);
    return this;
  }

  public VehicleBuilder setPurshasePrice(Double purshasePrice) {
    vehicle.setPurshasePrice(purshasePrice);
    return this;
  }

  public VehicleBuilder setPurshaseDate(LocalDate purshaseDate) {
    vehicle.setPurshaseDate(purshaseDate);
    return this;
  }

  public VehicleBuilder setDescription(String description) {
    vehicle.setDescription(description);
    return this;
  }

  public VehicleBuilder setVehiculeOptions(IVehiculeOption vehiculeOption) {
    vehicle.setVehiculeOptions(vehiculeOption);
    return this;
  }

  public VehicleBuilder setVehiculeType(VehiculeType vehiculeType) {
    vehicle.setVehiculeType(vehiculeType);
    return this;
  }

  public Vehicle build() {
    return vehicle;
  }

}
