package empresaServicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpresaDeServicios {
	private HashMap<Integer, Especialista> registroEspecialistas;
	private HashMap<Integer, Cliente> registroClientes;
	private GestionDeServicios servicios;
	private ArrayList<String> especialidadesAceptadas;
	
	
	public EmpresaDeServicios() {
		registroEspecialistas = new HashMap<>();
		registroClientes = new HashMap<>();
		servicios = new GestionDeServicios();
		especialidadesAceptadas = new ArrayList<>();
		especialidadesAceptadas.add("Pintura");
		especialidadesAceptadas.add("PinturaEnAltura");
		especialidadesAceptadas.add("Electricidad");
		especialidadesAceptadas.add("GasistaInstalacion");
		especialidadesAceptadas.add("GasistaRevision");
	}

	/**
	* Registra un nuevo cliente en el sistema dado su:
	* - dni,
	* - nombre y
	* - teléfono de contacto.
	*
	* Si el dni ya está en el sistema se debe generar una
	* excepción.
	*/
	
	public void registrarCliente(int dni, String nombre, String telefono) {
		if(!existeCliente(dni)) {
			Cliente c = new Cliente(dni, nombre, telefono);
			registroClientes.put(dni, c);
		}else {
			throw new RuntimeException("el cliente ya se encuentra registrado");
		}
	}
	
	private boolean existeCliente(Integer dni) {
		return registroClientes.containsKey(dni);
	}
	
	/**
	* Registra un nuevo especialista en el sistema dados su:
	* - nroEspecialista,
	* - nombre,
	* - teléfono y
	* - tipo De servicio en el que se especializa.
	*
	* Si el nroEspecialista ya está registrado en el sistema
	* se debe generar una excepción.
	*/
	
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		if(!existeEspecialista(nroEspecialista) && especialidadAceptada(especialidad)) {
			Especialista e = new Especialista(nroEspecialista, nombre, telefono, especialidad);
			registroEspecialistas.put(nroEspecialista, e);
		}else {
			throw new RuntimeException("El especialista ya se encuentra registrado");
		}
	}
	
	private boolean existeEspecialista(int nroEpecialista) {
		return registroEspecialistas.containsKey(nroEpecialista);
	}
	
	private boolean especialidadAceptada(String especialidad) {
		return especialidadesAceptadas.contains(especialidad);
	}
	
	/**
	* Se registra la prestación de un servicio de tipo Electricidad en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por hora de trabajo del especialista
	* - cantidad de horas estimadas que llevará realizar el trabajo.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción. //IMPLEMENTAR
	* Si el precio por hora o las horas de trabajo estimado son menores o
	* iguales a 0, se debe generar una excepción.
	*/

	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora, int horasTrabajadas) {
		if(!validarDatosCET(dni, nroEspecialista) || precioPorHora <= 0 || horasTrabajadas <= 0) {
			throw new RuntimeException("Algunos de los datos proporcionados no son correctos revise");//mejorar con case
		}
		Cliente c = registroClientes.get(dni);
		Especialista e = registroEspecialistas.get(nroEspecialista);
		int cod = servicios.agregarServicioElectricidad(c, e, direccion, precioPorHora, horasTrabajadas);
		return cod;
	}
	
	/**
	* Se registra la prestación de un servicio de tipo Pintura en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados son menores o
	* iguales a 0, se debe generar una excepción.
	* */
	
	private boolean validarDatosCET(int dni, int nroEspecialista) {
		return existeCliente(dni) && existeEspecialista(nroEspecialista); 
	}
	
	public int solicitarServicioPintura(int dni, int nroEspecialista,String direccion, int metrosCuadrados, double precioPorMetroCuadrado) {
		if(!validarDatosCET(dni, nroEspecialista) || metrosCuadrados <= 0 || precioPorMetroCuadrado <= 0 ){
			throw new RuntimeException("algunos parametros no son complatibles");
		}
		Cliente c = registroClientes.get(dni);
		Especialista e = registroEspecialistas.get(nroEspecialista);
		int cod = servicios.agregarServicioPintura(c, e, direccion, metrosCuadrados, precioPorMetroCuadrado);
		return cod;
	}
	
			/**
			* Se registra la prestación de un servicio de tipo PinturaEnAltura en el
			* sistema ingresando los datos necesarios para solicitar un servicio y además:
			* - precio por pintar un metro cuadrado
			* - cantidad de metros cuadrados a pintar
			* - nro de piso en el que se realizará el trabajo.
			* - costo del seguro
			* - costo del alquiler de los andamios.
			*
			* Se devuelve el código único del servicio a realizar.
			*
			* Si el dni o el nroEspecialista no están registrados en el sistema se debe
			* generar una excepción.
			* Si el especialista no se especializa en este tipo de servicio se debe generar
			* una excepción.
			* Si el precio por metro cuadrado o los metros cuadrados o el piso o el costo
			* del seguro o el costo del alquiler de los andamios son menores o iguales a 0,
			* se debe generar una excepción.*/
	
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados, double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {
		if(!validarDatosCET(dni, nroEspecialista) || metrosCuadrados <= 0 || precioPorMetroCuadrado <= 0 || piso <= 0 ||  seguro <= 0 || alqAndamios <= 0) {
			throw new RuntimeException("Algunos de los datos proporcionados no son correctos revise");
		}
		Cliente c = registroClientes.get(dni);
		Especialista e = registroEspecialistas.get(nroEspecialista);
		int cod = servicios.agregarServicioPinturaEnAltura(c, e, direccion, metrosCuadrados, precioPorMetroCuadrado, piso, seguro, alqAndamios);
		return cod;
	}
			/**
			* Se registra la prestación de un servicio de tipo GasistaInstalacion en el
			* sistema ingresando los datos necesarios para solicitar un servicio y además:
			* - cantidad de artefactos a instalar
			* - precio por la instalación de un artefacto.
			*
			* Se devuelve el código único del servicio a realizar.
			*
			* Si el dni o el nroEspecialista no están registrados en el sistema se debe
			* generar una excepción.
			* Si el especialista no se especializa en este tipo de servicio se debe generar
			* una excepción.
			* Si el precio de instalación o la cantidad de artefactos a instalar son
			* menores o iguales a 0, se debe generar una excepción.
			*/
	
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		if(!validarDatosCET(dni, nroEspecialista) ||cantArtefactos <= 0 || precioPorArtefacto <= 0 ) {
			throw new RuntimeException("Algunos de los datos proporcionados no son correctos");
		}
		Cliente c = registroClientes.get(dni);
		Especialista e = registroEspecialistas.get(nroEspecialista);
		int cod = servicios.agregarServicioGasistaInstalacion(c, e, direccion, cantArtefactos, precioPorArtefacto);
		return cod;
	}
	
			/**
			* Se registra la prestación de un servicio de tipo GasistaRevison en el
			* sistema ingresando los datos necesarios para solicitar un servicio y además:
			* - cantidad de artefactos a revisar
			* - precio por la revisión de un artefacto.
			*
			* Se devuelve el código único del servicio a realizar.
			*
			* Si el dni o el nroEspecialista no están registrados en el sistema se debe
			* generar una excepción.
			* Si el especialista no se especializa en este tipo de servicio se debe generar
			* * una excepción.
			* Si el precio de instalación o la cantidad de artefactos a revisar son
			* menores o iguales a 0, se debe generar una excepción
			* */
	
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		if(!validarDatosCET(dni, nroEspecialista) || cantArtefactos <= 0 || precioPorArtefacto <= 0) {
			throw new RuntimeException("Algunos de los datos proporcionados no son correctos");
		}
		Cliente c = registroClientes.get(dni);
		Especialista e = registroEspecialistas.get(nroEspecialista);
		int cod = servicios.agregarGasistaRevision(c, e, direccion, cantArtefactos, precioPorArtefacto);
		return cod;
	}
	
			/**
			* Se registra que el servicio solicitado ya fué concluido. Para esto se debe
			* ingresar el costo de los materiales utilizados para poder realizar el
			* trabajo.
			*
			* Se devuelve el precio que se debe facturar al cliente.
			* Este precio se obtiene sumando el costo de los materiales con el costo del
			* servicio realizado. Cada tipo de servicio tiene su forma de calcular el
			* costo del trabajo.
			*
			* Si el código de servicio no está en el sistema o el mismo ya fué finalizado,
			* se debe generar una excepción.
			*
			* Se debe realizar esta operación en O(1).
			*/
	
	public double finalizarServicio(int codServicio, double costoMateriales) {
		return servicios.finalizarServicio(codServicio, costoMateriales); 
	}
	
	/**
	* Devuelve un diccionario cuya clave es el tipo de servicio y el valor es la
	* cantidad de servicios realizados de ese tipo.
	* Si un tipo de servicio no tuvo ninguna demanda, el valor de esa entrada debe
	* ser 0.
	*/
	
	public Map<String,Integer> cantidadDeServiciosRealizadosPorTipo(){
		return servicios.listServiciosRealizados();
	
	}
	
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* son del tipo pasado por parámetro.
	* Si el tipo de servicio es invalido, debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	*/
	
	public double facturacionTotalPorTipo(String tipoServicio) {
		if(!servicios.tiposDeServiciosRegistrados(tipoServicio)) {
			throw new RuntimeException("el servicio que intenta consultar no existe, revise el tipo de servicio solicitado");
		}
		return servicios.facturacionPorTipo(tipoServicio);
	}
	
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* realizó la empresa.
	*/
	
	public double facturacionTotal() {
		return servicios.facturacionTotal();
	}
	
	/**
	* Debe cambiar el especialista responsable del servicio.
	* Si código de Servicio o el nroEspecialista no están registrados en el sistema
	* se debe generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	*
	*
	* Se debe realizar esta operación en O(1).
	*/
	
	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		if(!servicios.existeServicio(codServicio) ||  !existeEspecialista(nroEspecialista) ) {
			throw new RuntimeException("El servicio o el especialista no exiten en los registros");
		}
		Especialista relevoEspecialista = registroEspecialistas.get(nroEspecialista);
		servicios.relevoEspecialista(codServicio, relevoEspecialista);
	}
	
	/**
	* Devuelve un String con forma de listado donde cada renglón representa un
	* servicio realizado.
	* Cada renglón debe respetar el siguiente formato:
	* " + [ codServicio - GasistaInstalacion ] Dirección"
	* por ejemplo:
	* " + [ 1492 - GasistaInstalacion ] uan María Gutiérrez 1150"
	* Si el nroEspecialista no está registrado en el sistema, se debe generar una
	* excepción.
	* Si el especialista no ha realizado ningún servicio hasta el momento, se debe
	* devolver un String vacío.
	*/
	
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		if(!existeEspecialista(nroEspecialista)) {
			throw new RuntimeException("El especialista no se encuentra registrado o es erroneo el nroEspecialista");
		}
		Especialista e = registroEspecialistas.get(nroEspecialista);
		String lista = servicios.serviciosAtendidosPorEspecialista(e); 
		return lista;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("EMPRESA DE SERVICIOS \nEmpleados registrados: ");
		sb.append(registroEspecialistas.size() + "\n");
		sb.append("clientes registrados: " + registroClientes.size() +"\n");
		sb.append("Servicios realizados: " + servicios.cantidadDeSeriviciosRealizados());
		return sb.toString();
	}
}
