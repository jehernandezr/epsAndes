package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Consulta;
import negocio.ConsultaUrgencia;
import negocio.TipoDeConsulta;

public class SQLConsultaUrgencia {

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
	public SQLConsultaUrgencia(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**boolean Fue_Dado_DE_Alta, int Triage,
	 * Crea y ejecuta la sentencia SQL para adicionar una CONSULTA DE URGENCIA a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarConsulta(PersistenceManager pm, long Id, boolean Fue_Dado_De_Alta, int Triage, long Id_Receta) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsultaUrgencia() + "(Id,Fue_Dado_De_Alta,Triage,Id_Receta) values (?, ?, ?,?)");
		q.setParameters(Id,Fue_Dado_De_Alta?"T":"F",Triage,Id_Receta);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UNA CONSULTA DE URGENCIA, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarConsultaUrgenciaPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsultaUrgencia() + " WHERE Id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA CONSULTA DE URGENCIA, por su identificador
	 * @return El objeto GERENTE que tiene el identificador dado
	 */
	public ConsultaUrgencia darConsultaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaUrgencia() + " WHERE Id = ?");
		q.setResultClass(ConsultaUrgencia.class);
		q.setParameters(id);
		return (ConsultaUrgencia) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS CONSULTAS DE URGENCIA
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Consulta DE URGENCIA
	 */
	public List<ConsultaUrgencia> darConsultas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaUrgencia());
		q.setResultClass(ConsultaUrgencia.class);
		return (List<ConsultaUrgencia>) q.executeList();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS CONSULTAS DE URGENCIA, por su especializacion
	 * @return Una lista de objetos LAS CONSULTAS DE URGENCIA que tienen el TIPO dado
	 */
	public List<ConsultaUrgencia> darConsultaPorTriage (PersistenceManager pm, int triage) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsultaUrgencia() + " WHERE Triage = ?");
		q.setResultClass(Consulta.class);
		q.setParameters(triage);
		return (List<ConsultaUrgencia>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarTriageConsulta (PersistenceManager pm, long id, int triage) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaConsulta() + " SET Triage = ? WHERE Id = ?");
		q.setParameters(triage, id);
		return (long) q.executeUnique();            
	}
}
