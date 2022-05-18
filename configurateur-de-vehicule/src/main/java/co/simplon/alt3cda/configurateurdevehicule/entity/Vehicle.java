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
  private String mark;
  private String model;
  private String color;
  private BigDecimal price;
  private BigDecimal purshasePrice;
  private LocalDate purshaseDate;
  private String description;

  public Vehicle() {}

  public Vehicle(Integer id, String mark, String model, String color, BigDecimal price,
      BigDecimal purshasePrice, LocalDate purshaseDate, String description) {
    this.id = id;
    this.mark = mark;
    this.model = model;
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
    return mark;
  }

  public String getModel() {
    return model;
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

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setPurshasePrice(BigDecimal purshasePrice) {
    this.purshasePrice = purshasePrice;
  }

  public void setPurshaseDate(LocalDate purshaseDate) {
    this.purshaseDate = purshaseDate;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
