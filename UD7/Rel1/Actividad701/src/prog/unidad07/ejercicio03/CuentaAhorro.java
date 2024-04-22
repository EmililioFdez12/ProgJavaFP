package prog.unidad07.ejercicio03;

public class CuentaAhorro extends CuentaBancaria {

	private static final double INTERES_ANUAL = 0.15;

	private static final int PLAZO_RETIRADA = 12;

	private static final double PORCENTAJE_PENALIZACION = 0.2;

	private double penalizacion;
	private int mesesDesdeUltimaRetirada;

	protected CuentaAhorro(String dni, String nombreCompleto) {
		super(dni, nombreCompleto, INTERES_ANUAL);
		penalizacion = 0;
		mesesDesdeUltimaRetirada = 0;
	}

	@Override
	protected double calculaComisiones() {
		double comision = super.calculaComisiones();

		if (penalizacion > 0) {
			comision += penalizacion;
			penalizacion = 0;
		} else {
			mesesDesdeUltimaRetirada++;
		}
		return comision;
	}

	@Override
	public void retirada(double cantidad) {
		double saldo = getSaldo();
		super.retirada(cantidad);

		if (mesesDesdeUltimaRetirada < PLAZO_RETIRADA) {
			penalizacion = PORCENTAJE_PENALIZACION * saldo;

		}
		mesesDesdeUltimaRetirada = 0;
	}
}
