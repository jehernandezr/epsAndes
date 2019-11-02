package eps.negocio;

import java.math.BigDecimal;

public class Consulta extends ServicioDeSalud{


	/**
	 * Representa el tipo de consulta que se realiza
	 */
	private String tipo_Consulta;

	private BigDecimal id_receta;

	/**
	 * Constructor por defecto
	 */
	public Consulta() {
		super();
		this.tipo_Consulta = null;
		this.id_receta = null;
	}

	/**
	 * Constructor de cita
	 * 
	 * @param tipoConsulta
	 * @param recetas
	 */
	public Consulta(String tipoConsulta, BigDecimal receta) {
		super();
		this.tipo_Consulta = tipoConsulta;
		this.id_receta = receta;
	}

	/**
	 * @return the tipoConsulta
	 */
	public String getTipoConsulta() {
		return tipo_Consulta;
	}

	/**
	 * @param tipoConsulta the tipoConsulta to set
	 */
	public void setTipoConsulta(String tipoConsulta) {
		this.tipo_Consulta = tipoConsulta;
	}

	/**
	 * @return the recetas
	 */
	public BigDecimal getReceta() {
		return id_receta;
	}

	/**
	 * @param recetas the recetas to set
	 */
	public void setReceta(BigDecimal receta) {
		this.id_receta = receta;
	}


}
