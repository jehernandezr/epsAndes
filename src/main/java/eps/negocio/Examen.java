package eps.negocio;

import java.math.BigDecimal;

public class Examen extends ServicioDeSalud {

	/**
	 * representa la informacion del examen
	 */
	private String tipo_Examen;

	
	/**
	 * 
	 */
	private BigDecimal id;
	
	
	public Examen() {
		super();
		this.tipo_Examen = "";
	}
	
	/**
	 * Constructor de un examen
	 * 
	 * @param tipoExamen
	 */
	public Examen(String tipoExamen) {
		super();
		this.tipo_Examen = tipoExamen;
	}

	/**
	 * @return the tipoExamen
	 */
	public String getTipo_Examen() {
		return tipo_Examen;
	}

	/**
	 * @param tipoExamen the tipoExamen to set
	 */
	public void setTipo_Examen(String tipoExamen) {
		this.tipo_Examen = tipoExamen;
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
