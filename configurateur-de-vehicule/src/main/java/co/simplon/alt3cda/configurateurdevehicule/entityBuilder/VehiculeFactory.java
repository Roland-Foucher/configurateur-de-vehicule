package co.simplon.alt3cda.configurateurdevehicule.entityBuilder;

import co.simplon.alt3cda.configurateurdevehicule.entity.Vehicle;
import co.simplon.alt3cda.configurateurdevehicule.entity.enumClass.VehiculeEnum;

public class VehiculeFactory {

  public static Vehicle getVehicule(VehiculeEnum vehiculeEnum, VehiculeAttributs vehiculeAttributs)
      throws Exception {
    switch (vehiculeEnum) {

      case Car:
        return MotorVehiculeBuilder.getCar(vehiculeAttributs.getDoor(),
            vehiculeAttributs.getGearBox());

      case Moto:
        return MotorVehiculeBuilder.getMoto(vehiculeAttributs.getCylinder());

      case Velo:
        return NonMotorVehiculeBuilder.getVelo(vehiculeAttributs.getChainrings(),
            vehiculeAttributs.isAntitheft());

      default:
        throw new Exception("this Vehicule don't exist !");
    }
  }
}
