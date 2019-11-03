package eps.negocio;

import java.math.BigDecimal;

public class Consulta extends ServicioDeSalud{


	/**
	 * Representa el tipo de consulta que se realiza
	 */
	private String tipo_Consulta;

	private BigDecimal id_Receta;

	/**
	 * Constructor por defecto
	 */
	public Consulta() {
		super();
		this.tipo_Consulta = null;
		this.id_Receta = null;
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
		this.id_Receta = receta;
	}

	/**
	 * @return the tipoConsulta
	 */
	public String getTipo_Consulta() {
		return tipo_Consulta;
	}

	/**
	 * @param tipoConsulta the tipoConsulta to set
	 */
	public void setTipo_Consulta(String tipoConsulta) {
		this.tipo_Consulta = tipoConsulta;
	}

	/**
	 * @return the recetas
	 */
	public BigDecimal getId_Receta() {
		return id_Receta;
	}

	/**
	 * @param recetas the recetas to set
	 */
	public void setId_Receta(BigDecimal receta) {
		this.id_Receta = receta;
	}


}
