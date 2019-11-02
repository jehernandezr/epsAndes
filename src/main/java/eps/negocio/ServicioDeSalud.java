package eps.negocio;

import java.math.BigDecimal;


public class ServicioDeSalud {

	private BigDecimal id;

	private String fecha_Realizacion;

	private BigDecimal id_Ips;

	

	private BigDecimal id_Consulta;
	private BigDecimal id_Consulta_Urgencia;
	
	private BigDecimal id_Examenes; 
	
	private BigDecimal id_Terapias; 
	
	private BigDecimal id_Procedimiento_Especializado; 
	
	
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public ServicioDeSalud() {
		super();
		this.setId(id);
		this.fecha_Realizacion = "";
		this.id_Ips = null;
		this.id_Consulta = null;
		this.id_Consulta_Urgencia = null;
		this.id_Examenes = null;
		this.id_Terapias = null;
		this.id_Procedimiento_Especializado = null;
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
<<<<<<< HEAD
=======
	 * Constructor de unservicio de salud
	 * 
>>>>>>> dc998da77a59a2e174e4478826e94beed4284b59
	 * @param id
	 * @param fecha_Realizacion
	 * @param id_Ips
	 * @param id_Consulta
	 * @param id_Consulta_Urgencia
	 * @param id_Examenes
	 * @param id_Terapias
	 * @param id_Procedimiento_Especializado
	 */
	public ServicioDeSalud(BigDecimal id, String fecha_Realizacion, BigDecimal id_Ips, BigDecimal id_Consulta,
			BigDecimal id_Consulta_Urgencia, BigDecimal id_Examenes, BigDecimal id_Terapias,
			BigDecimal id_Procedimiento_Especializado) {
		super();
		this.setId(id);
		this.fecha_Realizacion = fecha_Realizacion;
		this.id_Ips = id_Ips;
		this.id_Consulta = id_Consulta;
		this.id_Consulta_Urgencia = id_Consulta_Urgencia;
		this.id_Examenes = id_Examenes;
		this.id_Terapias = id_Terapias;
		this.id_Procedimiento_Especializado = id_Procedimiento_Especializado;
	}



	/**
	 * @return the fechaDeRealizacion
	 */
	public String getFecha_Realizacion() {
		return fecha_Realizacion;
	}

	/**
	 * @param fechaDeRealizacion the fechaDeRealizacion to set
	 */
	public void setFecha_Realizacion(String fechaDeRealizacion) {
		this.fecha_Realizacion = fechaDeRealizacion;
	}



	/**
	 * @return the id_Ips
	 */
	public BigDecimal getId_Ips() {
		return id_Ips;
	}

	/**
	 * @param id_Ips the id_Ips to set
	 */
	public void setId_Ips(BigDecimal id_Ips) {
		this.id_Ips = id_Ips;
	}

	/**
	 * @return the id_Consulta
	 */
	public BigDecimal getId_Consulta() {
		return id_Consulta;
	}

	/**
	 * @param id_Consulta the id_Consulta to set
	 */
	public void setId_Consulta(BigDecimal id_Consulta) {
		this.id_Consulta = id_Consulta;
	}

	/**
	 * @return the id_Consulta_Urgencia
	 */
	public BigDecimal getId_Consulta_Urgencia() {
		return id_Consulta_Urgencia;
	}

	/**
	 * @param id_Consulta_Urgencia the id_Consulta_Urgencia to set
	 */
	public void setId_Consulta_Urgencia(BigDecimal id_Consulta_Urgencia) {
		this.id_Consulta_Urgencia = id_Consulta_Urgencia;
	}

	/**
	 * @return the id_Examnes
	 */
	public BigDecimal getId_Examnes() {
		return id_Examenes;
	}

	/**
	 * @param id_Examnes the id_Examnes to set
	 */
	public void setId_Examenes(BigDecimal id_Examnes) {
		this.id_Examenes = id_Examnes;
	}

	/**
	 * @return the id_Terapias
	 */
	public BigDecimal getId_Terapias() {
		return id_Terapias;
	}

	/**
	 * @param id_Terapias the id_Terapias to set
	 */
	public void setId_Terapias(BigDecimal id_Terapias) {
		this.id_Terapias = id_Terapias;
	}

	/**
	 * @return the id_Procedimiento_Especializado
	 */
	public BigDecimal getId_Procedimiento_Especializado() {
		return id_Procedimiento_Especializado;
	}

	/**
	 * @param id_Procedimiento_Especializado the id_Procedimiento_Especializado to set
	 */
	public void setId_Procedimiento_Especializado(BigDecimal id_Procedimiento_Especializado) {
		this.id_Procedimiento_Especializado = id_Procedimiento_Especializado;
	}

	



}
