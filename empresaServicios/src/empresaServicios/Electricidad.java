package empresaServicios;

public class Electricidad extends Servicio {
	private double precioPorHora;
	private int horasTrabajadas;

	public Electricidad(Cliente c, Especialista e, String tipo, String direccion, double precioPorHora, int horasTrabajadas) {
		super(c, e, tipo, direccion);
		this.precioPorHora = precioPorHora;
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	protected double calcularCosto() {
		return precioPorHora * horasTrabajadas;
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
