package prog.unidad06.arraysmulti.ejercicio07;

import prog.unidad06.arraysmulti.ejercicio06.TablaEnteraUtils;

public class DiagonalTabla {

  public static void main(String[] args) {
    int[][] tabla = TablaEnteraUtils.nuevaTablaAleatoria(10, 10, 200, 300);

    TablaEnteraUtils.imprimeTabla(tabla, 2);

    System.out.print("Los elementos que están en la diagonal son: ");

    int[][] arrayDiagonal = new int[10][10];
    
    for (int i = 0; i < 10; i++) {
      // Imprimir elemento diagonal
      System.out.print(tabla[i][i]);
      arrayDiagonal[i][i] = tabla[i][i];
      // Comprobar si es el último elemento de la diagonal
      if (i < 9) {
        System.out.print(", ");
      }
    }
    System.out.println();
    
    int sumaValores = 0;
        
    
    System.out.println("El máximo de los elementos de la diagonal es " + TablaEnteraUtils.getMaximo(arrayDiagonal)
    + " el mínimo es " + TablaEnteraUtils.getMinimo(arrayDiagonal) + " y la media de todos los elementos de la diagonal es "
    + "");
  }
}
