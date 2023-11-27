package prog.unidad04.actividad402.ejercicio03;

import java.util.Random;

public class Persona {

	private String nombre;
	private int edad;
	private char sexo;
	private double peso;
	private double estatura;
	private double imc;
	private String dni;
	private int pesoCorrecto = 1;

	// constructores
	/**
	 * Constructores
	 */
	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.sexo = 'M';
		this.peso = 0.0;
		this.estatura = 0.0;
	}

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param sexo
	 */
	public Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	/**
	 * 
	 * @param nombre
	 * @param edad
	 * @param sexo
	 * @param peso
	 * @param estatura
	 */
	public Persona(String nombre, int edad, char sexo, double peso, double estatura) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.estatura = estatura;
		this.dni = dni;
	}

	public String obtenerCadena() {
		return "Nombre: " + nombre + "\sEdad: " + edad + "\sSexo: " + sexo + "\sPeso: " + peso + "\sEstatura: " + estatura;
	}

	public double getIMC() {
		if (estatura == 0) {
			return 0;
		} else
			return (peso / (estatura * estatura));
	}

	public int getPesoCorrecto() {
		if (imc < 20) {
			return -1;
		} else if (imc <= 25) {
			return 0;
		} else { 
			return 1;
		}
	}


	public boolean esMayorDeEdad() {
		if (edad >= 18) {
			return true;
		} else {
			return false;
		}
	}

	public String generarDNI() {
		Random generador = new Random();
		int numeros = generador.nextInt(1, 8);
		for (int i = 1; i <= 8; i++) {
			numeros = generador.nextInt(1, 8);
			System.out.print(numeros);
		}

		int generadorLetra = (numeros % 23);

		if (generadorLetra == 0) {
			System.out.println("T");
		} else if (generadorLetra == 1) {
			System.out.println("R");
		} else if (generadorLetra == 2) {
			System.out.println("W");
		} else if (generadorLetra == 3) {
			System.out.println("A");
		} else if (generadorLetra == 4) {
			System.out.println("G");
		} else if (generadorLetra == 5) {
			System.out.println("M");
		} else if (generadorLetra == 6) {
			System.out.println("Y");
		} else if (generadorLetra == 7) {
			System.out.println("F");
		} else if (generadorLetra == 8) {
			System.out.println("P");
		} else if (generadorLetra == 9) {
			System.out.println("D");
		} else if (generadorLetra == 10) {
			System.out.println("X");
		} else if (generadorLetra == 11) {
			System.out.println("B");
		} else if (generadorLetra == 12) {
			System.out.println("N");
		} else if (generadorLetra == 13) {
			System.out.println("J");
		} else if (generadorLetra == 14) {
			System.out.println("Z");
		} else if (generadorLetra == 15) {
			System.out.println("S");
		} else if (generadorLetra == 16) {
			System.out.println("Q");
		} else if (generadorLetra == 17) {
			System.out.println("V");
		} else if (generadorLetra == 18) {
			System.out.println("H");
		} else if (generadorLetra == 19) {
			System.out.println("L");
		} else if (generadorLetra == 20) {
			System.out.println("C");
		} else if (generadorLetra == 21) {
			System.out.println("K");
		} else if (generadorLetra == 22) {
			System.out.println("E");
		}
		return dni;

	}

}
