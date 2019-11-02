package eps.negocio;

import java.math.BigDecimal;
public class Medico {


	/**
	 * 
	 */
	private BigDecimal id_Adscritos;
	
	/**
	 * Representa la especialidad del medico
	 */
	private String especialidad;
	
	/**
	 * representa el nombre del medico
	 */
	private String nombre;
	
	/**
	 * Representa el numero de registro del medico  
	 */
	private BigDecimal num_Registro;

	/**
	 * 
	 */
	private BigDecimal id_Servicio_Asociado;
	
	/**
	 *
	 */
	private String correo_Electronico;

	/**
	 * 
	 */
	private String num_Cc;

	

	/**
	 * Constructor de la clase
	 * @param idAdscritos
	 * @param especialidad
	 * @param nombre
	 * @param numRegistro
	 * @param idServicoAsociado
	 * @param correoElectronico
	 */
	public Medico(String numCc,String nombre,BigDecimal numRegistro, Especializacion especialidad, BigDecimal idServicoAsociado, 
			 String correoElectronico, BigDecimal idAdscritos) {
		this.num_Cc=numCc;
		this.id_Adscritos = idAdscritos;
		this.setEspecialidad(especialidad);
		this.nombre = nombre;
		this.num_Registro = numRegistro;
		this.id_Servicio_Asociado = idServicoAsociado;
		this.correo_Electronico = correoElectronico;
	}
	/**
	 * Constructor generico
	 * @param id_Adscritos
	 * @param especialidad
	 * @param nombre
	 * @param numRegistro
	 * @param id_Servicio_Asociado
	 * @param correo_Electronico
	 */
	public Medico() {
		this.num_Cc="";
		this.id_Adscritos = null;
		this.especialidad = null;
		this.nombre ="";
		this.num_Registro = null;
		this.id_Servicio_Asociado = null;
		this.correo_Electronico = "";
	}

	/**
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(Especializacion especialidad) {
		this.especialidad = especialidad.toString().toLowerCase();
	}
	
	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the idAdscritos
	 */
	public BigDecimal getId_Adscritos() {
		return id_Adscritos;
	}

	/**
	 * @param idAdscritos the idAdscritos to set
	 */
	public void setId_Adscritos(BigDecimal idAdscritos) {
		this.id_Adscritos = idAdscritos;
	}

	/**
	 * @return the numRegistro
	 */
	public BigDecimal getNum_Registro() {
		return num_Registro;
	}

	/**
	 * @param numRegistro the numRegistro to set
	 */
	public void setNum_Registro(BigDecimal numRegistro) {
		this.num_Registro = numRegistro;
	}

	/**
	 * @return the idServicoAsociado
	 */
	public BigDecimal getId_Servicio_Asociado() {
		return id_Servicio_Asociado;
	}

	/**
	 * @param idServicoAsociado the idServicoAsociado to set
	 */
	public void setId_Servicio_Asociado(BigDecimal idServicoAsociado) {
		this.id_Servicio_Asociado = idServicoAsociado;
	}

	/**
	 * @return the correoElectronico
	 */
	public String getCorreo_Electronico() {
		return correo_Electronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreo_Electronico(String correoElectronico) {
		this.correo_Electronico = correoElectronico;
	}
	/**
	 * @return the num_Cc
	 */
	public String getNum_Cc() {
		return num_Cc;
	}
	/**
	 * @param num_Cc the num_Cc to set
	 */
	public void setNum_Cc(String num_Cc) {
		this.num_Cc = num_Cc;
	}



}
