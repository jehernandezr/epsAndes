package negocio;

import java.sql.Date;

public class CitaReservada {

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
	private Afiliado afiliado;
	/**
	 * Atributo que representa el servicio de salud asociado a la cita
	 */
	private ServicioDeSalud servicioAsociado;

	/**
	 * constructor por defecto
	 */
	public CitaReservada() {
		this.estado = null;
		this.fechaConsulta = new Date(1232123);
		this.afiliado = new Afiliado();
		this.servicioAsociado = new ServicioDeSalud();
	}
	
	/**
	 * constructor de cita
	 * 
	 * @param estado
	 * @param fechaConsulta
	 * @param afiliado
	 * @param servicioAsociado
	 */
	public CitaReservada(EstadoCita estado, Date fechaConsulta, Afiliado afiliado, ServicioDeSalud servicioAsociado) {
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
	public Afiliado getAfiliado() {
		return afiliado;
	}

	/**
	 * @param afiliado the afiliado to set
	 */
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	/**
	 * @return the servicioAsociado
	 */
	public ServicioDeSalud getServicioAsociado() {
		return servicioAsociado;
	}

	/**
	 * @param servicioAsociado the servicioAsociado to set
	 */
	public void setServicioAsociado(ServicioDeSalud servicioAsociado) {
		this.servicioAsociado = servicioAsociado;
	}
	
	
	
}
