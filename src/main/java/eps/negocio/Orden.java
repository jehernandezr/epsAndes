package eps.negocio;

import java.math.BigDecimal;

public class Orden {

	/**
	 * representa si la orden tiene una cita reservada
	 */
	private String cita_Reservada;
	
	/**
	 * la fecha de la orden
	 */
	private String fecha;
	
	/**
	 * la id de la orden
	 */
	private BigDecimal id;
	
	/**
	 * el afiliado asociado a la orden
	 */
	private BigDecimal id_afiliado;
	/**
	 * id del servicio asociado a la orden
	 */
	private BigDecimal Id_servicio;
	
	
	/**
	 * el tipo de servicio de la orden
	 */
	private String tipo_Servicio;
	public Orden() {
		this.cita_Reservada = "";
		this.fecha = "";
		this.id = null;
		this.id_afiliado = null;
		this.Id_servicio = null;
		this.tipo_Servicio="";
	}
	
	/**
	 * @param citaReservada
	 * @param fecha
	 * @param id
	 * @param afiliadoOrden
	 * @param servicioSolicitado
	 */
	public Orden(BigDecimal id,boolean citaReservada, String fecha,  BigDecimal afiliadoOrden, BigDecimal servicioSolicitado,String tipoServicio) {
		setCita_Reservada(citaReservada);
		this.fecha = fecha;
		this.id = id;
		this.id_afiliado = afiliadoOrden;
		this.Id_servicio = servicioSolicitado;
		this.tipo_Servicio=tipoServicio;
	}

	/**
	 * @return the citaReservada
	 */
	public boolean isCita_Reservada() {
		return cita_Reservada=="T"? true:false;
	}

	/**
	 * @return the citaReservada
	 */
	public String getCita_Reservada() {
		return cita_Reservada;
	}
	
	/**
	 * @param citaReservada the citaReservada to set
	 */
	public void setCita_Reservada(boolean citaReservada) {
		this.cita_Reservada = citaReservada==true?"T":"F";
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	 * @return the afiliadoOrden
	 */
	public BigDecimal getId_Afiliado() {
		return id_afiliado;
	}

	/**
	 * @param afiliadoOrden the afiliadoOrden to set
	 */
	public void setId_Afiliado(BigDecimal afiliadoOrden) {
		this.id_afiliado = afiliadoOrden;
	}

	/**
	 * @return the servicioSolicitado
	 */
	public BigDecimal getId_Servicio() {
		return Id_servicio;
	}

	/**
	 * @param servicioSolicitado the servicioSolicitado to set
	 */
	public void setId_Servicio(BigDecimal servicioSolicitado) {
		this.Id_servicio = servicioSolicitado;
	}

	/**
	 * @return the tipo_Servicio
	 */
	public String getTipo_Servicio() {
		return tipo_Servicio;
	}

	/**
	 * @param tipo_Servicio the tipo_Servicio to set
	 */
	public void setTipo_Servicio(String tipo_Servicio) {
		this.tipo_Servicio = tipo_Servicio;
	}
	
}
