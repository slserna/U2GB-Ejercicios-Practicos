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
import java.util.Stack;

/**
 * Ejercicio 3: Verificar si una pila está vacía.
 * 
 * Objetivo:
 * - Comprobar el uso del método isEmpty().
 */
public class PilaVacia {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
        pila.push(1);
        System.out.println("¿Está vacía la pila? " + pila.isEmpty());
    }
}
// Salida esperada: true, false

