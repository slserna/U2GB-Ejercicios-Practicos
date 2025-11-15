/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

/**
 *
 * @author Sara Lizbeth Serna Rodriguez 
 * Grupo: GTID141
 * Ejercicio de Pila 
 */


/**
 * Clase StackArray
 * 
 * Implementa una pila (Stack) utilizando un arreglo genérico.
 * Permite almacenar elementos y aplicar operaciones básicas:
 * push, pop, peek y verificación de vacío.
 * 
 * @param <T> tipo de dato que almacenará la pila.
 */
public class StackArray<T> implements IStack<T> {

    // Arreglo donde se almacenan los elementos de la pila
    private T[] elements;

    // Índice del elemento ubicado en la parte superior de la pila
    private int top;

    /**
     * Constructor por defecto.
     * Crea una pila con capacidad de 30 elementos.
     */
    public StackArray() {
        elements = (T[]) new Object[30];
        top = -1; // pila vacía
    }

    /**
     * Constructor con tamaño personalizado.
     *
     * @param size capacidad máxima de la pila
     */
    public StackArray(int size) {
        elements = (T[]) new Object[size];
        top = -1;
    }

    /**
     * Inserta un elemento en la parte superior de la pila.
     *
     * @param elemento elemento a insertar
     */
    @Override
    public void push(T elemento) {
        // Validar si hay espacio disponible en la pila
        if (top < elements.length - 1) {
            top++;
            elements[top] = elemento;
        } else {
            System.out.println("Pila llena");
        }
    }

    /**
     * Elimina y retorna el elemento de la parte superior de la pila.
     *
     * @return el elemento eliminado o null si la pila está vacía
     */
    @Override
    public T pop() {
        if (estaVacia()) {
            System.out.println("Pila Vacía, no se puede eliminar");
            return null;
        } else {
            T elemento = elements[top];  // Guardar último elemento
            elements[top] = null;        // Limpiar referencia
            top--;                       // Mover tope hacia abajo
            return elemento;
        }
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return el elemento superior o null si la pila está vacía
     */
    @Override
    public T peek() {
        if (estaVacia()) {
            System.out.println("Pila Vacía");
            return null;
        }
        return elements[top];
    }

    /**
     * Verifica si la pila está completamente vacía.
     *
     * @return true si no contiene elementos, false en caso contrario
     */
    public boolean estaVacia() {
        return top == -1;
    }

    /**
     * Implementación del método isEmpty() heredado de la interfaz.
     *
     * @return true si la pila está vacía
     */
    @Override
    public boolean isEmpty() {
        return estaVacia();
    }
}
