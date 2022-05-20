package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;

/**
 * Les entités utilisent le design pattern builder pour créer les instances 
 */
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Bike extends Vehicle {

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "ENUM('ROAD', 'MOUNTAIN', 'CITY', 'RACE')", nullable = false)
  private BikeType bikeType;

  @Column(columnDefinition = "TINYINT unsigned")
  private int chainrings;
  private boolean antitheft;

  public Bike() {}

  public int getChainrings() {
    return chainrings;
  }

  public boolean isAntitheft() {
    return antitheft;
  }

  public BikeType getVeloType() {
    return bikeType;
  }

  public static class Builder {

    private Bike bike;

    public Builder(Vehicle vehicle, BikeType bikeType) {
      Assert.notNull(vehicle, "vehicle is null");
      Assert.notNull(bikeType, "bikeType is null");

      bike = new Bike();
      bike.setPrice(vehicle.getPrice());
      bike.setPurshasePrice(vehicle.getPurshasePrice());
      bike.setVehiculeType(vehicle.getVehiculeType());
      bike.bikeType = bikeType;
    }

    public Builder setId(Integer id) {
      bike.setId(id);
      return this;
    }

    public Builder setMark(String mark) {
      bike.setMark(mark);
      return this;

    }

    public Builder setModel(String model) {
      bike.setModel(model);
      return this;
    }

    public Builder setColor(String color) {
      bike.setColor(color);
      return this;
    }

    public Builder setPurshaseDate(LocalDate purshaseDate) {
      bike.setPurshaseDate(purshaseDate);
      return this;
    }

    public Builder setDescription(String description) {
      bike.setDescription(description);
      return this;
    }

    public Builder setChainrings(int chainrings) {
      bike.chainrings = chainrings;
      return this;
    }

    public Builder setAntitheft(Boolean antitheft) {
      bike.antitheft = antitheft;
      return this;

    }

    public Bike build() {
      return bike;
    }
  }



}
