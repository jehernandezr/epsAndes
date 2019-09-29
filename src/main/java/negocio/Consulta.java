package negocio;


public class Consulta extends ServicioDeSalud{

private TipoDeConsulta tipoConsulta;

private Receta recetas;
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
public Receta getRecetas() {
	return recetas;
}

/**
 * @param recetas the recetas to set
 */
public void setRecetas(Receta recetas) {
	this.recetas = recetas;
}


}
