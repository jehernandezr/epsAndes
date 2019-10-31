package eps.negocio;

import java.time.LocalTime;

public interface VOHorarioAtencion 
{
	public String getDiasSemanaAtencion();

	public void setDiasSemanaAtencion(String diasSemanaAtencion);

	public LocalTime getHoraDeInicio();

	public void setHoraDeInicio(LocalTime horaDeInicio);
	
	public LocalTime getHoraFin();
	
	public void setHoraFin(LocalTime horaFin);
	
	public int getNumeroAfiliados();
	
	public void setNumeroAfiliados(int numeroAfiliados);
	
	public int getNumeroSesiones();
	
	public void setNumeroSesiones(int numeroSesiones);
	
	public long getId();
	
	public void setId(long id);
	
}
