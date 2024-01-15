package prog.unidad06.arraysmulti.ejercicio5;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio2.TablaEnteraConTotales;

public class MaximoMinimoTablaAleatoriaApp {

  public static void main(String[] args) {
    
    TablaEnteraConTotales tablaAleatoria = new TablaEnteraConTotales(6, 10);
    
    Random rm = new Random();
    int filas = 6;
    int columnas = 10;

 
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        int generadorRandom = rm.nextInt(1000);
        tablaAleatoria.setCasilla(i, j, generadorRandom);
      }
    }   

    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        System.out.print(tablaAleatoria.getCasilla(i, j) + "\t");
      }
      System.out.println();
    }
  }


}
