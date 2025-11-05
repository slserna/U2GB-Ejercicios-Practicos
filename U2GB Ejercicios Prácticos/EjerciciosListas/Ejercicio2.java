/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO 2 -----
 */

public class Ejercicio2 {
    Nodo cabeza;
    
    class Nodo {
    String palabra;
    Nodo siguiente;

    public Nodo(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }
}


    // Insertar palabra al final
    void insertarFinal(String palabra) {
        Nodo nuevo = new Nodo(palabra);
        if (cabeza == null)
            cabeza = nuevo;
        else {
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
            System.out.print(aux.palabra + " ");
            aux = aux.siguiente;
        }
        System.out.println();
    }

    // Eliminar palabra específica
    void eliminarPalabra(String palabra) {
        while (cabeza != null && cabeza.palabra.equals(palabra))
            cabeza = cabeza.siguiente;

        Nodo actual = cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente.palabra.equals(palabra))
                actual.siguiente = actual.siguiente.siguiente;
            else
                actual = actual.siguiente;
        }
    }

    // Leer archivo y formar lista
    void leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] palabras = linea.split("\\s+");
            for (String p : palabras)
                if (!p.isEmpty()) insertarFinal(p);
        }
        br.close();
    }

    // Escribir lista al archivo
    void escribirArchivo(String nombreArchivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
        Nodo aux = cabeza;
        while (aux != null) {
            bw.write(aux.palabra + " ");
            aux = aux.siguiente;
        }
        bw.close();
    }

    public static void main(String[] args) {
        Ejercicio2 lista = new Ejercicio2();
        Scanner sc = new Scanner(System.in);
        String archivo = "palabras.txt";

        try {
            lista.leerArchivo(archivo);
            System.out.println("Palabras leídas:");
            lista.mostrarLista();

            System.out.print("Añadir nueva palabra: ");
            lista.insertarFinal(sc.nextLine());

            System.out.print("Eliminar palabra: ");
            lista.eliminarPalabra(sc.nextLine());

            System.out.println("Lista final:");
            lista.mostrarLista();

            lista.escribirArchivo(archivo);
            System.out.println("Archivo actualizado con éxito.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
