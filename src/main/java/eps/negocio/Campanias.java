/**
 * 
 */
package eps.negocio;

import java.math.BigDecimal;

/**
 * @author jonat
 *
 */
public class Campanias {

	private BigDecimal id;
	
	private String campania_Acepta;
	
	private BigDecimal id_Ips;
	
	private BigDecimal id_OrganizadorCampania;

	private String estado_Campania;
	
	
	/**
	 * @param id
	 * @param campania_Acepta
	 * @param id_Ips
	 * @param id_OrganizadorCampania
	 */
	public Campanias(BigDecimal id, String campania_Acepta, BigDecimal id_Ips, BigDecimal id_OrganizadorCampania) {
		this.id = id;
		this.campania_Acepta = campania_Acepta;
		this.id_Ips = id_Ips;
		this.id_OrganizadorCampania = id_OrganizadorCampania;
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
	 * @return the campania_Acepta
	 */
	public String getCampania_Acepta() {
		return campania_Acepta;
	}

	/**
	 * @param campania_Acepta the campania_Acepta to set
	 */
	public void setCampania_Acepta(String campania_Acepta) {
		this.campania_Acepta = campania_Acepta;
	}

	/**
	 * @return the id_Ips
	 */
	public BigDecimal getId_Ips() {
		return id_Ips;
	}

	/**
	 * @param id_Ips the id_Ips to set
	 */
	public void setId_Ips(BigDecimal id_Ips) {
		this.id_Ips = id_Ips;
	}

	/**
	 * @return the id_OrganizadorCampania
	 */
	public BigDecimal getId_OrganizadorCampania() {
		return id_OrganizadorCampania;
	}

	/**
	 * @param id_OrganizadorCampania the id_OrganizadorCampania to set
	 */
	public void setId_OrganizadorCampania(BigDecimal id_OrganizadorCampania) {
		this.id_OrganizadorCampania = id_OrganizadorCampania;
	}


	/**
	 * @return the estado_Campania
	 */
	public String getEstado_Campania() {
		return estado_Campania;
	}


	/**
	 * @param estado_Campania the estado_Campania to set
	 */
	public void setEstado_Campania(String estado_Campania) {
		this.estado_Campania = estado_Campania;
	}
	
	
}
