import java.util.ArrayList;
import java.util.List;

public class SistemaAtencionMedico {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<ServicioMedico> serviciosMedicos;
	
	static final double EDAD_ADULTO_MAYOR = 65;
	static final double DESCUENTO_ADULTO_MAYOR = 0.25;

    public SistemaAtencionMedico() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.serviciosMedicos = new ArrayList<>();
    }
	
	public getPacientes(){
		return pacientes;
	}
	
	public getMedicos(){
		return medicos;
	}
	
	public getServiciosMedicos(){
		return serviciosMedicos;
	}

    public void agregarPaciente(Paciente paciente) {
        getPacientes().add(paciente);
    }

    public void agregarMedico(Medico medico) {
        getMedicos().add(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        getServiciosMedicos().add(servicioMedico);
    }

    public void agendarConsulta(Paciente paciente, Consulta consulta){
        double costoConsulta = calcularValorFinalConsulta(consulta,paciente);
        System.out.println("Se han cobrado "+ costoConsulta+ " dolares de su tarjeta de credito");
        paciente.historialMedico.getConsultas().add(consulta); //Hacer esto es incorrecto
    }

    public double calcularValorFinalConsulta(Consulta consulta, Paciente paciente){
        double valorARestar = 0;
        if(paciente.getEdad()>=EDAD_ADULTO_MAYOR){ 
            valorARestar = consulta.getServicioMedico().getCosto() * DESCUENTO_ADULTO_MAYOR; //0.25 es el descuento para adultos mayores
        }
        return consulta.getServicioMedico().getCosto() - valorARestar;
    }
    public Object obtenerDesdeLista(String nombre, String tipo) {
        List lista;
        if(tipo.equals("Paciente")){
            lista = getPacientes();
        } else if (tipo.equals("Medico")) {
            lista = getMedicos();
        } else {
            lista = getServiciosMedicos();
        }
        for (Object elemento : lista) {
            if (elemento instanceof Paciente && ((Paciente) elemento).getNombre().equals(nombre)) {
                return elemento;
            } else if (elemento instanceof ServicioMedico && ((ServicioMedico) elemento).getNombre().equals(nombre)) {
                return elemento;
            } else if (elemento instanceof Medico && ((Medico) elemento).getNombre().equals(nombre)) {
                return elemento;
            }
        }
        return null;
    }

}
