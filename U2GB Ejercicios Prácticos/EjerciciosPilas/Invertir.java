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

import java.util.Scanner;
import java.util.Stack;

/**
 * Ejercicio 4: Invertir una palabra.
 * 
 * Objetivo:
 * - Utilizar una pila genérica para invertir una palabra carácter por carácter.
 * 
 * Descripción:
 * El programa solicita al usuario una palabra, almacena cada carácter en una pila
 * (estructura LIFO) y luego los extrae para mostrarlos en orden inverso.
 * 
 * Parametrización:
 * - Se usa Stack<T> con tipo T = Character.
 */

public class Invertir<T> {

    /**
     * Método principal que ejecuta la inversión de una palabra.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();

        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        // Insertar cada carácter en la pila
        for (char c : palabra.toCharArray()) {
            pila.push(c);
        }

        // Mostrar la palabra invertida
        System.out.print("Invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }

        sc.close();
    }
}
