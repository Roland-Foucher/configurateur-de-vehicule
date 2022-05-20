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

  @Transactional
  public void init() {
    if (vehicleRepository.findAll().size() == 0){

      Car car = new Car.Builder(new Vehicle(3000.0, 4000.0, VehiculeType.CAR), 
                                    CarType.SEDAN, Door.N5, 
                                    GearBox.MANUAL)
                        .setId(1)
                        .setColor("red")
                        .setMark("Peugeot")
                        .setModel("306")
                        .setPurshaseDate(LocalDate.now())
                        .setLaunchDate(LocalDate.now())
                        .setKilometers(86000)
                        .setPower(100)
                        .build();

    vehicleRepository.save(car);

    Car car2 = new Car.Builder(new Vehicle(2300.0, 3000.0, VehiculeType.CAR), 
                                  CarType.SEDAN, Door.N5, 
                                  GearBox.MANUAL)
                        .setId(2)
                        .setColor("black")
                        .setMark("Renault")
                        .setModel("Clio")
                        .setPurshaseDate(LocalDate.now())
                        .setLaunchDate(LocalDate.now())
                        .setKilometers(13400)
                        .setPower(100)
                        .build();

    vehicleRepository.save(car2);

    Bike bike = new Bike.Builder(new Vehicle(150.9, 200.0, VehiculeType.BIKE), BikeType.CITY)
                        .setId(3)
                        .setColor("blue")
                        .setMark("decatlon")
                        .setModel("vrun")
                        .setPurshaseDate(LocalDate.now())
                        .build();

    vehicleRepository.save(bike);

    Moto moto = new Moto.Builder(new Vehicle(8000.0, 6000.0, VehiculeType.MOTO), MotoType.SPORT)
                        .setId(4)
                        .setColor("green")
                        .setMark("Maserati")
                        .setModel("grosseMoto")
                        .setPurshaseDate(LocalDate.now())
                        .build();
      

  vehicleRepository.save(moto);

    }

  }
}
