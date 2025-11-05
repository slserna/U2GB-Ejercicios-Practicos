/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

import java.io.*;
import java.util.Scanner;

/**
 * Clase: ListaPalabras<T>
 * 
 * Objetivo:
 * - Leer, almacenar, eliminar y escribir palabras desde/hacia un archivo de texto.
 * - Implementar una lista enlazada genérica con encapsulamiento.
 * 
 * Autor: Sara Lizbeth Serna Rodríguez  
 * Grupo: GTID0141
 */
public class ListaPalabras<T> {

    /** Clase interna Nodo con encapsulamiento */
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

    /** Referencia al primer nodo */
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

    /** Muestra los elementos de la lista en consola */
    public void mostrarLista() {
        Nodo aux = cabeza;
        while (aux != null) {
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    /**
     * Elimina los nodos que coincidan con el valor especificado.
     * 
     * @param valor valor a eliminar de la lista
     */
    public void eliminarElemento(T valor) {
        while (cabeza != null && cabeza.getDato().equals(valor)) {
            cabeza = cabeza.getSiguiente();
        }

        Nodo actual = cabeza;
        while (actual != null && actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(valor)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
            } else {
                actual = actual.getSiguiente();
            }
        }
    }

    /**
     * Lee un archivo y agrega sus palabras (o líneas) a la lista.
     * 
     * @param nombreArchivo nombre del archivo de texto a leer
     * @throws IOException si ocurre un error al leer el archivo
     */
    public void leerArchivo(String nombreArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                for (String p : palabras) {
                    if (!p.isEmpty()) {
                        @SuppressWarnings("unchecked")
                        T valor = (T) p;
                        insertarFinal(valor);
                    }
                }
            }
        }
    }

    /**
     * Escribe el contenido de la lista en un archivo de texto.
     * 
     * @param nombreArchivo nombre del archivo donde se guardará la lista
     * @throws IOException si ocurre un error al escribir el archivo
     */
    public void escribirArchivo(String nombreArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Nodo aux = cabeza;
            while (aux != null) {
                bw.write(aux.getDato() + " ");
                aux = aux.getSiguiente();
            }
        }
    }

    /** Método principal para probar la funcionalidad */
    public static void main(String[] args) {
        ListaPalabras<String> lista = new ListaPalabras<>();
        Scanner sc = new Scanner(System.in);
        String archivo = "palabras.txt";

        try {
            // Leer contenido existente
            lista.leerArchivo(archivo);
            System.out.println("\nPalabras leídas desde el archivo:");
            lista.mostrarLista();

            // Insertar palabra nueva
            System.out.print("\n Ingrese una palabra nueva: ");
            lista.insertarFinal(sc.nextLine());

            // Eliminar palabra
            System.out.print("Ingrese una palabra a eliminar: ");
            lista.eliminarElemento(sc.nextLine());

            // Mostrar lista final
            System.out.println("\n Lista final:");
            lista.mostrarLista();

            // Guardar cambios
            lista.escribirArchivo(archivo);
            System.out.println("\n Archivo actualizado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
