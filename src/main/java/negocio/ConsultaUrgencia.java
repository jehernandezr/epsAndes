package negocio;

public class ConsultaUrgencia extends ServicioDeSalud{

	/**
	 * representa si el paciente fue dado de alta
	 */
	private boolean fueDadoAlta;
	
	/**
	 * representa la urgencia de la consulta en una escala del 1 al 5
	 */
	private int triage;
	
	/**
	 * representa la receta si se genera
	 */
	private long receta;

	/**
	 * Constructor por defecto
	 */
	public ConsultaUrgencia() {
		super();
		this.fueDadoAlta = false;
		this.triage = 0;
		this.receta = 0;
	}
	
	/**
	 * constructor de una consulta de emergencia
	 * 
	 * @param fueDadoAlta
	 * @param triage
	 * @param receta
	 */
	public ConsultaUrgencia(boolean fueDadoAlta, int triage, long receta) {
		super();
		this.fueDadoAlta = fueDadoAlta;
		this.triage = triage;
		this.receta = receta;
	}

	/**
	 * @return the fueDadoAlta
	 */
	public boolean isFueDadoAlta() {
		return fueDadoAlta;
	}

	/**
	 * @param fueDadoAlta the fueDadoAlta to set
	 */
	public void setFueDadoAlta(boolean fueDadoAlta) {
		this.fueDadoAlta = fueDadoAlta;
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
	public long getReceta() {
		return receta;
	}

	/**
	 * @param receta the receta to set
	 */
	public void setReceta(long receta) {
		this.receta = receta;
	}
	
	
}
