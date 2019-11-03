/**
 * 
 */
package eps.negocio;

import java.math.BigDecimal;

/**
 * @author jonat
 *
 */
public class ServiciosCampania {

	private BigDecimal id_Campania;
	
	private String fecha;
	
	private String nombre_Campania;
	
	private String numero_participantes;
	
	private String cupos_Actuales;
	
	private String tipo_Servicio;

	
	
	
	
	/**
	 * @param id_Campania
	 * @param fecha
	 * @param nombre_Campania
	 * @param numero_participantes
	 * @param cupos_Actuales
	 * @param tipo_Servicio
	 */
	public ServiciosCampania(BigDecimal id_Campania, String fecha, String nombre_Campania, String numero_participantes,
			String cupos_Actuales, String tipo_Servicio) {
		this.id_Campania = id_Campania;
		this.fecha = fecha;
		this.nombre_Campania = nombre_Campania;
		this.numero_participantes = numero_participantes;
		this.cupos_Actuales = cupos_Actuales;
		this.tipo_Servicio = tipo_Servicio;
	}

	/**
	 * @return the id_Campania
	 */
	public BigDecimal getId_Campania() {
		return id_Campania;
	}

	/**
	 * @param id_Campania the id_Campania to set
	 */
	public void setId_Campania(BigDecimal id_Campania) {
		this.id_Campania = id_Campania;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the nombre_Campania
	 */
	public String getNombre_Campania() {
		return nombre_Campania;
	}

	/**
	 * @param nombre_Campania the nombre_Campania to set
	 */
	public void setNombre_Campania(String nombre_Campania) {
		this.nombre_Campania = nombre_Campania;
	}

	/**
	 * @return the numero_participantes
	 */
	public String getNumero_participantes() {
		return numero_participantes;
	}

	/**
	 * @param numero_participantes the numero_participantes to set
	 */
	public void setNumero_participantes(String numero_participantes) {
		this.numero_participantes = numero_participantes;
	}

	/**
	 * @return the cupos_Actuales
	 */
	public String getCupos_Actuales() {
		return cupos_Actuales;
	}

	/**
	 * @param cupos_Actuales the cupos_Actuales to set
	 */
	public void setCupos_Actuales(String cupos_Actuales) {
		this.cupos_Actuales = cupos_Actuales;
	}

	/**
	 * @return the tipo_Servicio
	 */
	public String getTipo_Servicio() {
		return tipo_Servicio;
	}

	/**
	 * @param tipo_Servicio the tipo_Servicio to set
	 */
	public void setTipo_Servicio(String tipo_Servicio) {
		this.tipo_Servicio = tipo_Servicio;
	}
	
	
}
