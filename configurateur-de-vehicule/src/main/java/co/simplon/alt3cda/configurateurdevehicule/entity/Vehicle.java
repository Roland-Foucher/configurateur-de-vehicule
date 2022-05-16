package co.simplon.alt3cda.configurateurdevehicule.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String Mark;
  private String Model;
  private String color;
  private BigDecimal price;
  private BigDecimal purshasePrice;
  private LocalDate purshaseDate;
  private String description;

  public Vehicle() {}

  public Vehicle(Integer id, String mark, String model, String color, BigDecimal price,
      BigDecimal purshasePrice, LocalDate purshaseDate, String description) {
    this.id = id;
    Mark = mark;
    Model = model;
    this.color = color;
    this.price = price;
    this.purshasePrice = purshasePrice;
    this.purshaseDate = purshaseDate;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public String getMark() {
    return Mark;
  }

  public String getModel() {
    return Model;
  }

  public String getColor() {
    return color;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getPurshasePrice() {
    return purshasePrice;
  }

  public LocalDate getPurshaseDate() {
    return purshaseDate;
  }

  public String getDescription() {
    return description;
  }

}