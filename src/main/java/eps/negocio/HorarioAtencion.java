package eps.negocio;

import java.time.LocalTime;

public class HorarioAtencion {

	private long id;
	
	/**
	 * Representa los dias de atencion de un servicio de salud</br>
	 * se representan con las letras de la inicial de cada dia excepto el miercoles, el cual </br>
	 * su notacion es X
	 */
	private String diasSemanaAtencion;
	
	/**
	 * Representa la hora de inicio de un servicio
	 */
	private LocalTime horaDeInicio;
	
	/**
	 * Representa la hora de fin de un servicio
	 */
	private LocalTime horaFin;
	
	/**
	 * Representa el numero de afiliados que se atienden
	 */
	private int numeroAfiliados;
	

	/**
	 * Constructor por defecto
	 */
	public HorarioAtencion() {
		this.id=0;
		this.diasSemanaAtencion = "";
		this.horaDeInicio = LocalTime.MIN;
		this.horaFin = LocalTime.MIN;
		this.numeroAfiliados = 0;
	}
	
	/**
	 * Constructor de un Horario
	 * 
	 * @param diasSemanaAtencion
	 * @param horaDeInicio
	 * @param horaFin
	 * @param numeroAfiliados
	 * @param numeroSesiones
	 */
	public HorarioAtencion(long id, String diasSemanaAtencion, LocalTime horaDeInicio, LocalTime horaFin, int numeroAfiliados,
			int numeroSesiones) {
		this.id=id;
		this.diasSemanaAtencion = diasSemanaAtencion;
		this.horaDeInicio = horaDeInicio;
		this.horaFin = horaFin;
		this.numeroAfiliados = numeroAfiliados;
		
	}

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
