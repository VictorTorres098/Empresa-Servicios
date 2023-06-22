package empresaServicios;

public class Pintura extends Servicio {
	protected int metrosCuadrados;
	protected double precioPorMetroCuadrado;

	public Pintura(
			Cliente c, 
			Especialista e, 
			String tipo, 
			String direccion, 
			int metrosCuadrados, 
			double precioPorMetroCuadrado) {
		
		super(c, e, tipo, direccion);
		this.metrosCuadrados = metrosCuadrados;
		this.precioPorMetroCuadrado = precioPorMetroCuadrado;
	}

	@Override
	protected double calcularCosto() {
		return metrosCuadrados * precioPorMetroCuadrado;
	}

	@Override
	protected String tipoServicio() {
		return this.tipo;
	}

	@Override
	protected void cambiarEspecialista(Especialista nuevoEspecialista) {
		this.especialista = nuevoEspecialista;
		
	}
	@Override
	protected Especialista especialistaResposable() {
		return this.especialista;
	}

	@Override
	protected String direccionDelSerivicio() {
		return this.direccion;
	}
	

}
