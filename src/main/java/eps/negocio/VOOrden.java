package eps.negocio;

import java.sql.Date;

public interface VOOrden {

	public boolean isCitaReservada();
	
	public void setCitaReservada(boolean citaReservada);
	
	public Date getFecha();
	
	public void setFecha(Date fecha);
	
	public long getId();
	
	public void setId(long id);
	
	public long getAfiliadoOrden();
	
	public void setAfiliadoOrden(long afiliadoOrden);
	
	public long getServicioSolicitado();
	
	public void setServicioSolicitado(long servicioSolicitado);
	
}
