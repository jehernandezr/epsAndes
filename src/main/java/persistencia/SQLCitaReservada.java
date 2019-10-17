/**
 * 
 */
package persistencia;

import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.CitaReservada;
import negocio.Consulta;
import negocio.EstadoCita;
import negocio.TipoDeConsulta;

/**
 * @author jonat
 *
 */
public class SQLCitaReservada {

	
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
	 public SQLCitaReservada(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una CONSULTA a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarCita(PersistenceManager pm, EstadoCita estado , long Id_Recepcionista, Date Fecha_Consulta, long Id_Afiliado, long Servicio_Asociado, long Id ) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsulta() + "(Id, Id_Recepcionista, Id_Afiliado, Fecha_Consulta, Servicio_Asociado, Estado_Cita ) values (?, ?, ?)");
		q.setParameters(Id,Id_Recepcionista,Id_Afiliado,Fecha_Consulta,Servicio_Asociado,estado);
		return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UNA CONSULTA, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarCitaReservadaPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCitaReservada() + " WHERE Id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA CONSULTA, por su identificador
	 * @return El objeto GERENTE que tiene el identificador dado
	 */
	public CitaReservada darCitaReservadaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCitaReservada() + " WHERE Id = ?");
		q.setResultClass(CitaReservada.class);
		q.setParameters(id);
		return (CitaReservada) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS CONSULTAS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Consulta
	 */
	public List<CitaReservada> darCitaReservada (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCitaReservada());
		q.setResultClass(CitaReservada.class);
		return (List<CitaReservada>) q.executeList();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS CITAS RESERVADAS, por su especializacion
	 * @return Una lista de objetos CITARESERVADA que tienen la recepcionista  dada
	 */
	public List<CitaReservada> darCitaPorRecepcionista (PersistenceManager pm, long Recepcionista_Id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsulta() + " WHERE Recepcionista_Id = ?");
		q.setResultClass(CitaReservada.class);
		q.setParameters(Recepcionista_Id);
		return (List<CitaReservada>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el estado de la cita
	 * @return El número de tuplas modificadas
	 */
	public long cambiarEstadoCitaReservada (PersistenceManager pm, long id, EstadoCita estado) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCitaReservada() + " SET Estado_Cita = ? WHERE Id = ?");
		q.setParameters(estado, id);
		return (long) q.executeUnique();            
	}
}
