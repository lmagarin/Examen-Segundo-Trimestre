package excepciones;

/**
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 1.0
 */

public class CodigoNoExisteException extends Exception {
  public CodigoNoExisteException() {
    super("\nEl código no se encuentra entre los artículos.");
  }
}

