package negocio;


public interface VOConsulta extends VOServicioDeSalud
{
	public TipoDeConsulta getTipoConsulta();

	public void setTipoConsulta(TipoDeConsulta tipoConsulta);

	public long getReceta();
	
	public void setReceta(long receta);

}
