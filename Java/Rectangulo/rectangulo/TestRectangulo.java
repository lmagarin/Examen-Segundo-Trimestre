package rectangulo;

import rectangulo.Rectangulo;
import utiles.Teclado;
import utiles.Menu;

public class TestRectangulo {

  static Menu menuPrincipal = new Menu();
  
  public static void main(String[] args) {
    
    String[] opcionesPrincipal = {"Crear Rectángulo", "Terminar"};
    menuPrincipal.crearMenu("Menu Principal", opcionesPrincipal);
    String seleccion;
    
    Rectangulo rectangulo = new Rectangulo(1, 1);

    do {
      seleccion = menuPrincipal.recogerOpcion();

      switch (seleccion) {
        case "1" :
          crear(rectangulo);
          break;

        case "2" :
          System.out.println("Programa terminado.");
          break;

        default :
          System.err.println("Selección Fuera de Rango.");
          break;
      }
    } while (!seleccion.equals("2"));
  }

  /**
   * Crea un rectángulo.
   * 
   * @throws ArithmeticException
   */
  private static void crear(Rectangulo rectangulo) throws ArithmeticException {

    System.out.print("Introduzca el alto del rectángulo: ");
    int alto = Teclado.leerInteger();

    System.out.print("Introduzca el ancho del rectángulo: ");
    int ancho = Teclado.leerInteger();

    try {
      rectangulo.setAlto(alto);
      rectangulo.setAncho(ancho);
      System.out.println(rectangulo);
    } catch (ArithmeticException e) {
      System.err.println(
          "\nNo se ha podio crear el rectángulo.\n" + e.getMessage());
    }
  }
}

