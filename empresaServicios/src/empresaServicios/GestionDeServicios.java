package empresaServicios;

import java.util.HashMap;
import java.util.Map;

public class GestionDeServicios {
	private HashMap<Integer, Servicio> registrosServicios;
	private HashMap<Integer, Servicio> registrosServiciosRealizados;
	private HashMap<String, Double> cajaEmpresa; 
	
	public GestionDeServicios() {
		registrosServicios = new HashMap<>();
		registrosServiciosRealizados = new HashMap<>();
		cajaEmpresa = new HashMap<>();
		//se asigna a la caja de la empresa los tipos de servicios realizados
		cajaEmpresa.put("Electricidad", 0.0);
		cajaEmpresa.put("Pintura", 0.0);
		cajaEmpresa.put("PinturaEnAltura", 0.0);
		cajaEmpresa.put("GasistaInstalacion", 0.0);
		cajaEmpresa.put("GasistaRevision", 0.0);
	}
	
	//funciones para informacion empresa
	protected int cantidadDeSerivicios() {
		return registrosServicios.size();
	}
	
	protected int cantidadDeSeriviciosRealizados() {
		return registrosServiciosRealizados.size();
	}
	//fin de funciones
	
	protected int agregarServicioElectricidad(Cliente c, Especialista e, String direccion, double precioPorHora, int horasTrabajadas) {
		if(!e.tipoEspecialidad().equals("Electricidad")) {
			throw new RuntimeException("la especialidad no es compaible");
		}
		Integer cod = crearCodigoUnico( c.dniCliente(),e.nroEspecialista()); 
		Electricidad s = new Electricidad(c,e,"Electricidad",direccion,precioPorHora,horasTrabajadas); 
		registrosServicios.put(cod, s);
		return cod;
	}
	
	protected int agregarServicioPintura(Cliente c, Especialista e, String direccion, int metrosCuadrados, double precioPorMetroCuadrado) {
		if(!e.tipoEspecialidad().equals("Pintura")) {
			throw new RuntimeException("la especialidad no es compaible");
		}
		Integer cod = crearCodigoUnico(c.dniCliente(),e.nroEspecialista()); 
		Pintura p = new Pintura(c,e,"Pintura",direccion, metrosCuadrados, precioPorMetroCuadrado);
		registrosServicios.put(cod, p);
		return cod;
	}
	
	protected int agregarServicioPinturaEnAltura(Cliente c, Especialista e, String direccion, int metrosCuadrados, double precioPorMetroCuadrado, int piso,double seguro, double alqAndamios) {
		if(!e.tipoEspecialidad().equals("PinturaEnAltura")) {
			throw new RuntimeException("la especialidad no es compaible");
		}
		Integer cod = crearCodigoUnico(c.dniCliente(),e.nroEspecialista());
		PinturaEnAltura pAltura = new PinturaEnAltura(c, e, "PinturaEnAltura", direccion, metrosCuadrados, precioPorMetroCuadrado, piso, seguro, alqAndamios);
		registrosServicios.put(cod,pAltura);
		return cod;
	}
	
	protected int agregarServicioGasistaInstalacion(Cliente c, Especialista e, String direccion, int cantArtefactos, double precioPorArtefacto) {
		if(!e.tipoEspecialidad().equals("GasistaInstalacion")) {
			throw new RuntimeException("la especialidad no es compaible");
		}
		Integer cod = crearCodigoUnico(c.dniCliente(),e.nroEspecialista());
		GasistaInstalacion g = new GasistaInstalacion(c,e,"GasistaInstalacion",direccion, cantArtefactos, precioPorArtefacto);
		registrosServicios.put(cod, g);
		return cod;		
	}
	
	protected int agregarGasistaRevision(Cliente c, Especialista e, String direccion, int cantArtefactos, double precioPorArtefacto) {
		if(!e.tipoEspecialidad().equals("GasistaRevision")) {
			throw new RuntimeException("la especialidad no es compaible");
		}
		Integer cod = crearCodigoUnico(c.dniCliente(), e.nroEspecialista());
		GasistaRevision gr = new GasistaRevision(c,e,"GasistaRevision", direccion, cantArtefactos, precioPorArtefacto);
		registrosServicios.put(cod, gr);
		return cod;
	}
	
	protected double finalizarServicio(int codServicio, double costoMateriales) {
		if(!existeServicio(codServicio)) {
			throw new RuntimeException("el servicio no se encuentra en los registros");
		}
		double costo = registrosServicios.get(codServicio).calcularCosto() + costoMateriales;
		//sumo a la caja
		sumarCajaServicio(registrosServicios.get(codServicio).tipoServicio(), costo);
		//elimino el servicio
		cambiarServicioDeRegistro(codServicio);
		return costo;
	}
	
