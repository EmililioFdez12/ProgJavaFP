package prog.unidad06.listas.ejercicio06;

import java.util.Scanner;

public class PruebaMezclaListasApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("MEZCLA DE LISTAS");

    String entradaTexto = " ";

    for (int i = 1; i <= 2; i++) {
      System.out.println("Introduce la primera lista de palabras");
      System.out.println("Introduce palabras, una por línea. Línea vacía para terminar");
      while (!entradaTexto.isEmpty()) {
        entradaTexto = sc.nextLine();
      }
    }
  }
}
