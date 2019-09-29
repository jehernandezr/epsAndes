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
	private int id;
	
	/**
	 * el afiliado asociado a la orden
	 */
	private Afiliado afiliadoOrden;
	
	private ServicioDeSalud servicioSolicitado;
	

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
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the afiliadoOrden
	 */
	public Afiliado getAfiliadoOrden() {
		return afiliadoOrden;
	}

	/**
	 * @param afiliadoOrden the afiliadoOrden to set
	 */
	public void setAfiliadoOrden(Afiliado afiliadoOrden) {
		this.afiliadoOrden = afiliadoOrden;
	}

	/**
	 * @return the servicioSolicitado
	 */
	public ServicioDeSalud getServicioSolicitado() {
		return servicioSolicitado;
	}

	/**
	 * @param servicioSolicitado the servicioSolicitado to set
	 */
	public void setServicioSolicitado(ServicioDeSalud servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}
	
}
