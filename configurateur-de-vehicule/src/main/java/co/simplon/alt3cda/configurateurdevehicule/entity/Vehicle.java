package co.simplon.alt3cda.configurateurdevehicule.entity;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String mark;
  private String model;
  private String color;

  @Column(columnDefinition = "double unsigned", nullable = false)
  private Double price;

  @Column(columnDefinition = "double unsigned", nullable = false)
  private Double purshasePrice;

  @Column(nullable = false)
  private LocalDate purshaseDate;

  @Column (columnDefinition = "TINYTEXT")
  private String description;

  @Enumerated(EnumType.STRING)
  private VehiculeType VehiculeType;

  public Vehicle() {}

  public Vehicle(Integer id, String mark, String model, String color, Double price,
      Double purshasePrice, LocalDate purshaseDate, String description, VehiculeType vehiculeType) {
    this.id = id;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.price = price;
    this.purshasePrice = purshasePrice;
    this.purshaseDate = purshaseDate;
    this.description = description;
    this.VehiculeType = vehiculeType;
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

  public void setId(Integer id) {
    this.id = id;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setPurshasePrice(Double purshasePrice) {
    this.purshasePrice = purshasePrice;
  }

  public void setPurshaseDate(LocalDate purshaseDate) {
    this.purshaseDate = purshaseDate;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public VehiculeType getVehiculeType() {
    return VehiculeType;
  }

  public void setVehiculeType(VehiculeType vehiculeType) {
    VehiculeType = vehiculeType;
  }


  public static class Builder {

    private Vehicle vehicle = new Vehicle();

    public Builder setId(Integer id) {
      vehicle.setId(id);
      return this;
    }

    public Builder setMark(String mark) {
      vehicle.setMark(mark);
      return this;

    }

    public Builder setModel(String model) {
      vehicle.setModel(model);
      return this;
    }

    public Builder setColor(String color) {
      vehicle.setColor(color);
      return this;
    }

    public Builder setPrice(Double price) {
      vehicle.setPrice(price);
      return this;
    }

    public Builder setPurshasePrice(Double purshasePrice) {
      vehicle.setPurshasePrice(purshasePrice);
      return this;
    }

    public Builder setPurshaseDate(LocalDate purshaseDate) {
      vehicle.setPurshaseDate(purshaseDate);
      return this;
    }

    public Builder setDescription(String description) {
      vehicle.setDescription(description);
      return this;
    }

    public Builder setVehiculeType(VehiculeType vehiculeType) {
      vehicle.setVehiculeType(vehiculeType);
      return this;
    }

    public Vehicle build() {
      return vehicle;
    }
  }
}
