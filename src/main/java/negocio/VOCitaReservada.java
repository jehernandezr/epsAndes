package negocio;

import java.sql.Date;

public interface VOCitaReservada 
{

	public EstadoCita getEstado();

	public void setEstado(EstadoCita estado);

	public Date getFechaConsulta();

	public void setFechaConsulta(Date fechaConsulta);

	public long getAfiliado();

	public void setAfiliado(long afiliado);

	public long getServicioAsociado();

	public void setServicioAsociado(long servicioAsociado);

	public long getId();

	public void setId(long id);

	public long getRecepcionista();

	public void setRecepcionista(long recepcionista);
	
}
