package negocio;

import java.util.List;

public interface VOIps {

	public String getLocalizacion();
	
	public void setLocalizacion(String localizacion);
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public List<Long> getServiciosOfrecidos();
	
	public void setServiciosOfrecidos(List<Long> serviciosOfrecidos);
	
	public List<Long> getMedicosAdscritos();
	
	public void setMedicosAdscritos(List<Long> medicosAdscritos) ;
	
	public void addMedicoAdscrito(Long medico);

	public long getIdMedicosAdscritos();
	
	public void setIdMedicosAdscritos(long idMedicosAdscritos);
	
	public long getId();
	
	public void setId(long id);

}
