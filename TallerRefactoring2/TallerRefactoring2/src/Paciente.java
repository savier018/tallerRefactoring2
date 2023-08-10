public class Paciente extends Persona {
    public HistorialMedico historialMedico;
	static final double EDAD_ADULTO_MAYOR = 65;
    public Paciente(String nombre, int edad, String genero, String direccion, String telefono, String correoElectronico) {
        super(nombre, edad, genero, direccion, telefono, correoElectronico);
        this.historialMedico = new HistorialMedico();
    }

    public boolean esAdultoMayor(){
        return super.getEdad()>=EDAD_ADULTO_MAYOR;
    }
}