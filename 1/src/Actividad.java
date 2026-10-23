
public class Actividad {

    private final String codigo;
    private final String nombre;
    private final String horario;

    private int cantidadInscriptos;
    private double cuotaMensual;
    private boolean habilitada;
    private Entrenador responsable;

    // Constante compartida por todas las actividades.
    public static final int CUPO_MINIMO = 5;

    // Cupo máximo compartido y modificable.
    private static int cupoMaximo = 30;

    public Actividad(String codigo, String nombre, String horario,
                     int cantidadInscriptos, double cuotaMensual,
                     Entrenador responsable) {

        if (cantidadInscriptos < 0 || cantidadInscriptos > cupoMaximo) {
            throw new IllegalArgumentException(
                    "La cantidad de inscriptos no es válida.");
        }

        if (cuotaMensual < 0) {
            throw new IllegalArgumentException(
                    "La cuota mensual no puede ser negativa.");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.horario = horario;
        this.cantidadInscriptos = cantidadInscriptos;
        this.cuotaMensual = cuotaMensual;
        this.responsable = responsable;

        actualizarHabilitacion();
    }

    private void actualizarHabilitacion() {
        habilitada = cantidadInscriptos >= CUPO_MINIMO;
    }

    // Actualiza directamente el total de inscriptos.
    public boolean actualizarCantidadInscriptos(int cantidad) {
        if (cantidad < 0 || cantidad > cupoMaximo) {
            return false;
        }

        cantidadInscriptos = cantidad;
        actualizarHabilitacion();
        return true;
    }

    // Agrega un inscripto.
    public boolean altaInscripto() {
        if (cantidadInscriptos >= cupoMaximo) {
            return false;
        }

        cantidadInscriptos++;
        actualizarHabilitacion();
        return true;
    }

    // Quita un inscripto.
    public boolean bajaInscripto() {
        if (cantidadInscriptos <= 0) {
            return false;
        }

        cantidadInscriptos--;
        actualizarHabilitacion();
        return true;
    }

    public double calcularRecaudacionMensual() {
        return cantidadInscriptos * cuotaMensual;
    }

    public void cambiarResponsable(Entrenador responsable) {
        this.responsable = responsable;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        if (cuotaMensual < 0) {
            throw new IllegalArgumentException(
                    "La cuota mensual no puede ser negativa.");
        }

        this.cuotaMensual = cuotaMensual;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public Entrenador getResponsable() {
        return responsable;
    }

    public static int getCupoMinimo() {
        return CUPO_MINIMO;
    }

    public static int getCupoMaximo() {
        return cupoMaximo;
    }

    public static boolean setCupoMaximo(int nuevoCupo) {
        if (nuevoCupo < CUPO_MINIMO) {
            return false;
        }

        cupoMaximo = nuevoCupo;
        return true;
    }

    @Override
    public String toString() {
        String nombreResponsable = responsable == null
                ? "Sin responsable"
                : responsable.getNombreCompleto();

        return nombre + " | Horario: " + horario
                + " | Inscriptos: " + cantidadInscriptos
                + " | Habilitada: " + habilitada
                + " | Responsable: " + nombreResponsable;
    }
}