	protected Map<String, Integer> listServiciosRealizados(){
		Map<String, Integer> list = new HashMap<>();
		list.put("Pintura", 0);
		list.put("PinturaEnAltura", 0);
		list.put("Electricidad", 0);
		list.put("GasistaInstalacion", 0);
		list.put("GasistaRevision", 0);
		for(Integer key : registrosServiciosRealizados.keySet()) {
			if(list.containsKey(registrosServiciosRealizados.get(key).tipoServicio())) {
				String clave = registrosServiciosRealizados.get(key).tipoServicio();
				int suma = list.get(clave) + 1;
				list.put(clave, suma);
			}
		}
		return list;
	}
	protected String serviciosAtendidosPorEspecialista(Especialista e) {
		StringBuilder sb = new StringBuilder(); //O(1)
		
		for(Integer cod : registrosServiciosRealizados.keySet()) { //O(n)
			Servicio s = registrosServiciosRealizados.get(cod); // O(1) + O(1) = O(2); 
			if(s.especialistaResposable().nroEspecialista().equals(e.nroEspecialista())) { //O(1) + O(1) + O(1) + O(1) = O(4);
				sb.append(" + [ " + cod.toString() + " - " + s.tipoServicio() + " ] " + s.direccionDelSerivicio()+"\n" );
			}						//O(1) + O(1) + O(1) + O(1) + O(1) = O(5);
		}
		if(sb.isEmpty()) { //O(1);
			return "";
		}else{
			return sb.toString();
		}
	}
	// comlejidad de serviciosAtendidosPorEspecialista = O(1) + O(n) * O(2) + O(4) + O(5) + O(1);
	/**
	 * Complejidad
	 * O(1) + O(n) + O(12);
	 * O(1) + O(n) * O(1) = regla 4
	 * O(1) + O(n) = regla 3
	 * O(1 + n) = regla 2
	 * O(max{1,n}) = regla 2
	 * O(n) = regla 1  
	 * 
	 * serviciosAtendidosPorEspecialista = O(n); 
	 */
	
	protected boolean tiposDeServiciosRegistrados(String tipoServicio) {
		return cajaEmpresa.containsKey(tipoServicio);
	}
	
	protected double facturacionPorTipo(String tipoServicio) {
		return cajaEmpresa.get(tipoServicio);
	}
	
	protected double facturacionTotal() {
		double facturacionEmpresa = 0.0;
		for(String claves : cajaEmpresa.keySet()) {
			facturacionEmpresa += cajaEmpresa.get(claves);
		}
		return facturacionEmpresa;
	}
	
	//validacion que existe el servicio
	protected boolean existeServicio(Integer codServicio) {
		return registrosServicios.containsKey(codServicio);
	}
	
	protected void relevoEspecialista(int codServicio, Especialista nuevoEspecialista) {
		Especialista es = registrosServicios.get(codServicio).especialistaResposable();
		if(!es.coicedenEspecialidad(nuevoEspecialista.tipoEspecialidad())) {
			throw new RuntimeException("Las especialidades no son compatibles");
		}
		registrosServicios.get(codServicio).cambiarEspecialista(nuevoEspecialista);
	}
	
	//FUNCIONES AUX
	private void sumarCajaServicio(String tipoServicio, double monto) {
		Double suma = cajaEmpresa.get(tipoServicio) + monto;
		cajaEmpresa.put(tipoServicio, suma);
	}
	
	private void cambiarServicioDeRegistro(int codServicio) {
		 Servicio s = registrosServicios.get(codServicio); //obtengo el servicio
		 registrosServiciosRealizados.put(codServicio, s); //ahora lo agrego a servicios realizados
		 registrosServicios.remove(codServicio);           //elimino el servicio del registro
	}
	
	private boolean existeServicio(int codServicio) {
		return registrosServicios.containsKey(codServicio);
	}
	
	private Integer crearCodigoUnico(Integer dni, Integer nroEspecialista) {
	    if (dni == null || nroEspecialista == null) {
	        throw new IllegalArgumentException("El dni y el nroEspecialista no pueden ser nulos.");
	    }
	    StringBuilder codigoUnicoStr = new StringBuilder();
	    String dniStr = dni.toString();
	    String especialistaStr = nroEspecialista.toString();
	    codigoUnicoStr.append(dniStr.substring(0, Math.min(3, dniStr.length())));
	    codigoUnicoStr.append(especialistaStr.substring(0, Math.min(3, especialistaStr.length())));
	    return Integer.valueOf(codigoUnicoStr.toString());
	}
}
