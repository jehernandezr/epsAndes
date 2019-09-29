package negocio;

import java.util.List;

public class Ips {

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
	private List<ServicioDeSalud> serviciosOfrecidos;
	
	/**
	 * representa la lista de medicos adscritos a una ips
	 */
	private List<Medico> medicosAdscritos;

	/**
	 * 
	 */
	private long idMedicosAdscritos;
	
	/**
	 * Constructor por defecto
	 */
	public Ips() {
		this.localizacion = "";
		this.nombre = "";
		this.idMedicosAdscritos=0;
		this.serviciosOfrecidos =(List<ServicioDeSalud>) new java.awt.List();
		this.medicosAdscritos = (List<Medico>) new java.awt.List();
	}
	
	/**
	 * constructor de una Ips
	 * 
	 * @param localizacion
	 * @param nombre
	 * @param serviciosOfrecidos
	 * @param medicosAdscritos
	 */
	public Ips(String localizacion, String nombre, long medicosAdscritos) {
		this.localizacion = localizacion;
		this.nombre = nombre;
		this.idMedicosAdscritos=medicosAdscritos;
		this.serviciosOfrecidos =(List<ServicioDeSalud>) new java.awt.List();
		this.medicosAdscritos = (List<Medico>) new java.awt.List();
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
	public List<ServicioDeSalud> getServiciosOfrecidos() {
		return serviciosOfrecidos;
	}

	/**
	 * @param serviciosOfrecidos the serviciosOfrecidos to set
	 */
	public void setServiciosOfrecidos(List<ServicioDeSalud> serviciosOfrecidos) {
		this.serviciosOfrecidos = serviciosOfrecidos;
	}

	/**
	 * agrega a la lista de servicios ofrecidos uno que empieza a prestar
	 */
	public void addServiciOfrecido(ServicioDeSalud servicio)
	{
		serviciosOfrecidos.add(servicio);
	}
	/**
	 * @return the medicosAdscritos
	 */
	public List<Medico> getMedicosAdscritos() {
		return medicosAdscritos;
	}

	/**
	 * @param medicosAdscritos the medicosAdscritos to set
	 */
	public void setMedicosAdscritos(List<Medico> medicosAdscritos) {
		this.medicosAdscritos = medicosAdscritos;
	}
	
	/**
	 * agrega un medico a la lista de medicos de la Ips
	 */
	public void addMedicoAdscrito(Medico medico)
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
	
}
