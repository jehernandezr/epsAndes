/**
 * 
 */
package negocio;

import org.apache.log4j.Logger;


import persistencia.EpsAndesPersistencia;


/**
 * @author jonat
 *
 */
public class EpsAndes {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(EpsAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private EpsAndesPersistencia Ep;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	 public EpsAndes() {
	
		Ep = EpsAndesPersistencia.getInstance ();
	}
	
	
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		Ep.cerrarUnidadPersistencia ();
	}

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo 
	 */
	public long [] limpiarEpsAndes ()
	{
        log.info ("Limpiando la BD de EpsAndes");
        long [] borrrados = Ep.limpiarEpsAndes();	
        log.info ("Limpiando la BD de EpsAndes: Listo!");
        return borrrados;
	}
	
}
