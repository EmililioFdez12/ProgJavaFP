package prog.unidad08.relacion01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PoblacionesAddApp {

  public static void main(String[] args) {
    String ruta = "jdbc:sqLite:poblaciones.db";
    
    try (Connection conn = DriverManager.getConnection(ruta)) {
      System.out.println("Conexión establecida");
      
      Scanner sc = new Scanner(System.in);
      
      System.out.println("Introduzca los nuevos datos de la población");
      System.out.print("Código: ");
      System.out.print("Nombre de la población: ");
      System.out.print("Extensión (en Km2): ");
      System.out.print("Población (Hombres): ");
      System.out.print("Población (Mujeres): ");
      System.out.print("Número de vehículos: ");
      System.out.print("Número de líneas telefónicas: ");
      
      
    } catch (SQLException e) {
      System.out.println("ERROR en la conexion");
    }
  }

}
