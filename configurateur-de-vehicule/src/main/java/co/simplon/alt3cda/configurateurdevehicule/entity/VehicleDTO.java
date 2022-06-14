package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.time.LocalDate;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.CarType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.Door;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.GearBox;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;

/**
 * utilisation du pattern DTO pour transporter les données du front au backend
 * entité complète pour afficher la totalité des informations du vehicule
 * 
 */
public class VehicleDTO {
  private Integer id;
  private String mark;
  private String model;
  private String color;
  private Double price;
  private Double purshasePrice;
  private LocalDate purshaseDate;
  private String description;
  private VehiculeType vehiculeType;
  private int cylinder;
  private int kilometers;
  private LocalDate launchDate;
  private int power;
  private MotoType motoType;
  private Door door;
  private GearBox gearBox;
  private CarType carType;
  private BikeType bikeType;
  private int chainrings;
  private boolean antitheft;

  public VehicleDTO(Integer id, String mark, String model, String color, Double price,
      Double purshasePrice, LocalDate purshaseDate, String description,
      VehiculeType vehiculeType, int cylinder, int kilometers, LocalDate launchDate,
      int power, MotoType motoType, int door, GearBox gearBox, CarType carType,
      BikeType bikeType, int chainrings, boolean antitheft) {
    this.id = id;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.price = price;
    this.purshasePrice = purshasePrice;
    this.purshaseDate = purshaseDate;
    this.description = description;
    this.vehiculeType = vehiculeType;
    this.cylinder = cylinder;
    this.kilometers = kilometers;
    this.launchDate = launchDate;
    this.power = power;
    this.motoType = motoType;
    this.door = door == 2 ? Door.N2 : door == 3 ? Door.N3 : door == 5 ? Door.N5 : null;
    this.gearBox = gearBox;
    this.carType = carType;
    this.bikeType = bikeType;
    this.chainrings = chainrings;
    this.antitheft = antitheft;
  }

  public Integer getId() {
    return id;
  }

  public String getMark() {
    return mark;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public Double getPrice() {
    return price;
  }

  public Double getPurshasePrice() {
    return purshasePrice;
  }

  public LocalDate getPurshaseDate() {
    return purshaseDate;
  }

  public String getDescription() {
    return description;
  }

  public VehiculeType getVehiculeType() {
    return vehiculeType;
  }

  public int getCylinder() {
    return cylinder;
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

  public MotoType getMotoType() {
    return motoType;
  }

  public Door getDoor() {
    return door;
  }

  public GearBox getGearBox() {
    return gearBox;
  }

  public CarType getCarType() {
    return carType;
  }

  public BikeType getBikeType() {
    return bikeType;
  }

  public int getChainrings() {
    return chainrings;
  }

  public boolean isAntitheft() {
    return antitheft;
  }
}
