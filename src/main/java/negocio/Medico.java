package negocio;

public class Medico {

	private Ips ips;
	
	private Especializacion especialidad;
	
	private String nombre;
	
	private int numeroRegistro;

	/**
	 * @return the ips
	 */
	public Ips getIps() {
		return ips;
	}

	/**
	 * @param ips the ips to set
	 */
	public void setIps(Ips ips) {
		this.ips = ips;
	}

	/**
	 * @return the especialidad
	 */
	public Especializacion getEspecialidad() {
		return especialidad;
	}

	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(Especializacion especialidad) {
		this.especialidad = especialidad;
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
	 * @return the numeroRegistro
	 */
	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	/**
	 * @param numeroRegistro the numeroRegistro to set
	 */
	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
	
	
}
