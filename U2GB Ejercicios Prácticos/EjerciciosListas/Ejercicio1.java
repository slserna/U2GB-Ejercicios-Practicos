/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase: ListaEnlazada<T>
 * 
 * Objetivo:
 * - Implementar una lista enlazada simple genérica.
 * - Permitir insertar elementos, mostrarlos y eliminar aquellos mayores a un valor dado.
 * 
 * Autor: Sara Lizbeth Serna Rodríguez
 * Grupo: GTID0141
 */
public class ListaEnlazada<T extends Comparable<T>> {

    /** Nodo interno con encapsulamiento */
    private class Nodo {
        private T dato;
        private Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public T getDato() {
            return dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    /** Referencia al primer nodo de la lista */
    private Nodo cabeza;

    /** Inserta un elemento al final de la lista */
    public void insertarFinal(T valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    /** Muestra el contenido de la lista en consola */
    public void mostrarLista() {
        Nodo aux = cabeza;
        while (aux != null) {
            System.out.print(aux.getDato() + " -> ");
            aux = aux.getSiguiente();
        }
        System.out.println("null");
    }

    /**
     * Elimina los nodos cuyos valores sean mayores que el límite dado.
     * 
     * @param limite valor de referencia para eliminar elementos mayores
     */
    public void eliminarMayores(T limite) {
        while (cabeza != null && cabeza.getDato().compareTo(limite) > 0) {
            cabeza = cabeza.getSiguiente();
        }

        Nodo actual = cabeza;
        while (actual != null && actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().compareTo(limite) > 0) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
            } else {
                actual = actual.getSiguiente();
            }
        }
    }

    /** Método principal para probar la lista enlazada */
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // Generar y agregar 10 números aleatorios
        for (int i = 0; i < 10; i++) {
            lista.insertarFinal(rand.nextInt(100) + 1);
        }

        System.out.println("\n Lista original:");
        lista.mostrarLista();

        System.out.print("\nIngrese un valor límite: ");
        int limite = sc.nextInt();

        lista.eliminarMayores(limite);
        System.out.println("\n Lista después de eliminar elementos mayores a " + limite + ":");
        lista.mostrarLista();

        sc.close();
    }
}

