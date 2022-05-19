package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.MotoType;

@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Moto extends Vehicle {
  @Column(columnDefinition = "INT unsigned")
  private int cylinder;

  @Column(columnDefinition = "INT unsigned")
  private int kilometers;

  private LocalDate launchDate;
  
  @Column (columnDefinition = "TINYINT unsigned")
  private int power;

  @Enumerated(EnumType.STRING)
  @Column (columnDefinition = "ENUM('SPORT', 'ROAD', 'ROADSTER')", nullable = false)
  private MotoType motoType;

  public Moto() {}

  public int getCylinder() {
    return cylinder;
  }

  public MotoType getMotoType() {
    return motoType;
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

    private Moto moto;

    public Builder(Vehicle vehicule, MotoType motoType) {
      moto = new Moto();
      moto.setPrice(vehicule.getPrice());
      moto.setPurshasePrice(vehicule.getPurshasePrice());
      moto.setVehiculeType(vehicule.getVehiculeType());
      moto.motoType = motoType;
    }

    public Builder setId(Integer id) {
      moto.setId(id);
      return this;
    }

    public Builder setMark(String mark) {
      moto.setMark(mark);
      return this;

    }

    public Builder setModel(String model) {
      moto.setModel(model);
      return this;
    }

    public Builder setColor(String color) {
      moto.setColor(color);
      return this;
    }

    public Builder setPurshaseDate(LocalDate purshaseDate) {
      moto.setPurshaseDate(purshaseDate);
      return this;
    }

    public Builder setDescription(String description) {
      moto.setDescription(description);
      return this;
    }

    public Builder setCylinder(int cylinder) {
      moto.cylinder = cylinder;
      return this;
    }

    public Builder setKilometers(int kilometers) {
      moto.kilometers = kilometers;
      return this;

    }

    public Builder setLaunchDate(LocalDate launchDate) {
      moto.launchDate = launchDate;
      return this;
    }

    public Builder setPower(int power) {
      moto.power = power;
      return this;
    }

    public Moto build() {
      return moto;
    }
  }


   

}
