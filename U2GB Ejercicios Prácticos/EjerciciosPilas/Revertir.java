/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 * @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO DE PILA -----
 * 30/10/25
 */
import java.util.Stack;

/**
 * Ejercicio 9: Revertir lista.
 * 
 * Objetivo:
 * - Invertir los elementos de una lista usando una pila.
 */
public class Revertir {
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4};
        Stack<Integer> pila = new Stack<>();

        for (int n : lista) {
            pila.push(n);
        }

        System.out.print("Lista invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
    }
}
// Entrada: [1, 2, 3, 4] → Salida: 4 3 2 1

