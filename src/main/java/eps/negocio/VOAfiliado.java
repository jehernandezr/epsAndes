package eps.negocio;

import java.sql.Date;
import java.util.List;

public interface VOAfiliado 
{
	public Date getFechaDeNacimiento();

	public void setFechaDeNacimiento(Date fechaDeNacimiento);

	public String getNombre();

	public void setNombre(String nombre);

	public String getNumeroDeDocumento();

	public void setNumeroDeDocumento(String numeroDeDocumento);

	public TipoDeDocumento getTipoDocumento();

	public void setTipoDocumento(TipoDeDocumento tipoDocumento);

	public List<Long> getCitasRecervadas();

	public void setCitasRecervadas(List<Long> citasRecervadas);

	public List<Long> getOrdenes();
	
	public void setOrdenes(List<Long> ordenes) ;
}
