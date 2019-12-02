package eps.negocio;

public class Gerente {

	/**
	 * Atributo Representa Identificacion laboral del usuario
	 */
	private String correo_electronico;

	/**
	 * Atributo que representa la cedula de ciudadania del usuario
	 */
	private String numCc;
	/**
	 * atributo que representa el nombre del usuario
	 */
	private String nombre;
	
	/**
	 * Constructor por defecto
	 */
	public Gerente() {
		this.correo_electronico = "";
		this.numCc = "";
		this.nombre = "";
	}
	
	
	/**
	 * Constructor del gerente
	 * 
	 * @param pCorreo_electronico
	 * @param numCc
	 * @param nombre
	 */
	public Gerente(String pCorreo_electronico, String numCc, String nombre) {
		this.correo_electronico = pCorreo_electronico;
		this.numCc = numCc;
		this.nombre = nombre;
	}
	
	/**
	 * @return the correo_electronico
	 */
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	/**
	 * @param correo_electronico the correo_electronico to set
	 */
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
