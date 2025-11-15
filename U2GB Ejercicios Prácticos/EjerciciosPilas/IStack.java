/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

/**
 * Interfaz IStack
 * 
 * Representa las operaciones básicas que debe implementar
 * cualquier estructura de tipo pila (Stack) genérica.
 * 
 * @author 
 *     Sara Lizbeth Serna Rodriguez
 *     Grupo: GTID141
 *     Ejercicio de Pila
 */
public interface IStack<T> {

    //Inserta un elemento en la parte superior de la pila.
    void push(T elemento);

    // Elimina y devuelve el elemento ubicado en la parte superior de la pila.
    T pop();

    // Devuelve (sin eliminar) el elemento en la parte superior de la pila.
    T peek();

    // Verifica si la pila está vacía.
    boolean isEmpty();
}

