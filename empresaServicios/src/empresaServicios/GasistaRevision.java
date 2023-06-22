package empresaServicios;

public class GasistaRevision extends Servicio{
	private int cantArtefactos;
	private double precioPorArtefacto;
	
	
	public GasistaRevision(Cliente c, Especialista e, String tipo, String direccion, int cantArtefactos, double precioPorArtefacto) {
		super(c, e, tipo, direccion);
		this.cantArtefactos = cantArtefactos;
		this.precioPorArtefacto = precioPorArtefacto;
	}

	@Override
	protected double calcularCosto() {
		double costo = precioPorArtefacto * cantArtefactos;
		double descuento = 0;
		double costoFinal = 0;
		if(cantArtefactos > 5 && cantArtefactos <= 10) {
			descuento = costo * 0.10; //descuento el 10%
		}
		if(cantArtefactos > 10) {
			descuento = costo * 0.15; //descuento el 10%
		}
		costoFinal = costo - descuento;
		return costoFinal;
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
