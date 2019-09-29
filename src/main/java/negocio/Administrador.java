package negocio;

public class Administrador {



	/**
	 * Atributo Representa Identificacion laboral del usuario
	 */
	private int identificacionLaboral;

	/**
	 * Atributo que representa la cedula de ciudadania del usuario
	 */
	private String numCc;
	/**
	 * atributo que representa el nombre del usuario
	 */
	private String nombre;

	/**
	 * Constructor  por defecto  del admisntrador
	 */
	public Administrador() {
		this.identificacionLaboral = 0;
		this.numCc = "";
		this.nombre = "";
	}

	/**
	 * Constructor del admisntrador
	 * 
	 * @param identificacionLaboral
	 * @param numCc
	 * @param nombre
	 */
	public Administrador(int identificacionLaboral, String numCc, String nombre) {
		this.identificacionLaboral = identificacionLaboral;
		this.numCc = numCc;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdentificacionLaboral() {
		return identificacionLaboral;
	}

	public void setIdentificacionLaboral(int identificacionLaboral) {
		this.identificacionLaboral = identificacionLaboral;
	}

	/**
	 * @return the numCc
	 */
	public String getNumCc() {
		return numCc;
	}

	/**
	 * @param numCc the numCc to set
	 */
	public void setNumCc(String numCc) {
		this.numCc = numCc;
	}

}
