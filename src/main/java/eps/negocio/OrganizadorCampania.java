/**
 * 
 */
package eps.negocio;

/**
 * @author jonat
 *
 */
public class OrganizadorCampania {

	private String nombre;
	
	private String correo;
	
	private String num_Cc;

	
	
	
	/**
	 * @param nombre
	 * @param correo
	 * @param num_Cc
	 */
	public OrganizadorCampania(String nombre, String correo, String num_Cc) {
		this.nombre = nombre;
		this.correo = correo;
		this.num_Cc = num_Cc;
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

	/**
	 * @return the num_Cc
	 */
	public String getNum_Cc() {
		return num_Cc;
	}

	/**
	 * @param num_Cc the num_Cc to set
	 */
	public void setNum_Cc(String num_Cc) {
		this.num_Cc = num_Cc;
	}
	
	
}
