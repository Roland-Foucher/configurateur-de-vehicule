package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.NonMotorVehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.Velo;

public class NonMotorVehiculeBuilder {
  public static NonMotorVehicle getVelo(int chainrings, boolean antitheft) {
    Velo velo = new Velo();
    velo.setAntitheft(antitheft);
    velo.setChainrings(chainrings);
    return velo;
  }
}
