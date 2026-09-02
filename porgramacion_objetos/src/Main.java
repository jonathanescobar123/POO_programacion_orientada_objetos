import java.util.Scanner;

public class Main {

    // Recibe un nombre, retorna la inicial y cuenta sus repeticiones
    public static char obtenerInicial(String nombre) {

        char inicial = Character.toLowerCase(nombre.charAt(0));
        int cantidad = 0;

        for (int i = 0; i < nombre.length(); i++) {
            char letra = Character.toLowerCase(nombre.charAt(i));

            if (letra == inicial) {
                cantidad++;
            }
        }

        System.out.println("La inicial es: " + inicial);
        System.out.println("La letra se repite: " + cantidad + " veces");

        return inicial;
    }


    // Evalúa si el estudiante promociona
    public static String evaluarPromocion(double asistencia, boolean trabajos, double nota) {

        if (asistencia < 80) {
            return "No promociona porque tiene menos del 80% de asistencia.";
        }

        if (!trabajos) {
            return "No promociona porque no presentó los trabajos.";
        }

        if (nota < 6) {
            return "No promociona porque obtuvo una nota menor a 6.";
        }

        return "¡Felicitaciones! El estudiante promociona.";
    }


    // Cuenta las letras y vocales de cualquier texto
    public static void contarLetrasVocales(String texto) {

        int letras = 0;
        int vocales = 0;

        for (int i = 0; i < texto.length(); i++) {

            char caracter = Character.toLowerCase(texto.charAt(i));

            if (Character.isLetter(caracter)) {
                letras++;
            }

            if (caracter == 'a' || caracter == 'e' ||
                    caracter == 'i' || caracter == 'o' ||
                    caracter == 'u') {
                vocales++;
            }
        }

        System.out.println("Cantidad de letras: " + letras);
        System.out.println("Cantidad de vocales: " + vocales);
    }


    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Ejercicio 1
        System.out.print("Ingrese un nombre: ");
        String nombre = teclado.nextLine();

        obtenerInicial(nombre);


        // Ejercicio 2
        System.out.println("\n--- PROMOCIÓN ---");

        System.out.print("Ingrese el porcentaje de asistencia: ");
        double asistencia = teclado.nextDouble();

        System.out.print("¿Presentó los trabajos? (true/false): ");
        boolean trabajos = teclado.nextBoolean();

        System.out.print("Ingrese la nota del examen final: ");
        double nota = teclado.nextDouble();

        String mensaje = evaluarPromocion(asistencia, trabajos, nota);

        System.out.println(mensaje);


        // Ejercicio 3
        teclado.nextLine();

        System.out.println("\n--- LETRAS Y VOCALES ---");

        System.out.print("Ingrese un texto: ");
        String texto = teclado.nextLine();

        contarLetrasVocales(texto);

        teclado.close();
    }
}