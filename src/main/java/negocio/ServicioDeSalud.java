package negocio;

import java.sql.Date;

public class ServicioDeSalud {
	
	private int id;
	
	private HorarioAtencion horarioAtencion;
	
	private String direccion;
	
	private Date fechaDeRealizacion;
	
	private Medico medicoAsignado;
	
	private Ips ipsAsociada;

	/**
	 * @return the horarioAtencion
	 */
	public HorarioAtencion getHorarioAtencion() {
		return horarioAtencion;
	}

	/**
	 * @param horarioAtencion the horarioAtencion to set
	 */
	public void setHorarioAtencion(HorarioAtencion horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the fechaDeRealizacion
	 */
	public Date getFechaDeRealizacion() {
		return fechaDeRealizacion;
	}

	/**
	 * @param fechaDeRealizacion the fechaDeRealizacion to set
	 */
	public void setFechaDeRealizacion(Date fechaDeRealizacion) {
		this.fechaDeRealizacion = fechaDeRealizacion;
	}

	/**
	 * @return the medicoAsignado
	 */
	public Medico getMedicoAsignado() {
		return medicoAsignado;
	}

	/**
	 * @param medicoAsignado the medicoAsignado to set
	 */
	public void setMedicoAsignado(Medico medicoAsignado) {
		this.medicoAsignado = medicoAsignado;
	}

	/**
	 * @return the ipsAsociada
	 */
	public Ips getIpsAsociada() {
		return ipsAsociada;
	}

	/**
	 * @param ipsAsociada the ipsAsociada to set
	 */
	public void setIpsAsociada(Ips ipsAsociada) {
		this.ipsAsociada = ipsAsociada;
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
	

}
