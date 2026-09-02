import java.util.Scanner;

public class ejer3 {

    // Función que verifica si las faltas están dentro del límite
    public static boolean puedeRendir(int faltas) {
        int horasTotales = 150;
        double horasPorClase = 3.20;

        double horasFaltadas = faltas * horasPorClase;
        double porcentajeFaltas = (horasFaltadas / horasTotales) * 100;

        return porcentajeFaltas <= 25;
    }

    // Segunda función: solicita los datos y utiliza la primera función
    public static void consultarDatos(Scanner scanner) {

        System.out.print("Ingrese la cantidad de faltas: ");
        int faltas = scanner.nextInt();

        boolean dentroDelLimite = puedeRendir(faltas);

        System.out.print("¿Presentó la documentación para rendir? (si/no): ");
        String documentacion = scanner.next();

        if (dentroDelLimite && documentacion.equalsIgnoreCase("si")) {
            System.out.println("Puede rendir el examen.");
        } else {
            System.out.println("No puede rendir el examen.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el texto del primer ejercicio: ");
        String texto = scanner.nextLine();

        System.out.println("Ejercicio ingresado: " + texto);

        consultarDatos(scanner);

        scanner.close();
    }
}