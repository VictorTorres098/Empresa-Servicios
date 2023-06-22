package empresaServicios;

public class Especialista {
	private Integer nroEspecialista;
	private String nombre;
	private String telefono;
	private String especialidad;
	
	public Especialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		this.nroEspecialista = nroEspecialista;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}
	protected Integer nroEspecialista() {
		return this.nroEspecialista;
	}
	protected boolean coicedenEspecialidad(String tipoEspecialidadRequerida) {
		return this.especialidad.equals(tipoEspecialidadRequerida);
	}
	protected String tipoEspecialidad() {
		return this.especialidad;
	}
	@Override
	public String toString() {
		return "Numero especialista : " + this.nroEspecialista.toString() + " " + "Nombre : " + this.nombre + "Contacto : " + this.telefono ; 
	}
	

}
