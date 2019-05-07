package gestion;

import java.util.ArrayList;

import excepciones.CodigoNoExisteException;
import excepciones.IvaInvalidoException;
import excepciones.PrecioNegativoException;
import excepciones.StockNegativoException;

/**
 * Clase Almacen: actúa como relación entre las clases TestAlmacen y Articulo.
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 3.0
 */

public class Almacen {

  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();

  /**
   * Crea un artículo con los datos que recive.
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @param iva
   * @throws PrecioNegativoException
   * @throws StockNegativoException
   */
  public void crear(String descripcion, double precioCompra,
      double precioVenta, int stock, String iva)
      throws PrecioNegativoException, StockNegativoException,
      IvaInvalidoException {
    almacen.add(new Articulo(descripcion, precioCompra, precioVenta, stock,
        iva));
  }

  /**
   * Eliminia un elemento del ArrayList.
   * 
   * @param codigo
   * @throws CodigoNoExisteException
   */
  public void eliminar(int codigo) throws CodigoNoExisteException {
    almacen.remove(index(codigo));
  }

  /**
   * Muestra el listado de los artículos del almacen.
   * 
   * @return almacen
   */
  public void inventario() {
    for (Articulo articulos : almacen) {
      System.out.println(articulos);
    }
  }

  /**
   * Modifica el stock de un artículo.
   * 
   * @param codigo
   * @param stock
   * @throws CodigoNoExisteException
   * @throws StockNegativoException
   */
  public void modStock(int codigo, int stock)
      throws CodigoNoExisteException, StockNegativoException {
    if (index(codigo) != -1) {
      almacen.get(index(codigo)).setStock(stock);
    } else {
      throw new CodigoNoExisteException();
    }
  }

  /**
   * Aumenta el número de existencias de un artículo.
   * 
   * @param codigo
   * @param cantidad
   * @throws StockNegativoException
   */
  public void incrementarStock(int codigo, int cantidad)
      throws CodigoNoExisteException, StockNegativoException {
    if (index(codigo) != -1) {
      almacen.get(index(codigo))
          .setStock(almacen.get(index(codigo)).getSotck() + cantidad);
    } else {
      throw new CodigoNoExisteException();
    }
  }

  /**
   * Reduce el número de existencias de un artículo.
   * 
   * @param codigo
   * @param cantidad
   * @throws CodigoNoExisteException
   * @throws StockNegativoException
   */
  public void decrementarStock(int codigo, int cantidad)
      throws CodigoNoExisteException, StockNegativoException {
    if (index(codigo) != -1) {
      almacen.get(index(codigo))
          .setStock(almacen.get(index(codigo)).getSotck() - cantidad);
    } else {
      throw new CodigoNoExisteException();
    }
  }

  /**
   * Modifica la descripción de un artículo.
   * 
   * @param codigo
   * @param descripcion
   * @throws CodigoNoExisteException
   */
  public void modDescripcion(int codigo, String descripcion)
      throws CodigoNoExisteException {
    if (index(codigo) != -1) {
      almacen.get(index(codigo)).setDescripcion(descripcion);
    } else {
      throw new CodigoNoExisteException();
    }
  }

  /**
   * Modifica el precio de compra de un artículo.
   * 
   * @param codigo
   * @param precioCompra
   * @throws CodigoNoExisteException
   * @throws PrecioNegativoException
   */
  public void modPrecioCompra(int codigo, double precioCompra)
      throws CodigoNoExisteException, PrecioNegativoException {
    if (index(codigo) != -1) {
      almacen.get(index(codigo)).setPrecioCompra(precioCompra);
    } else {
      throw new CodigoNoExisteException();
    }
  }

  /**
   * Modifica el precio de venta de un artículo.
   * 
   * @param codigo
   * @param precioVenta
   * @throws CodigoNoExisteException
   * @throws PrecioNegativoException
   */
  public void modPrecioVenta(int codigo, double precioVenta)
      throws CodigoNoExisteException, PrecioNegativoException {
    if (index(codigo) != -1) {
      almacen.get(index(codigo)).setPrecioVenta(precioVenta);
    } else {
      throw new CodigoNoExisteException();
    }
  }

  /**
   * Modifica el tipo de iva de un artículo.
   * 
   * @param codigo
   * @param iva
   * @throws CodigoNoExisteException
   * @throws IvaInvalidoException
   */
  public void modIva(int codigo, String iva)
      throws CodigoNoExisteException, IvaInvalidoException {
    if (index(codigo) != -1) {
      almacen.get(index(codigo)).setIva(iva);
    } else {
      throw new CodigoNoExisteException();
    }
  }

  /**
   * Comprueba si el ArrayList está vacío o no.
   * 
   * @return vacio
   */
  public boolean vacio() {
    boolean vacio = almacen.isEmpty();
    return vacio;
  }

  /**
   * Comprueba que el código introducido se encuentra en el ArrayList.
   * 
   * Si e código se encuentra en el ArrayList devuelve el índice del mismo, en
   * el caso de que no lo encuentre, devuelve -1.
   * 
   * @param codigo
   * @return indexArticulo
   */
  private int index(int codigo) {
    int i;
    boolean existe = false;
    for (i = 0; i < almacen.size(); i++) {
      if (almacen.get(i).getCodigo() == codigo) {
        existe = true;
        break;
      }
    }

    if (i == almacen.size() && i != 0) {
      existe = false;
    }

    if (existe == true) {
      return i;
    } else {
      return -1;
    }
  }
}

