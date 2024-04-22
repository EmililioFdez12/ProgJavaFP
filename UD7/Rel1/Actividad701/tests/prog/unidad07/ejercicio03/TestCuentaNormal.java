package prog.unidad07.ejercicio03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCuentaNormal {
	
	@Test
	void testCreaCuenta() {
		CuentaBancaria cuenta = null;
		
		cuenta = new CuentaNormal("4242", "Julian");	
		assertEquals(cuenta.getSaldo(), 0);
	}
	
	@Test
	void testCreaCuentaActualiza() {
		CuentaBancaria cuenta = null;
		
		cuenta = new CuentaNormal("4242", "Julian");
		cuenta.actualizacionMensual();
		
		assertEquals(cuenta.getSaldo(), 0);
	}
	
	@Test
	void testCuentaNormalIngresa90() {
		CuentaBancaria cuenta = null;
		
		cuenta = new CuentaNormal("4242", "Julian");
		cuenta.ingreso(90);
		
		assertEquals(cuenta.getSaldo(), 90);
	}
	
	@Test
	void testCuentaNormalIngresa90Actualiza() {
		CuentaBancaria cuenta = null;
		
		cuenta = new CuentaNormal("4242", "Julian");
		cuenta.ingreso(90);
		cuenta.actualizacionMensual();
		
		assertEquals(cuenta.getSaldo(), 81);
	}
	
	@Test
	void testCuentaNormalIngresa100() {
		CuentaBancaria cuenta = null;
		
		cuenta = new CuentaNormal("4242", "Julian");
		cuenta.ingreso(100);
		
		assertEquals(cuenta.getSaldo(), 100);
	}
	
	@Test
	void testCuentaNormalIngresa100Actualiza() {
		CuentaBancaria cuenta = null;
		
		cuenta = new CuentaNormal("4242", "Julian");
		cuenta.ingreso(100);
		cuenta.actualizacionMensual();
		
		assertEquals(cuenta.getSaldo(), 90);
	}
	
	
	
	
	
	

}
