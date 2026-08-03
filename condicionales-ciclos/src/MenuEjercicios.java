import java.util.Scanner;

/**
 * Clase DesafiosLogicos
 * Programa que presenta un menú con 5 desafíos lógicos utilizando
 * condicionales, ciclos y validaciones.
 *
 * @author [Mynor Adolfo Girón Muralles]
 * @carnet [9941-25-8300]
 * Semana 3 - Condiciones y ciclos
 */
public class MenuEjercicios{

    public static void main(String[] args) {
        // Crear el objeto Scanner para leer datos desde la consola
        Scanner scanner = new Scanner(System.in);

        // Mostrar información del estudiante
        System.out.println("=====================================");
        System.out.println("Estudiante: [Mynor Adolfo Girón Muralles]");
        System.out.println("Carné: [9941-25-8300]");
        System.out.println("Semana 3 — Condiciones y ciclos");
        System.out.println("=====================================\n");

        int opcion; // Variable para almacenar la opción del usuario

        // Ciclo principal del menú (se repite hasta que el usuario elija salir)
        do {
            // Mostrar el menú principal
            System.out.println("========= DESAFÍOS LÓGICOS =========");
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo regresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que la entrada sea un número entero
            while (!scanner.hasNextInt()) {
                System.out.print("Error: Ingrese un número válido: ");
                scanner.next(); // Limpiar entrada incorrecta
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println(); // Línea en blanco para formato

            // Procesar la opción seleccionada usando switch
            switch (opcion) {
                case 1:
                    // Opción 1: Generar una secuencia
                    System.out.println("--- GENERAR UNA SECUENCIA ---");

                    // Solicitar datos al usuario
                    System.out.print("Número inicial: ");
                    int numInicial = scanner.nextInt();

                    System.out.print("Número final: ");
                    int numFinal = scanner.nextInt();

                    System.out.print("Incremento: ");
                    int incremento = scanner.nextInt();

                    // Validar que el incremento sea mayor que cero
                    if (incremento <= 0) {
                        System.out.println("Error: El incremento debe ser mayor que cero.");
                    }
                    // Validar que el número final sea mayor que el inicial
                    else if (numFinal <= numInicial) {
                        System.out.println("Error: El número final debe ser mayor que el inicial.");
                    }
                    // Si los datos son válidos, generar la secuencia
                    else {
                        System.out.print("Resultado: ");
                        // Ciclo for para generar la secuencia
                        for (int i = numInicial; i <= numFinal; i += incremento) {
                            System.out.print(i + " ");
                        }
                        System.out.println(); // Salto de línea
                    }
                    break;

                case 2:
                    // Opción 2: Conteo regresivo
                    System.out.println("--- CONTEO REGRESIVO ---");

                    int numero;
                    // Ciclo while para solicitar un número entre 10 y 50
                    while (true) {
                        System.out.print("Ingrese el número inicial (10-50): ");
                        numero = scanner.nextInt();

                        // Validar que el número esté en el rango permitido
                        if (numero >= 10 && numero <= 50) {
                            break; // Salir del ciclo si es válido
                        } else {
                            System.out.println("Error: El número debe estar entre 10 y 50.");
                        }
                    }

                    // Mostrar el conteo regresivo
                    System.out.print("Resultado: ");
                    int contador = numero;
                    while (contador >= 0) {
                        System.out.print(contador + " ");
                        contador--;
                    }
                    System.out.println("\n¡Despegue!");
                    break;

                case 3:
                    // Opción 3: Analizar números
                    System.out.println("--- ANALIZAR NÚMEROS ---");
                    System.out.println("Ingrese números enteros (0 para finalizar):");

                    int positivos = 0;
                    int negativos = 0;
                    int sumaValida = 0;
                    int ignorados = 0;
                    int numeroIngresado;

                    // Ciclo while para ingresar números hasta que sea 0
                    while (true) {
                        System.out.print("Ingrese un número: ");
                        numeroIngresado = scanner.nextInt();

                        // Si el número es 0, finalizar el ciclo
                        if (numeroIngresado == 0) {
                            break; // Salir del ciclo
                        }

                        // Si el número es múltiplo de 5, ignorarlo
                        if (numeroIngresado % 5 == 0) {
                            System.out.println("El número " + numeroIngresado + " fue ignorado.");
                            ignorados++;
                            continue; // Saltar al siguiente número
                        }

                        // Contar positivos y negativos
                        if (numeroIngresado > 0) {
                            positivos++;
                        } else if (numeroIngresado < 0) {
                            negativos++;
                        }

                        // Acumular la suma de números válidos
                        sumaValida += numeroIngresado;
                    }

                    // Mostrar los resultados
                    System.out.println("\nResultado:");
                    System.out.println("Positivos: " + positivos);
                    System.out.println("Negativos: " + negativos);
                    System.out.println("Suma válida: " + sumaValida);
                    System.out.println("Números ignorados: " + ignorados);
                    break;

                case 4:
                    // Opción 4: Dibujar una pirámide
                    System.out.println("--- DIBUJAR UNA PIRÁMIDE ---");

                    int altura;
                    // Ciclo para validar que la altura esté entre 3 y 10
                    while (true) {
                        System.out.print("Ingrese la altura (3-10): ");
                        altura = scanner.nextInt();

                        if (altura >= 3 && altura <= 10) {
                            break; // Altura válida
                        } else {
                            System.out.println("Error: La altura debe estar entre 3 y 10.");
                        }
                    }

                    // Ciclos for anidados para dibujar la pirámide
                    for (int i = 1; i <= altura; i++) {
                        // Imprimir espacios en blanco (para centrar la pirámide)
                        for (int j = 1; j <= altura - i; j++) {
                            System.out.print(" ");
                        }
                        // Imprimir asteriscos (2*i - 1 para que sea impar)
                        for (int k = 1; k <= (2 * i - 1); k++) {
                            System.out.print("*");
                        }
                        System.out.println(); // Salto de línea después de cada fila
                    }
                    break;

                case 5:
                    // Opción 5: Validar palabra secreta
                    System.out.println("--- VALIDAR PALABRA SECRETA ---");

                    String palabraIngresada;
                    // Ciclo do-while para solicitar la palabra hasta que sea correcta
                    do {
                        System.out.print("Ingrese la palabra secreta: ");
                        palabraIngresada = scanner.nextLine();

                        // Limpiar espacios al inicio y al final, y comparar ignorando mayúsculas
                        if (palabraIngresada.trim().equalsIgnoreCase("Guatemala")) {
                            System.out.println("Palabra correcta.");
                            break; // Salir del ciclo
                        } else {
                            System.out.println("Palabra incorrecta. Intente nuevamente.");
                        }
                    } while (true);
                    break;

                case 6:
                    // Opción 6: Salir
                    System.out.println("Programa finalizado correctamente.");
                    break;

                default:
                    // Opción no válida
                    System.out.println("Error: Opción no válida. Seleccione una opción del 1 al 6.");
                    break;
            }

            System.out.println(); // Línea en blanco para separar iteraciones

        } while (opcion != 6); // Repetir mientras la opción no sea 6

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}