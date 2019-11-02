package eps.negocio;

public class Recepcionista 
{
	private String id_ips;

	private String num_Cc;

	private String nombre;

	private String correo_electronico;	
	/**
	 * Constructor por defecto
	 */
	public Recepcionista() 
	{
		this.id_ips = "";
		this.num_Cc = "";
		this.nombre = "";
		this.correo_electronico = "";
	}

	public Recepcionista(String id_ips, String num_Cc, String nombre, String correo_e) 
	{
		this.id_ips = id_ips;
		this.num_Cc = num_Cc;
		this.nombre = nombre;
		this.correo_electronico = correo_e;
	}

	public String getId_ips() 
	{
		return id_ips;
	}

	public void setId_ips(String id_ips) 
	{
		this.id_ips = id_ips;
	}

	public String getnombre() 
	{
		return nombre;
	}
	
	public void setnum_Cc(String num_Cc) 
	{
		this.num_Cc = num_Cc;
	}
	
	public String getnum_Cc() 
	{
		return num_Cc;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public void setCorreo_electronico(String correo)
	{
		this.correo_electronico = correo;
	}
	
	public String getCorreo_electronico()
	{
		return correo_electronico;
	}
}
