package prog.unidad07.ejercicio03;

public abstract class CuentaBancaria {
	
  // Porcentaje de comision
  private static final double COMISION_PORCENTAJE = 10.0 / 100.0;
  // Comision Máxima €
  private static final double COMISION_MAXIMA = 10;
	
	private String dni;
	private String nombreCompleto;
	private double interesAnual;
	private double saldo;
	
	protected CuentaBancaria(String dni, String nombreCompleto, double interesAnual) {
		this.nombreCompleto = nombreCompleto;
    this.dni = dni;
    this.interesAnual = interesAnual;
    setSaldo(0);
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	
	public double getInteresAnual() {
		return interesAnual;
	}

	public void setInteresAnual(double interesAnual) {
		this.interesAnual = interesAnual;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void ingreso(double cantidad) {
		if (cantidad > 0) {
			setSaldo(saldo + cantidad);
		} else {
			throw new IllegalArgumentException("No se puede ingresar una cantidad negativa o cero");
		}
	}
	
	
	public void retirada(double cantidad) {
		if (cantidad > 0 && cantidad <= saldo) {
			setSaldo(saldo - cantidad);
		} else {
			throw new IllegalArgumentException("No se puede ingresar una cantidad negativa, cero o superior al saldo");
		}
	}
	
	public void actualizacionMensual() {
		setSaldo(saldo + calculaIntereses() - calculaComisiones());
	}
	
	protected double calculaIntereses() {
		// Calculamos interes mensual
		double interesMensual = interesAnual / 12;
		// Intereses totales
		double intereses = saldo * interesMensual;
		
		return intereses > 0 ? intereses : 0;
	}
	
	protected double calculaComisiones() {
		double comision = Math.round(getSaldo() * COMISION_PORCENTAJE * 100) / 100.0;
		
		if (comision > COMISION_MAXIMA) {
			comision = COMISION_MAXIMA;
		}
		return comision;
	}
	
	
	/**
	 * Modifica el saldo de la cuenta
	 * @param saldo
	 */
	protected void setSaldo(double saldo) {
		this.saldo = Math.round(saldo * 100) / 100;
	}

	
}
