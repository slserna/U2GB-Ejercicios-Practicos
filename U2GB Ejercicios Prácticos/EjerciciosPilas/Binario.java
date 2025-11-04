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
 * Ejercicio 6: Decimal a binario.
 * 
 * Objetivo:
 * - Convertir un número decimal a binario utilizando una pila.
 */
public class Binario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese número: ");
        int num = sc.nextInt();
        Stack<Integer> pila = new Stack<>();

        while (num > 0) {
            pila.push(num % 2);
            num /= 2;
        }

        System.out.print("Binario: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }
    }
}
// Entrada: 13 → Salida: 1101

