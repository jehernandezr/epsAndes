/**
 * 
 */
package eps.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Campanias;
import eps.negocio.ServiciosCampania;

/**
 * @author jonat
 *
 */
public class SQLServiciosCampania {
	
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
		public SQLServiciosCampania (EpsAndesPersistencia pp)
		{
			this.pp = pp;
		}
		/**
		 * Crea y ejecuta la sentencia SQL para adicionar un AFILIADO a la base de datos
		 * @return EL número de tuplas insertadas
		 */
		public long adicionarServicioCampania (PersistenceManager pm, String id_Campania, String fecha, String numero_participantes, String cupos_Actuales, String tipo_Servicio )
		{
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosCampania() + "( id_Campania, fecha, numero_Participantes, cupos_Actuales, tipo_De_Servicio) values (?,?,?,?,?)");
			q.setParameters( id_Campania, fecha, numero_participantes, cupos_Actuales, tipo_Servicio);
			return (long) q.executeUnique();
		}

		/**y
		 * Crea y ejecuta la sentencia SQL para eliminar UN AFILIADO, por su identificador
		 * @return EL número de tuplas eliminadas
		 */
		public long eliminarServiciosCampaniaPorId (PersistenceManager pm, String id_Campania, String id_servicio)
		{
			Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciosCampania()+ " WHERE id_campania = ? AND tipo_de_servicio = ?");
			q.setParameters(id_Campania, id_servicio);
			return (long) q.executeUnique();            
		}
		/**
		 * Crea y ejecuta la sentencia SQL para encontrar la información de UN AFILIADO, por su identificador
		 * @return El objeto campanias que tiene el identificador dado
		 */
		public ServiciosCampania darservicioCampaniaPorId (PersistenceManager pm, String id_Campania) 
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaParticipantes()+ " WHERE id_Campania= ?");
			q.setParameters(id_Campania);
			q.setResultClass(ServiciosCampania.class);
			return (ServiciosCampania) q.executeUnique();
		}

		/**
		 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS
		 * @param pm - El manejador de persistencia
		 * @return Una lista de objetos Campanias
		 */
		public List<ServiciosCampania> darparticipantes (PersistenceManager pm)
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaParticipantes());
			q.setResultClass(ServiciosCampania.class);
			return (List<ServiciosCampania>) q.executeList();
		}

	}


