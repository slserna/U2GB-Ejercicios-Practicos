/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO DE PILA -----
 * 30/10/25
 */
import java.util.Stack;
import java.util.Scanner;

/**
 * Ejercicio 4: Invertir una palabra.
 * 
 * Objetivo:
 * - Usar una pila de caracteres para invertir una palabra.
 */
public class Invertir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        Stack<Character> pila = new Stack<>();
        for (char c : palabra.toCharArray()) {
            pila.push(c);
        }

        System.out.print("Invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }
    }
}
// Entrada: UTNG → Salida: GNTU

