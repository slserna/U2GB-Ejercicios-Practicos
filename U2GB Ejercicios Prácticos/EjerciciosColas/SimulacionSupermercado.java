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
 * Ejercicio 2: Simulación de supermercado parametrizada
 *
 * Objetivos:
 * - Modelar colas para carritos y cajas.
 * - Aplicar lógica de asignación y liberación de recursos.
 * - Simular comportamiento de clientes en tiempo discreto.
 * - Permitir configuración flexible (número de cajas, carritos, tiempo).
 */
public class SimulacionSupermercado {

    /**
     * Simula el funcionamiento de un supermercado con colas.
     *
     * @param <T> Tipo genérico para representar a los clientes (String, objeto, etc.)
     * @param tiempoSimulacion Tiempo total de simulación en "unidades de tiempo"
     * @param numCarritos Número total de carritos disponibles
     * @param numCajas Número de cajas de cobro
     * @param probLlegada Probabilidad (0.0–1.0) de que llegue un nuevo cliente por unidad de tiempo
     * @param probPago Probabilidad (0.0–1.0) de que un cliente termine su pago por unidad de tiempo
     */
    public static <T> void simulacion(
            int tiempoSimulacion,
            int numCarritos,
            int numCajas,
            double probLlegada,
            double probPago) {

        if (tiempoSimulacion <= 0 || numCarritos <= 0 || numCajas <= 0) {
            throw new IllegalArgumentException("Parámetros inválidos: deben ser mayores que cero.");
        }

        Queue<String> carritos = new LinkedList<>();
        for (int i = 1; i <= numCarritos; i++) {
            carritos.add("Carrito-" + i);
        }

        @SuppressWarnings("unchecked")
        Queue<String>[] cajas = new LinkedList[numCajas];
        for (int i = 0; i < numCajas; i++) {
            cajas[i] = new LinkedList<>();
        }

        Queue<String> espera = new LinkedList<>();
        Random random = new Random();
        int clienteId = 1;

        System.out.println("=== INICIO DE LA SIMULACIÓN ===\n");

        for (int t = 0; t < tiempoSimulacion; t++) {
            System.out.println("\n[Tiempo " + (t + 1) + "]");

            // Llega un nuevo cliente con cierta probabilidad
            if (random.nextDouble() < probLlegada) {
                String cliente = "Cliente-" + clienteId++;
                espera.add(cliente);
                System.out.println(cliente + " llegó y espera su turno.");
            }

            // Asignar carrito y caja con menos clientes
            if (!carritos.isEmpty() && !espera.isEmpty()) {
                String cliente = espera.poll();
                String carrito = carritos.poll();

                // Buscar caja con menor número de clientes
                int menor = 0;
                for (int i = 1; i < cajas.length; i++) {
                    if (cajas[i].size() < cajas[menor].size()) {
                        menor = i;
                    }
                }

                cajas[menor].add(cliente + " (" + carrito + ")");
                System.out.println(cliente + " tomó " + carrito + " y fue a la caja " + (menor + 1));
            }

            // Simular pagos y liberar carritos
            for (int i = 0; i < cajas.length; i++) {
                if (!cajas[i].isEmpty() && random.nextDouble() < probPago) {
                    String registro = cajas[i].poll();
                    String carrito = registro.substring(registro.indexOf("(") + 1, registro.indexOf(")"));
                    carritos.add(carrito);
                    System.out.println(registro + " terminó en caja " + (i + 1) + " y liberó " + carrito);
                }
            }
        }

        System.out.println("\n=== SIMULACIÓN FINALIZADA ===");
        System.out.println("Carritos disponibles: " + carritos.size());
        System.out.println("Clientes en espera: " + espera.size());
        for (int i = 0; i < cajas.length; i++) {
            System.out.println("Clientes restantes en caja " + (i + 1) + ": " + cajas[i].size());
        }
    }

    public static void main(String[] args) {
        // 🔹 Simulación configurable
        int tiempo = 20;         // tiempo total (unidades)
        int carritos = 25;       // cantidad de carritos
        int cajas = 3;           // número de cajas
        double probLlegada = 0.5; // probabilidad de que llegue un cliente
        double probPago = 0.3;    // probabilidad de que un cliente termine

        simulacion(tiempo, carritos, cajas, probLlegada, probPago);
    }
}
