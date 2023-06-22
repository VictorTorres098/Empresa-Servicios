package empresaServicios;

public class Cliente {
	private Integer dni;
	private String nombre;
	private String direccion;
	
	public Cliente(Integer dni, String nombre, String direccion) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	protected Integer dniCliente() {
		return this.dni;
	}
	@Override
	public String toString() {
		return "DNI: " + " " + this.dni.toString() + "Nombre: " + " " + this.nombre + "Direccion: " + " " + this.direccion; 
	}
}
