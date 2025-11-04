/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

/**
 *
 @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO DE COLA -----
 * 30/10/25
 */
import java.util.LinkedList;
import java.util.Queue;

/**
 * Ejercicio 1: Comparación de colas
 * 
 * Objetivos:
 * - Aplicar estructuras de datos tipo cola.
 * - Implementar recorrido y comparación de elementos.
 * - Preservar el estado original de las colas (usando colas auxiliares).
 */
public class Comparacion {

    /**
     * Compara si dos colas son idénticas (mismo tamaño y mismos elementos en el mismo orden).
     *
     * @param cola1 Primera cola a comparar
     * @param cola2 Segunda cola a comparar
     * @return true si son iguales, false en caso contrario
     */
    public static <T> boolean colasIdenticas(Queue<T> cola1, Queue<T> cola2) {
        if (cola1.size() != cola2.size()) {
            return false;
        }

        Queue<T> aux1 = new LinkedList<>();
        Queue<T> aux2 = new LinkedList<>();
        boolean iguales = true;

        while (!cola1.isEmpty()) {
            T e1 = cola1.poll();
            T e2 = cola2.poll();
            aux1.add(e1);
            aux2.add(e2);

            if (!e1.equals(e2)) {
                iguales = false;
            }
        }

        // Restaurar el contenido original
        while (!aux1.isEmpty()) {
            cola1.add(aux1.poll());
            cola2.add(aux2.poll());
        }

        return iguales;
    }

    public static void main(String[] args) {
        Queue<Integer> c1 = new LinkedList<>();
        Queue<Integer> c2 = new LinkedList<>();

        for (int i = 1; i <= 4; i++) {
            c1.add(i);
            c2.add(i);
        }

        System.out.println("¿Son idénticas? " + colasIdenticas(c1, c2));
    }
}

