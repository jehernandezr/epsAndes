package negocio;

public class RolesEnSistema {

	/***
	 * representa cada booleano si hay un rol activo
	 */
	private boolean hayAdmins;
	private boolean hayAfiliados;
	private boolean hayGerente;
	private boolean hayMedicos;
	private boolean hayRecepcionistas;
	
	/**
	 * Constructor por defecto
	 */
	public RolesEnSistema() {
		this.hayAdmins = false;
		this.hayAfiliados = false;
		this.hayGerente =false;
		this.hayMedicos = false;
		this.hayRecepcionistas = false;
	}
	
	/**
	 * Constructor de los roles en le sistema
	 * 
	 * @param hayAdmins
	 * @param hayAfiliados
	 * @param hayGerente
	 * @param hayMedicos
	 * @param hayRecepcionistas
	 */
	public RolesEnSistema(boolean hayAdmins, boolean hayAfiliados, boolean hayGerente, boolean hayMedicos,
			boolean hayRecepcionistas) {
		this.hayAdmins = hayAdmins;
		this.hayAfiliados = hayAfiliados;
		this.hayGerente = hayGerente;
		this.hayMedicos = hayMedicos;
		this.hayRecepcionistas = hayRecepcionistas;
	}
	/**
	 * @return the hayAdmins
	 */
	public boolean isHayAdmins() {
		return hayAdmins;
	}
	/**
	 * @param hayAdmins the hayAdmins to set
	 */
	public void setHayAdmins(boolean hayAdmins) {
		this.hayAdmins = hayAdmins;
	}
	/**
	 * @return the hayAfiliados
	 */
	public boolean isHayAfiliados() {
		return hayAfiliados;
	}
	/**
	 * @param hayAfiliados the hayAfiliados to set
	 */
	public void setHayAfiliados(boolean hayAfiliados) {
		this.hayAfiliados = hayAfiliados;
	}
	/**
	 * @return the hayGerente
	 */
	public boolean isHayGerente() {
		return hayGerente;
	}
	/**
	 * @param hayGerente the hayGerente to set
	 */
	public void setHayGerente(boolean hayGerente) {
		this.hayGerente = hayGerente;
	}
	/**
	 * @return the hayMedicos
	 */
	public boolean isHayMedicos() {
		return hayMedicos;
	}
	/**
	 * @param hayMedicos the hayMedicos to set
	 */
	public void setHayMedicos(boolean hayMedicos) {
		this.hayMedicos = hayMedicos;
	}
	/**
	 * @return the hayRecepcionistas
	 */
	public boolean isHayRecepcionistas() {
		return hayRecepcionistas;
	}
	/**
	 * @param hayRecepcionistas the hayRecepcionistas to set
	 */
	public void setHayRecepcionistas(boolean hayRecepcionistas) {
		this.hayRecepcionistas = hayRecepcionistas;
	}
	
}
