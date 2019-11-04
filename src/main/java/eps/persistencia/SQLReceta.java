package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import eps.negocio.Receta;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto RECETA de EPSAndes
 * @author diani
 */
public class SQLReceta 
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
	public SQLReceta(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una RECETA a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarReceta(PersistenceManager pm, int Id, String pMedicamento, String pDosis) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReceta() + "(Id, Medicamento, Dosis) values (?, ?, ?)");
		q.setParameters(Id, pMedicamento, pDosis);
		return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UNA RECETA, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarRecetaPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReceta() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA RECETA, por su identificador
	 * @return El objeto RECETA que tiene el identificador dado
	 */
	public Receta darRecetaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReceta() + " WHERE id = ?");
		q.setResultClass(Receta.class);
		q.setParameters(id);
		return (Receta) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS RECETAS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos RECETA
	 */
	public List<Receta> darRecetas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReceta());
		q.setResultClass(Receta.class);
		return (List<Receta>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el medicamento
	 * @return El número de tuplas modificadas
	 */
	public long cambiarMedicamento (PersistenceManager pm, long id, String pTipo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReceta() + " SET Medicamento = ? WHERE id = ?");
		q.setParameters(pTipo, id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para cambiar la dosis
	 * @return El número de tuplas modificadas
	 */
	public long cambiarDosis (PersistenceManager pm, long id, String pTipo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReceta() + " SET Dosis = ? WHERE id = ?");
		q.setParameters(pTipo, id);
		return (long) q.executeUnique();            
	}

}
