package Ejercicio3;

import java.util.Scanner;

public class MainSensorTemperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SensorTemperatura[] sensores = new SensorTemperatura[3];

        System.out.println("=== 1. INGRESO DE DATOS (ARREGLO COMPLETO CON .length) ===");
        for (int i = 0; i < sensores.length; i++) {
            System.out.println("\nRegistro para el sensor en la posición [" + i + "]:");
            System.out.print("ID del Sensor: ");
            String id = sc.nextLine();

            System.out.print("Temperatura actual: ");
            double valor = Double.parseDouble(sc.nextLine());

            System.out.print("Unidad de medida (ej. °C, °F): ");
            String unidad = sc.nextLine();

            sensores[i] = new SensorTemperatura(id, valor, unidad);
        }

        System.out.println("\n=== 2. LECTURA GENERAL DE LA RED DE SENSORES ===");
        for (int i = 0; i < sensores.length; i++) {
            System.out.print("[" + i + "] ");
            sensores[i].mostrarLectura();
        }

        System.out.println("\n=== 3. CALIBRACIÓN GENERAL (+1.5 A TODAS LAS LECTURAS) ===");
        for (int i = 0; i < sensores.length; i++) {
            double nuevaTemp = sensores[i].getValorActual() + 1.5;
            sensores[i].setValorActual(nuevaTemp);
        }
        System.out.println("Ajuste completado en todos los registros.");

        System.out.println("\n=== 4. LECTURAS ACTUALIZADAS (RECORRIDO CON .length) ===");
        for (int i = 0; i < sensores.length; i++) {
            System.out.print("[" + i + "] ");
            sensores[i].mostrarLectura();
        }

        sc.close();
    }
}
