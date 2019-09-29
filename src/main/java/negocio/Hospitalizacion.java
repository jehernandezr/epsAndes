package negocio;

import java.util.List;

public class Hospitalizacion extends ServicioDeSalud {

	private boolean fueDadoAlta;
	
	private List<ServicioDeSalud>serviciosRequeridos;

	/**
	 * @return the fueDadoAlta
	 */
	public boolean isFueDadoAlta() {
		return fueDadoAlta;
	}

	/**
	 * @param fueDadoAlta the fueDadoAlta to set
	 */
	public void setFueDadoAlta(boolean fueDadoAlta) {
		this.fueDadoAlta = fueDadoAlta;
	}

	/**
	 * @return the serviciosRequeridos
	 */
	public List<ServicioDeSalud> getServiciosRequeridos() {
		return serviciosRequeridos;
	}

	/**
	 * @param serviciosRequeridos the serviciosRequeridos to set
	 */
	public void setServiciosRequeridos(List<ServicioDeSalud> serviciosRequeridos) {
		this.serviciosRequeridos = serviciosRequeridos;
	}
	
	
}
