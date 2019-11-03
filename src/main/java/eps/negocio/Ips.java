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
	 * Constructor por defecto
	 */
	public Ips() {
		this.id=null;
		this.localizacion = "";
		this.nombre = "";
	}

	/**
	 * constructor de una Ips
	 * 
	 * @param localizacion
	 * @param nombre
	 * @param serviciosOfrecidos
	 * @param medicosAdscritos
	 */
	public Ips(BigDecimal id,String localizacion, String nombre) {
		this.id=id;
		this.localizacion = localizacion;
		this.nombre = nombre;		
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

}
