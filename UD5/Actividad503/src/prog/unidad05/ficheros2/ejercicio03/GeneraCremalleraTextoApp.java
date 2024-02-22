package prog.unidad05.ficheros2.ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneraCremalleraTextoApp {

  public static void main(String[] args) {
    String fichero1 = null;
    String fichero2 = null;
    List<String> archivo1 = new ArrayList<>();
    List<String> archivo2 = new ArrayList<>();

    if (args.length > 0) {
      fichero1 = args[0];
      fichero2 = args[1];
    }

    // Leemos el primer archivo y almacenamos en una lista cada linea
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(fichero1))) {
      String linea = null;
      do {
        linea = flujoEntrada.readLine();
        if (linea != null) {
          archivo1.add(linea);
        }

      } while (linea != null);

    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el archivo");
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }    
     
    // Leemos el segundo archivo y almacenamos en una lista cada linea
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(fichero2))) {
      String linea = null;
      do {
        linea = flujoEntrada.readLine();
        if (linea != null) {
          archivo2.add(linea);
        }

      } while (linea != null);

    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el archivo");
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }
               
  }
}
