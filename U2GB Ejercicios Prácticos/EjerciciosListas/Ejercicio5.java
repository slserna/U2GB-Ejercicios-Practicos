/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

import java.util.Scanner;

/**
 * EJERCICIO 5 -----
 * 
 * @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * 
 * Objetivo:
 * - Implementar una lista doblemente enlazada genérica.
 * - Insertar caracteres de una cadena en la lista.
 * - Ordenar los elementos alfabéticamente utilizando el método de burbuja.
 * 
 * Descripción:
 * Este programa construye una lista doblemente enlazada con los caracteres
 * de una cadena ingresada por el usuario. Luego, los ordena alfabéticamente
 * y muestra la lista antes y después de la ordenación.
 * 
 * Parametrización:
 * - Se utiliza el tipo genérico <T> para permitir manejar distintos tipos de datos
 *   en la lista, aunque en este caso se usa con caracteres.
 */

public class Ejercicio5<T extends Comparable<T>> {
    Nodo<T> cabeza, cola;

    /**
     * Clase interna Nodo parametrizada con tipo T.
     * Representa un elemento de la lista doblemente enlazada.
     */
    class Nodo<T> {
        T dato;
        Nodo<T> ant, sig;

        public Nodo(T dato) {
            this.dato = dato;
            this.ant = null;
            this.sig = null;
        }
    }

    /** Inserta un elemento al final de la lista */
    void insertarFinal(T c) {
        Nodo<T> nuevo = new Nodo<>(c);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.sig = nuevo;
            nuevo.ant = cola;
            cola = nuevo;
        }
    }

    /** Ordena la lista alfabéticamente mediante el método burbuja */
    void ordenarLista() {
        if (cabeza == null) return;
        boolean cambiado;
        do {
            cambiado = false;
            Nodo<T> actual = cabeza;
            while (actual.sig != null) {
                if (actual.dato.compareTo(actual.sig.dato) > 0) {
                    T temp = actual.dato;
                    actual.dato = actual.sig.dato;
                    actual.sig.dato = temp;
                    cambiado = true;
                }
                actual = actual.sig;
            }
        } while (cambiado);
    }

    /** Muestra la lista desde el inicio */
    void mostrarLista() {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.sig;
        }
        System.out.println();
    }

    /** Método principal: ejecuta el programa */
    public static void main(String[] args) {
        Ejercicio5<Character> lista = new Ejercicio5<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa una cadena: ");
        String cadena = sc.nextLine();

        // Construir lista doblemente enlazada con los caracteres
        for (char c : cadena.toCharArray()) {
            lista.insertarFinal(c);
        }

        System.out.println("\nLista original:");
        lista.mostrarLista();

        lista.ordenarLista();
        System.out.println("Lista ordenada alfabéticamente:");
        lista.mostrarLista();
    }
}
