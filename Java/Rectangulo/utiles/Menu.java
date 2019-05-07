package utiles;

import utiles.Teclado;

/**
 * Muestra los menús utilizados en la clase TestAlmacen.
 * 
 * @author Damián Jesús Miquel Jiménez
 * @version 2.0
 */

public class Menu {

  String titulo = null;
  String opciones[] = null;
  int numeroOpciones;

  public void crearMenu(String titulo, String[] opciones) {
    this.titulo = titulo;
    this.opciones = opciones;
    this.numeroOpciones = this.opciones.length;
  }

  /**
   * Da formato al menu que se muestra por pantalla.
   * 
   * @return title
   */
  private String formatearTexto(String titulo) {
    // Título
    int x = (int) ((36 - titulo.length()) / 2);
    String title = ("");
    boolean done = false;

    for (int i = 1; i <= x; i++) {
      title += ("=");

      if (i == x && done == false) {
        title += titulo;
        i = 0;
        done = true;
      }
    }

    if (opciones[0].length() < 36) {
      // Opciones
      for (int i = 0; i < numeroOpciones; i++) {
        opciones[i] += (" ");
        int aux = opciones[i].length();

        if ((opciones[i].length() + 4) < 36) {
          for (int j = 0; j < (36 - 4 - aux); j++) {
            opciones[i] += ("-");
          }
        }

        opciones[i] += (" [" + (i + 1) + "]");
      }
    }
    return title;
  }

  private void mostrar(String titulo) {
    System.out.println(titulo);
    for (String lista : opciones) {
      System.out.println(lista);
    }
  }

  /**
   * Muestra el menu y recoge el valor de la selección.
   * 
   * @return
   */
  public String recogerOpcion() {
    mostrar(formatearTexto(titulo));
    System.out.print("Introduzca su selección: ");
    String tipo = Teclado.leerCandena();
    System.out.println("====================================");
    return tipo;
  }
}

