import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Empleado {
    private String cedula;
    private String nombre;
    private String apellido;
    private char genero;
    private double salario;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    // Constructor
    public Empleado() {
        ingresarDatos();
    }

    // Metodo para ingresar datos del empleado
    public void ingresarDatos() {
        try {
            cedula = JOptionPane.showInputDialog("Ingrese la cedula del empleado:");
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
            apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado:");

            String generoStr = JOptionPane.showInputDialog("Ingrese el genero (M/F):");
            genero = generoStr.toUpperCase().charAt(0);

            String salarioStr = JOptionPane.showInputDialog("Ingrese el salario del empleado:");
            salario = Double.parseDouble(salarioStr);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String fechaNacStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/MM/yyyy):");
            fechaNacimiento = LocalDate.parse(fechaNacStr, formatter);

            String fechaIngStr = JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/MM/yyyy):");
            fechaIngreso = LocalDate.parse(fechaIngStr, formatter);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Formato de fecha inválido. Use dd/MM/yyyy",
                    "Error de entrada",
                    JOptionPane.ERROR_MESSAGE);
            throw e;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al ingresar los datos: " + e.getMessage(),
                    "Error de entrada",
                    JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    // Metodo para modificar salario
    public void modificarSalario() {
        try {
            String nuevoSalarioStr = JOptionPane.showInputDialog(
                    "Salario actual: $" + String.format("%.2f", salario) +
                            "\nIngrese el nuevo salario:");
            double nuevoSalario = Double.parseDouble(nuevoSalarioStr);

            if (nuevoSalario <= 0) {
                throw new IllegalArgumentException("El salario debe ser mayor que 0");
            }

            salario = nuevoSalario;
            JOptionPane.showMessageDialog(null,
                    "Salario modificado exitosamente",
                    "Exito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Ingrese un valor numerico valido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodo para calcular edad
    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Metodo para calcular años de antigüedad
    private double calcularAntiguedad() {
        double años = Period.between(fechaIngreso, LocalDate.now()).getYears();
        double meses = Period.between(fechaIngreso, LocalDate.now()).getMonths() / 12.0;
        return años + meses;
    }

    // Metodo para calcular prestaciones
    public double calcularPrestaciones() {
        return (calcularAntiguedad() * salario) / 12;
    }

    // Metodo para mostrar información del empleado
    public void mostrarInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("=== Información del Empleado ===\n\n");
        info.append("Cedula: ").append(cedula).append("\n");
        info.append("Nombre completo: ").append(nombre).append(" ").append(apellido).append("\n");
        info.append("Genero: ").append(genero).append("\n");
        info.append("Salario: $").append(String.format("%.2f", salario)).append("\n");
        info.append("Fecha de nacimiento: ").append(fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        info.append("Fecha de ingreso: ").append(fechaIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        info.append("Edad: ").append(calcularEdad()).append(" años\n");
        info.append("Antigüedad: ").append(String.format("%.1f", calcularAntiguedad())).append(" años\n");
        info.append("Prestaciones: $").append(String.format("%.2f", calcularPrestaciones()));

        JOptionPane.showMessageDialog(null,
                info.toString(),
                "Resumen del Empleado",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

public class SistemaEmpleados {
    public static void main(String[] args) {
        try {
            // Configurar look and feel nativo del sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Continuar con el look and feel por defecto
        }

        Empleado empleado = null;

        while (true) {
            String[] opciones = {
                    "Ingresar nuevo empleado",
                    "Modificar salario",
                    "Calcular edad",
                    "Calcular prestaciones",
                    "Mostrar información",
                    "Salir"
            };

            int seleccion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opcion",
                    "Sistema de Gestión de Empleados",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            try {
                switch (seleccion) {
                    case 0: // Ingresar nuevo empleado
                        empleado = new Empleado();
                        empleado.mostrarInformacion();
                        break;

                    case 1: // Modificar salario
                        if (empleado != null) {
                            empleado.modificarSalario();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Primero debe ingresar un empleado",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 2: // Calcular edad
                        if (empleado != null) {
                            JOptionPane.showMessageDialog(null,
                                    "La edad del empleado es: " + empleado.calcularEdad() + " años",
                                    "Edad del Empleado",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Primero debe ingresar un empleado",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 3: // Calcular prestaciones
                        if (empleado != null) {
                            JOptionPane.showMessageDialog(null,
                                    "Las prestaciones del empleado son: $" +
                                            String.format("%.2f", empleado.calcularPrestaciones()),
                                    "Prestaciones del Empleado",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Primero debe ingresar un empleado",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 4: // Mostrar información
                        if (empleado != null) {
                            empleado.mostrarInformacion();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Primero debe ingresar un empleado",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 5: // Salir
                    case -1: // Si cierra la ventana
                        JOptionPane.showMessageDialog(null,
                                "Gracias por usar el sistema",
                                "Fin del Programa",
                                JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}