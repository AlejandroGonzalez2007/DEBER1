package Ejercicio2;
import java.util.Scanner;
public class MainSistemaSeguridad {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            final int CAPACIDAD = 4;
            SistemaSeguridad[] sistemas = new SistemaSeguridad[CAPACIDAD];
            int cantidadActual = 0;

            int opcion;
            do {
                System.out.println("\n--- MENÚ SEGURIDAD (Disponibles: " + (CAPACIDAD - cantidadActual) + ") ---");
                System.out.println("1. Registrar sistema (uno por uno mientras haya espacio)");
                System.out.println("2. Registrar intento fallido (por índice)");
                System.out.println("3. Reiniciar contador (por índice)");
                System.out.println("4. Consultar estado (por índice)");
                System.out.println("5. Salir");
                System.out.print("Opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        if (cantidadActual < sistemas.length) {
                            System.out.print("Nombre del sistema: ");
                            String nom = sc.nextLine();
                            sistemas[cantidadActual] = new SistemaSeguridad(nom);
                            System.out.println("Guardado en índice [" + cantidadActual + "].");
                            cantidadActual++;
                        } else {
                            System.out.println("ERROR: No hay más espacio en el arreglo.");
                        }
                        break;

                    case 2:
                        System.out.print("Índice del sistema (0 a " + (cantidadActual - 1) + "): ");
                        int iFallo = Integer.parseInt(sc.nextLine());
                        if (iFallo >= 0 && iFallo < cantidadActual) {
                            sistemas[iFallo].registrarIntentoFallido();
                            System.out.println("Falla sumada a " + sistemas[iFallo].getNombreSistema());
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;

                    case 3:
                        System.out.print("Índice del sistema (0 a " + (cantidadActual - 1) + "): ");
                        int iReset = Integer.parseInt(sc.nextLine());
                        if (iReset >= 0 && iReset < cantidadActual) {
                            sistemas[iReset].reiniciarContador();
                            System.out.println("Contador reiniciado para " + sistemas[iReset].getNombreSistema());
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;

                    case 4:
                        System.out.print("Índice del sistema (0 a " + (cantidadActual - 1) + "): ");
                        int iVer = Integer.parseInt(sc.nextLine());
                        if (iVer >= 0 && iVer < cantidadActual) {
                            sistemas[iVer].mostrarEstado();
                        } else {
                            System.out.println("Índice no válido.");
                        }
                        break;
                }
            } while (opcion != 5);
        }
}
