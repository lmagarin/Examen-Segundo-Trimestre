package rectangulo;

public class Cuadrado extends Rectangulo {

  // Constructor
  Cuadrado(int lado) {
    super(lado, lado);
    setAlto(lado);
    setAncho(lado);
  }

  /**
   * Devuelve el valor del lado del cuadrado.
   * 
   * @return lado
   */
  int getLado() {
    return getAlto();
  }

  /**
   * Asigna el valor al lado del cuadrado.
   * 
   * @param lado
   * @throws ArithmeticException
   */
  void setLado(int lado) throws ArithmeticException {
    if (lado < 1)
      throw new ArithmeticException("El lado no puede ser menor que 1.");

    if (lado > 10)
      throw new ArithmeticException("El lado no puede ser mayor que 10.");

    this.alto = lado;
    this.ancho = lado;
  }
}
