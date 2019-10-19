package negocio;

public interface VORolesEnSistema 
{

	public boolean isHayAdmins();
	
	public void setHayAdmins(boolean hayAdmins);
	
	public boolean isHayAfiliados()
	;
	public void setHayAfiliados(boolean hayAfiliados);
	
	public boolean isHayGerente();
	
	public void setHayGerente(boolean hayGerente);
	
	public boolean isHayMedicos();
	
	public void setHayMedicos(boolean hayMedicos);
	
	public boolean isHayRecepcionistas();
	
	public void setHayRecepcionistas(boolean hayRecepcionistas);
	
	public long getId();
	
	public void setId(long id);
	
}
