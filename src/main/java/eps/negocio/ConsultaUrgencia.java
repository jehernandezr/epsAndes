package eps.negocio;

import java.math.BigDecimal;

public class ConsultaUrgencia extends ServicioDeSalud{

	/**
	 * id de una consulta de urgencia
	 */
	private BigDecimal id;
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
	 * representa si el paciente fue dado de alta
	 */
	private String fue_Dado_De_Alta;
	
	/**
	 * representa la urgencia de la consulta en una escala del 1 al 5
	 */
	private int triage;
	
	/**
	 * representa la receta si se genera
	 */
	private BigDecimal Id_receta;

	/**
	 * Constructor por defecto
	 */
	public ConsultaUrgencia() {
		super();
		this.fue_Dado_De_Alta = "";
		this.triage = 0;
		this.Id_receta = null;
	}
	
	/**
	 * constructor de una consulta de emergencia
	 * 
	 * @param fueDadoAlta
	 * @param triage
	 * @param receta
	 */
	public ConsultaUrgencia(String fueDadoAlta, Integer triage, BigDecimal receta) {
		super();
		this.fue_Dado_De_Alta = fueDadoAlta;
		this.triage = triage;
		this.Id_receta = receta;
	}

	/**
	 * @return the fueDadoAlta
	 */
	public String isFue_Dado_De_Alta() {
		return fue_Dado_De_Alta;
	}

	/**
	 * @param fueDadoAlta the fueDadoAlta to set
	 */
	public void setFue_Dado_De_Alta(String fueDadoAlta) {
		this.fue_Dado_De_Alta = fueDadoAlta;
	}

	/**
	 * @return the triage
	 */
	public int getTriage() {
		return triage;
	}

	/**
	 * @param triage the triage to set
	 */
	public void setTriage(int triage) {
		this.triage = triage;
	}

	/**
	 * @return the receta
	 */
	public BigDecimal getReceta() {
		return Id_receta;
	}

	/**
	 * @param receta the receta to set
	 */
	public void setReceta(BigDecimal receta) {
		this.Id_receta = receta;
	}
	
	
}
