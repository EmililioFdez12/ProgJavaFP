package prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.println("INTRODUCCIÓN DE NÚMERO SEGURA");
      System.out.print("Inroduce un número entero: ");
      int numero = Integer.parseInt(sc.nextLine());

      System.out.println("El numero que has introducido es " + numero);
    } catch (NumberFormatException e) {
      System.out.println("El dato introducido no es un número valido");
    }
    sc.close();
  }

}
