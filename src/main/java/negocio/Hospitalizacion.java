package negocio;

import java.util.List;

public class Hospitalizacion extends ServicioDeSalud {

	/**
	 * representa si el paciente fue dado de alta
	 */
	private boolean fueDadoAlta;
	
	/**
	 * representa los servicios adicionales que puede requerir una hospitalizacion
	 */
	private List<ServicioDeSalud>serviciosRequeridos;

	/**
	 * constructor por defecto
	 */
	public Hospitalizacion() {
		this.fueDadoAlta = false;
		this.serviciosRequeridos = (List<ServicioDeSalud>) new java.awt.List();
	}
	
	/**
	 * Cosntructor de una hospitalizacion
	 * @param fueDadoAlta
	 * @param serviciosRequeridos
	 */
	public Hospitalizacion(boolean fueDadoAlta) {
		this.fueDadoAlta = fueDadoAlta;
		this.serviciosRequeridos = (List<ServicioDeSalud>) new java.awt.List();
	}

	/**
	 * @return the fueDadoAlta
	 */
	public boolean isFueDadoAlta() {
		return fueDadoAlta;
	}

	/**
	 * @param fueDadoAlta the fueDadoAlta to set
	 */
	public void setFueDadoAlta(boolean fueDadoAlta) {
		this.fueDadoAlta = fueDadoAlta;
	}

	/**
	 * @return the serviciosRequeridos
	 */
	public List<ServicioDeSalud> getServiciosRequeridos() {
		return serviciosRequeridos;
	}

	/**
	 * @param serviciosRequeridos the serviciosRequeridos to set
	 */
	public void setServiciosRequeridos(List<ServicioDeSalud> serviciosRequeridos) {
		this.serviciosRequeridos = serviciosRequeridos;
	}
	
	/**
	 * Agrega un servicio de salud a la lista
	 */
	public void addServicioRequerido(ServicioDeSalud servicio){
		serviciosRequeridos.add(servicio);
	}
	
}
