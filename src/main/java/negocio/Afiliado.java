package negocio;

import java.sql.Date;
import java.util.List;

public class Afiliado {

	private Date fechaDeNacimiento;
	
	private String nombre;
	
	private String numeroDeDocumento;
	
	private TipoDeDocumento tipoDocumento;
	
	private List<CitaReservada> citasRecervadas;
	
	private List<Orden> ordenes;

	/**
	 * @return the fechaDeNacimiento
	 */
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	/**
	 * @param fechaDeNacimiento the fechaDeNacimiento to set
	 */
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
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
	 * @return the numeroDeDocumento
	 */
	public String getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	/**
	 * @param numeroDeDocumento the numeroDeDocumento to set
	 */
	public void setNumeroDeDocumento(String numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	/**
	 * @return the tipoDocumento
	 */
	public TipoDeDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDeDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the citasRecervadas
	 */
	public List<CitaReservada> getCitasRecervadas() {
		return citasRecervadas;
	}

	/**
	 * @param citasRecervadas the citasRecervadas to set
	 */
	public void setCitasRecervadas(List<CitaReservada> citasRecervadas) {
		this.citasRecervadas = citasRecervadas;
	}

	/**
	 * @return the ordenes
	 */
	public List<Orden> getOrdenes() {
		return ordenes;
	}

	/**
	 * @param ordenes the ordenes to set
	 */
	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	} 
}
