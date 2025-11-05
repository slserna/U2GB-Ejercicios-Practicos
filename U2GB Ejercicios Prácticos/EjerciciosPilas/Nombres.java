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
 * Ejercicio 2: Pila de nombres (versión parametrizada).
 * 
 * Objetivo:
 * - Permitir al usuario ingresar nombres y mostrarlos en orden inverso utilizando una pila genérica.
 * 
 * Descripción:
 * 1. Leer nombres hasta que el usuario escriba "FIN".
 * 2. Apilar cada nombre.
 * 3. Desapilar los nombres para mostrarlos en orden inverso.
 * 
 * Parametrización:
 * - Se utiliza una pila genérica Stack<T> donde T = String.
 */

public class PilaNombres<T> {

    /**
     * Método que ejecuta la lógica principal del programa.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> pila = new Stack<>();

        System.out.println("=== Ingreso de nombres ===");
        while (true) {
            System.out.print("Ingrese un nombre (FIN para salir): ");
            String nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("FIN")) break;
            pila.push(nombre);
        }

        System.out.println("\nNombres en orden inverso:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }

        sc.close();
    }
}
