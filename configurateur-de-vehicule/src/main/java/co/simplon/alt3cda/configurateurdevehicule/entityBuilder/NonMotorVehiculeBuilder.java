package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import org.springframework.util.Assert;
import co.simplon.alt3cda.configurateurdevehicule.entity.NonMotorVehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.enumClass.BikeType;
import co.simplon.alt3cda.configurateurdevehicule.entity.Bike;

public abstract class NonMotorVehiculeBuilder {
  public static Bike getVelo(Vehicle vehicle, int chainrings, boolean antitheft, BikeType type) {
    Assert.notNull(vehicle, "vehicle is null");
    Assert.notNull(type, "type of bike is null");

    Bike bike = new Bike(vehicle);
    bike.setAntitheft(antitheft);
    bike.setChainrings(chainrings);
    bike.setVeloType(type);
    return bike;
  }

}
