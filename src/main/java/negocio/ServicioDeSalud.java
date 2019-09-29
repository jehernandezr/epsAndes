package negocio;

import java.sql.Date;

public class ServicioDeSalud {

	private long id;

	private long horarioAtencion;

	private String direccion;

	private Date fechaDeRealizacion;

	private long medicoAsignado;

	private long ipsAsociada;

	/**
	 * Constructor por defecto
	 * 
	 */
	public ServicioDeSalud() {
		this.id = 0;
		this.horarioAtencion = 0;
		this.direccion = "";
		this.fechaDeRealizacion = new Date(214524);
		this.medicoAsignado = 0;
		this.ipsAsociada = 0;
	}
	
	/**
	 * COnstructor de unservicio de salud
	 * 
	 * @param id
	 * @param horarioAtencion
	 * @param direccion
	 * @param fechaDeRealizacion
	 * @param medicoAsignado
	 * @param ipsAsociada
	 */
	public ServicioDeSalud(long id, long horarioAtencion, String direccion, Date fechaDeRealizacion,
			long medicoAsignado, long ipsAsociada) {
		this.id = id;
		this.horarioAtencion = horarioAtencion;
		this.direccion = direccion;
		this.fechaDeRealizacion = fechaDeRealizacion;
		this.medicoAsignado = medicoAsignado;
		this.ipsAsociada = ipsAsociada;
	}

	/**
	 * @return the horarioAtencion
	 */
	public long getHorarioAtencion() {
		return horarioAtencion;
	}

	/**
	 * @param horarioAtencion the horarioAtencion to set
	 */
	public void setHorarioAtencion(long horarioAtencion) {
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
	public long getMedicoAsignado() {
		return medicoAsignado;
	}

	/**
	 * @param medicoAsignado the medicoAsignado to set
	 */
	public void setMedicoAsignado(long medicoAsignado) {
		this.medicoAsignado = medicoAsignado;
	}

	/**
	 * @return the ipsAsociada
	 */
	public long getIpsAsociada() {
		return ipsAsociada;
	}

	/**
	 * @param ipsAsociada the ipsAsociada to set
	 */
	public void setIpsAsociada(long ipsAsociada) {
		this.ipsAsociada = ipsAsociada;
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


}
