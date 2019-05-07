package rectangulo;

public class Rectangulo {
  protected int alto;
  protected int ancho;

  // Constructor
  Rectangulo(int alto, int ancho) {
    this.alto = alto;
    this.ancho = ancho;
  }

  /**
   * Devuelve el valor del alto del rectángulo.
   * 
   * @return alto
   */
  int getAlto() {
    return alto;
  }

  /**
   * Asigna el valor del alto al rectángulo.
   * 
   * @param alto
   * @throws ArithmeticException
   */
  void setAlto(int alto) throws ArithmeticException {
    if (alto < 1)
      throw new ArithmeticException(
        "\nEl alto del rectángulo no puede ser menor que 1.");

    if (alto > 10)
      throw new ArithmeticException(
          "\nEl alto del rectángulo no puede ser mayor que 10.");

    this.alto = alto;
  }

  /**
   * Devuelve el valor del ancho del rectángulo.
   * 
   * @return
   */
  int getAncho() {
    return ancho;
  }

  /**
   * Asigna el valor del ancho al rectángulo.
   * 
   * @param ancho
   * @throws ArithmeticException
   */
  void setAncho(int ancho) throws ArithmeticException {
    if (ancho < 0)
      throw new ArithmeticException(
          "\nEl alto del rectángulo no puede ser menor que 0.");

    if (ancho > 10)
      throw new ArithmeticException(
          "\nEl alto del rectángulo no puede ser mayor que 10.");
    this.ancho = ancho;
  }

  /**
   * Muestra el rectángulo por pantalla.
   */
  public String toString() {
    String ancho = ("");
    String alto = ("");
    String resultado = ("");

    for (int i = 0; i < getAncho(); i++) {
      ancho += ("* ");

      if (i == 0 || i == getAncho() - 1) {
        alto += ("* ");
      } else {
        alto += ("  ");
      }
    }

    if (getAlto() > 1 || getAncho() > 1) {
      resultado += (ancho + "\n");
      for (int i = 0; i < getAlto() - 2; i++) {
        resultado += (alto + "\n");
      }
      if (getAlto() > 1) {
        resultado += ancho;
      }
    } else {
      resultado = ("*");
    }

    return resultado;
  }
}

