package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import negocio.Gerente;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto GERENTE de EPSAndes
 * @author diani
 */
public class SQLGerente 
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
	public SQLGerente (EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un GERENTE a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarGerente (PersistenceManager pm, String pNombre, int pIdLaboral, String pCorreo, String pNumCc) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaGerente() + "(Id_Laboral, Nombre, Correo_Electronico, Num_Cc) values (?, ?, ?, ?)");
		q.setParameters(pIdLaboral, pNombre, pCorreo, pNumCc);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar GERENTE, por su nombre
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarGerentePorNombre (PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaGerente() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN GERENTE, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarGerentePorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaGerente() + " WHERE Id_Laboral = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN GERENTE, por su identificador
	 * @return El objeto GERENTE que tiene el identificador dado
	 */
	public Gerente darGerentePorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaGerente() + " WHERE Id_Laboral = ?");
		q.setResultClass(Gerente.class);
		q.setParameters(id);
		return (Gerente) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS GERENTES, por su nombre
	 * @return Una lista de objetos GERENTES que tienen el nombre dado
	 */
	public List<Gerente> darGerentesPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaGerente() + " WHERE nombre = ?");
		q.setResultClass(Gerente.class);
		q.setParameters(nombre);
		return (List<Gerente>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS GERENTES
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos GERENTES
	 */
	public List<Gerente> darGerentes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaGerente());
		q.setResultClass(Gerente.class);
		return (List<Gerente>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarCorreoMedico (PersistenceManager pm, long id, String correo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaGerente() + " SET Correo_Electronico = ? WHERE Id_Laboral = ?");
		q.setParameters(correo, id);
		return (long) q.executeUnique();            
	}

}
