package empresaServicios;

public abstract class Servicio {
	protected Cliente cliente;
	protected Especialista especialista;
	protected String tipo;
	protected String direccion;
	
	public Servicio(Cliente c, Especialista e, String tipo, String direccion) {
		this.cliente = c;
		this.especialista = e;
		this.tipo = tipo;
		this.direccion = direccion;
	}
	protected abstract double calcularCosto();
	
	protected String tipoServicio() {
		return this.tipo;
	}
	
	protected void cambiarEspecialista(Especialista nuevoEspecialista) {
		this.especialista = nuevoEspecialista;
	}
	
	protected Especialista especialistaResposable() {
		return this.especialista;	//O(1)
	}
	
	protected String direccionDelSerivicio() {
		return this.direccion;
	}
	
	

}
