package excepciones;

/**
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 1.0
 */

public class IvaInvalidoException extends Exception {
  public IvaInvalidoException() {
    super("\nEl IVA introducido no es válido.");
  }
}

