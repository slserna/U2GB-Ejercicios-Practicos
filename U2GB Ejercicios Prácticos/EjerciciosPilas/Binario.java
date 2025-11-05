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
 * Ejercicio 6: Conversión decimal a binario con tipo genérico <T>.
 *
 * Objetivo:
 * - Convertir un número decimal a binario utilizando una pila genérica.
 */
public class Binario {

    public static <T extends Number> void convertirABinario(T numero) {
        Stack<Integer> pila = new Stack<>();
        int num = numero.intValue();

        if (num == 0) {
            System.out.println("Binario: 0");
            return;
        }

        while (num > 0) {
            pila.push(num % 2);
            num /= 2;
        }

        System.out.print("Binario: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese número decimal: ");
        int num = sc.nextInt();

        // Usa el método genérico
        convertirABinario(num);
    }
}


