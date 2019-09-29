package negocio;

import java.util.List;

public class Medico {

	/**
	 * Representa la asociacion con una ips a la cual el medico esta adscrito
	 */
	private List<Ips> ips;
	
	/**
	 * 
	 */
	private long idMedicosAdscritos;
	/**
	 * Representa la especialidad del medico
	 */
	private Especializacion especialidad;
	
	/**
	 * representa el nombre del medico
	 */
	private String nombre;
	
	/**
	 * Representa el numero de registro del medico  
	 */
	private int numeroRegistro;

	public Medico() {
		this.idMedicosAdscritos=0;
		this.setIps((List<Ips>) new java.awt.List());
		this.especialidad = null;
		this.nombre = "";
		this.numeroRegistro = 0;
	}
	
	/**
	 * Cosntructor de un medico
	 * 
	 * @param ips
	 * @param especialidad
	 * @param nombre
	 * @param numeroRegistro
	 */
	public Medico(Especializacion especialidad, String nombre, int numeroRegistro, long medicosAdscritos) {
		this.idMedicosAdscritos= medicosAdscritos;
		this.setIps((List<Ips>) new java.awt.List());
		this.especialidad = especialidad;
		this.nombre = nombre;
		this.numeroRegistro = numeroRegistro;
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

	/**
	 * @return the ips
	 */
	public List<Ips> getIps() {
		return ips;
	}

	/**
	 * @param ips the ips to set
	 */
	public void setIps(List<Ips> ips) {
		this.ips = ips;
	}
	
	/**
	 * agrega una ips a la lista de ips en la cual el medico está adscrito
	 * @param i
	 */
	public void addIps(Ips i)
	{
		ips.add(i);
		
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
