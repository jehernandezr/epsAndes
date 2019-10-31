package eps.negocio;


public class Consulta extends ServicioDeSalud{


	/**
	 * Representa el tipo de consulta que se realiza
	 */
	private TipoDeConsulta tipoConsulta;

	private long receta;

	/**
	 * Constructor por defecto
	 */
	public Consulta() {
		super();
		this.tipoConsulta = null;
		this.receta = 0;
	}

	/**
	 * Constructor de cita
	 * 
	 * @param tipoConsulta
	 * @param recetas
	 */
	public Consulta(TipoDeConsulta tipoConsulta, long receta) {
		super();
		this.tipoConsulta = tipoConsulta;
		this.receta = receta;
	}

	/**
	 * @return the tipoConsulta
	 */
	public TipoDeConsulta getTipoConsulta() {
		return tipoConsulta;
	}

	/**
	 * @param tipoConsulta the tipoConsulta to set
	 */
	public void setTipoConsulta(TipoDeConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	/**
	 * @return the recetas
	 */
	public long getReceta() {
		return receta;
	}

	/**
	 * @param recetas the recetas to set
	 */
	public void setReceta(long receta) {
		this.receta = receta;
	}


}
