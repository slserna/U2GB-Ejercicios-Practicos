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
import java.util.Scanner;
import java.util.Stack;

/**
 * Ejercicio 7: Simular función Deshacer (Undo).
 * 
 * Objetivo:
 * - Implementar una pila de acciones para poder deshacer la última acción.
 */
public class Deshacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> acciones = new Stack<>();

        while (true) {
            System.out.print("Acción (UNDO/FIN): ");
            String act = sc.nextLine();

            if (act.equalsIgnoreCase("FIN")) break;
            if (act.equalsIgnoreCase("UNDO")) {
                if (!acciones.isEmpty()) {
                    acciones.pop();
                }
            } else {
                acciones.push(act);
            }

            System.out.println("Actual: " + acciones);
        }
    }
}
// Ejemplo: escribir 'Hola', escribir 'Mundo', UNDO → [Hola]

