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
}
