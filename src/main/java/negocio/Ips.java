package negocio;

import java.util.List;

public class Ips {

	private String localizacion;
	
	private String nombre;
	
	private List<ServicioDeSalud> serviciosOfrecidos;
	
	private List<Medico> medicosAdscritos;

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
	
	
	
}
