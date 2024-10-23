class Triangulo {
    double base;
    double altura;
    double lado1;
    double lado2;
    double lado3;

    double calcularArea() {
        return (base * altura) / 2;
    }

    double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
}

class Cuadrado {
    double lado;

    double calcularArea() {
        return lado * lado;
    }

    double calcularPerimetro() {
        return 4 * lado;
    }
}

class Rectangulo {
    double largo;
    double ancho;

    double calcularArea() {
        return largo * ancho;
    }

    double calcularPerimetro() {
        return 2 * (largo + ancho);
    }
}

public class CalculadoraFiguras {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\n=== Calculadora de Figuras Geométricas ===");
                System.out.println("1. Triángulo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Rectángulo");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                String entrada = System.console().readLine();
                if (entrada == null || entrada.isEmpty()) {
                    System.out.println("Entrada no válida");
                    continue;
                }

                char opcion = entrada.charAt(0);

                switch (opcion) {
                    case '1':
                        calcularTriangulo();
                        break;
                    case '2':
                        calcularCuadrado();
                        break;
                    case '3':
                        calcularRectangulo();
                        break;
                    case '4':
                        System.out.println("¡Gracias por usar la calculadora!");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void calcularTriangulo() {
        try {
            Triangulo triangulo = new Triangulo();

            System.out.println("\n=== Cálculos para Triángulo ===");
            System.out.print("Ingrese la base: ");
            triangulo.base = Double.parseDouble(System.console().readLine());

            System.out.print("Ingrese la altura: ");
            triangulo.altura = Double.parseDouble(System.console().readLine());

            System.out.print("Ingrese el lado 1: ");
            triangulo.lado1 = Double.parseDouble(System.console().readLine());

            System.out.print("Ingrese el lado 2: ");
            triangulo.lado2 = Double.parseDouble(System.console().readLine());

            System.out.print("Ingrese el lado 3: ");
            triangulo.lado3 = Double.parseDouble(System.console().readLine());

            System.out.println("\nResultados:");
            System.out.println("Área: " + triangulo.calcularArea());
            System.out.println("Perímetro: " + triangulo.calcularPerimetro());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese solo números válidos");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void calcularCuadrado() {
        try {
            Cuadrado cuadrado = new Cuadrado();

            System.out.println("\n=== Cálculos para Cuadrado ===");
            System.out.print("Ingrese el lado: ");
            cuadrado.lado = Double.parseDouble(System.console().readLine());

            System.out.println("\nResultados:");
            System.out.println("Área: " + cuadrado.calcularArea());
            System.out.println("Perímetro: " + cuadrado.calcularPerimetro());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese solo números válidos");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void calcularRectangulo() {
        try {
            Rectangulo rectangulo = new Rectangulo();

            System.out.println("\n=== Cálculos para Rectángulo ===");
            System.out.print("Ingrese el largo: ");
            rectangulo.largo = Double.parseDouble(System.console().readLine());

            System.out.print("Ingrese el ancho: ");
            rectangulo.ancho = Double.parseDouble(System.console().readLine());

            System.out.println("\nResultados:");
            System.out.println("Área: " + rectangulo.calcularArea());
            System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese solo números válidos");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}