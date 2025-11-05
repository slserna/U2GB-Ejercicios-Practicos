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
 * Ejercicio 3: Simulación de atención al cliente en Supermercado Esperanza (parametrizada)
 *
 * Objetivos:
 * - Aplicar estructuras de cola y simulación temporal.
 * - Implementar lógica condicional y aleatoria.
 * - Generar estadísticas de rendimiento configurables.
 */
public class SupermercadoEsperanza {

    /**
     * Simula la atención al cliente en un supermercado.
     *
     * @param horasDuracion   Número de horas de simulación.
     * @param numCajasBase    Cantidad de cajas abiertas desde el inicio.
     * @param umbralApertura4 Umbral de personas en fila para abrir una caja adicional.
     * @param tiempoMinAt     Tiempo mínimo de atención por cliente (minutos).
     * @param tiempoMaxAt     Tiempo máximo de atención por cliente (minutos).
     * @param probLlegada     Probabilidad (0–1) de que llegue un cliente cada minuto.
     */
    public static void simulacion(
            int horasDuracion,
            int numCajasBase,
            int umbralApertura4,
            int tiempoMinAt,
            int tiempoMaxAt,
            double probLlegada
    ) {
        // Validaciones básicas
        if (horasDuracion <= 0 || numCajasBase <= 0 || tiempoMinAt <= 0 || tiempoMaxAt < tiempoMinAt) {
            throw new IllegalArgumentException("Los parámetros deben tener valores válidos y positivos.");
        }

        int minutosTotales = horasDuracion * 60;
        Queue<Cliente> fila = new LinkedList<>();
        String[] cajas = new String[Math.max(numCajasBase, 4)]; // hasta 4 cajas máximo
        int[] tiempoRestante = new int[cajas.length];
        Random random = new Random();

        int totalClientes = 0;
        int atendidos = 0;
        int tamMaxFila = 0;
        int sumaTamFila = 0;
        int tiempoEsperaMax = 0;
        Integer aperturaCajaExtra = null;

        System.out.println("=== INICIO DE SIMULACIÓN SUPERMERCADO ESPERANZA ===");

        for (int minuto = 0; minuto < minutosTotales; minuto++) {

            // 📥 Llega un cliente con cierta probabilidad
            if (random.nextDouble() < probLlegada) {
                fila.add(new Cliente(minuto, "Cliente-" + (totalClientes + 1)));
                totalClientes++;
            }

            // ⚡ Apertura de la caja extra si hay demasiada gente
            if (fila.size() > umbralApertura4 && aperturaCajaExtra == null) {
                aperturaCajaExtra = minuto;
                System.out.println("⚡ Se abrió una caja extra en el minuto " + minuto);
            }

            // 🛒 Asignar clientes a cajas disponibles
            for (int i = 0; i < cajas.length; i++) {
                // Las primeras n cajas funcionan siempre; la caja extra se abre si es necesario
                if (i < numCajasBase || aperturaCajaExtra != null) {
                    if (cajas[i] == null && !fila.isEmpty()) {
                        Cliente c = fila.poll();
                        int espera = minuto - c.tiempoLlegada;
                        if (espera > tiempoEsperaMax) tiempoEsperaMax = espera;
                        cajas[i] = c.nombre;
                        tiempoRestante[i] = tiempoMinAt + random.nextInt(tiempoMaxAt - tiempoMinAt + 1);
                    }
                }
            }

            // 💳 Reducir tiempos de atención y liberar cajas
            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i] != null) {
                    tiempoRestante[i]--;
                    if (tiempoRestante[i] <= 0) {
                        cajas[i] = null;
                        atendidos++;
                    }
                }
            }

            // 📊 Estadísticas de fila
            sumaTamFila += fila.size();
            if (fila.size() > tamMaxFila) tamMaxFila = fila.size();
        }

        // 🧾 Resultados finales
        System.out.println("\n--- RESULTADOS DE LA SIMULACIÓN ---");
        System.out.println("Horas simuladas: " + horasDuracion);
        System.out.println("Total de clientes que llegaron: " + totalClientes);
        System.out.println("Total de clientes atendidos: " + atendidos);
        System.out.printf("Tamaño medio de la fila: %.2f%n", (sumaTamFila / (double) minutosTotales));
        System.out.println("Tamaño máximo de la fila: " + tamMaxFila);
        System.out.println("Tiempo máximo de espera: " + tiempoEsperaMax + " min");
        System.out.println("Minuto de apertura de la caja extra: " +
                (aperturaCajaExtra == null ? "No se abrió" : aperturaCajaExtra + " min"));
        System.out.println("=== FIN DE LA SIMULACIÓN ===");
    }

    public static void main(String[] args) {
        // 🔹 Parámetros configurables
        int horas = 7;             // duración en horas
        int cajasIniciales = 3;    // número de cajas abiertas al inicio
        int umbral = 20;           // cuando la fila supera este número se abre otra caja
        int tMin = 3;              // tiempo mínimo de atención (minutos)
        int tMax = 8;              // tiempo máximo de atención (minutos)
        double probLlegada = 1.0;  // probabilidad de llegada de cliente cada minuto

        simulacion(horas, cajasIniciales, umbral, tMin, tMax, probLlegada);
    }
}

/**
 * Clase Cliente: Representa a un cliente con tiempo de llegada y nombre.
 */
class Cliente {
    int tiempoLlegada;
    String nombre;

    public Cliente(int tiempoLlegada, String nombre) {
        this.tiempoLlegada = tiempoLlegada;
        this.nombre = nombre;
    }
}
