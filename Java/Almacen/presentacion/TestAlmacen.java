package presentacion;

import excepciones.CodigoNoExisteException;
import excepciones.IvaInvalidoException;
import excepciones.PrecioNegativoException;
import excepciones.StockNegativoException;

import gestion.Almacen;
import gestion.IVA;

import utiles.Menu;
import utiles.Teclado;

/**
 * Clase de test del poryecto Almacen.
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 3.0
 */

public class TestAlmacen {

  static Almacen almacen = new Almacen();
  static Menu menuPrincipal = new Menu();
  static Menu menuModificar = new Menu();
  static Menu menuIva = new Menu();

  public static void main(String[] args)
      throws CodigoNoExisteException, PrecioNegativoException,
      StockNegativoException, IvaInvalidoException {

    String[] opcionesPrincipal = {"Añadir Artículo", "Borrar Artículo",
        "Modificar Artículo", "Introducir Mercancía",
        "Extraer Mercancía", "Mostrar Artículos", "Salir del Programa"};
    menuPrincipal.crearMenu("Menu Principal", opcionesPrincipal);

    String[] opcionesModificar = {"Modificar Descripción",
        "Modificar Precio de Compra", "Modificar Precio de Venta",
        "Modificar Stock", "Modificar IVA"};
    menuModificar.crearMenu("Menu Modificar", opcionesModificar);

    String[] opcionesIVA = {"General", "Reducido", "Super Reducido"};
    menuIva.crearMenu("Menu IVA", opcionesIVA);

    String seleccion;

    do {
      seleccion = menuPrincipal.recogerOpcion();
      switch (seleccion) {
        case "1" :
          crearArticulo();
          break;

        case "2" :
          borrarArticulo();
          break;

        case "3" :
          do {
            if (almacen.vacio() == false) {
              System.out.println(
                  "------------------------------------");
              almacen.inventario();
              seleccion = menuModificar.recogerOpcion();
            } else {
              System.err.println(
                  "\nNo hay datos para mostrar.");
              seleccion = "0";
            }
            switch (seleccion) {
              case "1" :
                modificarDescripcion();
                seleccion = "0";
                break;

              case "2" :
                modificarPrecioCompra();
                seleccion = "0";
                break;

              case "3" :
                modificarPrecioVenta();
                seleccion = "0";
                break;

              case "4" :
                modificarStock();
                seleccion = "0";
                break;

              case "5" :
                modificarIva();
                seleccion = "0";
                break;

              default :
                System.err.println("Selección no válida.");
                break;
            }
          } while (!seleccion.equals("0"));
          break;

        case "4" :
          if (almacen.vacio() == false) {
            introducirMercancia();
          } else {
            System.err.println("No hay datos para mostrar.");
          }
          break;

        case "5" :
          extarerMercancia();
          break;

        case "6" :
          if (almacen.vacio() == false) {
            System.out.println(
                "------------------------------------");
            almacen.inventario();
          } else {
            System.err.println("No hay datos para mostrar.");
          }
          break;

        case "7" :
          System.err.println("Programa Finalizado.");
          break;

        default :
          System.err.println("Selección no válida.");
          break;
      }
    } while (!seleccion.equals("7"));

  }

  /**
   * Crea un artículo.
   * 
   * @return iva
   * @throws PrecioNegativoException
   * @throws StockNegativoException
   */
  private static void crearArticulo()
      throws PrecioNegativoException, StockNegativoException {

    System.out.print("Introduzca la descripción del artículo: ");
    String descripcion = Teclado.leerCandena();

    System.out.print("Introduzca el precio de compra del artículo: ");
    double precioCompra = Teclado.leerDouble();

    System.out.print("Introduzca el precio de venta del artículo: ");
    double precioVenta = Teclado.leerDouble();

    System.out.print("Introduzca el número de unidades del artículo: ");
    int stock = Teclado.leerInteger();

    String iva = tipoIVA().toString();

    try {
      almacen.crear(descripcion, precioCompra, precioVenta, stock, iva);
    } catch (PrecioNegativoException | StockNegativoException
        | IvaInvalidoException e) {
      System.err.println(
          "\nNo se ha podido crear el artículo." + e.getMessage());
    }
  }

  /**
   * Borra un artículo utilizando el código.
   * 
   * @throws CodigoNoExisteException
   */
  private static void borrarArticulo() throws CodigoNoExisteException {
    System.out
        .print("Introduzca el código del artículo que desea borrar: ");
    int codigo = Teclado.leerInteger();

    try {
      almacen.eliminar(codigo);
      System.err.println("Artículo eliminado.");
    } catch (CodigoNoExisteException e) {
      System.err.println(
          "\nNo se ha podiddo borrar el artículo." + e.getMessage());
    }
  }

  /**
   * Modifica la descripción de un artículo.
   * 
   * @throws CodigoNoExisteException
   */
  private static void modificarDescripcion() throws CodigoNoExisteException {
    System.out.print(
        "Introduzca el código del artículo que desea modificar: ");
    int codigo = Teclado.leerInteger();

    System.out.print("Introduzca la nueva descripción: ");
    String descripcion = Teclado.leerCandena();

    try {
      almacen.modDescripcion(codigo, descripcion);
    } catch (CodigoNoExisteException e) {
      System.err.println("\nNo se ha podido realizar la modificación."
          + e.getMessage());
    }

  }

