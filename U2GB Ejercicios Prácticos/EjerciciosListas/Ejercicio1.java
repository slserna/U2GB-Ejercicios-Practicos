/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO 1 -----
 * 
 */


public class Ejercicio1 {
    Nodo cabeza;
    
    class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

    // Insertar al final
    void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.siguiente != null)
                aux = aux.siguiente;
            aux.siguiente = nuevo;
        }
    }

    // Mostrar lista
    void mostrarLista() {
        Nodo aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;
        }
        System.out.println("null");
    }

    // Eliminar mayores a un valor dado
    void eliminarMayores(int limite) {
        while (cabeza != null && cabeza.dato > limite)
            cabeza = cabeza.siguiente;

        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.dato > limite)
                actual.siguiente = actual.siguiente.siguiente;
            else
                actual = actual.siguiente;
        }
    }

    public static void main(String[] args) {
        Ejercicio1 lista = new Ejercicio1();
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // Generar números aleatorios
        for (int i = 0; i < 10; i++)
            lista.insertarFinal(rand.nextInt(100) + 1);

        System.out.println("Lista original:");
        lista.mostrarLista();

        System.out.print("Ingresa un valor límite: ");
        int limite = sc.nextInt();

        lista.eliminarMayores(limite);
        System.out.println("Lista después de eliminar mayores a " + limite + ":");
        lista.mostrarLista();
    }
}