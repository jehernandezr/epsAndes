package negocio;

public class Examen extends ServicioDeSalud {

	/**
	 * representa la informacion del examen
	 */
	private String tipoExamen;

	public Examen() {
		super();
		this.tipoExamen = "";
	}
	
	/**
	 * Constructor de un examen
	 * 
	 * @param tipoExamen
	 */
	public Examen(String tipoExamen) {
		super();
		this.tipoExamen = tipoExamen;
	}

	/**
	 * @return the tipoExamen
	 */
	public String getTipoExamen() {
		return tipoExamen;
	}

	/**
	 * @param tipoExamen the tipoExamen to set
	 */
	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}
	
	
}
