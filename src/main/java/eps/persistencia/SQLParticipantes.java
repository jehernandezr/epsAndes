/**
 * 
 */
package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Participantes;

/**
 * @author jonat
 *
 */
public class SQLParticipantes {
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
	public SQLParticipantes (EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un AFILIADO a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarParticipante (PersistenceManager pm, String id_cliente, String id_Campania )
	{

		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaParticipantes() + "( id_cliente,id_Campania) values (?, ?)");
		q.setParameters( id_cliente, id_Campania);
		return (long) q.executeUnique();
	}

	/**y
	 * Crea y ejecuta la sentencia SQL para eliminar UN AFILIADO, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarParticipantePorId (PersistenceManager pm, String id_Cliente)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaParticipantes()+ " WHERE id_Cliente = ?");
		q.setParameters(id_Cliente);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN AFILIADO, por su identificador
	 * @return El objeto campanias que tiene el identificador dado
	 */
	public Participantes darParticipantePorId (PersistenceManager pm, String id_Cliente ) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaParticipantes()+ " WHERE id_Cliente = ?");
		q.setParameters(id_Cliente);
		q.setResultClass(Participantes.class);
		return (Participantes) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Campanias
	 */
	public List<Participantes> darparticipantes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaParticipantes());
		q.setResultClass(Participantes.class);
		return (List<Participantes>) q.executeList();
	}

}
