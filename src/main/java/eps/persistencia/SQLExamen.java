package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Examen;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto EXAMENES de EPSAndes
 * @author diani
 */
public class SQLExamen 
{
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
	public SQLExamen(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un EXAMEN a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarExamen(PersistenceManager pm, long Id, String pExamen) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaExamen() + "(Id, Tipo_Examen) values (?, ?)");
		q.setParameters(Id, pExamen);
		return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN EXAMEN, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarTerapiaPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaExamen() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN EXAMEN, por su identificador
	 * @return El objeto TERAPIA que tiene el identificador dado
	 */
	public Examen darExamenPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaExamen() + " WHERE id = ?");
		q.setResultClass(Examen.class);
		q.setParameters(id);
		return (Examen) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS EXAMENES
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos EXAMEN
	 */
	public List<Examen> darExamenes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaExamen());
		q.setResultClass(Examen.class);
		return (List<Examen>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el tipo de examen
	 * @return El número de tuplas modificadas
	 */
	public long cambiarTipoExamen (PersistenceManager pm, long id, String pTipo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaExamen() + " SET Tipo_Examen = ? WHERE id = ?");
		q.setParameters(pTipo, id);
		return (long) q.executeUnique();            
	}

}
