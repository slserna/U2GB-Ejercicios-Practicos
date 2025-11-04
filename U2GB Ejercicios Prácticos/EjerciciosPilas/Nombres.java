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
import java.util.Scanner;
import java.util.Stack;

/**
 * Ejercicio 2: Pila de nombres.
 * 
 * Objetivo:
 * - Permitir al usuario ingresar nombres y mostrarlos en orden inverso.
 * 
 * Lógica:
 * 1. Leer nombres hasta que el usuario escriba "FIN".
 * 2. Apilar cada nombre.
 * 3. Desapilar e imprimir en orden inverso.
 */
public class Nombres{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> pila = new Stack<>();
        String nombre;

        while (true) {
            System.out.print("Ingrese un nombre (FIN para salir): ");
            nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("FIN")) break;
            pila.push(nombre);
        }

        System.out.println("Nombres en orden inverso:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}
// Ejemplo: Ana, Luis, Pedro, FIN → Salida: Pedro, Luis, Ana
