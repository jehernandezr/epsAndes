package eps.negocio;

import java.math.BigDecimal;


public class Hospitalizacion extends ServicioDeSalud {

	/**
	 * representa si el paciente fue dado de alta
	 */
	private String fue_Dado_Alta;
	
	/**
	 * representa los servicios adicionales que puede requerir una hospitalizacion
	 */
	BigDecimal id_servicio_Requerido;

	/**
	 * constructor por defecto
	 */
	public Hospitalizacion() {
		super();
		this.fue_Dado_Alta = "";
		this.id_servicio_Requerido = null;
	}
	
	/**
	 * Cosntructor de una hospitalizacion
	 * @param fueDadoAlta
	 * @param serviciosRequeridos
	 */
	public Hospitalizacion(String fueDadoAlta, BigDecimal id) {
		super();
		this.fue_Dado_Alta = fueDadoAlta;
		this.id_servicio_Requerido = id;
	}

	/**
	 * @return the fueDadoAlta
	 */
	public String getFue_Dado_Alta() {
		return fue_Dado_Alta;
	}

	/**
	 * @param fueDadoAlta the fueDadoAlta to set
	 */
	public void setFue_Dado_Alta(String fueDadoAlta) {
		this.fue_Dado_Alta = fueDadoAlta;
	}

	/**
	 * @return the serviciosRequeridos
	 */
	public BigDecimal getId_Servicio_Requerido() {
		return id_servicio_Requerido;
	}

	/**
	 * @param serviciosRequeridos the serviciosRequeridos to set
	 */
	public void setId_Servicio_Requerido(BigDecimal serviciosRequerido) {
		this.id_servicio_Requerido = serviciosRequerido;
	}
	
	
	
}
