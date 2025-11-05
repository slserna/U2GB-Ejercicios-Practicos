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
 * Ejercicio 1: Comparación de colas parametrizadas
 *
 * Objetivos:
 * - Aplicar estructuras de datos tipo cola.
 * - Implementar recorrido y comparación de elementos.
 * - Preservar el estado original de las colas (usando colas auxiliares).
 * - Hacer uso de tipos genéricos para permitir comparar colas de cualquier tipo.
 */
public class Comparacion {

    /**
     * Compara si dos colas son idénticas (mismo tamaño y mismos elementos en el mismo orden).
     * 
     * @param <T> Tipo de los elementos almacenados en la cola (genérico)
     * @param cola1 Primera cola a comparar
     * @param cola2 Segunda cola a comparar
     * @return true si son iguales, false en caso contrario
     */
    public static <T> boolean colasIdenticas(Queue<T> cola1, Queue<T> cola2) {
        if (cola1 == null || cola2 == null) {
            throw new IllegalArgumentException("Las colas no pueden ser nulas.");
        }

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

            // Compara considerando nulls
            if (e1 == null && e2 != null || e1 != null && !e1.equals(e2)) {
                iguales = false;
            }
        }

        // Restaurar el contenido original de ambas colas
        while (!aux1.isEmpty()) {
            cola1.add(aux1.poll());
            cola2.add(aux2.poll());
        }

        return iguales;
    }

    public static void main(String[] args) {
        // Ejemplo con Integer
        Queue<Integer> c1 = new LinkedList<>();
        Queue<Integer> c2 = new LinkedList<>();
        for (int i = 1; i <= 4; i++) {
            c1.add(i);
            c2.add(i);
        }
        System.out.println("¿Son idénticas (Integer)? " + colasIdenticas(c1, c2));

        // Ejemplo con String
        Queue<String> colaStr1 = new LinkedList<>();
        Queue<String> colaStr2 = new LinkedList<>();
        colaStr1.add("A");
        colaStr1.add("B");
        colaStr2.add("A");
        colaStr2.add("C");
        System.out.println("¿Son idénticas (String)? " + colasIdenticas(colaStr1, colaStr2));

        // Ejemplo con Double
        Queue<Double> colaD1 = new LinkedList<>();
        Queue<Double> colaD2 = new LinkedList<>();
        colaD1.add(1.5);
        colaD1.add(2.5);
        colaD2.add(1.5);
        colaD2.add(2.5);
        System.out.println("¿Son idénticas (Double)? " + colasIdenticas(colaD1, colaD2));
    }
}

