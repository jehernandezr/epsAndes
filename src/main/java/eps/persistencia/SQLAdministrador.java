package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Administrador;
/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto ADMINISTRADOR de EPSAndes
 * @author diani
 */
public class SQLAdministrador 
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
	public SQLAdministrador(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ADMINISTRADOR a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarAdministrador(PersistenceManager pm, String pNombre, String pCorreo, String pNumCc) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAdministrador() + " ( Nombre, Correo_Electronico, Num_Cc) values (?, ?, ?)");
		q.setParameters( pNombre, pCorreo, pNumCc);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar ADMINISTRADOR, por su nombre
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAdministradorPorNombre (PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAdministrador() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN ADMINISTRADOR, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAdministradorPorId (PersistenceManager pm, String numCc)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAdministrador() + " WHERE Num_Cc= ?");
		q.setParameters(numCc);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ADMINISTRADOR, por su identificador
	 * @return El objeto ADMINISTRADOR que tiene el identificador dado
	 */
	public Administrador darAdministradorPorId (PersistenceManager pm,String numCc) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAdministrador() + " WHERE Num_Cc=?");
		q.setParameters(numCc);
		q.setResultClass(Administrador.class);
		return (Administrador) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ADMINISTRADORES, por su nombre
	 * @return Una lista de objetos ADMINISTRADORES que tienen el nombre dado
	 */
	public List<Administrador> darAdministradoresPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAdministrador() + " WHERE nombre = ?");
		q.setResultClass(Administrador.class);
		q.setParameters(nombre);
		return (List<Administrador>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS GERENTES
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos GERENTES
	 */
	public List<Administrador> darAdministradores(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAdministrador());
		q.setResultClass(Administrador.class);
		return (List<Administrador>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarCorreoAdministrador (PersistenceManager pm, String numCc, String correo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaAdministrador() + " SET Correo_Electronico = ? WHERE Num_Cc = ?");
		q.setParameters(correo, numCc);
		return (long) q.executeUnique();            
	}
}
