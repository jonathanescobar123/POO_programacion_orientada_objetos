
public class Entrenador {

    private String nombreCompleto;
    private final String dni;
    private String telefono;
    private String especialidad;

    public Entrenador(String nombreCompleto, String dni,
                      String telefono, String especialidad) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return nombreCompleto + " - DNI: " + dni
                + " - Especialidad: " + especialidad;
    }
}
