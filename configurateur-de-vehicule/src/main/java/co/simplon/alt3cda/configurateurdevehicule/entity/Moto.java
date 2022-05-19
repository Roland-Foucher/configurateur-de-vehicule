package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;

@Entity
public class Moto extends Vehicle {
  @Column(columnDefinition = "INT unsigned")
  private int cylinder;

  @Column(columnDefinition = "INT unsigned")
  private int kilometers;

  private LocalDate launchDate;
  
  @Column (columnDefinition = "TINYINT unsigned")
  private int power;

  @Enumerated(EnumType.STRING)
  @Column (nullable = false)
  private MotoType motoType;


  public Moto(Vehicle vehicle) {
    super(vehicle.getId(), vehicle.getMark(), vehicle.getModel(), vehicle.getColor(),
        vehicle.getPrice(), vehicle.getPurshasePrice(), vehicle.getPurshaseDate(),
        vehicle.getDescription(), vehicle.getVehiculeType());
  }

  public Moto() {}

  public int getCylinder() {
    return cylinder;
  }

  public void setCylinder(int cylinder) {
    this.cylinder = cylinder;
  }

  public MotoType getMotoType() {
    return motoType;
  }

  public void setMotoType(MotoType motoType) {
    this.motoType = motoType;
  }

  public int getKilometers() {
    return kilometers;
  }

  public void setKilometers(int kilometers) {
    this.kilometers = kilometers;
  }

  public LocalDate getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(LocalDate launchDate) {
    this.launchDate = launchDate;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

}
