package eps.negocio;

import java.math.BigDecimal;


public class CitaReservada {

	private BigDecimal id;
	/**
	 * Atributo que representa el estado de la cita
	 */
	private  String estado; 
	/**
	 * Atributo que representa la fecha de la cita
	 */
	private String fecha_Consulta; 
	/**
	 * Atributo que representa el afiliado asociado a la cita
	 */
	private BigDecimal id_Afiliado;
	/**
	 * Atributo que representa el servicio de salud asociado a la cita
	 */
	private BigDecimal servicio_Asociado;

	private BigDecimal id_Recepcionista;
	
	
	/**
	 * constructor por defecto
	 */
	public CitaReservada() {
		this.id =null;
		this.estado = null;
		this.fecha_Consulta = "";
		this.id_Afiliado =null;
		this.servicio_Asociado = null;
		this.id_Recepcionista=null;
	}
	
	/**
	 * constructor de cita
	 * 
	 * @param estado
	 * @param fechaConsulta
	 * @param afiliado
	 * @param servicioAsociado
	 */
	public CitaReservada(BigDecimal id,EstadoCita estado,BigDecimal afiliado,String fechaConsulta,  BigDecimal recepcionista,  BigDecimal servicioAsociado ) {
		this.id=id;
		setEstado(estado);
		this.fecha_Consulta = fechaConsulta;
		this.id_Afiliado = afiliado;
		this.servicio_Asociado = servicioAsociado;
		this.id_Recepcionista=recepcionista;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoCita estado) {
		this.estado = estado.toString().toLowerCase();
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaConsulta
	 */
	public String getFecha_Consulta() {
		return fecha_Consulta;
	}

	/**
	 * @param fechaConsulta the fechaConsulta to set
	 */
	public void setFecha_Consulta(String fechaConsulta) {
		this.fecha_Consulta = fechaConsulta;
	}

	/**
	 * @return the afiliado
	 */
	public BigDecimal getId_Afiliado() {
		return id_Afiliado;
	}

	/**
	 * @param afiliado the afiliado to set
	 */
	public void setId_Afiliado(BigDecimal afiliado) {
		this.id_Afiliado = afiliado;
	}

	/**
	 * @return the servicioAsociado
	 */
	public BigDecimal getServicio_Asociado() {
		return servicio_Asociado;
	}

	/**
	 * @param servicioAsociado the servicioAsociado to set
	 */
	public void setServicio_Asociado(BigDecimal servicioAsociado) {
		this.servicio_Asociado = servicioAsociado;
	}

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the recepcionista
	 */
	public BigDecimal getId_Recepcionista() {
		return id_Recepcionista;
	}

	/**
	 * @param recepcionista the recepcionista to set
	 */
	public void setId_Recepcionista(BigDecimal recepcionista) {
		this.id_Recepcionista = recepcionista;
	}
	
	
	
}
