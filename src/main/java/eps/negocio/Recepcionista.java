package eps.negocio;

import java.math.BigDecimal;

public class Recepcionista 
{
	private BigDecimal id_ips;

	private String num_Cc;

	private String nombre;

	private String correo_electronico;	
	/**
	 * Constructor por defecto
	 */
	public Recepcionista() 
	{
		this.id_ips = null;
		this.num_Cc = "";
		this.nombre = "";
		this.correo_electronico = "";
	}

	public Recepcionista(String correo_e,String nombre,String num_Cc,BigDecimal id_ips ) 
	{
		this.id_ips = id_ips;
		this.num_Cc = num_Cc;
		this.nombre = nombre;
		this.correo_electronico = correo_e;
	}

	public BigDecimal getId_ips() 
	{
		return id_ips;
	}

	public void setId_ips(BigDecimal id_ips) 
	{
		this.id_ips = id_ips;
	}

	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNum_Cc(String num_Cc) 
	{
		this.num_Cc = num_Cc;
	}
	
	public String getNum_Cc() 
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
