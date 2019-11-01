package eps.persistencia;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Afiliado;
import eps.negocio.TipoDeDocumento;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto AFILIADO de EPSAndes
 * @author dianis
 */
public class SQLAfiliado 
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
	public SQLAfiliado (EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un AFILIADO a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarAfiliado (PersistenceManager pm, String pNombre, String pCorreo, String pNumDoc, String pFecha, TipoDeDocumento pTipo) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAfiliado() + "(Tipo_De_Documento, Nombre, Correo_Electronico, Num_Documento, Fecha_Nacimiento) values (?, ?, ?, ?,?)");
		q.setParameters(pTipo, pNombre, pCorreo, pNumDoc, pFecha);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar AFILIADO, por su nombre
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAfiliadoPorNombre (PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAfiliado() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN AFILIADO, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAfiliadoPorId (PersistenceManager pm, String numcc)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAfiliado() + " WHERE Num_Documento = ?");
		q.setParameters(numcc);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN AFILIADO, por su identificador
	 * @return El objeto AFILIADO que tiene el identificador dado
	 */
	public Afiliado darAfiliadoPorId (PersistenceManager pm, String numcc) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAfiliado() + " WHERE Num_Documento = ?");
		q.setResultClass(Afiliado.class);
		q.setParameters(numcc);
		return (Afiliado) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS, por su nombre
	 * @return Una lista de objetos AFILIADOS que tienen el nombre dado
	 */
	public List<Afiliado> darAfiliadosPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAfiliado() + " WHERE nombre = ?");
		q.setResultClass(Afiliado.class);
		q.setParameters(nombre);
		return (List<Afiliado>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AFILIADOS
	 */
	public List<Afiliado> darAfiliado (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAfiliado());
		q.setResultClass(Afiliado.class);
		return (List<Afiliado>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarCorreoAfiliado (PersistenceManager pm,String numcc, String correo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaAfiliado() + " SET Correo_Electronico = ? WHERE Num_Documento = ?");
		q.setParameters(correo, numcc);
		return (long) q.executeUnique();            
	}
}
