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

import java.util.Stack;

/**
 * Ejercicio 8: Evaluar expresión postfija.
 * 
 * Objetivo:
 * - Evaluar expresiones aritméticas en notación polaca inversa (postfija).
 * 
 * Descripción:
 * Este programa utiliza una pila genérica para evaluar expresiones postfijas,
 * donde los operandos preceden al operador. Por ejemplo, la expresión:
 * 
 *     "5 3 + 8 2 - *"
 * 
 * equivale a (5 + 3) * (8 - 2) = 48.
 * 
 * Parametrización:
 * - Se usa la clase genérica Stack<T> para manipular operandos de tipo Integer.
 */

public class Evaluar<T> {

    /**
     * Método para evaluar una expresión postfija.
     * 
     * @param expr expresión aritmética en notación postfija separada por espacios.
     * @return el resultado entero de la evaluación.
     */
    public static int evaluar(String expr) {
        Stack<Integer> pila = new Stack<>();

        for (String token : expr.split(" ")) {
            if (token.matches("\\d+")) { // Si es número
                pila.push(Integer.parseInt(token));
            } else { // Si es operador
                int b = pila.pop();
                int a = pila.pop();

                switch (token) {
                    case "+": pila.push(a + b); break;
                    case "-": pila.push(a - b); break;
                    case "*": pila.push(a * b); break;
                    case "/": pila.push(a / b); break;
                    default:
                        throw new IllegalArgumentException("Operador no válido: " + token);
                }
            }
        }

        return pila.pop();
    }

    /**
     * Método principal: prueba de evaluación.
     */
    public static void main(String[] args) {
        String expresion = "5 3 + 8 2 - *";
        System.out.println("Expresión postfija: " + expresion);
        System.out.println("Resultado: " + evaluar(expresion));
    }
}
