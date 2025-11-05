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
 * Clase: VerificarPalindromo<T>
 * 
 * Ejercicio 10: Verificar si una palabra es palíndroma.
 * 
 * Objetivo:
 * - Determinar si una palabra es igual al revés utilizando una pila genérica.
 * 
 * Descripción:
 * 1. Leer una palabra del usuario.
 * 2. Insertar cada carácter en una pila.
 * 3. Formar la palabra invertida desapilando los caracteres.
 * 4. Comparar la palabra original con la invertida (ignorando mayúsculas/minúsculas).
 * 
 * Parametrización:
 * - Se usa Stack<T> con T = Character.
 */
public class VerificarPalindromo<T> {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();

        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        // Apilar cada carácter
        for (char c : palabra.toCharArray()) {
            pila.push(c);
        }

        // Construir palabra invertida
        StringBuilder invertida = new StringBuilder();
        while (!pila.isEmpty()) {
            invertida.append(pila.pop());
        }

        // Comparar sin distinción de mayúsculas
        if (palabra.equalsIgnoreCase(invertida.toString())) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }

        sc.close();
    }
}
