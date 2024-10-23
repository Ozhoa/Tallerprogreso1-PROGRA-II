import javax.swing.JOptionPane;

class Vehiculo {
    private String numeroMotor;
    private int numeroVentanas;
    private int numeroPuertas;
    private String marca;
    private String modelo;
    private double kilometrajeInicial;
    private double kilometrajeFinal;

    // Constructor
    public Vehiculo() {
        obtenerDatos();
        mostrarInformacion();
    }

    // Método para obtener los datos del vehículo
    private void obtenerDatos() {
        try {
            numeroMotor = JOptionPane.showInputDialog("Ingrese el número de motor:");

            String ventanas = JOptionPane.showInputDialog("Ingrese el número de ventanas:");
            numeroVentanas = Integer.parseInt(ventanas);

            String puertas = JOptionPane.showInputDialog("Ingrese la cantidad de puertas:");
            numeroPuertas = Integer.parseInt(puertas);

            marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
            modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");

            String kmInicial = JOptionPane.showInputDialog("Ingrese el kilometraje inicial:");
            kilometrajeInicial = Double.parseDouble(kmInicial);

            String kmFinal = JOptionPane.showInputDialog("Ingrese el kilometraje final:");
            kilometrajeFinal = Double.parseDouble(kmFinal);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Por favor ingrese números válidos para los campos numéricos.",
                    "Error de entrada",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    // Método para calcular kilómetros recorridos
    private double calcularKilometrosRecorridos() {
        return kilometrajeFinal - kilometrajeInicial;
    }

    // Método para mostrar la información
    private void mostrarInformacion() {
        String informacion = "=== Información del Vehículo ===\n\n" +
                "Número de Motor: " + numeroMotor + "\n" +
                "Número de Ventanas: " + numeroVentanas + "\n" +
                "Número de Puertas: " + numeroPuertas + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Kilometraje Inicial: " + kilometrajeInicial + " km\n" +
                "Kilometraje Final: " + kilometrajeFinal + " km\n" +
                "\nKilómetros Recorridos: " + calcularKilometrosRecorridos() + " km";

        JOptionPane.showMessageDialog(null,
                informacion,
                "Resumen del Vehículo",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

public class ControlVehiculo {
    public static void main(String[] args) {
        try {
            // Configurar look and feel nativo del sistema
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si hay error, continuar con el look and feel por defecto
        }

        // Mostrar mensaje de bienvenida
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Sistema de Control de Kilometraje",
                "Sistema de Control",
                JOptionPane.INFORMATION_MESSAGE);

        // Crear nueva instancia de Vehiculo
        new Vehiculo();

        // Mensaje de finalización
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Desea registrar otro vehículo?",
                "Continuar",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            main(args); // Reiniciar el programa
        } else {
            JOptionPane.showMessageDialog(null,
                    "Gracias por usar el sistema",
                    "Fin del Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}