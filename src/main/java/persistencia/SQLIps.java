package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Ips;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto IPS de EPSAndes
 * @author diani
 */
public class SQLIps 
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
	public SQLIps(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una IPS a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarMedico(PersistenceManager pm, String Id, String pNombre, String pLocalizacion) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIPS() + "(Id, Nombre, Localizacion) values (?, ?, ?)");
		q.setParameters(Id, pNombre, pLocalizacion);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar IPS, por su nombre
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarIPSPorNombre (PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIPS() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UNA IPS, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarIPSPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIPS() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA IPS, por su identificador
	 * @return El objeto GERENTE que tiene el identificador dado
	 */
	public Ips darIpsPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS() + " WHERE id = ?");
		q.setResultClass(Ips.class);
		q.setParameters(id);
		return (Ips) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS IPS, por su nombre
	 * @return Una lista de objetos IPS que tienen el nombre dado
	 */
	public List<Ips> darIpsPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS() + " WHERE nombre = ?");
		q.setResultClass(Ips.class);
		q.setParameters(nombre);
		return (List<Ips>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS IPS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos IPS
	 */
	public List<Ips> darMedicos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS());
		q.setResultClass(Ips.class);
		return (List<Ips>) q.executeList();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS IPS, por su locacion
	 * @return Una lista de objetos MEDICOS que tienen el nombre dado
	 */
	public List<Ips> darMedicoPorNombre (PersistenceManager pm, String pLocacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS() + " WHERE Localizacion = ?");
		q.setResultClass(Ips.class);
		q.setParameters(pLocacion);
		return (List<Ips>) q.executeList();
	}

}
