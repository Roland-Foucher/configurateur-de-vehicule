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
  private VehiculeType vehiculeType;

  public Vehicle() {}
  public Vehicle(Double price, Double purshasePrice, VehiculeType vehiculeType, String mark, String model) {
    
    Assert.notNull(price, "price is null");
    Assert.notNull(purshasePrice, "purshaseprice is null");
    Assert.notNull(vehiculeType, "vehiculeType is null");
    Assert.notNull(mark, "vehicle mark is null");
    Assert.notNull(model, "vehicle model is null");

    this.price = price;
    this.purshasePrice = purshasePrice;
    this.vehiculeType = vehiculeType;
    this.mark = mark;
    this.model = model;
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

  protected void setId(Integer id) {
    this.id = id;
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

  protected void setVehiculeType(VehiculeType vehiculeType) {
    this.vehiculeType = vehiculeType;
  }

  protected void setModel(String model) {
    this.model = model;
  }

  protected void setMark(String mark) {
    this.mark = mark;
  }
  
}
