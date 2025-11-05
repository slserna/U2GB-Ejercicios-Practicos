/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

import java.util.Scanner;

/**
 * Clase: Polinomio<T>
 * 
 * Objetivo:
 * - Representar un polinomio mediante una lista enlazada genérica.
 * - Permitir insertar términos y evaluar el polinomio para distintos valores de x.
 * 
 * Autor: Sara Lizbeth Serna Rodríguez
 * Grupo: GTID0141
 */
public class Polinomio<T> {

    /** Clase interna Nodo con encapsulamiento */
    private class Nodo {
        private double coeficiente;
        private int exponente;
        private Nodo siguiente;

        public Nodo(double coeficiente, int exponente) {
            this.coeficiente = coeficiente;
            this.exponente = exponente;
            this.siguiente = null;
        }

        public double getCoeficiente() { return coeficiente; }
        public int getExponente() { return exponente; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    private Nodo cabeza;

    /** Inserta un nuevo término al final del polinomio */
    public void insertarTermino(double coef, int exp) {
        Nodo nuevo = new Nodo(coef, exp);
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

    /** Evalúa el polinomio para un valor dado de x */
    public double evaluar(double x) {
        double resultado = 0;
        Nodo aux = cabeza;
        while (aux != null) {
            resultado += aux.getCoeficiente() * Math.pow(x, aux.getExponente());
            aux = aux.getSiguiente();
        }
        return resultado;
    }

    /** Muestra una tabla de valores de P(x) para x entre 0 y 5 con incremento de 0.5 */
    public void mostrarTabla() {
        System.out.println("x\t|\tP(x)");
        System.out.println("-------------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            System.out.printf("%.1f\t|\t%.2f%n", x, evaluar(x));
        }
    }

    /** Método principal para probar la clase Polinomio */
    public static void main(String[] args) {
        Polinomio<Double> polinomio = new Polinomio<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa los términos del polinomio (coef exp). Termina con exponente negativo:");
        while (true) {
            System.out.print("Coeficiente: ");
            double coef = sc.nextDouble();
            System.out.print("Exponente: ");
            int exp = sc.nextInt();
            if (exp < 0) break;
            polinomio.insertarTermino(coef, exp);
        }

        System.out.println("\nTabla de valores del polinomio:");
        polinomio.mostrarTabla();
        sc.close();
    }
}
