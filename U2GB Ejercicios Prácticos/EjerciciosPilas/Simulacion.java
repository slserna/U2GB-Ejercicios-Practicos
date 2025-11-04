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
 * Ejercicio 1: Simulación simple de pila.
 * 
 * Objetivo:
 * - Practicar operaciones básicas de pila: push() y pop().
 * 
 * Descripción:
 * 1. Se crea una pila vacía.
 * 2. Se insertan los valores 5, 10, 15, 20.
 * 3. Se eliminan dos elementos.
 * 4. Se muestra el contenido restante.
 */
public class Simulacion {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        pila.push(5);
        pila.push(10);
        pila.push(15);
        pila.push(20);
        pila.pop();
        pila.pop();
        System.out.println("Contenido actual: " + pila);
    }
}
// Salida esperada: [5, 10]
