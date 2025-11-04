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

/**
 * Ejercicio 8: Evaluar expresión postfija.
 * 
 * Objetivo:
 * - Evaluar expresiones aritméticas en notación polaca inversa (postfija).
 */
public class Evaluar {

    public static int evaluar(String expr) {
        Stack<Integer> pila = new Stack<>();
        for (String token : expr.split(" ")) {
            if (token.matches("\\d+")) {
                pila.push(Integer.parseInt(token));
            } else {
                int b = pila.pop();
                int a = pila.pop();
                switch (token) {
                    case "+": pila.push(a + b); break;
                    case "-": pila.push(a - b); break;
                    case "*": pila.push(a * b); break;
                    case "/": pila.push(a / b); break;
                }
            }
        }
        return pila.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluar("5 3 + 8 2 - *"));
    }
}
// Ejemplo: "5 3 + 8 2 - *" → Salida esperada: 48

