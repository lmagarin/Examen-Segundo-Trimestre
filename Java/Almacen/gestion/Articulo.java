package gestion;

import excepciones.IvaInvalidoException;
import excepciones.PrecioNegativoException;
import excepciones.StockNegativoException;

/**
 * Define los atributos de los artículos que se creen.
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 3.0
 */

public class Articulo {

  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int stock;
  private String iva;
  private static int contador = 1;

  // Constructor.
  Articulo(String descripcion, double precioCompra, double precioVenta,
      int stock, String iva) throws StockNegativoException,
      PrecioNegativoException, IvaInvalidoException {
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
    setIva(iva);
    this.codigo = generarCodigo();
  }

  /**
   * Genera el código del artículo.
   * 
   * @return contador
   */
  int generarCodigo() {
    return contador++;
  }

  /**
   * Devuelve el valor del código de un articulo.
   * 
   * @return codigo
   */
  int getCodigo() {
    return codigo;
  }

  /**
   * Asigna el valor del código a un artículo.
   * 
   * @param incrementarCodigo
   */
  void setCodigo(int incrementarCodigo) {
    this.codigo = incrementarCodigo;
  }

  /**
   * Devuelve el valor el código de un artículo.
   * 
   * @return descripcion
   */
  String getDescripcion() {
    return descripcion;
  }

  /**
   * Asigna el valor de la descripción a un artículo.
   * 
   * @param descripcion
   */
  void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Devuelve el valor del precio de compra de una artículo.
   * 
   * @return precioCompra
   */
  double getPrecioCompra() {
    return precioCompra;
  }

  /**
   * Asgina el precio de compra de un artículo. Si el precio del artículo es
   * negativo no se crea o modifica.
   * 
   * @param precioCompra
   * @throws PrecioNegativoException
   */
  void setPrecioCompra(double precioCompra) throws PrecioNegativoException {
    if (precioCompra < 0)
      throw new PrecioNegativoException(
          "\nEl precio de compra no puede ser negativo.");

    this.precioCompra = precioCompra;
  }

  /**
   * Devuelve el valor del precio de venta de un artículo.
   * 
   * @return precioVenta
   */
  double getPrecioVenta() {
    return precioVenta;
  }

  /**
   * Asigna el precio de venta de un artículo. Si el precio es negativo el
   * artículo no se crea o modifica.
   * 
   * @param precioVenta
   * @throws PrecioNegativoException
   */
  void setPrecioVenta(double precioVenta) throws PrecioNegativoException {
    if (precioVenta < 0)
      throw new PrecioNegativoException(
          "\nEl precio de venta no puede ser negativo.");
    this.precioVenta = precioVenta;
  }

  /**
   * Devuelve el valor del stock de un artículo.
   * 
   * @return stock
   */
  int getSotck() {
    return stock;
  }

  /**
   * Asigna el valor del stock a un artículo. Si el stock es negativo no se
   * crea o modifica.
   * 
   * @param stock
   * @throws StockNegativoException
   */
  void setStock(int stock) throws StockNegativoException {
    if (stock < 0)
      throw new StockNegativoException();
    this.stock = stock;
  }

  /**
   * Devuelve el valor del tipo de iva de un artículo.
   * 
   * @return iva
   */
  String getIva() {
    return iva;
  }

  /**
   * Asigan el valor del iva a un artículo. Si su valor es nulo no se crea o
   * modifica.
   * 
   * @param iva
   * @throws IvaInvalidoException
   */
  void setIva(String iva) throws IvaInvalidoException {
    if (iva.equals("Null"))
      throw new IvaInvalidoException();
    this.iva = iva;
  }

  public String toString() {
    return "Código: " + codigo + "\nDescripción: " + descripcion
        + "\nPrecio de compra: " + precioCompra + "\nPrecio de venta: "
        + precioVenta + "\nStock: " + stock + "\nIVA: " + iva
        + "\n------------------------------------";
  }
}

