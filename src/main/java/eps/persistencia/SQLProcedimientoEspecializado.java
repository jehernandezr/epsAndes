package eps.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Procedimiento;
import eps.negocio.ProcedimientoEspecializado;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto PROCEDIMIENTO_ESPECIALIZADO de EPSAndes
 * @author diani
 */
public class SQLProcedimientoEspecializado 
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
	public SQLProcedimientoEspecializado(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un PROCEDIMIENTO_ESPECIALIZADO a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarProcedimiento(PersistenceManager pm, int Id, Procedimiento pProcedimiento) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProcedimientoEspecializado() + "(Id, Tipo_Procedimiento) values (?, ?)");
		q.setParameters(Id, pProcedimiento);
		return (long) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN PROCEDIMIENTO_ESPECIALIZADO, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarProcedimientoPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProcedimientoEspecializado() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PROCEDIMIENTO_ESPECIALIZADO, por su identificador
	 * @return El objeto PROCEDIMIENTO_ESPECIALIZADO que tiene el identificador dado
	 */
	public ProcedimientoEspecializado darProcedimientoPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProcedimientoEspecializado() + " WHERE id = ?");
		q.setResultClass(ProcedimientoEspecializado.class);
		q.setParameters(id);
		return (ProcedimientoEspecializado) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PROCEDIMIENTO_ESPECIALIZADO, por su nombre
	 * @return Una lista de objetos MEDICOS que tienen el nombre dado
	 */
	public List<ProcedimientoEspecializado> darProcedimientoPorTipoProd (PersistenceManager pm, Procedimiento procedimiento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProcedimientoEspecializado() + " WHERE Tipo_Procedimiento = ?");
		q.setResultClass(ProcedimientoEspecializado.class);
		q.setParameters(procedimiento);
		return (List<ProcedimientoEspecializado>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PROCEDIMIENTO_ESPECIALIZADO
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos PROCEDIMIENTO_ESPECIALIZADO
	 */
	public List<ProcedimientoEspecializado> darMedicos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProcedimientoEspecializado());
		q.setResultClass(ProcedimientoEspecializado.class);
		return (List<ProcedimientoEspecializado>) q.executeList();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PROCEDIMIENTO_ESPECIALIZADO, por su tipo de procedimiento
	 * @return Una lista de objetos PROCEDIMIENTO_ESPECIALIZADO que tienen el nombre dado
	 */
	public List<ProcedimientoEspecializado> darProcedimientoPorTipo (PersistenceManager pm, Procedimiento pTipo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProcedimientoEspecializado() + " WHERE Tipo_Procedimiento = ?");
		q.setResultClass(ProcedimientoEspecializado.class);
		q.setParameters(pTipo);
		return (List<ProcedimientoEspecializado>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el tipo de procedimiento
	 * @return El número de tuplas modificadas
	 */
	public long cambiarCorreoMedico (PersistenceManager pm, long id, Procedimiento pTipo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaProcedimientoEspecializado() + " SET Tipo_Procedimiento = ? WHERE id = ?");
		q.setParameters(pTipo, id);
		return (long) q.executeUnique();            
	}

}
