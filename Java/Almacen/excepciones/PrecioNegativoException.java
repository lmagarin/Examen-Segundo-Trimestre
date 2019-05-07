package excepciones;

/**
 * Esta excepción utiliza el mensaje personalizado cuando se lanza ya que es
 * utilizada tanto como para el precio de compra como para el precio de venta.
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 1.0
 */

public class PrecioNegativoException extends Exception {
  public PrecioNegativoException(String string) {
    super(string);
  }
}

