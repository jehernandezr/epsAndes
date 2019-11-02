package eps.negocio;

import java.math.BigDecimal;


public class ServicioDeSalud {

	private BigDecimal id;

	private String fecha_Realizacion;

	private BigDecimal id_Ips;

	/**
	 * Constructor por defecto
	 * 
	 */
	public ServicioDeSalud() {
		this.id = null;
		this.fecha_Realizacion ="";
		this.id_Ips = null;
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
	public ServicioDeSalud(BigDecimal id,  String fechaDeRealizacion,
			long medicoAsignado, BigDecimal ipsAsociada) {
		this.id = id;
		
		this.fecha_Realizacion = fechaDeRealizacion;
		this.id_Ips = ipsAsociada;
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
	 * @return the ipsAsociada
	 */
	public BigDecimal getIpsAsociada() {
		return id_Ips;
	}

	/**
	 * @param ipsAsociada the ipsAsociada to set
	 */
	public void setIpsAsociada(BigDecimal ipsAsociada) {
		this.id_Ips = ipsAsociada;
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


}
