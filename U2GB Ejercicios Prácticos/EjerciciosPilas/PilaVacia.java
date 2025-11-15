/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO DE PILA -----
 * 30/10/25
 */
import java.util.pila.StackArray;

/**
 * Ejercicio 3: Verificar si una pila está vacía.
 * 
 * Objetivo:
 * - Comprobar el uso del método isEmpty().
 */
public class PilaVacia {
    public static void main(String[] args) {
        // Crear una pila Integer vacía
        Stack<Integer> pila = new Stack<>();
        // Verificar si la pila está vacía (debe ser true al inicio)
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
        // Insertar un elemento en la pila
        pila.push(1);
        // Volver a verificar si la pila está vacía (ahora debe ser false)
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
    }
}
// Salida esperada: true, false


