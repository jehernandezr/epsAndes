/**
 * 
 */
package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.ServicioDeSalud;
import eps.negocio.ServiciosRequeridos;

/**
 * @author je.hernandezr
 *
 */
public class SQLServiciosRequeridos {
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 */
	private final static String SQL = EpsAndesPersistencia.SQL;
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private EpsAndesPersistencia pp;
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLServiciosRequeridos(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Servicio de salud a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarServicioRequerido (PersistenceManager pm,long Id_Hospitalizacion, long Id_Servicio) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosRequeridos()+ "(Id_Hospitalizacion, Id_Servicio) values (?,?)");
		q.setParameters(Id_Hospitalizacion, Id_Servicio);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN Servicio de salud, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioRequeridoPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioDeSalud() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ServicioDeSalud, por su identificador
	 * @return El objeto ServicioDeSalud que tiene el identificador dado
	 */
	public ServicioDeSalud darServicioRequeridoPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciosRequeridos()+ " WHERE id = ?");
		q.setResultClass(ServicioDeSalud.class);
		q.setParameters(id);
		return (ServicioDeSalud) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ServicioDeSalud
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ServicioDeSalud
	 */
	public List<ServiciosRequeridos> darAfiliado (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciosRequeridos());
		q.setResultClass(ServiciosRequeridos.class);
		return (List<ServiciosRequeridos>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para el servicio que se requiere en la hospitalizacion
	 *  * @param pm - El manejador de persistencia
	 * @return El número de tuplas modificadas
	 * 
	 */
	public long cambiarServicioRequerido (PersistenceManager pm, long id, long nuevoId) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServiciosRequeridos() + " SET Id_Servicio= ? WHERE Id_Servicio = ?");
		q.setParameters(nuevoId, id) ;
		return (long) q.executeUnique();            
	}
}
