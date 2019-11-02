package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Recepcionista;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto RECEPCIONISTA de EPSAndes
 * @author diani
 */
public class SQLRecepcionista 
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
	public SQLRecepcionista(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un RECEPCIONISTA a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarRecepcionista(PersistenceManager pm, String pNombre, String pCorreo, String pNumCc, String ips) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRecepcionista() + "( Nombre, Correo_Electronico, Num_Cc, Id_IPS) values (?, ?, ?, ?)");
		q.setParameters( pNombre, pCorreo, pNumCc, ips);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar RECEPCIONISTA, por su nombre
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarRecepcionistaPorNombre (PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRecepcionista() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN RECEPCIONISTA, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarRecepcionistaPorId (PersistenceManager pm, String numCc)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRecepcionista() + " WHERE Num_Cc=?");
		q.setParameters(numCc);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN RECEPCIONISTA, por su identificador
	 * @return El objeto RECEPCIONISTA que tiene el identificador dado
	 */
	public Recepcionista darRecepcionistaPorId (PersistenceManager pm, String numCc) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRecepcionista() + " WHERE Num_Cc = ?");
		q.setResultClass(Recepcionista.class);
		q.setParameters(numCc);
		return (Recepcionista) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS RECEPCIONISTAS, por su nombre
	 * @return Una lista de objetos RECEPCIONISTAS que tienen el nombre dado
	 */
	public List<Recepcionista> darRecepcionistasPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRecepcionista() + " WHERE nombre = ?");
		q.setResultClass(Recepcionista.class);
		q.setParameters(nombre);
		return (List<Recepcionista>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS RECEPCIONISTAS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos RECEPCIONISTAS
	 */
	public List<Recepcionista> darRecepcionistas(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRecepcionista());
		q.setResultClass(Recepcionista.class);
		return (List<Recepcionista>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarCorreoRecepcionista (PersistenceManager pm, String numCc, String correo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaRecepcionista() + " SET Correo_Electronico = ? WHERE Num_Cc= ?");
		q.setParameters(correo, numCc);
		return (long) q.executeUnique();            
	}

}
