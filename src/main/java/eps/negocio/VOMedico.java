package eps.negocio;

import java.util.List;

public interface VOMedico 
{
	public Especializacion getEspecialidad();

	public void setEspecialidad(Especializacion especialidad);
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public int getNumeroRegistro();
	
	public void setNumeroRegistro(int numeroRegistro);
	
	public List<Long> getIps();

	public void setIps(List<Long> ips);

	public long getIdMedicosAdscritos();

	public void setIdMedicosAdscritos(long idMedicosAdscritos);
}
