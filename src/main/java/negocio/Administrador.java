package negocio;

public class Administrador {

	private int identificacionLaboral;
	
	private String nombre;

	public Administrador()
	{
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdentificacionLaboral() {
		return identificacionLaboral;
	}

	public void setIdentificacionLaboral(int identificacionLaboral) {
		this.identificacionLaboral = identificacionLaboral;
	}
	
}
