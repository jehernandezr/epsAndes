package negocio;


public class Consulta extends ServicioDeSalud{
/**
 * Representa el tipo de consulta que se realiza
 */
private TipoDeConsulta tipoConsulta;

private Receta receta;

/**
 * Constructor por defecto
 */
public Consulta() {
	super();
	this.tipoConsulta = null;
	this.receta = new Receta();
}

/**
 * Constructor de cita
 * 
 * @param tipoConsulta
 * @param recetas
 */
public Consulta(TipoDeConsulta tipoConsulta, Receta recetas) {
	super();
	this.tipoConsulta = tipoConsulta;
	this.receta = recetas;
}

/**
 * @return the tipoConsulta
 */
public TipoDeConsulta getTipoConsulta() {
	return tipoConsulta;
}

/**
 * @param tipoConsulta the tipoConsulta to set
 */
public void setTipoConsulta(TipoDeConsulta tipoConsulta) {
	this.tipoConsulta = tipoConsulta;
}

/**
 * @return the recetas
 */
public Receta getReceta() {
	return receta;
}

/**
 * @param recetas the recetas to set
 */
public void setReceta(Receta receta) {
	this.receta = receta;
}


}
