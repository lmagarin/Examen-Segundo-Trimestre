package utiles;

import java.util.Scanner;

/**
 * Lee los datos introducidos por teclado utilizando Scanner.
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 1.0
 */
public class Teclado {

  /**
   * Leer una cadena de caracteres por teclado.
   * 
   * @return cadena
   */
  public static String leerCandena() {
    Scanner scanner = new Scanner(System.in);
    String cadena = scanner.nextLine();
    return cadena;
  }

  /**
   * Lee números introducidos por teclado.
   * 
   * @return integer
   * @throws NumberFormatException
   */
  public static int leerInteger() throws NumberFormatException {
    int integer = 0;

    try {
      integer = Integer.parseInt(leerCandena().trim());
    } catch (NumberFormatException e) {
      System.err.println("\nFormato de número inválido.");
    }

    return integer;
  }

  /**
   * Lee un caracter introducido por teclado.
   * 
   * @return caracter
   */
  public static char leerChar() {
    char caracter = leerCandena().charAt(0);
    return caracter;
  }

  /**
   * Lee un decimal introducido por teclado.
   * 
   * @return decimal
   * @throws NumberFormatException
   */
  public static double leerDouble() throws NumberFormatException {
    double decimal = 0;
    try {
      decimal = Double.parseDouble(leerCandena().trim());
    } catch (Exception e) {
      System.err.println("\nFormato de número inválido.");
    }

    return decimal;
  }
}

