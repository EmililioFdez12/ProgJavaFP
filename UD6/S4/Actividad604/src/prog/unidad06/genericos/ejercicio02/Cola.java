package prog.unidad06.genericos.ejercicio02;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Clase que representa una pila<br>
 * En una pila los elementos entran y salen por el mismo extremo
 * de forma que el primero que entra es el último que sale
 * @param <T> Tipo de los elementos de la pila
 */
public class Cola<T> {

  // Vamos a almacenar los elementos en una lista
  List<T> cola;
  
  /**
   * Constructor. Crea una pila vacía
   */
  public Cola() {
    // Crea la lista para almacenar los elementos
    cola = new ArrayList<T>();
  }
  
  /**
   * Añade un elemento a la pila
   * @param elemento Elemento a añadir
   */
  public void push(T elemento) {
    // Siempre se puede añadir
    cola.add(elemento);
  }
  
  /**
   * Extrae un elemento de la pila. El elemento se quita de la pila
   * @return Elemento extraido de la pila
   * @throws EmptyStackException Si la pila está vacía
   */
  public T pop() {
    // Obtenemos el tamaño
    int size = getNumeroElementos();
    // Si la pila no está vacía
    if (size > 0) {
      // Obtenemos el elemento
      T elemento = cola.get(size - size);
      // LO eliminamos 
      cola.remove(size - size);
      // Y lo devolvemos
      return elemento;
    } else {
      // Si no hay elementos, lamzamos excepcion
      throw new EmptyStackException();
    }
  }

  /**
   * Chequea si la pila está vacía o no.
   * @return true si la pila está vacia, false si contiene algo
   */
  public boolean esVacia() {
    // Devuelve true si no hay algún elemento
    return getNumeroElementos() == 0;
  }

  /**
   * Obtiene el número de elementos contenidos en la pila
   * @return Número de elementos contenidos en la pila
   */
  public int getNumeroElementos() {
    // Devuelve el número de elementos contenidos en la 
    return cola.size();
  }
}
