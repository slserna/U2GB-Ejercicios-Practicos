/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

/**
 *
 @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO 5 -----
 */
import java.util.Scanner;

class Nodo {
    char dato;
    Nodo ant, sig;

    public Nodo(char dato) {
        this.dato = dato;
        this.ant = null;
        this.sig = null;
    }
}

public class Ejercicio5 {
    Nodo cabeza, cola;

    // Insertar al final
    void insertarFinal(char c) {
        Nodo nuevo = new Nodo(c);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.sig = nuevo;
            nuevo.ant = cola;
            cola = nuevo;
        }
    }

    // Ordenar alfabéticamente (burbuja)
    void ordenarLista() {
        if (cabeza == null) return;
        boolean cambiado;
        do {
            cambiado = false;
            Nodo actual = cabeza;
            while (actual.sig != null) {
                if (actual.dato > actual.sig.dato) {
                    char temp = actual.dato;
                    actual.dato = actual.sig.dato;
                    actual.sig.dato = temp;
                    cambiado = true;
                }
                actual = actual.sig;
            }
        } while (cambiado);
    }

    // Mostrar lista desde el inicio
    void mostrarLista() {
        Nodo aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.sig;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ejercicio5 lista = new Ejercicio5();
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa una cadena: ");
        String cadena = sc.nextLine();

        // Construir lista doblemente enlazada
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

