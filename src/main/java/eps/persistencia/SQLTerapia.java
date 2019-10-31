package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Terapia;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto TERAPIAS de EPSAndes
 * @author diani
 */
public class SQLTerapia 
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
	public SQLTerapia(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una TERAPIAS a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarProcedimiento(PersistenceManager pm, int Id, String pTerapia) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTerapia() + "(Id, Tipo_Terapia) values (?, ?)");
		q.setParameters(Id, pTerapia);
		return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UNA TERAPIAS, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarTerapiaPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTerapia() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA TERAPIA, por su identificador
	 * @return El objeto TERAPIA que tiene el identificador dado
	 */
	public Terapia darTerapiaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTerapia() + " WHERE id = ?");
		q.setResultClass(Terapia.class);
		q.setParameters(id);
		return (Terapia) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS TERAPIAS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos TERAPIAS
	 */
	public List<Terapia> darTerapias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTerapia());
		q.setResultClass(Terapia.class);
		return (List<Terapia>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el tipo de terapia
	 * @return El número de tuplas modificadas
	 */
	public long cambiarTipoTerapia (PersistenceManager pm, long id, String pTipo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaTerapia() + " SET Tipo_Terapia = ? WHERE id = ?");
		q.setParameters(pTipo, id);
		return (long) q.executeUnique();            
	}

}
