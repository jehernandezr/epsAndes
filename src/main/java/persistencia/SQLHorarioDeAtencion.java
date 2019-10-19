/**
 * 
 */
package persistencia;

import java.time.LocalTime;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import negocio.HorarioAtencion;

/**
 * @author je.hernandezr
 *
 */
public class SQLHorarioDeAtencion {

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
	public SQLHorarioDeAtencion(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	
	public long agregarHorarioDeAtencion(PersistenceManager pm, String Dias_Sem_Atencion, LocalTime Hora_Inicio, LocalTime Hora_Fin, int Num_Afiliados)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHorariosDeAtencion() + "(Dias_Sem_Atencion, Hora_Inicio, Hora_Fin, Num_Afiliados) values (?, ?, ?, ?)");
		q.setParameters(Dias_Sem_Atencion, Hora_Inicio, Hora_Fin, Num_Afiliados);
		return (long) q.executeUnique();
	}
	
	public long eliminarHorarioDeAtencionPorId(PersistenceManager pm, long id){
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHorariosDeAtencion() + " WHERE Id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();    
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Horario de atencion, por su identificador
	 * @return El objeto HORARIO DE ATENCION que tiene el identificador dado
	 */
	public HorarioAtencion darHorarioDeAtencionPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorariosDeAtencion() + " WHERE Id= ?");
		q.setResultClass(HorarioAtencion.class);
		q.setParameters(id);
		return (HorarioAtencion) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS HORARIOs DE ATENCION, por sus Dias_Sem_Atencion
	 * @return Una lista de objetos HORARIO DE ATENCION que tienen el nombre dado
	 */
	public List<HorarioAtencion> darHorarioDeAtencionPorDiasAtendidosPorNombre (PersistenceManager pm, String Dias_Sem_Atencion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorariosDeAtencion() + " WHERE Dias_Sem_Atencion = ?");
		q.setResultClass(HorarioAtencion.class);
		q.setParameters(Dias_Sem_Atencion);
		return (List<HorarioAtencion>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS HORARIO DE ATENCION
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos HORARIO DE ATENCION
	 */
	public List<HorarioAtencion> darHorarioDeAtencion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorariosDeAtencion());
		q.setResultClass(HorarioAtencion.class);
		return (List<HorarioAtencion>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarDiasSemAtencion(PersistenceManager pm, long id, String Dias_Sem_Atencion) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaAfiliado() + " SET Dias_Sem_Atencion = ? WHERE Id = ?");
		q.setParameters(Dias_Sem_Atencion, id);
		return (long) q.executeUnique();            
	}
}
