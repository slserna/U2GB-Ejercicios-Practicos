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
import java.util.Scanner;

/**
 * Ejercicio 10: Verificar palíndromo.
 * 
 * Objetivo:
 * - Determinar si una palabra es palíndroma usando una pila de caracteres.
 */
public class Palindromo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese palabra: ");
        String palabra = sc.nextLine();

        Stack<Character> pila = new Stack<>();
        for (char c : palabra.toCharArray()) {
            pila.push(c);
        }

        String invertida = "";
        while (!pila.isEmpty()) {
            invertida += pila.pop();
        }

        if (palabra.equalsIgnoreCase(invertida)) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }
    }
}
// Entrada: reconocer → Salida: Es palíndromo

