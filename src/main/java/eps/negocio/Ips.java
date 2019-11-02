package eps.negocio;

import java.math.BigDecimal;


public class Ips {

	private BigDecimal id;

	/**
	 * representa la localizacion de la ips
	 */
	private String localizacion;

	/**
	 * Representa el nombre de la Ips
	 */
	private String nombre;

	/**
	 * id de los medicos adscritos
	 */
	private BigDecimal id_Adscritos;

	

	/**
	 * Constructor por defecto
	 */
	public Ips() {
		this.id=null;
		this.localizacion = "";
		this.nombre = "";
		this.id_Adscritos=null;
	}

	/**
	 * constructor de una Ips
	 * 
	 * @param localizacion
	 * @param nombre
	 * @param serviciosOfrecidos
	 * @param medicosAdscritos
	 */
	public Ips(BigDecimal id,String localizacion, String nombre, BigDecimal medicosAdscritos) {
		this.id=id;
		this.localizacion = localizacion;
		this.nombre = nombre;
		this.id_Adscritos =medicosAdscritos;
		
	}

	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
	
	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the id_Adscritos
	 */
	public BigDecimal getId_Adscritos() {
		return id_Adscritos;
	}

	/**
	 * @param id_Adscritos the id_Adscritos to set
	 */
	public void setId_Adscritos(BigDecimal id_Adscritos) {
		this.id_Adscritos = id_Adscritos;
	}

}
