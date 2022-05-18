package co.simplon.alt3cda.configurateurdevehicule.service;


import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.CarBuilder;
import co.simplon.alt3cda.configurateurdevehicule.entityBuilder.VehicleBuilder;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;
import co.simplon.alt3cda.configurateurdevehicule.repository.BikeRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.CarRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.MotoRepository;
import co.simplon.alt3cda.configurateurdevehicule.repository.VehicleRepository;

@Service
public class initDatabase {

  @Autowired
  static VehicleRepository vehicleRepository;

  @Autowired
  static MotoRepository motoRepository;

  @Autowired
  static BikeRepository bikeRepository;

  @Transactional
  public static void init() {
    Vehicle vehicle = new VehicleBuilder().setColor("red").setMark("Peuegot").setModel("306")
        .setPrice(3000.0).setPurshaseDate(LocalDate.now()).setPurshasePrice(4000.0)
        .setVehiculeType(VehiculeType.Car)
        .setVehiculeOptions(new CarBuilder().setCarType(CarType.SEDAN).setDoor(Door.N5)
            .setGearBox(GearBox.MANUAL).setKilometers(10000).build())
        .build();

    vehicleRepository.save(vehicle);

  }
}
