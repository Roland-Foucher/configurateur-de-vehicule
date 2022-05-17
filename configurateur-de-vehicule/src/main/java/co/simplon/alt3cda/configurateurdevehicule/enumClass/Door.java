package co.simplon.alt3cda.configurateurdevehicule.enumClass;

public enum Door {

  N2(2), N3(3), N5(5);

  private int value;

  Door(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

}
