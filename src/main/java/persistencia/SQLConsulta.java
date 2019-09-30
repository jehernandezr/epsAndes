package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Consulta;
import negocio.TipoDeConsulta;



public class SQLConsulta {

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
	public SQLConsulta(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una CONSULTA a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarConsulta(PersistenceManager pm, long Id, TipoDeConsulta pTipoConsulta, long Id_Receta) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsulta() + "(Id, Tipo_Consulta, Id_Receta) values (?, ?, ?)");
		q.setParameters(Id,pTipoConsulta,Id_Receta);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UNA CONSULTA, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsultaPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsulta() + " WHERE Id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA CONSULTA, por su identificador
	 * @return El objeto GERENTE que tiene el identificador dado
	 */
	public Consulta darConsultaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsulta() + " WHERE Id = ?");
		q.setResultClass(Consulta.class);
		q.setParameters(id);
		return (Consulta) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS CONSULTAS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Consulta
	 */
	public List<Consulta> darConsultas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsulta());
		q.setResultClass(Consulta.class);
		return (List<Consulta>) q.executeList();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS MEDICOS, por su especializacion
	 * @return Una lista de objetos CONSULTA que tienen el TIPO dado
	 */
	public List<Consulta> darConsultaPorTipo (PersistenceManager pm, TipoDeConsulta pTipoConsulta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsulta() + " WHERE Tipo_Consulta = ?");
		q.setResultClass(Consulta.class);
		q.setParameters(pTipoConsulta);
		return (List<Consulta>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarTipoConsulta (PersistenceManager pm, long id, String pTipo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsulta() + " SET Tipo_Consulta = ? WHERE Id = ?");
		q.setParameters(pTipo, id);
		return (long) q.executeUnique();            
	}

}
