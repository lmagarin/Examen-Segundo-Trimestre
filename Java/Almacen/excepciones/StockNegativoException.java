package excepciones;

/**
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 1.0
 */

public class StockNegativoException extends Exception {
  public StockNegativoException() {
    super("\nEl stock no puede ser negativo.");
  }
}

