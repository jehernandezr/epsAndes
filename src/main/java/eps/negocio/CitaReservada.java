package eps.negocio;

import java.sql.Date;

public class CitaReservada {

	private long id;
	/**
	 * Atributo que representa el estado de la cita
	 */
	private  EstadoCita estado; 
	/**
	 * Atributo que representa la fecha de la cita
	 */
	private Date fechaConsulta; 
	/**
	 * Atributo que representa el afiliado asociado a la cita
	 */
	private long afiliado;
	/**
	 * Atributo que representa el servicio de salud asociado a la cita
	 */
	private long servicioAsociado;

	private long recepcionista;
	
	
	/**
	 * constructor por defecto
	 */
	public CitaReservada() {
		this.id =0;
		this.estado = null;
		this.fechaConsulta = new Date(1232123);
		this.afiliado =0;
		this.servicioAsociado = 0;
		this.recepcionista=0;
	}
	
	/**
	 * constructor de cita
	 * 
	 * @param estado
	 * @param fechaConsulta
	 * @param afiliado
	 * @param servicioAsociado
	 */
	public CitaReservada(EstadoCita estado, long recepcionista, Date fechaConsulta, long afiliado, long servicioAsociado, long id) {
		this.id=id;
		this.estado = estado;
		this.fechaConsulta = fechaConsulta;
		this.afiliado = afiliado;
		this.servicioAsociado = servicioAsociado;
	}

	/**
	 * @return the estado
	 */
	public EstadoCita getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoCita estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaConsulta
	 */
	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	/**
	 * @param fechaConsulta the fechaConsulta to set
	 */
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	/**
	 * @return the afiliado
	 */
	public long getAfiliado() {
		return afiliado;
	}

	/**
	 * @param afiliado the afiliado to set
	 */
	public void setAfiliado(long afiliado) {
		this.afiliado = afiliado;
	}

	/**
	 * @return the servicioAsociado
	 */
	public long getServicioAsociado() {
		return servicioAsociado;
	}

	/**
	 * @param servicioAsociado the servicioAsociado to set
	 */
	public void setServicioAsociado(long servicioAsociado) {
		this.servicioAsociado = servicioAsociado;
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

	/**
	 * @return the recepcionista
	 */
	public long getRecepcionista() {
		return recepcionista;
	}

	/**
	 * @param recepcionista the recepcionista to set
	 */
	public void setRecepcionista(long recepcionista) {
		this.recepcionista = recepcionista;
	}
	
	
	
}
