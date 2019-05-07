package rectangulo;

import rectangulo.Cuadrado;

import utiles.Teclado;
import utiles.Menu;

public class TestCuadrado {

  static Menu menuPrincipal = new Menu();

  public static void main(String[] args) {
    String[] opciones = {"Crear Cuadrado", "Compara Cuadrados", "Terminar"};
    menuPrincipal.crearMenu("Menu Principal", opciones);

    Cuadrado cuadrado1 = new Cuadrado(1);
    Cuadrado cuadrado2 = new Cuadrado(1);

    String seleccion;

    do {
      seleccion = menuPrincipal.recogerOpcion();
      switch (seleccion) {
        case "1" :
          crear(cuadrado1);
          break;

        case "2" :
          comparar(cuadrado1, cuadrado2);
          break;

        case "3" :
          System.out.println("Programa Finalizado.");
          break;

        default :
          System.err.println("Selección fuera de rango.");
          break;
      }
    } while (!seleccion.equals("3"));
  }

  /**
   * Crea un cuadrado.
   * 
   * @throws ArithmeticException
   */
  private static void crear(Cuadrado cuadrado1) throws ArithmeticException {
    System.out.print("Introduzca la longitud del lado: ");
    int lado = Teclado.leerInteger();

    try {
      cuadrado1.setLado(lado);
      System.out.println("\n");
      System.out.println(cuadrado1);
      System.out.println("\n");
    } catch (ArithmeticException e) {
      System.err.println(
          "\nNo se ha podido crear el cuadrado.\n" + e.getMessage());
    }

  }

  /**
   * Compara dos cuadrados.
   * 
   * @param cuadrado1
   * @param cuadrado2
   */
  private static void comparar(Cuadrado cuadrado1, Cuadrado cuadrado2) {
    System.out.print("Introduzca la longitud del lado: ");
    int lado = Teclado.leerInteger();

    try {
      cuadrado2.setLado(lado);

      System.out.println("\nCuadrado 1:");
      System.out.println(cuadrado1);
      System.out.println("\n\nCuadrado 2:");
      System.out.println(cuadrado2);
      System.out.println("\n");

      if (cuadrado1.getLado() == cuadrado2.getLado()) {
        System.out.println("El 1º es igual que el 2º.");
      } else if (cuadrado1.getLado() < cuadrado2.getLado()) {
        System.out.println("El 1º es menor que el 2º.");
      } else {
        System.out.println("El 1º es mayor que el 2º.");
      }
    } catch (ArithmeticException e) {
      System.err.println("\nNo se ha podido crear el segundo cuadrado.\n"
          + e.getMessage());
    }
  }
}

