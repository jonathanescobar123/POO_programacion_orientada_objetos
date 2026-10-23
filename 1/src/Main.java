
public class Main {

    public static void main(String[] args) {

        // 1. Crear la sede.
        Sede sede = new Sede("SEDE01");

        // 2. Crear entrenadores.
        Entrenador entrenador1 = new Entrenador(
                "Juan Pérez", "30111222",
                "1122334455", "Musculación");

        Entrenador entrenador2 = new Entrenador(
                "Ana Gómez", "30999888",
                "1166778899", "Yoga");

        // 3. Incorporar entrenadores a la sede.
        System.out.println("Incorporar entrenador 1: "
                + sede.incorporarEntrenador(entrenador1));

        System.out.println("Incorporar entrenador 2: "
                + sede.incorporarEntrenador(entrenador2));

        // 4. Crear actividades.
        Actividad actividad1 = new Actividad(
                "ACT01", "Musculación", "08:00",
                4, 15000, entrenador1);

        Actividad actividad2 = new Actividad(
                "ACT02", "Yoga", "10:00",
                6, 12000, entrenador2);

        // 5. Agregar actividades a la sede.
        System.out.println("Agregar actividad 1: "
                + sede.agregarActividad(actividad1));

        System.out.println("Agregar actividad 2: "
                + sede.agregarActividad(actividad2));

        // 6. Consultar actividades.
        sede.consultarActividades();

        // 7. Verificar habilitación.
        System.out.println("\n¿Musculación está habilitada? "
                + actividad1.isHabilitada());

        // 8. Alta de un inscripto.
        actividad1.altaInscripto();

        System.out.println("Inscriptos en Musculación: "
                + actividad1.getCantidadInscriptos());

        System.out.println("¿Está habilitada ahora? "
                + actividad1.isHabilitada());

        // 9. Baja de un inscripto.
        actividad1.bajaInscripto();

        System.out.println("Inscriptos después de la baja: "
                + actividad1.getCantidadInscriptos());

        System.out.println("¿Está habilitada ahora? "
                + actividad1.isHabilitada());

        // 10. Actualizar directamente la cantidad de inscriptos.
        actividad1.actualizarCantidadInscriptos(8);

        System.out.println("Cantidad actualizada: "
                + actividad1.getCantidadInscriptos());

        // 11. Modificar la cuota mensual.
        actividad1.setCuotaMensual(18000);

        System.out.println("Nueva cuota: $"
                + actividad1.getCuotaMensual());

        // 12. Calcular la recaudación mensual.
        System.out.println("Recaudación de Musculación: $"
                + actividad1.calcularRecaudacionMensual());

        System.out.println("Recaudación de Yoga: $"
                + actividad2.calcularRecaudacionMensual());

        // 13. Cambiar el entrenador responsable.
        actividad1.cambiarResponsable(entrenador2);

        System.out.println("Nuevo responsable: "
                + actividad1.getResponsable().getNombreCompleto());


    }