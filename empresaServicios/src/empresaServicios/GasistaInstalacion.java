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
}
