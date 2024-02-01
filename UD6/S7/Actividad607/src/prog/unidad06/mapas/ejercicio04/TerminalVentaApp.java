package prog.unidad06.mapas.ejercicio04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TerminalVentaApp {
    
    public static final String CODIGO_DESCUENTO = "ECODTO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Double> mapaSuperMercado = new HashMap<>();
        mapaSuperMercado.put("avena", 2.21);
        mapaSuperMercado.put("garbanzos", 2.39);
        mapaSuperMercado.put("tomates", 1.59);
        mapaSuperMercado.put("jengibre", 3.13);
        mapaSuperMercado.put("quinoa", 4.50);
        mapaSuperMercado.put("guisantes", 1.60);

        
        String productoAComprar;
        int cantidadAComprar;
        double precioProducto; 
        
        Map<String, Integer> productosAVender = new HashMap<>();

        System.out.println("TERMINAL DEL PUNTO DE VENTA");


        do {
            System.out.print("Introduzca el nombre del producto (vacío para terminar): ");
            productoAComprar = sc.nextLine();
        
            if (!productoAComprar.isBlank() && mapaSuperMercado.containsKey(productoAComprar)) {
                System.out.print("Introduzca la cantidad del producto comprada (número entero): ");
                cantidadAComprar = Integer.parseInt(sc.nextLine());
                
                productosAVender.put(productoAComprar, cantidadAComprar);
            }
        } while (!productoAComprar.isBlank());
        
        System.out.println("Introduzca el código de descuento (vacío si no tiene ninguno): ");
        String codigo = sc.nextLine();
        
        double subtotal = 0;
        System.out.println("Producto  Precio Cantidad Subtotal");
        System.out.println("----------------------------------");
        for (Map.Entry<String, Integer> entry : productosAVender.entrySet()) {
          String producto = entry.getKey();
          int cantidad = entry.getValue();
          precioProducto = mapaSuperMercado.get(producto);
          double subtotalProducto = precioProducto * cantidad;
          
          // Formato de impresión para cada columna de la tabla
          System.out.printf(producto +  precioProducto + cantidad + subtotalProducto);
      }
    }
}
