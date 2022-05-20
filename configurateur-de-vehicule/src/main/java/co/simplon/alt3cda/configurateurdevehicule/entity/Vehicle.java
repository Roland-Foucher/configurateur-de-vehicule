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
import org.springframework.util.Assert;
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

  @Column(columnDefinition = "DECIMAL(10,2) unsigned", nullable = false)
  private Double price;

  @Column(columnDefinition = "DECIMAL(10,2) unsigned", nullable = false)
  private Double purshasePrice;

  @Column(nullable = false)
  private LocalDate purshaseDate;

  @Column (columnDefinition = "TINYTEXT")
  private String description;

  @Enumerated(EnumType.STRING)
  @Column (columnDefinition = "ENUM('CAR', 'MOTO', 'BIKE')", nullable = false)
  private VehiculeType VehiculeType;

  public Vehicle() {}
  public Vehicle(Double price, Double purshasePrice, VehiculeType vehiculeType) {
    
    Assert.notNull(price, "price is null");
    Assert.notNull(purshasePrice, "purshaseprice is null");
    Assert.notNull(vehiculeType, "vehiculeType is null");

    this.price = price;
    this.purshasePrice = purshasePrice;
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

  protected void setId(Integer id) {
    this.id = id;
  }

  protected void setMark(String mark) {
    this.mark = mark;
  }

  protected void setModel(String model) {
    this.model = model;
  }

  protected void setColor(String color) {
    this.color = color;
  }

  protected void setPrice(Double price) {
    this.price = price;
  }

  protected void setPurshasePrice(Double purshasePrice) {
    this.purshasePrice = purshasePrice;
  }

  protected void setPurshaseDate(LocalDate purshaseDate) {
    this.purshaseDate = purshaseDate;
  }

  protected void setDescription(String description) {
    this.description = description;
  }

  public VehiculeType getVehiculeType() {
    return VehiculeType;
  }

  protected void setVehiculeType(VehiculeType vehiculeType) {
    VehiculeType = vehiculeType;
  }
  
}
