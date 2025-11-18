/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 * @author 12241
 * @Autor Sara Lizbeth Serna Rodríguez
 * Grupo: GTID0141
 * Fecha: 30/10/25
 * EJERCICIO DE PILA -----
 */

import java.util.pila.Stack;

/**
 * Clase: SimulacionPila<T>
 * 
 * Ejercicio 1: Simulación simple de pila.
 * 
 * Objetivo:
 * - Practicar las operaciones básicas de una pila: push() y pop().
 * 
 * Descripción:
 * 1. Se crea una pila vacía.
 * 2. Se insertan los valores 5, 10, 15, 20.
 * 3. Se eliminan dos elementos.
 * 4. Se muestra el contenido restante.
 * 
 * Parametrización:
 * - Se utiliza Stack<T> para permitir manejar pilas de cualquier tipo de dato.
 */
public class Ejercicio1PilaSimple {
    public static void main(String[] args) {
        //Se Crea la pila para que guarde los datos 
        Stack<Integer> pila = new Stack<>();
        
        //Insercion de elementos
        pila.push(5);
        pila.push(10);
        pila.push(15);
        pila.push(20);
        
        //Elementos eliminados
        pila.pop();
        pila.pop();
        
        //Resultado final de la pila
        System.out.println("Contenido actual: " + pila);
    }
}
