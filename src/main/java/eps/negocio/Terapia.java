package eps.negocio;

import java.math.BigDecimal;

public class Terapia  extends ServicioDeSalud {

	private String tipo_Terapia;
	
	private BigDecimal id ;

	/**
	 * constrcutor por defecto
	 */
	public Terapia() {
		super();
		this.tipo_Terapia = null;
		this.id=null;
	}

	/**
	 * @param tipoTerapia
	 */
	public Terapia(String tipoTerapia, BigDecimal id) {
		super();
		this.tipo_Terapia = tipoTerapia;
		this.id= id;
	}

	/**
	 * @return the tipoTerapia
	 */
	public String getTipo_Terapia() {
		return tipo_Terapia;
	}

	/**
	 * @param tipoTerapia the tipoTerapia to set
	 */
	public void setTipo_Terapia(String tipoTerapia) {
		this.tipo_Terapia = tipoTerapia;
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
