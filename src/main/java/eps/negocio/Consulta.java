package eps.negocio;

import java.math.BigDecimal;

public class Consulta extends ServicioDeSalud{


	/**
	 * Representa el tipo de consulta que se realiza
	 */
	private String tipoConsulta;

	private BigDecimal receta;

	/**
	 * Constructor por defecto
	 */
	public Consulta() {
		super();
		this.tipoConsulta = null;
		this.receta = null;
	}

	/**
	 * Constructor de cita
	 * 
	 * @param tipoConsulta
	 * @param recetas
	 */
	public Consulta(String tipoConsulta, BigDecimal receta) {
		super();
		this.tipoConsulta = tipoConsulta;
		this.receta = receta;
	}

	/**
	 * @return the tipoConsulta
	 */
	public String getTipoConsulta() {
		return tipoConsulta;
	}

	/**
	 * @param tipoConsulta the tipoConsulta to set
	 */
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	/**
	 * @return the recetas
	 */
	public BigDecimal getReceta() {
		return receta;
	}

	/**
	 * @param recetas the recetas to set
	 */
	public void setReceta(BigDecimal receta) {
		this.receta = receta;
	}


}
