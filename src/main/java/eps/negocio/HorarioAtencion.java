package eps.negocio;

import java.math.BigDecimal;

public class HorarioAtencion {

	private BigDecimal id;
	
	/**
	 * Representa los dias de atencion de un servicio de salud</br>
	 * se representan con las letras de la inicial de cada dia excepto el miercoles, el cual </br>
	 * su notacion es X
	 */
	private String dias_Sem_Atencion;
	
	/**
	 * Representa la hora de inicio de un servicio
	 */
	private String hora_Inicial;
	
	/**
	 * Representa la hora de fin de un servicio
	 */
	private String hora_Fin;
	
	/**
	 * Representa el numero de afiliados que se atienden
	 */
	private int num_Afiliados;
	
	
	/**
	 * id del servicio al cual corresponde el horario
	 */
	private BigDecimal id_Servicio;

	/**
	 * Constructor por defecto
	 */
	public HorarioAtencion() {
		this.id=null;
		this.dias_Sem_Atencion = "";
		this.hora_Inicial = "";
		this.hora_Fin = "";
		this.num_Afiliados = 0;
		this.id_Servicio =null;
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
	public HorarioAtencion(BigDecimal id,BigDecimal id_Servico, String diasSemanaAtencion, String horaDeInicio, String horaFin, int numeroAfiliados) {
		this.id=id;
		this.dias_Sem_Atencion = diasSemanaAtencion;
		this.hora_Inicial = horaDeInicio;
		this.hora_Fin = horaFin;
		this.num_Afiliados = numeroAfiliados;
		this.id_Servicio=id_Servico;
		
	}

	/**
	 * @return the diasSemanaAtencion
	 */
	public String getDias_Sem_Atencion() {
		return dias_Sem_Atencion;
	}

	/**
	 * @param diasSemanaAtencion the diasSemanaAtencion to set
	 */
	public void setDias_Sem_Atencion(String diasSemanaAtencion) {
		this.dias_Sem_Atencion = diasSemanaAtencion;
	}

	/**
	 * @return the horaDeInicio
	 */
	public String getHora_Inicial() {
		return hora_Inicial;
	}

	/**
	 * @param horaDeInicio the horaDeInicio to set
	 */
	public void setHora_Inicial(String horaDeInicio) {
		this.hora_Inicial = horaDeInicio;
	}

	/**
	 * @return the horaFin
	 */
	public String getHora_Fin() {
		return hora_Fin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHora_Fin(String horaFin) {
		this.hora_Fin = horaFin;
	}

	/**
	 * @return the numeroAfiliados
	 */
	public int getNum_Afiliados() {
		return num_Afiliados;
	}

	/**
	 * @param numeroAfiliados the numeroAfiliados to set
	 */
	public void setNum_Afiliados(int numeroAfiliados) {
		this.num_Afiliados = numeroAfiliados;
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
	 * @return the id_Servicio
	 */
	public BigDecimal getId_Servicio() {
		return id_Servicio;
	}

	/**
	 * @param id_Servicio the id_Servicio to set
	 */
	public void setId_Servicio(BigDecimal id_Servicio) {
		this.id_Servicio = id_Servicio;
	}
	
}
