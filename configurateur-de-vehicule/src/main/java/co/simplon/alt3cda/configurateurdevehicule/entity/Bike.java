package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;

@Entity
public class Bike extends Vehicle {

  @Enumerated(EnumType.ORDINAL)
  private BikeType veloType;

  private int chainrings;
  private boolean antitheft;


  public Bike(Vehicle vehicle) {
    super(vehicle.getId(), vehicle.getMark(), vehicle.getModel(), vehicle.getColor(),
        vehicle.getPrice(), vehicle.getPurshasePrice(), vehicle.getPurshaseDate(),
        vehicle.getDescription());
  }

  public Bike() {}

  public int getChainrings() {
    return chainrings;
  }

  public boolean isAntitheft() {
    return antitheft;
  }

  public void setChainrings(int chainrings) {
    this.chainrings = chainrings;
  }

  public void setAntitheft(boolean antitheft) {
    this.antitheft = antitheft;
  }

  public BikeType getVeloType() {
    return veloType;
  }

  public void setVeloType(BikeType veloType) {
    this.veloType = veloType;
  }



}
