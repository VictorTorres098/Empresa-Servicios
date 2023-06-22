package empresaServicios;

public class PinturaEnAltura extends Pintura {
	private int piso;
	private double seguro;
	private double alqAndamios;

	public PinturaEnAltura(
			Cliente c, 
			Especialista e, 
			String tipo, 
			String direccion, 
			int metrosCuadrados,
			double precioPorMetroCuadrado, 
			int piso,
			double seguro, 
			double alqAndamios) {
		
		super(c, e, tipo, direccion, metrosCuadrados, precioPorMetroCuadrado);
		this.piso = piso;
		this.seguro = seguro;
		this.alqAndamios = alqAndamios;
		
	}
	@Override
	protected double calcularCosto() {
		double costo = metrosCuadrados * precioPorMetroCuadrado;
		double andamios = 0;
		double costoFinal = 0;
		if(piso >= 1 && piso <= 5 ) {
			costoFinal = seguro + alqAndamios;
		}
		if(piso > 5) {
			andamios = alqAndamios + 0.20;
		}
		return costoFinal + costo + andamios;
	}
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
