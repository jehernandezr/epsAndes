package negocio;

import java.util.List;

public interface VOHospitalizacion extends VOServicioDeSalud {

	public boolean isFueDadoAlta();

	public void setFueDadoAlta(boolean fueDadoAlta);
	
	public List<Long> getServiciosRequeridos();
	
	public void setServiciosRequeridos(List<Long> serviciosRequeridos);
	
}
