package negocio;

public class ConsultaUrgencia extends ServicioDeSalud{

	private boolean fueDadoAlta;
	
	private int triage;
	
	private Receta receta;

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
	public Receta getReceta() {
		return receta;
	}

	/**
	 * @param receta the receta to set
	 */
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	
}
