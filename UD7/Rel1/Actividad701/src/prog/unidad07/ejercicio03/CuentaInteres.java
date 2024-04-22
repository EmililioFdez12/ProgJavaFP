package prog.unidad07.ejercicio03;

public class CuentaInteres extends CuentaBancaria {
	
	private static final double INTERES_ANUAL = 0.07;

	protected CuentaInteres(String dni, String nombreCompleto) {
		super(dni, nombreCompleto, INTERES_ANUAL);
	}

}
