public class ejer4 {

    public static void main(String[] args) {

        int resultado = 1;

        for (int i = 1; i <= 12; i++) {

            if (i % 2 == 0) {
                resultado = resultado * i;
            }
        }

        System.out.println("El resultado es: " + resultado);
    }
}