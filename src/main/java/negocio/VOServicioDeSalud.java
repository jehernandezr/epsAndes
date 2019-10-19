package negocio;

import java.sql.Date;

public interface VOServicioDeSalud 
{

	public long getHorarioAtencion() ;

	public void setHorarioAtencion(long horarioAtencion);

	public String getDireccion();

	public void setDireccion(String direccion);

	public Date getFechaDeRealizacion();

	public void setFechaDeRealizacion(Date fechaDeRealizacion);

	public long getMedicoAsignado();
	
	public void setMedicoAsignado(long medicoAsignado);

	public long getIpsAsociada();
	
	public void setIpsAsociada(long ipsAsociada);
	
	public long getId();

	public void setId(long id);

}
