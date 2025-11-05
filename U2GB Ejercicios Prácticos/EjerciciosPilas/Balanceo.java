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
 * Ejercicio 5: Balanceo de símbolos con tipo genérico <T>.
 *
 * Objetivo:
 * - Verificar si los símbolos están balanceados usando una pila genérica.
 */
public class Balanceo {

    public static <T> boolean estaBalanceada(String expr, T apertura, T cierre) {
        Stack<T> pila = new Stack<>();
        for (char c : expr.toCharArray()) {
            // Convertir el carácter actual al tipo genérico (solo simbólico aquí)
            @SuppressWarnings("unchecked")
            T simbolo = (T) Character.valueOf(c);

            if (simbolo.equals(apertura)) pila.push(simbolo);
            else if (simbolo.equals(cierre)) {
                if (pila.isEmpty()) return false;
                pila.pop();
            }
        }
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(estaBalanceada("((2+3)*5)", '(', ')'));    // true
        System.out.println(estaBalanceada("((2+3)*5", '(', ')'));     // false
        System.out.println(estaBalanceada("{[a+b]*(c+d)}", '{', '}')); // true
    }
}
