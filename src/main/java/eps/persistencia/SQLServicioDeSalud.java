/**
 * 
 */
package eps.persistencia;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.ServicioDeSalud;


/**
 * @author je.hernandezr
 *
 */
public class SQLServicioDeSalud {

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
	public SQLServicioDeSalud(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Servicio de salud a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarServicioDeSalud (PersistenceManager pm, long id,  BigDecimal Id_Ips, long Id_Servicio, String tipoServicio, String Fecha_realizacion ) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicioDeSalud()+ "(Id, " + tipoServicio +",  Fecha_realizacion, Id_Ips) values (?,?,?,?)");
		q.setParameters(id, Id_Servicio,  Fecha_realizacion,Id_Ips );
		return (long) q.executeUnique();
	}


	/**
	 * 
	 * Crea y ejecuta la sentencia SQL para eliminar UN Servicio de salud, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarServicioDeSaludPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioDeSalud() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ServicioDeSalud, por su identificador
	 * @return El objeto ServicioDeSalud que tiene el identificador dado
	 */
	public ServicioDeSalud darServicioDeSaludPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioDeSalud() + " WHERE id = ?");
		q.setResultClass(ServicioDeSalud.class);
		q.setParameters(id);
		return (ServicioDeSalud) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ServicioDeSalud
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ServicioDeSalud
	 */
	public List<ServicioDeSalud> darServicioDeSalud (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicioDeSalud());
		q.setResultClass(ServicioDeSalud.class);
		return (List<ServicioDeSalud>) q.executeList();
	}

}
