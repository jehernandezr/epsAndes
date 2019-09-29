package negocio;

import java.sql.Date;

public class Orden {

	/**
	 * representa si la orden tiene una cita reservada
	 */
	private boolean citaReservada;
	
	/**
	 * la fecha de la orden
	 */
	private Date fecha;
	
	/**
	 * la id de la orden
	 */
	private long id;
	
	/**
	 * el afiliado asociado a la orden
	 */
	private long afiliadoOrden;
	
	private long servicioSolicitado;
	
	public Orden() {
		this.citaReservada = false;
		this.fecha = new Date(2123245233);
		this.id = 0;
		this.afiliadoOrden = 0;
		this.servicioSolicitado = 0;
	}
	
	/**
	 * @param citaReservada
	 * @param fecha
	 * @param id
	 * @param afiliadoOrden
	 * @param servicioSolicitado
	 */
	public Orden(boolean citaReservada, Date fecha, long id, long afiliadoOrden, long servicioSolicitado) {
		this.citaReservada = citaReservada;
		this.fecha = fecha;
		this.id = id;
		this.afiliadoOrden = afiliadoOrden;
		this.servicioSolicitado = servicioSolicitado;
	}

	/**
	 * @return the citaReservada
	 */
	public boolean isCitaReservada() {
		return citaReservada;
	}

	/**
	 * @param citaReservada the citaReservada to set
	 */
	public void setCitaReservada(boolean citaReservada) {
		this.citaReservada = citaReservada;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * @return the afiliadoOrden
	 */
	public long getAfiliadoOrden() {
		return afiliadoOrden;
	}

	/**
	 * @param afiliadoOrden the afiliadoOrden to set
	 */
	public void setAfiliadoOrden(long afiliadoOrden) {
		this.afiliadoOrden = afiliadoOrden;
	}

	/**
	 * @return the servicioSolicitado
	 */
	public long getServicioSolicitado() {
		return servicioSolicitado;
	}

	/**
	 * @param servicioSolicitado the servicioSolicitado to set
	 */
	public void setServicioSolicitado(long servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}
	
}
