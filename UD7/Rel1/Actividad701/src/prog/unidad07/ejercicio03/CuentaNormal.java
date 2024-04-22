package prog.unidad07.ejercicio03;

public class CuentaNormal extends CuentaBancaria {

	private static final double INTERES_ANUAL = 0;

	private static final double PENALIZACION = 10;

	private static final double SALDO_MINIMO = 500;

	private boolean penaliza;

	protected CuentaNormal(String dni, String nombreCompleto) {
		super(dni, nombreCompleto, INTERES_ANUAL);
		// Al crear la cuenta no penaliza
		this.penaliza = false;
	}

	@Override
	public void retirada(double cantidad) {
		super.retirada(cantidad);

		if (getSaldo() < SALDO_MINIMO) {
			penaliza = true;
		}
	}

	@Override
	protected double calculaComisiones() {
		double comision = super.calculaComisiones();

		if (penaliza) {
			penaliza = false;
			comision += PENALIZACION;
		}
		return comision;
	}
}
