package co.simplon.alt3cda.configurateurdevehicule.entity;

import co.simplon.alt3cda.configurateurdevehicule.enumClass.VehiculeType;

/**
 * * utilisation du pattern DTO pour transporter les données du front au backend
 * Entité DTO envoyé au front avec le minimum de'attribut pour afficher la liste des vehicule
 * permet d'économisé la data lors transfert de l'envoi des données
 */
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
