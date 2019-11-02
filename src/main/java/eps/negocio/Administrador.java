package eps.negocio;

public class Administrador {


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
		this.numCc = "";
		this.nombre = "";
		this.correo="";
	}

	/**
	 * Constructor del admisntrador
	 * 
	 * @param identificacionLaboral
	 * @param numCc
	 * @param nombre
	 */
	public Administrador(String nombre,  String correo,String numCc) {
		this.numCc = numCc;
		this.nombre = nombre;
		this.correo=correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
