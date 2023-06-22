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
	
	protected abstract String tipoServicio();
	
	protected abstract void cambiarEspecialista(Especialista nuevoEspecialista);
	
	protected abstract Especialista especialistaResposable();
	
	protected abstract String direccionDelSerivicio();
	
	

}
