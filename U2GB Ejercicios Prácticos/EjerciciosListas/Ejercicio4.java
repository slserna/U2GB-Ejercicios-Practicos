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
 * EJERCICIO 4 -----
 */
import java.util.Scanner;

/**
 * Clase: PolinomioCircular<T>
 * 
 * Objetivo:
 * - Representar un polinomio mediante una lista circular enlazada genérica.
 * - Permitir insertar términos, mostrar el polinomio y evaluarlo.
 * 
 * Autor: Sara Lizbeth Serna Rodríguez
 * Grupo: GTID0141
 */
public class PolinomioCircular<T> {

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

    private Nodo ultimo; // referencia al último nodo (lista circular)

    /** Inserta un término al final del polinomio manteniendo la circularidad */
    public void insertarTermino(double coef, int exp) {
        Nodo nuevo = new Nodo(coef, exp);
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.setSiguiente(ultimo);
        } else {
            nuevo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    /** Muestra el polinomio recorriendo la lista circular */
    public void mostrarPolinomio() {
        if (ultimo == null) return;
        Nodo aux = ultimo.getSiguiente();
        do {
            System.out.print((aux.getCoeficiente() >= 0 ? "+ " : "") + aux.getCoeficiente() + "x^" + aux.getExponente() + " ");
            aux = aux.getSiguiente();
        } while (aux != ultimo.getSiguiente());
        System.out.println();
    }

    /** Evalúa el polinomio para un valor dado de x */
    public double evaluar(double x) {
        if (ultimo == null) return 0;
        double resultado = 0;
        Nodo aux = ultimo.getSiguiente();
        do {
            resultado += aux.getCoeficiente() * Math.pow(x, aux.getExponente());
            aux = aux.getSiguiente();
        } while (aux != ultimo.getSiguiente());
        return resultado;
    }

    /** Muestra una tabla con los valores del polinomio para x entre 0 y 5 */
    public void mostrarTabla() {
        System.out.println("x\t|\tP(x)");
        System.out.println("-------------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            System.out.printf("%.1f\t|\t%.2f%n", x, evaluar(x));
        }
    }

    /** Método principal de prueba */
    public static void main(String[] args) {
        PolinomioCircular<Double> polinomio = new PolinomioCircular<>();
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

        System.out.println("\nPolinomio representado:");
        polinomio.mostrarPolinomio();

        System.out.println("\nTabla de valores:");
        polinomio.mostrarTabla();
        sc.close();
    }
}
