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

import java.util.Stack;

/**
 * Clase: VerificarPilaVacia<T>
 * 
 * Ejercicio 3: Verificar si una pila está vacía.
 * 
 * Objetivo:
 * - Comprobar el uso del método isEmpty() en una pila genérica.
 * 
 * Descripción:
 * 1. Se crea una pila vacía.
 * 2. Se verifica si está vacía.
 * 3. Se agrega un elemento.
 * 4. Se vuelve a verificar su estado.
 * 
 * Parametrización:
 * - Se utiliza Stack<T> para manejar cualquier tipo de dato.
 */
public class VerificarPilaVacia<T> {

    public static void main(String[] args) {
        // Pila genérica de enteros
        Stack<Integer> pila = new Stack<>();

        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
        pila.push(1);
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
    }
}
