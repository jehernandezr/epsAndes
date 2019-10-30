package negocio;

public class Administrador {

	/**
	 * Atributo Representa Identificacion laboral del usuario
	 */
	private long identificacionLaboral;

	/**
	 * Atributo que representa la cedula de ciudadania del usuario
	 */
	private String numCc;
	/**
	 * atributo que representa el nombre del usuario
	 */
	private String nombre;

	private String correo;

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
	public Administrador(long identificacionLaboral, String numCc, String nombre, String correo) {
		this.identificacionLaboral = identificacionLaboral;
		this.numCc = numCc;
		this.nombre = nombre;
		this.setCorreo(correo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdentificacionLaboral() {
		return identificacionLaboral;
	}

	public void setIdentificacionLaboral(long identificacionLaboral) {
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

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
