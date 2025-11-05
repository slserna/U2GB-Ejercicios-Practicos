/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import java.util.Scanner;
import java.util.Stack;

/**
 * EJERCICIO 7 -----
 * 
 * @author 12241
 * @Autor Sara Lizbeth Serna Rodríguez
 * Grupo: GTID0141
 * 
 * Objetivo:
 * - Implementar una pila de acciones para simular la función "Deshacer" (Undo).
 * 
 * Descripción:
 * Este programa utiliza una pila genérica para almacenar acciones de texto.
 * El usuario puede ingresar acciones, y al escribir "UNDO" se elimina la última
 * acción realizada (simulando la función de deshacer). Si escribe "FIN", el programa
 * termina. Después de cada operación, se muestra el estado actual de la pila.
 * 
 * Parametrización:
 * - Se utiliza el tipo genérico <T> para permitir que la pila almacene diferentes
 *   tipos de acciones (en este caso, cadenas de texto).
 */

public class Deshacer<T> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> acciones = new Stack<>();

        System.out.println("Simulación de función Deshacer (UNDO)");
        System.out.println("Ingrese acciones. Escriba 'UNDO' para deshacer o 'FIN' para salir.\n");

        while (true) {
            System.out.print("Acción (UNDO/FIN): ");
            String act = sc.nextLine();

            if (act.equalsIgnoreCase("FIN")) break;

            if (act.equalsIgnoreCase("UNDO")) {
                if (!acciones.isEmpty()) {
                    String eliminada = acciones.pop();
                    System.out.println("Acción '" + eliminada + "' deshecha.");
                } else {
                    System.out.println("No hay acciones para deshacer.");
                }
            } else {
                acciones.push(act);
                System.out.println("Acción '" + act + "' agregada.");
            }

            System.out.println("Actual: " + acciones + "\n");
        }

        System.out.println("Programa finalizado. Estado final de acciones: " + acciones);
    }
}
