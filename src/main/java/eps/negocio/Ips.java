package eps.negocio;

import java.util.List;

public class Ips {

	private long id;

	/**
	 * representa la localizacion de la ips
	 */
	private String localizacion;

	/**
	 * Representa el nombre de la Ips
	 */
	private String nombre;

	/**
	 * Representa la lista de servicios ofrecidos por una Ips
	 */
	private List<Long> serviciosOfrecidos;

	/**
	 * representa la lista de medicos adscritos a una ips
	 */
	private List<Long> medicosAdscritos;

	/**
	 * 
	 */
	private long idMedicosAdscritos;

	/**
	 * Constructor por defecto
	 */
	public Ips() {
		this.id=0;
		this.localizacion = "";
		this.nombre = "";
		this.idMedicosAdscritos=0;
		this.serviciosOfrecidos =(List<Long>) new java.awt.List();
		this.medicosAdscritos = (List<Long>) new java.awt.List();
	}

	/**
	 * constructor de una Ips
	 * 
	 * @param localizacion
	 * @param nombre
	 * @param serviciosOfrecidos
	 * @param medicosAdscritos
	 */
	public Ips(long id,String localizacion, String nombre, long medicosAdscritos) {
		this.id=id;
		this.localizacion = localizacion;
		this.nombre = nombre;
		this.idMedicosAdscritos=medicosAdscritos;
		this.serviciosOfrecidos =(List<Long>) new java.awt.List();
		this.medicosAdscritos = (List<Long>) new java.awt.List();
	}

	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
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
	 * @return the serviciosOfrecidos
	 */
	public List<Long> getServiciosOfrecidos() {
		return serviciosOfrecidos;
	}

	/**
	 * @param serviciosOfrecidos the serviciosOfrecidos to set
	 */
	public void setServiciosOfrecidos(List<Long> serviciosOfrecidos) {
		this.serviciosOfrecidos = serviciosOfrecidos;
	}

	/**
	 * agrega a la lista de servicios ofrecidos uno que empieza a prestar
	 */
	public void addServiciOfrecido(Long servicio)
	{
		serviciosOfrecidos.add(servicio);
	}
	/**
	 * @return the medicosAdscritos
	 */
	public List<Long> getMedicosAdscritos() {
		return medicosAdscritos;
	}

	/**
	 * @param medicosAdscritos the medicosAdscritos to set
	 */
	public void setMedicosAdscritos(List<Long> medicosAdscritos) {
		this.medicosAdscritos = medicosAdscritos;
	}

	/**
	 * agrega un medico a la lista de medicos de la Ips
	 */
	public void addMedicoAdscrito(Long medico)
	{
		medicosAdscritos.add(medico);
	}

	/**
	 * @return the idMedicosAdscritos
	 */
	public long getIdMedicosAdscritos() {
		return idMedicosAdscritos;
	}

	/**
	 * @param idMedicosAdscritos the idMedicosAdscritos to set
	 */
	public void setIdMedicosAdscritos(long idMedicosAdscritos) {
		this.idMedicosAdscritos = idMedicosAdscritos;
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
