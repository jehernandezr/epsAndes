package negocio;

import java.time.LocalTime;

public class HorarioAtencion {

	private String diasSemanaAtencion;
	
	private LocalTime horaDeInicio;
	
	private LocalTime horaFin;
	
	private int numeroAfiliados;
	
	private int numeroSesiones;

	/**
	 * @return the diasSemanaAtencion
	 */
	public String getDiasSemanaAtencion() {
		return diasSemanaAtencion;
	}

	/**
	 * @param diasSemanaAtencion the diasSemanaAtencion to set
	 */
	public void setDiasSemanaAtencion(String diasSemanaAtencion) {
		this.diasSemanaAtencion = diasSemanaAtencion;
	}

	/**
	 * @return the horaDeInicio
	 */
	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}

	/**
	 * @param horaDeInicio the horaDeInicio to set
	 */
	public void setHoraDeInicio(LocalTime horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
	}

	/**
	 * @return the horaFin
	 */
	public LocalTime getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * @return the numeroAfiliados
	 */
	public int getNumeroAfiliados() {
		return numeroAfiliados;
	}

	/**
	 * @param numeroAfiliados the numeroAfiliados to set
	 */
	public void setNumeroAfiliados(int numeroAfiliados) {
		this.numeroAfiliados = numeroAfiliados;
	}

	/**
	 * @return the numeroSesiones
	 */
	public int getNumeroSesiones() {
		return numeroSesiones;
	}

	/**
	 * @param numeroSesiones the numeroSesiones to set
	 */
	public void setNumeroSesiones(int numeroSesiones) {
		this.numeroSesiones = numeroSesiones;
	}
	
}
