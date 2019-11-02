package eps.negocio;

public class Afiliado {


	/**
	 * Atributo que representa la fecha de nacimiento de un afiliado
	 */
	private String fecha_Nacimiento;
	/**
	 * Atributo que representa el correo electrónico de un afiliado
	 */
	private String correo_electronico;
	/**
	 * Atrubuto que representa el nombre de un afiliado
	 */
	private String nombre;
	/**
	 * Atributo que representa el numero de cedula de un afiliado
	 */
	private String num_Documento;

	/**
	 * Atributo que representa el tipo de documento de un afiliado
	 */
	private String tipo_De_Documento;
	/**
	 * constructor por defecto
	 */
	@SuppressWarnings("deprecation")
	public Afiliado() {
		this.fecha_Nacimiento = "";
		this.nombre = "";
		this.num_Documento ="";
		this.tipo_De_Documento = null;
	}

	/**
	 * Constructor de un afiliado
	 * 
	 * @param fechaDeNacimiento
	 * @param nombre
	 * @param numeroDeDocumento
	 * @param tipoDocumento
	 * @param citasRecervadas
	 * @param ordenes
	 */
	public Afiliado(String fechaDeNacimiento, String nombre, String numeroDeDocumento, String tipoDocumento) {
		this.fecha_Nacimiento = fechaDeNacimiento;
		this.nombre = nombre;
		this.num_Documento = numeroDeDocumento;
		this.tipo_De_Documento = tipoDocumento;
	}

	/**
	 * @return the fechaDeNacimiento
	 */
	public String getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	/**
	 * @param fechaDeNacimiento the fechaDeNacimiento to set
	 */
	public void setFecha_Nacimiento(String fechaDeNacimiento) {
		this.fecha_Nacimiento = fechaDeNacimiento;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numeroDeDocumento
	 */
	public String getNum_Documento() {
		return num_Documento;
	}

	/**
	 * @param numeroDeDocumento the numeroDeDocumento to set
	 */
	public void setNum_Documento(String numeroDeDocumento) {
		this.num_Documento = numeroDeDocumento;
	}
	public void setCorreo_electronico(String pCorreo)
	{
		this.correo_electronico = pCorreo;
	}
	public String getCorreo_electronico()
	{
		return correo_electronico;
	}
	/**
	 * @return the tipoDocumento
	 */
	public String getTipo_De_Documento() {
		return tipo_De_Documento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipo_De_Documento(String tipoDocumento) {
		this.tipo_De_Documento = tipoDocumento;
	}
}
