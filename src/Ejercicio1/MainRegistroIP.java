package Ejercicio1;

import java.util.Scanner;

public class MainRegistroIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistroIP[] bitacora = new RegistroIP[3];

        System.out.println("=== 1. INGRESO DE DATOS (ARREGLO COMPLETO) ===");
        for (int i = 0; i < bitacora.length; i++) {
            System.out.println("\nRegistro [" + i + "]:");
            System.out.print("Dirección IP: ");
            String ip = sc.nextLine();
            System.out.print("Hora de acceso: ");
            String hora = sc.nextLine();
            System.out.print("¿Acceso permitido? (true/false): ");
            boolean permitida = Boolean.parseBoolean(sc.nextLine());

            bitacora[i] = new RegistroIP(ip, hora, permitida);
        }

        System.out.println("\n=== 2. LISTADO COMPLETO (USANDO .length) ===");
        for (int i = 0; i < bitacora.length; i++) {
            System.out.print("[" + i + "] ");
            bitacora[i].mostrarEstado();
        }

        System.out.println("\n=== 3. AUDITORÍA GENERAL DE ACCESOS DENEGADOS ===");
        for (int i = 0; i < bitacora.length; i++) {
            if (!bitacora[i].isPermitida()) {
                System.out.println("Alerta de seguridad en pos [" + i + "] -> IP: " + bitacora[i].getDireccionIP());
            }
        }
    }
}
