package eps.negocio;

public class Terapia  extends ServicioDeSalud {

	private String tipoTerapia;

	/**
	 * constrcutor por defecto
	 */
	public Terapia() {
		super();
		this.tipoTerapia = null;
	}

	/**
	 * @param tipoTerapia
	 */
	public Terapia(String tipoTerapia) {
		super();
		this.tipoTerapia = tipoTerapia;
	}

	/**
	 * @return the tipoTerapia
	 */
	public String getTipoTerapia() {
		return tipoTerapia;
	}

	/**
	 * @param tipoTerapia the tipoTerapia to set
	 */
	public void setTipoTerapia(String tipoTerapia) {
		this.tipoTerapia = tipoTerapia;
	}


}
