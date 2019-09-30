/**
 * 
 */
package negocio;

/**
 * @author jonat
 *
 */
public class ServiciosRequeridos {

	/**
	 * id de servicio requerido
	 */
	private long id;
	
	/**
	 * id de la relacion con la hospitalizacion
	 */
	private long idHospitalizacion;
	
	/**
	 * id de la relacion con el servicio necesitado
	 */
	private long idServicio;

	/**
	 * Constructor por defecto
	 * 
	 */
	public ServiciosRequeridos() {
		this.id = 0;
		this.idHospitalizacion = 0;
		this.idServicio = 0;
	}
	
	/**
	 * @param id
	 * @param idHospitalizacion
	 * @param idServicio
	 */
	public ServiciosRequeridos(long id, long idHospitalizacion, long idServicio) {
		this.id = id;
		this.idHospitalizacion = idHospitalizacion;
		this.idServicio = idServicio;
	}

	/**
	 * @return the idServicio
	 */
	public long getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the idHospitalizacion
	 */
	public long getIdHospitalizacion() {
		return idHospitalizacion;
	}

	/**
	 * @param idHospitalizacion the idHospitalizacion to set
	 */
	public void setIdHospitalizacion(long idHospitalizacion) {
		this.idHospitalizacion = idHospitalizacion;
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
