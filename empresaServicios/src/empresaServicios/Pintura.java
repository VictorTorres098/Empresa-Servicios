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
}
