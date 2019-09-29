package negocio;

import java.sql.Date;

public class ServicioDeSalud {
	
	private HorarioAtencion horarioAtencion;
	
	private String direccion;
	
	private Date fechaDeRealizacion;

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
	

}
