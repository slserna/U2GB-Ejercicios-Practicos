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
 * Ejercicio 2: Simulación de supermercado con carritos y cajas
 * 
 * Objetivos:
 * - Modelar colas para carritos y cajas.
 * - Aplicar lógica de asignación y liberación de recursos.
 * - Simular comportamiento de clientes en tiempo discreto.
 */
public class SimulacionSupermercado {

    public static void simulacion(int tiempoSimulacion) {
        Queue<String> carritos = new LinkedList<>();
        for (int i = 1; i <= 25; i++) {
            carritos.add("Carrito-" + i);
        }

        Queue<String>[] cajas = new LinkedList[3];
        for (int i = 0; i < 3; i++) {
            cajas[i] = new LinkedList<>();
        }

        Queue<String> espera = new LinkedList<>();
        Random random = new Random();
        int clienteId = 1;

        for (int t = 0; t < tiempoSimulacion; t++) {
            // Llega cliente nuevo
            if (random.nextDouble() < 0.5) {
                espera.add("Cliente-" + clienteId);
                clienteId++;
            }

            // Asignar carrito y caja con menos clientes
            if (!carritos.isEmpty() && !espera.isEmpty()) {
                String cliente = espera.poll();
                String carrito = carritos.poll();

                // Buscar caja con menos clientes
                int menor = 0;
                for (int i = 1; i < cajas.length; i++) {
                    if (cajas[i].size() < cajas[menor].size()) {
                        menor = i;
                    }
                }

                cajas[menor].add(cliente + " (" + carrito + ")");
                System.out.println(cliente + " tomó " + carrito + " y fue a la caja " + (menor + 1));
            }

            // Simular pago aleatorio y liberar carrito
            for (int i = 0; i < cajas.length; i++) {
                if (!cajas[i].isEmpty() && random.nextDouble() < 0.3) {
                    String registro = cajas[i].poll();
                    String carrito = registro.substring(registro.indexOf("(") + 1, registro.indexOf(")"));
                    carritos.add(carrito);
                    System.out.println(registro + " terminó en caja " + (i + 1) + " y liberó " + carrito);
                }
            }
        }

        System.out.println("\n--- Simulación finalizada ---");
        System.out.println("Carritos disponibles: " + carritos.size());
    }

    public static void main(String[] args) {
        simulacion(20);
    }
}
