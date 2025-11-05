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
 * Clase: SimulacionPila<T>
 * 
 * Ejercicio 1: Simulación simple de pila.
 * 
 * Objetivo:
 * - Practicar las operaciones básicas de una pila: push() y pop().
 * 
 * Descripción:
 * 1. Se crea una pila vacía.
 * 2. Se insertan los valores 5, 10, 15, 20.
 * 3. Se eliminan dos elementos.
 * 4. Se muestra el contenido restante.
 * 
 * Parametrización:
 * - Se utiliza Stack<T> para permitir manejar pilas de cualquier tipo de dato.
 */
public class SimulacionPila<T> {

    public void ejecutarSimulacion(T[] elementos, int pops) {
        Stack<T> pila = new Stack<>();

        // Insertar elementos
        for (T e : elementos) {
            pila.push(e);
        }

        // Eliminar los elementos indicados
        for (int i = 0; i < pops && !pila.isEmpty(); i++) {
            pila.pop();
        }

        // Mostrar pila actual
        System.out.println("Contenido actual: " + pila);
    }

    public static void main(String[] args) {
        SimulacionPila<Integer> simulacion = new SimulacionPila<>();
        Integer[] datos = {5, 10, 15, 20};
        simulacion.ejecutarSimulacion(datos, 2);
    }
}
