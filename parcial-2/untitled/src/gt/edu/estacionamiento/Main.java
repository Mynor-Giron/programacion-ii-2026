package gt.edu.estacionamiento;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        HashSet<String> placasRegistradas = new HashSet<>();
        HashMap<String, Double> recaudacionPorTipo = new HashMap<>();

        recaudacionPorTipo.put("Automóvil", 0.0);
        recaudacionPorTipo.put("Motocicleta", 0.0);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE ESTACIONAMIENTO ===");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar todos los vehículos registrados");
            System.out.println("3. Buscar un vehículo por placa");
            System.out.println("4. Mostrar el vehículo con mayor costo");
            System.out.println("5. Mostrar el total general recaudado");
            System.out.println("6. Mostrar total recaudado por tipo de vehículo");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción (1-7): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- REGISTRAR VEHÍCULO ---");
                        System.out.print("Seleccione tipo (1. Automóvil / 2. Motocicleta): ");
                        int tipoSel = scanner.nextInt();
                        scanner.nextLine();

                        if (tipoSel != 1 && tipoSel != 2) {
                            System.out.println("Error: Tipo de vehículo inválido.");
                            break;
                        }

                        System.out.print("Ingrese la placa: ");
                        String placa = scanner.nextLine().trim().toUpperCase();
                        if (placa.isEmpty()) {
                            System.out.println("Error: La placa no puede estar vacía.");
                            break;
                        }

                        if (placasRegistradas.contains(placa)) {
                            System.out.println("Error: La placa '" + placa + "' ya existe en el sistema.");
                            break;
                        }

                        System.out.print("Ingrese el nombre del propietario: ");
                        String propietario = scanner.nextLine().trim();
                        if (propietario.isEmpty()) {
                            System.out.println("Error: El propietario no puede estar vacío.");
                            break;
                        }

                        System.out.print("Ingrese la hora de ingreso (ej. 08:30 AM): ");
                        String horaIngreso = scanner.nextLine().trim();

                        System.out.print("Ingrese la cantidad de horas utilizadas: ");
                        int horas = scanner.nextInt();
                        scanner.nextLine();

                        if (horas <= 0) {
                            System.out.println("Error: Las horas deben ser mayores que cero.");
                            break;
                        }

                        Vehiculo v = (tipoSel == 1) ?
                                new Automovil(placa, propietario, horaIngreso, horas) :
                                new Motocicleta(placa, propietario, horaIngreso, horas);

                        listaVehiculos.add(v);
                        placasRegistradas.add(placa);

                        double acumulado = recaudacionPorTipo.get(v.getTipo());
                        recaudacionPorTipo.put(v.getTipo(), acumulado + v.calcularCosto());

                        System.out.println("¡Vehículo registrado con éxito!");
                        break;

                    case 2:
                        System.out.println("\n--- VEHÍCULOS REGISTRADOS ---");
                        if (listaVehiculos.isEmpty()) {
                            System.out.println("No hay vehículos registrados.");
                        } else {
                            for (Vehiculo veh : listaVehiculos) {
                                veh.mostrarInformacion();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n--- BUSCAR VEHÍCULO POR PLACA ---");
                        System.out.print("Ingrese la placa a buscar: ");
                        String placaBuscar = scanner.nextLine().trim().toUpperCase();
                        boolean encontrado = false;
                        for (Vehiculo veh : listaVehiculos) {
                            if (veh.getPlaca().equalsIgnoreCase(placaBuscar)) {
                                veh.mostrarInformacion();
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) System.out.println("No se encontró la placa.");
                        break;

                    case 4:
                        System.out.println("\n--- VEHÍCULO CON MAYOR COSTO ---");
                        if (listaVehiculos.isEmpty()) {
                            System.out.println("No hay vehículos registrados.");
                        } else {
                            Vehiculo mayor = listaVehiculos.get(0);
                            for (Vehiculo veh : listaVehiculos) {
                                if (veh.calcularCosto() > mayor.calcularCosto()) {
                                    mayor = veh;
                                }
                            }
                            mayor.mostrarInformacion();
                        }
                        break;

                    case 5:
                        System.out.println("\n--- TOTAL GENERAL RECAUDADO ---");
                        double total = 0;
                        for (Vehiculo veh : listaVehiculos) {
                            total += veh.calcularCosto();
                        }
                        System.out.printf("Total General: Q%.2f%n", total);
                        break;

                    case 6:
                        System.out.println("\n--- TOTAL RECAUDADO POR TIPO ---");
                        System.out.printf("Automóvil: Q%.2f%n", recaudacionPorTipo.get("Automóvil"));
                        System.out.printf("Motocicleta: Q%.2f%n", recaudacionPorTipo.get("Motocicleta"));
                        break;

                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ha ingresado un valor incompatible con el tipo esperado.");
                scanner.nextLine();
            } finally {
                System.out.println("[AUDITORÍA] Operación realizada.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
