package prog.unidad06.arraysobjetos;

public class Estudiante {
  
  private static final String PRIMERO = "Primero"; 
  private static final String SEGUNDO = "Segundo"; 
  private static final String MASTER = "Master"; 

  private String dni;
  private String nombre;
  private String curso;

  public Estudiante(String dni, String nombre, String curso) {
    if (dni.length() > 9) {
      System.out.println("Ingrese de nuevo el dni");
    } else if (Character.isLetter(dni.charAt(8))) {
      this.dni = dni;
    } else {
      System.out.println("Ingrese de nuevo el dni");
    }
    
    
    if (validarNombre(nombre)) {
      this.nombre = nombre;
    } else {
      throw new IllegalArgumentException("Formato incorrecto para el nombre");
    }
    
    if(curso.equalsIgnoreCase(PRIMERO)) {
      this.curso = PRIMERO;
    } else if (curso.equalsIgnoreCase(SEGUNDO)) {
      this.curso = SEGUNDO;
    } else if (curso.equalsIgnoreCase(MASTER)) {
      this.curso = MASTER;
    }
    

  }

  public String getDni() {
    return dni;
  }

  private boolean validarNombre(String nombre) {
    return nombre.length() > 1 && nombre.length() < 100;
  }

  public String getNombre() {
    return nombre;
  }

  public String getCurso() {
    return curso;
  }
}
