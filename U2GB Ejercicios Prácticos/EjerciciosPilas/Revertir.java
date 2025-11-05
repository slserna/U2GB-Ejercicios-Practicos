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
 * Clase: RevertirLista<T>
 * 
 * Ejercicio 9: Revertir lista.
 * 
 * Objetivo:
 * - Invertir los elementos de una lista utilizando una pila genérica.
 * 
 * Descripción:
 * 1. Se insertan los elementos de una lista en una pila.
 * 2. Se desapilan para obtener el orden inverso.
 * 
 * Parametrización:
 * - Se usa Stack<T> para permitir el manejo de cualquier tipo de dato.
 */
public class RevertirLista<T> {

    /**
     * Método genérico para invertir un arreglo de cualquier tipo.
     * @param lista arreglo de elementos a invertir
     */
    public void invertirLista(T[] lista) {
        Stack<T> pila = new Stack<>();

        // Apilar elementos
        for (T elemento : lista) {
            pila.push(elemento);
        }

        // Mostrar en orden invertido
        System.out.print("Lista invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RevertirLista<Integer> ejemplo = new RevertirLista<>();
        Integer[] numeros = {1, 2, 3, 4};
        ejemplo.invertirLista(numeros);
    }
}
