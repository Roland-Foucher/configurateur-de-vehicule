package co.simplon.alt3cda.configurateurdevehicule.service;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehiculeBuilder;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;

@Service
public class InitDatabase {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Transactional
  public void init() {
    if (vehicleRepository.findAll().size() == 0){
      Vehicle vehicle = new Vehicle.Builder()
        .setId(1)
        .setColor("red")
        .setMark("Peugeot")
        .setModel("306")
        .setPrice(3000.0)
        .setPurshaseDate(LocalDate.now())
        .setPurshasePrice(4000.0)
        .setVehiculeType(VehiculeType.Car).build();

    Car car = VehiculeBuilder.setCar(vehicle, 86000, LocalDate.now(), 100, Door.N5, GearBox.MANUAL,
        CarType.SEDAN);

    vehicleRepository.save(car);
    
    Vehicle vehicle2 = new Vehicle.Builder()
      .setId(2)
      .setColor("black")
      .setMark("Renault")
      .setModel("Clio")
      .setPrice(2300.0)
      .setPurshaseDate(LocalDate.now())
      .setPurshasePrice(3000.0)
      .setVehiculeType(VehiculeType.Car)
      .build();

    Car car2 = VehiculeBuilder.setCar(vehicle2, 134000, LocalDate.now(), 100, Door.N5, GearBox.MANUAL,
        CarType.SEDAN);

    vehicleRepository.save(car2);

    Vehicle vehicle3 = new Vehicle.Builder()
      .setId(3)
      .setColor("blue")
      .setMark("dectlon")
      .setModel("vrun")
      .setPrice(150.90)
      .setPurshaseDate(LocalDate.now())
      .setPurshasePrice(200.0)
      .setVehiculeType(VehiculeType.Bike)
      .build();

    Bike bike = VehiculeBuilder.setBike(vehicle3, 4, false, BikeType.CITY);
    vehicleRepository.save(bike);

    Vehicle vehicle4 = new Vehicle.Builder()
    .setId(4)
    .setColor("green")
    .setMark("Maserati")
    .setModel("grosseMoto")
    .setPrice(8000.00)
    .setPurshaseDate(LocalDate.now())
    .setPurshasePrice(6000.0)
    .setVehiculeType(VehiculeType.Moto)
    .build();

  Moto moto = VehiculeBuilder.setMoto(vehicle4, 80000, LocalDate.now(), 100, 80, MotoType.SPORT);
  vehicleRepository.save(bike);
      

  vehicleRepository.save(moto);

    }

  }
}
