package parqueadero;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n--- SISTEMA DE PARQUEADERO ---");
            System.out.println("1. Ingresar vehiculo");
            System.out.println("2. Retirar vehiculo");
            System.out.println("3. Mostrar estado del parqueadero");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion:");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la placa del vehiculo:");
                    String placaIngreso = leer.nextLine();

                    parqueadero.ingresarVehiculo(placaIngreso);
                    break;

                case 2:
                    System.out.println("Ingrese la placa del vehiculo que desea retirar:");
                    String placaSalida = leer.nextLine();

                    parqueadero.retirarVehiculo(placaSalida);
                    break;

                case 3:
                    parqueadero.mostrarEstado();
                    break;

                case 4:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

        leer.close();
    }
}
