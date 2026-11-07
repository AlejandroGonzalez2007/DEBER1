package Ejercicio4;

import java.util.Scanner;

public class MainMotor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CAPACIDAD = 4;
        Motor[] motores = new Motor[CAPACIDAD];
        int totalMotores = 0; // Control de elementos agregados uno a uno

        int opcion;
        do {
            System.out.println("\n=======================================================");
            System.out.println("   CONTROL DE MOTORES ELECTRICOS (Espacios libres: " + (CAPACIDAD - totalMotores) + ")");
            System.out.println("=======================================================");
            System.out.println("1. Registrar nuevo motor (uno a uno mientras haya cupo)");
            System.out.println("2. Encender un motor (por indice)");
            System.out.println("3. Ajustar velocidad de un motor (por indice)");
            System.out.println("4. Apagar un motor (por indice)");
            System.out.println("5. Mostrar estado de un motor (por indice)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Modalidad B: Ingreso uno a uno validando espacio en el arreglo
                    if (totalMotores < motores.length) {
                        motores[totalMotores] = new Motor();
                        System.out.println(">> Motor registrado exitosamente en el indice [" + totalMotores + "].");
                        totalMotores++;
                    } else {
                        System.out.println(">> ALERTA: No hay espacio disponible en el arreglo (capacidad maxima alcanzada).");
                    }
                    break;

                case 2:
                    if (totalMotores == 0) {
                        System.out.println(">> No hay motores registrados todavia.");
                        break;
                    }
                    System.out.print("Ingrese el indice del motor a encender (0 a " + (totalMotores - 1) + "): ");
                    int idxEncender = Integer.parseInt(sc.nextLine());
                    if (idxEncender >= 0 && idxEncender < totalMotores) {
                        motores[idxEncender].encender();
                    } else {
                        System.out.println(">> Indice fuera de rango o elemento no existente.");
                    }
                    break;

                case 3:
                    if (totalMotores == 0) {
                        System.out.println(">> No hay motores registrados todavia.");
                        break;
                    }
                    System.out.print("Ingrese el indice del motor a ajustar (0 a " + (totalMotores - 1) + "): ");
                    int idxVel = Integer.parseInt(sc.nextLine());
                    if (idxVel >= 0 && idxVel < totalMotores) {
                        System.out.print("Ingrese la nueva velocidad (0 a 100): ");
                        int vel = Integer.parseInt(sc.nextLine());
                        motores[idxVel].ajustarVelocidad(vel);
                    } else {
                        System.out.println(">> Indice fuera de rango o elemento no existente.");
                    }
                    break;

                case 4:
                    if (totalMotores == 0) {
                        System.out.println(">> No hay motores registrados todavia.");
                        break;
                    }
                    System.out.print("Ingrese el indice del motor a apagar (0 a " + (totalMotores - 1) + "): ");
                    int idxApagar = Integer.parseInt(sc.nextLine());
                    if (idxApagar >= 0 && idxApagar < totalMotores) {
                        motores[idxApagar].apagar();
                    } else {
                        System.out.println(">> Indice fuera de rango o elemento no existente.");
                    }
                    break;

                case 5:
                    if (totalMotores == 0) {
                        System.out.println(">> No hay motores registrados todavia.");
                        break;
                    }
                    System.out.print("Ingrese el indice del motor a consultar (0 a " + (totalMotores - 1) + "): ");
                    int idxEstado = Integer.parseInt(sc.nextLine());
                    if (idxEstado >= 0 && idxEstado < totalMotores) {
                        System.out.print("Motor [" + idxEstado + "] -> ");
                        motores[idxEstado].mostrarEstado();
                    } else {
                        System.out.println(">> Indice fuera de rango o elemento no existente.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa de control de motores...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}