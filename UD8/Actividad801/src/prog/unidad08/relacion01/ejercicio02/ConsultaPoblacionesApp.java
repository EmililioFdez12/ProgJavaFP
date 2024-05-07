package prog.unidad08.relacion01.ejercicio02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import prog.unidad08.relacion01.common.Poblacion;

public class ConsultaPoblacionesApp {
  // Constantes
  // URL de la base de datos
  private static final String URL = "jdbc:sqlite:db/poblaciones.db";
  private static final String SQL_CONSULTA = "SELECT * FROM pueblos WHERE nombre LIKE ? AND pob_total >= ? AND pob_total <= ?";

  private static final String C_CODIGO = "codigo";
  private static final String C_NOMBRE = "nombre";
  private static final String C_EXTENSION = "extension";
  private static final String C_POB_HOMBRES = "pob_hombres";
  private static final String C_POB_MUJERES = "pob_mujeres";
  private static final String C_VEHICULOS = "vehiculos";
  private static final String C_LINEAS_TEL = "lineas_tel";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Solicita los datos al usuario
    System.out.print("Texto a buscar en el nombre (vacío para cualquier nombre): ");
    String nombre = sc.nextLine();
    System.out.print("Mostrar sólo poblaciones con un mínimo de habitantes igual a: ");
    int poblacionMinima = Integer.parseInt(sc.nextLine());
    System.out.print("Mostrar sólo poblaciones con un máximo de habitantes igual a: ");
    int poblacionMaxima = Integer.parseInt(sc.nextLine());

    try {
      List<Poblacion> poblaciones = buscarPoblaciones(nombre, poblacionMinima, poblacionMaxima);
      imprimePoblaciones(poblaciones);
    } catch (SQLException e) {
      System.err.println("Ocurrió un errro realizando la búsqueda: " + e);
    }
  }

  private static List<Poblacion> buscarPoblaciones(String nombre, int poblacionMinima, int poblacionMaxima)
      throws SQLException {
    try (Connection conexion = DriverManager.getConnection(URL);
        PreparedStatement sentencia = conexion.prepareStatement(SQL_CONSULTA);) {
      // like de sql
      sentencia.setString(1, "%" + nombre + "%");
      sentencia.setInt(2, poblacionMinima);
      sentencia.setInt(3, poblacionMaxima);

      ResultSet resultado = sentencia.executeQuery();

      List<Poblacion> salida = new ArrayList<>();
      while (resultado.next()) {
        Poblacion poblacion = new Poblacion(resultado.getString(C_CODIGO), resultado.getString(C_NOMBRE),
            resultado.getDouble(C_EXTENSION), resultado.getInt(C_POB_HOMBRES), resultado.getInt(C_POB_MUJERES),
            resultado.getInt(C_VEHICULOS), resultado.getInt(C_LINEAS_TEL));
        salida.add(poblacion);
      }
      resultado.close();

      return salida;
    }
  }

  private static void imprimePoblaciones(List<Poblacion> poblaciones) {
    System.out.println("Poblaciones encontradas");
    System.out.println("CODIGO           NOMBRE             EXT   P_TOT  P_HOM  P_MUJ VEHIC LINEAS");
    System.out.println("--------------------------------------------------------------------------");
    for (Poblacion poblacion : poblaciones) {
      System.out.printf("%5s %-28s %5.1f %6d %6d %6d %5d %6d", poblacion.getCodigo(), poblacion.getNombre(),
          poblacion.getExtension(), poblacion.getPoblacionTotal(), poblacion.getPoblacionHombres(),
          poblacion.getPoblacionMujeres(), poblacion.getVehiculos(), poblacion.getLineasTelefonicas());
    System.out.println("");
    }
    System.out.println("--------------------------------------------------------------------------");
  }
}
