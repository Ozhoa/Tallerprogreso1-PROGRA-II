import javax.swing.JOptionPane;

class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean tieneIva;

    // Constructor
    public Producto() {
        ingresarDatos();
        mostrarResultados();
    }

    // Metodo para ingresar datos del producto
    private void ingresarDatos() {
        try {
            codigo = JOptionPane.showInputDialog("Ingrese el codigo del producto:");
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
            descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto:");

            String precioStr = JOptionPane.showInputDialog("Ingrese el precio del producto:");
            precio = Double.parseDouble(precioStr);

            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿El producto tiene IVA?",
                    "Configuracion IVA",
                    JOptionPane.YES_NO_OPTION);

            tieneIva = (respuesta == JOptionPane.YES_OPTION);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Por favor ingrese un precio valido.",
                    "Error de entrada",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    // Metodo para calcular el porcentaje de IVA
    private double calcularPorcentajeIva() {
        if (!tieneIva) {
            return 0.0;
        }

        if (precio <= 500) {
            return 0.12; // 12%
        } else if (precio <= 1500) {
            return 0.14; // 14%
        } else {
            return 0.15; // 15%
        }
    }

    // Metodo para calcular el valor del IVA
    private double calcularValorIva() {
        return precio * calcularPorcentajeIva();
    }

    // Metodo para calcular el precio final
    private double calcularPrecioFinal() {
        return precio + calcularValorIva();
    }

    // Metodo para mostrar los resultados
    private void mostrarResultados() {
        StringBuilder info = new StringBuilder();
        info.append("=== Información del Producto ===\n\n");
        info.append("Código: ").append(codigo).append("\n");
        info.append("Nombre: ").append(nombre).append("\n");
        info.append("Descripción: ").append(descripcion).append("\n");
        info.append("Precio Base: $").append(String.format("%.2f", precio)).append("\n");
        info.append("Tiene IVA: ").append(tieneIva ? "Sí" : "No").append("\n");

        if (tieneIva) {
            info.append("Porcentaje IVA: ").append(String.format("%.1f", calcularPorcentajeIva() * 100)).append("%\n");
            info.append("Valor IVA: $").append(String.format("%.2f", calcularValorIva())).append("\n");
        }

        info.append("\nPrecio Final: $").append(String.format("%.2f", calcularPrecioFinal()));

        JOptionPane.showMessageDialog(null,
                info.toString(),
                "Resumen del Producto",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

public class CalculadoraIVA {
    public static void main(String[] args) {
        try {
            // Configurar look and feel nativo del sistema
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si hay error, continuar con el look and feel por defecto
        }

        // Mensaje de bienvenida
        JOptionPane.showMessageDialog(null,
                "Bienvenido al Sistema de Cálculo de IVA",
                "Sistema de IVA",
                JOptionPane.INFORMATION_MESSAGE);

        while (true) {
            // Crear nuevo producto
            new Producto();

            // Preguntar si desea calcular otro producto
            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Desea calcular otro producto?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION);

            if (opcion != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "Gracias por usar el sistema",
                        "Fin del Programa",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }
}
