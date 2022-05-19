package co.simplon.alt3cda.configurateurdevehicule.exception;

public class VehicleNotInEnumException extends Exception {

  @Override
  public String getMessage() {

    return "This vehicule is not present in enum !";
  }

}
