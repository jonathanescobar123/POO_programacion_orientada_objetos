
import java.util.ArrayList;
import java.util.List;

public class Sede {

    private final String codigo;
    private final List<Entrenador> entrenadores;
    private final List<Actividad> actividades;

    public Sede(String codigo) {
        this.codigo = codigo;
        this.entrenadores = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }

    public boolean agregarActividad(Actividad actividad) {
        for (Actividad existente : actividades) {
            if (existente.getCodigo().equals(actividad.getCodigo())) {
                return false;
            }
        }

        actividades.add(actividad);
        return true;
    }

    public boolean eliminarActividad(String codigoActividad) {
        for (Actividad actividad : actividades) {
            if (actividad.getCodigo().equals(codigoActividad)) {
                actividades.remove(actividad);
                return true;
            }
        }

        return false;
    }

    public boolean incorporarEntrenador(Entrenador entrenador) {
        for (Entrenador existente : entrenadores) {
            if (existente.getDni().equals(entrenador.getDni())) {
                return false;
            }
        }

        entrenadores.add(entrenador);
        return true;
    }

    public boolean desvincularEntrenador(String dni) {
        // No se desvincula si tiene actividades a cargo.
        for (Actividad actividad : actividades) {
            Entrenador responsable = actividad.getResponsable();

            if (responsable != null && responsable.getDni().equals(dni)) {
                return false;
            }
        }

        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getDni().equals(dni)) {
                entrenadores.remove(entrenador);
                return true;
            }
        }

        return false;
    }

    public void consultarActividades() {
        System.out.println("Actividades de la sede " + codigo + ":");

        for (Actividad actividad : actividades) {
            System.out.println(
                    actividad.getNombre() + " - " + actividad.getHorario());
        }
    }

    public void mostrarEntrenadores() {
        System.out.println("Entrenadores de la sede " + codigo + ":");

        for (Entrenador entrenador : entrenadores) {
            System.out.println(entrenador);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Actividad> getActividades() {
        return new ArrayList<>(actividades);
    }

    public List<Entrenador> getEntrenadores() {
        return new ArrayList<>(entrenadores);
    }
}
