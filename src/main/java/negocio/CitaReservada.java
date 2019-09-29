package negocio;

import java.sql.Date;

public class CitaReservada {

	private  EstadoCita estado; 
	
	private Date fechaConsulta; 
	
	private Afiliado afiliado;
	
	private ServicioDeSalud servicioAsociado;

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
