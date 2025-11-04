/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

/**
 *
 @author 12241
 * @Autor Sara Lizbeth Serna Rodriguez
 * Grupo: GTID0141
 * EJERCICIO DE COLA -----
 * 30/10/25
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Ejercicio 3: Simulación de atención al cliente en supermercado Esperanza
 * 
 * Objetivos:
 * - Aplicar estructuras de cola y simulación temporal.
 * - Implementar lógica condicional y aleatoria.
 * - Generar estadísticas de rendimiento.
 */
public class SupermercadoEsperanza {

    public static void simulacion() {
        int minutosTotales = 7 * 60; // 7 horas
        Queue<Cliente> fila = new LinkedList<>();
        String[] cajas = new String[4];
        int[] tiempoRestante = new int[4];
        Random random = new Random();

        int totalClientes = 0;
        int atendidos = 0;
        int tamMaxFila = 0;
        int sumaTamFila = 0;
        int tiempoEsperaMax = 0;
        Integer aperturaCaja4 = null;

        for (int minuto = 0; minuto < minutosTotales; minuto++) {
            // Llega un cliente cada minuto en promedio
            if (random.nextDouble() < 1.0) {
                fila.add(new Cliente(minuto, "Cliente-" + (totalClientes + 1)));
                totalClientes++;
            }

            // Abrir caja 4 si hay más de 20 personas
            if (fila.size() > 20 && aperturaCaja4 == null) {
                aperturaCaja4 = minuto;
                System.out.println("⚡ Se abrió la cuarta caja en el minuto " + minuto);
            }

            // Asignar clientes a cajas disponibles
            for (int i = 0; i < 4; i++) {
                if (i < 3 || aperturaCaja4 != null) {
                    if (cajas[i] == null && !fila.isEmpty()) {
                        Cliente c = fila.poll();
                        int espera = minuto - c.tiempoLlegada;
                        if (espera > tiempoEsperaMax) tiempoEsperaMax = espera;
                        cajas[i] = c.nombre;
                        tiempoRestante[i] = 3 + random.nextInt(6); // 3 a 8 min
                    }
                }
            }

            // Reducir tiempos de atención
            for (int i = 0; i < 4; i++) {
                if (cajas[i] != null) {
                    tiempoRestante[i]--;
                    if (tiempoRestante[i] == 0) {
                        cajas[i] = null;
                        atendidos++;
                    }
                }
            }

            sumaTamFila += fila.size();
            if (fila.size() > tamMaxFila) tamMaxFila = fila.size();
        }

        System.out.println("\n--- Resultados de la simulación ---");
        System.out.println("Total de clientes que llegaron: " + totalClientes);
        System.out.println("Total de clientes atendidos: " + atendidos);
        System.out.println("Tamaño medio de la fila: " + (sumaTamFila / (double) minutosTotales));
        System.out.println("Tamaño máximo de la fila: " + tamMaxFila);
        System.out.println("Tiempo máximo de espera: " + tiempoEsperaMax + " min");
        System.out.println("Minuto de apertura de la 4ª caja: " + (aperturaCaja4 == null ? "No se abrió" : aperturaCaja4 + " min"));
    }

    public static void main(String[] args) {
        simulacion();
    }
}

class Cliente {
    int tiempoLlegada;
    String nombre;

    public Cliente(int tiempoLlegada, String nombre) {
        this.tiempoLlegada = tiempoLlegada;
        this.nombre = nombre;
    }
}

