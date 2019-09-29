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
	private List<Long>serviciosRequeridos;

	/**
	 * constructor por defecto
	 */
	public Hospitalizacion() {
		super();
		this.fueDadoAlta = false;
		this.serviciosRequeridos = (List<Long>) new java.awt.List();
	}
	
	/**
	 * Cosntructor de una hospitalizacion
	 * @param fueDadoAlta
	 * @param serviciosRequeridos
	 */
	public Hospitalizacion(boolean fueDadoAlta) {
		super();
		this.fueDadoAlta = fueDadoAlta;
		this.serviciosRequeridos = (List<Long>) new java.awt.List();
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
	public List<Long> getServiciosRequeridos() {
		return serviciosRequeridos;
	}

	/**
	 * @param serviciosRequeridos the serviciosRequeridos to set
	 */
	public void setServiciosRequeridos(List<Long> serviciosRequeridos) {
		this.serviciosRequeridos = serviciosRequeridos;
	}
	
	/**
	 * Agrega un servicio de salud a la lista
	 */
	public void addServicioRequerido(Long servicio){
		serviciosRequeridos.add(servicio);
	}
	
}
