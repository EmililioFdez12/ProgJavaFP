package prog.unidad07.ejercicio02;

public class Comercial extends EmpleadoFijo {
  
  // Constantes
  private static final double SALARIO_MINIMO = 300;
  
  // Atributos
  protected double ventas;

  protected Comercial(String nombre, String dni, String telefono, Double ventas) {
    super(nombre, dni, telefono, SALARIO_MINIMO);    
    if (ventas >= 0) {
      this.ventas = ventas;
    } else {
      throw new IllegalArgumentException("Ventas no puede ser negativo");
    }
    
  }

  @Override
  public double getSalario() {
    double comisiones = getComisiones();
    // Si las comisiones son mayores que el salario, devuelve las comisiones, si no devuelve el salario mínimo
    return super.getSalario() > comisiones ? super.getSalario() : comisiones;
  }
  

  private double getComisiones() {
 // Si las ventas son de menos de 10000 euros
    if (ventas <= 10000) {
      // Devuelve el 5%
      return redondea2Decimales(ventas * 0.05);
      // Si son entre 10000 y 300000
    } else if (ventas >= 10001 && ventas <= 30000) {
      // Devuelve el 8%
      return redondea2Decimales(ventas * 0.08);
    } else {
      // Si son superiores devuelve el 10%
      return redondea2Decimales(ventas * 0.1);
    }
  }
}