  /**
   * Modifica el precio de compra de un artículo.
   * 
   * @throws CodigoNoExisteException
   * @throws PrecioNegativoException
   */
  private static void modificarPrecioCompra()
      throws CodigoNoExisteException, PrecioNegativoException {
    System.out.print(
        "Introduzca el código del artículo que desea modificar: ");
    int codigo = Teclado.leerInteger();

    System.out.print("Introduzca el nuevo precio: ");
    double precioCompra = Teclado.leerDouble();

    try {
      almacen.modPrecioCompra(codigo, precioCompra);
    } catch (CodigoNoExisteException | PrecioNegativoException e) {
      System.err.println("\nNo se ha podido relizar la modificación."
          + e.getMessage());
    }
  }

  /**
   * Modifica el precio de venta.
   * 
   * @throws CodigoNoExisteException
   * @throws PrecioNegativoException
   */
  private static void modificarPrecioVenta()
      throws CodigoNoExisteException, PrecioNegativoException {
    System.out.print(
        "Introduzca el código del artículo que desea modificar: ");
    int codigo = Teclado.leerInteger();

    System.out.print("Introduzca el nuevo precio: ");
    double precioVenta = Teclado.leerDouble();

    try {
      almacen.modPrecioVenta(codigo, precioVenta);
    } catch (CodigoNoExisteException | PrecioNegativoException e) {
      System.err.println("\nNo se ha podido realizar la modificación."
          + e.getMessage());
    }

  }

  /**
   * Modifica el stock de un artículo.
   * 
   * @throws CodigoNoExisteException
   * @throws StockNegativoException
   */
  private static void modificarStock()
      throws CodigoNoExisteException, StockNegativoException {
    System.out.print(
        "Introduzca el código del artículo que desea modificar: ");
    int codigo = Teclado.leerInteger();

    System.out.print("Introduzca el nuevo stock: ");
    int stock = Teclado.leerInteger();

    try {
      almacen.modStock(codigo, stock);
    } catch (CodigoNoExisteException | StockNegativoException e) {
      System.err.println("\nNo se ha podido realizar la modificación."
          + e.getMessage());
    }

  }

  /**
   * Modifica el tipo de IVA de un artículo.
   * 
   * @throws CodigoNoExisteException
   * @throws IvaInvalidoException
   */
  private static void modificarIva()
      throws CodigoNoExisteException, IvaInvalidoException {
    System.out.print(
        "Introduzca el código del artículo que desea modificar: ");
    int codigo = Teclado.leerInteger();

    String iva = tipoIVA().toString();

    try {
      almacen.modIva(codigo, iva);
    } catch (CodigoNoExisteException | IvaInvalidoException e) {
      System.err.println("\nNo se ha podido realizar la modificación."
          + e.getMessage());
    }
  }

  /**
   * Aumenta el número de unidades de un artículo.
   * 
   * @throws CodigoNoExisteException
   * @throws StockNegativoException
   */
  private static void introducirMercancia()
      throws CodigoNoExisteException, StockNegativoException {
    System.out.print(
        "Introduzca el código del artículo que desea modificar: ");
    int codigo = Teclado.leerInteger();

    System.out.print("Introduzca las unidades que se van a itroducir: ");
    int cantidad = Teclado.leerInteger();

    try {
      almacen.decrementarStock(codigo, cantidad);
    } catch (CodigoNoExisteException | StockNegativoException e) {
      System.err.println(
          "\nNo se ha podido realizar la entrada de mercancía."
              + e.getMessage());
    }
  }

  /**
   * Reduce el número de un artículo.
   * 
   * @throws CodigoNoExisteException
   * @throws StockNegativoException
   */
  private static void extarerMercancia()
      throws CodigoNoExisteException, StockNegativoException {
    System.out.print(
        "Introduzca el código del artículo que desea modificar: ");
    int codigo = Teclado.leerInteger();

    System.out.print("Introduzca las unidades que se van a retiar: ");
    int cantidad = Teclado.leerInteger();

    try {
      almacen.decrementarStock(codigo, cantidad);
    } catch (CodigoNoExisteException | StockNegativoException e) {
      System.err.println(
          "\nNo se ha podido realizar la retirarda de mercancía."
              + e.getMessage());
    }
  }

  /**
   * Devuelve el tipo de IVA mediante el uso de un enum (IVA). Si la selección
   * es errónea, el valor que se le asigna es 'Null', ya que si se utiliza
   * null, devulve un error de NullPointerException.
   * 
   * @return tipo de iva
   */

  private static IVA tipoIVA() {
    String iva = menuIva.recogerOpcion();
    switch (iva) {
      case "1" :
        return IVA.General;

      case "2" :
        return IVA.Reducido;

      case "3" :
        return IVA.SuperReducido;

      default :
        return IVA.Null;
    }
  }
}

