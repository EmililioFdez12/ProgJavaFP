package prog.unidad04.actividad402.ejercicio08;

public class Fraccion {

  private int numerador;
  private int denominador;

  public Fraccion(int numerador, int denominador) {
    this.numerador = numerador;
    this.denominador = denominador;
  }

  public Fraccion suma(Fraccion otra) {
    // Hay que hacer minimo comun multiplo, o otra manera.
    if (this.denominador == otra.denominador) {
      this.numerador = this.numerador + otra.numerador;
    } else {
      // manera rapida de sumar fracciones
      numerador = (this.numerador * otra.denominador) + (otra.numerador * this.denominador);
      denominador = this.denominador * otra.denominador;
    }

    return new Fraccion(numerador, denominador);
  }
  
  public Fraccion resta(Fraccion otra) {
    int nuevoNumerador;
    int nuevoDenominador;
    // Hay que hacer minimo comun multiplo, o otra manera.
    if (this.denominador == otra.denominador) {
      nuevoNumerador  = this.numerador - otra.numerador;
    } else {
      // manera rapida de sumar fracciones
    nuevoNumerador = (this.numerador * otra.denominador) - (otra.numerador * this.denominador);
    nuevoDenominador = this.denominador * otra.denominador;
    
    }
    return new Fraccion(nuevoNumerador, denominador);
    
  }

  public String obtieneString() {
    return this.numerador + " / " + this.denominador;
  }
}
