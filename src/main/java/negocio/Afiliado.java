package negocio;

import java.sql.Date;
import java.util.List;

public class Afiliado {


	/**
	 * Atributo que representa la fecha de nacimiento de un afiliado
	 */
	private Date fechaDeNacimiento;
	/**
	 * Atrubuto que representa el nombre de un afiliado
	 */
	private String nombre;
	/**
	 * Atributo que representa el numero de cedula de un afiliado
	 */
	private String numeroDeDocumento;

	/**
	 * Atributo que representa el tipo de documento de un afiliado
	 */
	private TipoDeDocumento tipoDocumento;

	/**
	 * Atributo que representa la lista de citas reservadas de un afiliado
	 */
	private List<Long> citasRecervadas;

	/**
	 * Atributo que representa la lista de ordenes de servicios de un afiliado
	 */
	private List<Long> ordenes;

	
	/**
	 * constructor por defecto
	 */
	@SuppressWarnings("deprecation")
	public Afiliado() {
		this.fechaDeNacimiento = new Date(0, 0, 0);
		this.nombre = "";
		this.numeroDeDocumento ="";
		this.tipoDocumento = null;
		this.citasRecervadas = (List<Long>) new java.awt.List();
		this.ordenes = (List<Long>) new java.awt.List();
	}

	/**
	 * Constructor de un afiliado
	 * 
	 * @param fechaDeNacimiento
	 * @param nombre
	 * @param numeroDeDocumento
	 * @param tipoDocumento
	 * @param citasRecervadas
	 * @param ordenes
	 */
	public Afiliado(Date fechaDeNacimiento, String nombre, String numeroDeDocumento, TipoDeDocumento tipoDocumento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nombre = nombre;
		this.numeroDeDocumento = numeroDeDocumento;
		this.tipoDocumento = tipoDocumento;
		this.citasRecervadas = (List<Long>) new java.awt.List();
		this.ordenes = (List<Long>) new java.awt.List();
	}

	/**
	 * @return the fechaDeNacimiento
	 */
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	/**
	 * @param fechaDeNacimiento the fechaDeNacimiento to set
	 */
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
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
	 * @return the numeroDeDocumento
	 */
	public String getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	/**
	 * @param numeroDeDocumento the numeroDeDocumento to set
	 */
	public void setNumeroDeDocumento(String numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	/**
	 * @return the tipoDocumento
	 */
	public TipoDeDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDeDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * agrega a la lista
	 */
	private void addCitaRecervada(Long cita)
	{
		citasRecervadas.add(cita);
	}

	/**
	 * agrega a la lista
	 */
	private void addOrden(Long orden)
	{ordenes.add(orden);
	}

	/**
	 * @return the citasRecervadas
	 */
	public List<Long> getCitasRecervadas() {
		return citasRecervadas;
	}

	/**
	 * @param citasRecervadas the citasRecervadas to set
	 */
	public void setCitasRecervadas(List<Long> citasRecervadas) {
		this.citasRecervadas = citasRecervadas;
	}

	/**
	 * @return the ordenes
	 */
	public List<Long> getOrdenes() {
		return ordenes;
	}

	/**
	 * @param ordenes the ordenes to set
	 */
	public void setOrdenes(List<Long> ordenes) {
		this.ordenes = ordenes;
	} 
}
