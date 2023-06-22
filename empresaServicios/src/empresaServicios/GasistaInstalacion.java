package empresaServicios;

public class GasistaInstalacion extends Servicio {
	private int cantArtefactos;
	private double precioPorArtefacto;

	public GasistaInstalacion(Cliente c, Especialista e, String tipo, String direccion, int cantArtefactos, double precioPorArtefacto) {
		super(c, e, tipo, direccion);
		this.cantArtefactos = cantArtefactos;
		this.precioPorArtefacto = precioPorArtefacto;
	}
	@Override
	protected double calcularCosto() {
		double costo = cantArtefactos * precioPorArtefacto;
		return costo;
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
