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
import java.util.pila.StackArray;
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
    // Solicitar al usuario una palabra
    System.out.print("Ingrese una palabra: ");
    String palabra = sc.nextLine();
    // Crear una pila para almacenar caracteres de la palabra
    Stack<Character> pila = new Stack<>();
    // Recorrer cada caracter de la palabra y apilarlo
    for (char c : palabra.toCharArray()) {
        pila.push(c); // Inserta el caracter en la pila
    }
    // Mostrar la palabra invertida usando pop()
    System.out.print("Invertida: ");
    while (!pila.isEmpty()) {
        System.out.print(pila.pop()); // Extrae y muestra el último caracter ingresado
    }
}
}


