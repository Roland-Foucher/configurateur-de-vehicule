package co.simplon.alt3cda.configurateurdevehicule.exception;

public class VehiculeNotInDatabaseException extends Exception {

  @Override
  public String getMessage() {
    return "vehicle not in database";
  }
}
