package negocio;

public class Receta {

	/**
	 * dosis de los medicamentos
	 */
	private String dosis;
	
	/**
	 * medicamentos prescritos
	 */
	private String medicamentos;

	/**
	 * Constructor por defecto
	 */
	public Receta() {
		this.dosis ="";
		this.medicamentos = "";
	}
	
	/**
	 * constructor de una receta
	 * 
	 * @param dosis
	 * @param medicamentos
	 */
	public Receta(String dosis, String medicamentos) {
		this.dosis = dosis;
		this.medicamentos = medicamentos;
	}

	/**
	 * @return the dosis
	 */
	public String getDosis() {
		return dosis;
	}

	/**
	 * @param dosis the dosis to set
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	/**
	 * @return the medicamentos
	 */
	public String getMedicamentos() {
		return medicamentos;
	}

	/**
	 * @param medicamentos the medicamentos to set
	 */
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
}
