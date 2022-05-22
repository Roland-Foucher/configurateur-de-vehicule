package co.simplon.alt3cda.configurateurdevehicule.entity;

import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;

public class SmallVehicleDTO {
  private Integer id;
  private String mark;
  private String model;
  private VehiculeType vehiculeType;
  private Double price;

  public SmallVehicleDTO(Integer id, String mark, String model, VehiculeType vehiculeType,
      Double price) {
    this.id = id;
    this.mark = mark;
    this.model = model;
    this.vehiculeType = vehiculeType;
    this.price = price;
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


  public VehiculeType getVehiculeType() {
    return vehiculeType;
  }


  public Double getPrice() {
    return price;
  }
}
