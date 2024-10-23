import java.util.Scanner;

public class CalculadoraBasica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Calculadora Básica ===");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            char opcion = scanner.next().charAt(0);

            if (opcion == '5') {
                System.out.println("¡Gracias por usar la calculadora!");
                break;
            }

            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();

            switch (opcion) {
                case '1':
                    System.out.println("Resultado: " + sumar(num1, num2));
                    break;
                case '2':
                    System.out.println("Resultado: " + restar(num1, num2));
                    break;
                case '3':
                    System.out.println("Resultado: " + multiplicar(num1, num2));
                    break;
                case '4':
                    if (num2 != 0) {
                        System.out.println("Resultado: " + dividir(num1, num2));
                    } else {
                        System.out.println("Error: División por cero no permitida.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }

    private static double sumar(double a, double b) {
        return a + b;
    }

    private static double restar(double a, double b) {
        return a - b;
    }

    private static double multiplicar(double a, double b) {
        return a * b;
    }

    private static double dividir(double a, double b) {
        return a / b;
    }
}
