package eps.negocio;

public interface VOConsultaUrgencia extends VOServicioDeSalud
{

	public boolean isFueDadoAlta();

	public void setFueDadoAlta(boolean fueDadoAlta);

	public int getTriage();

	public void setTriage(int triage);

	public long getReceta();

	public void setReceta(long receta);
	
}
