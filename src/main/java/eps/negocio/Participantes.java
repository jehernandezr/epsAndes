/**
 * 
 */
package eps.negocio;

import java.math.BigDecimal;

/**
 * @author jonat
 *
 */
public class Participantes {

	
	private BigDecimal id_Cliente;
	
	private BigDecimal id_Campania;

	
	
	/**
	 * @param id_Cliente
	 * @param id_Campania
	 */
	public Participantes(BigDecimal id_Cliente, BigDecimal id_Campania) {
		this.id_Cliente = id_Cliente;
		this.id_Campania = id_Campania;
	}

	/**
	 * @return the id_Cliente
	 */
	public BigDecimal getId_Cliente() {
		return id_Cliente;
	}

	/**
	 * @param id_Cliente the id_Cliente to set
	 */
	public void setId_Cliente(BigDecimal id_Cliente) {
		this.id_Cliente = id_Cliente;
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
	
}
