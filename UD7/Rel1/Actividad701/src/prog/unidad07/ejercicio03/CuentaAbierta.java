package prog.unidad07.ejercicio03;

public class CuentaAbierta extends CuentaBancaria {
	
	private static final double INTERES_ANUAL = 0.07;
	
	private static final double PENALIZACION = 10;
	
	private static final double SALDO_MINIMO = 100;
	
	private static final double COMISION_TRANSACCION = 0.1;
	
	private boolean penaliza;
  private int transacciones;

	protected CuentaAbierta(String dni, String nombreCompleto) {
		super(dni, nombreCompleto, INTERES_ANUAL);
		this.penaliza = false;
		transacciones = 0;
	}
	
	@Override
	public void retirada(double cantidad) {
		super.retirada(cantidad);

		if (getSaldo() < SALDO_MINIMO) {
			penaliza = true;
		}
		transacciones++;
	}
	
	@Override
  public void ingreso(double cantidad) {
    super.ingreso(cantidad);
    // Añadimos una nueva transaccion
    transacciones++;
  }
	
	
	
	@Override
	protected double calculaComisiones() {
		double comision = super.calculaComisiones();
		if (penaliza) {
			penaliza = false;
			comision += PENALIZACION;
		}
		
		comision += transacciones * COMISION_TRANSACCION;
		// Reiniciamos las transacciones
    transacciones = 0;

    return comision;
	}

}
