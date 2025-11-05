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
import java.util.*;



public class Ejercicio4 {
    Nodo ultimo; // referencia al último nodo (lista circular)

    // Insertar término al final (manteniendo la circularidad)
    void insertarTermino(double c, int e) {
        Nodo nuevo = new Nodo(c, e);
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.sig = ultimo;
        } else {
            nuevo.sig = ultimo.sig;
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
    }
    
    class Nodo {
    double coef;
    int exp;
    Nodo sig;

    public Nodo(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.sig = null;
    }
}

    // Mostrar polinomio recorriendo circularmente
    void mostrarPolinomio() {
        if (ultimo == null) return;
        Nodo aux = ultimo.sig; // empieza desde el primero
        do {
            System.out.print((aux.coef >= 0 ? "+ " : "") + aux.coef + "x^" + aux.exp + " ");
            aux = aux.sig;
        } while (aux != ultimo.sig);
        System.out.println();
    }

    // Evaluar el polinomio para cierto valor de x
    double evaluar(double x) {
        if (ultimo == null) return 0;
        double resultado = 0;
        Nodo aux = ultimo.sig;
        do {
            resultado += aux.coef * Math.pow(x, aux.exp);
            aux = aux.sig;
        } while (aux != ultimo.sig);
        return resultado;
    }

    // Mostrar tabla de valores
    void mostrarTabla() {
        System.out.println(" x\t|  P(x)");
        System.out.println("---------------");
        for (double x = 0.0; x <= 5.0; x += 0.5)
            System.out.printf("%.1f\t|  %.2f%n", x, evaluar(x));
    }

    public static void main(String[] args) {
        Ejercicio4 poli = new Ejercicio4();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa los términos del polinomio (coef exp), termina con exp negativo:");
        while (true) {
            System.out.print("Coeficiente: ");
            double c = sc.nextDouble();
            System.out.print("Exponente: ");
            int e = sc.nextInt();
            if (e < 0) break;
            poli.insertarTermino(c, e);
        }

        System.out.println("\nPolinomio representado:");
        poli.mostrarPolinomio();

        System.out.println("\nTabla de valores:");
        poli.mostrarTabla();
    }
}

