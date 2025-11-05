/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Five;

import java.util.Scanner;

/**
 *
 @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO 3 -----
 */


public class Ejercicio3 {
    Nodo cabeza;
    
    
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

    // Insertar término al final
    void insertarTermino(double c, int e) {
        Nodo nuevo = new Nodo(c, e);
        if (cabeza == null)
            cabeza = nuevo;
        else {
            Nodo aux = cabeza;
            while (aux.sig != null)
                aux = aux.sig;
            aux.sig = nuevo;
        }
    }
    
    
    

    // Evaluar polinomio para un valor x
    double evaluar(double x) {
        double resultado = 0;
        Nodo aux = cabeza;
        while (aux != null) {
            resultado += aux.coef * Math.pow(x, aux.exp);
            aux = aux.sig;
        }
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
        Ejercicio3 poli = new Ejercicio3();
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

        System.out.println("\nTabla de valores del polinomio:");
        poli.mostrarTabla();
    }
}
