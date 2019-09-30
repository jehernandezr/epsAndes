/**
 * 
 */
package negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

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
	private static Logger log = Logger.getLogger(Parranderos.class.getName());
	
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
	 * 			Métodos para manejar los TIPOS DE BEBIDA
	 *****************************************************************/
	

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo 
	 */
	public long [] limpiarParranderos ()
	{
        log.info ("Limpiando la BD de EpsAndes");
        long [] borrrados = Ep.limpiarEpsAndes();	
        log.info ("Limpiando la BD de EpsAndes: Listo!");
        return borrrados;
	}
}
