package eps.negocio;

public class Recepcionista {

	
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
	 * Constructor por defecto
	 */
	
	public Recepcionista() {
		this.identificacionLaboral = 0;
		this.numCc = "";
		this.nombre = "";
	}
	/**
	 * Constructor de Recepcionista
	 * 
	 * @param identificacionLaboral
	 * @param numCc
	 * @param nombre
	 */
	public Recepcionista(int identificacionLaboral, String numCc, String nombre) {
		this.identificacionLaboral = identificacionLaboral;
		this.numCc = numCc;
		this.nombre = nombre;
	}
	
	/**
	 * @return the identificacionLaboral
	 */
	public int getIdentificacionLaboral() {
		return identificacionLaboral;
	}
	/**
	 * @param identificacionLaboral the identificacionLaboral to set
	 */
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
