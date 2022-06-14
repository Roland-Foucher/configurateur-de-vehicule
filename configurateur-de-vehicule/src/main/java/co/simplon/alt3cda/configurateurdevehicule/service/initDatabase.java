package co.simplon.alt3cda.configurateurdevehicule.service;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;
import co.simplon.alt3cda.configurateurdevehicule.entity.Car;
import co.simplon.alt3cda.configurateurdevehicule.entity.Moto;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
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

  @Transactional(rollbackOn = Exception.class)
  public boolean init() {

    Car car = new Car.Builder(new Vehicle(3000.0, 4000.0, VehiculeType.CAR, "Peugeot", "306"), CarType.SEDAN, Door.N5,
        GearBox.MANUAL)
        .setId(1)
        .setColor("red")
        .setPurshaseDate(LocalDate.now())
        .setLaunchDate(LocalDate.now())
        .setKilometers(86000)
        .setPower(100)
        .build();

    vehicleRepository.save(car);

    Car car2 = new Car.Builder(new Vehicle(2300.0, 3000.0, VehiculeType.CAR, "Renault", "Clio"),
        CarType.SEDAN, Door.N5,
        GearBox.MANUAL)
        .setId(2)
        .setColor("black")
        .setPurshaseDate(LocalDate.now())
        .setLaunchDate(LocalDate.now())
        .setKilometers(13400)
        .setPower(100)
        .build();

    vehicleRepository.save(car2);

    Bike bike = new Bike.Builder(new Vehicle(150.9, 200.0, VehiculeType.BIKE, "Decatlon", "VRun"), BikeType.CITY)
        .setId(3)
        .setColor("blue")
        .setPurshaseDate(LocalDate.now())
        .build();

    vehicleRepository.save(bike);

    Moto moto = new Moto.Builder(new Vehicle(8000.0, 6000.0, VehiculeType.MOTO, "Maserati", "Grosse-Moto"),
        MotoType.SPORT)
        .setId(4)
        .setColor("green")
        .setPurshaseDate(LocalDate.now())
        .build();

    vehicleRepository.save(moto);
    return true;
  }
}
