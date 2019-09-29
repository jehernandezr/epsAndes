package negocio;

public class Receta {

	private long id;
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
		this.id=0;
		this.dosis ="";
		this.medicamentos = "";
	}
	
	/**
	 * constructor de una receta
	 * 
	 * @param dosis
	 * @param medicamentos
	 */
	public Receta(long id, String dosis, String medicamentos) {
		this.id=id;
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

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}
