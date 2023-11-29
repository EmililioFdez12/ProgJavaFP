package prog.unidad04.actividad204.ejercicio05;

import java.util.Scanner;

public class Zona {
	Scanner sc = new Scanner(System.in);

	private int entradasIniciales;

	public Zona(int entradasIniciales) {
		this.entradasIniciales = entradasIniciales;
	}

	public int getEntradasPorVender() {
		return entradasIniciales;
	}

	public int vender() {
		System.out.print("Introduzca el numero de asientos a vender: ");
		int entradasAVender = Integer.parseInt(sc.nextLine());

		if (entradasIniciales < entradasAVender) {
			System.out.print("El numero de entradas a vender es mayor de las entradas que disponemos");
		} else {
			System.out.println("Venta realizada correctamente");
			entradasIniciales -= entradasAVender;
		}

		return entradasIniciales;
	}

}
