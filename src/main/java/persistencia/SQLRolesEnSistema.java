/**
 * 
 */
package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.RolesEnSistema;

/**
 * @author je.hernandezr
 *
 */
public class SQLRolesEnSistema {


		/* **********************
		 * 			Constantes
		 ***********************/
		/** Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos Se renombra acá para facilitar la escritura de las sentencias. */
		private final static String SQL = EpsAndesPersistencia.SQL;

		/* **********************
		 * 			Atributos
		 ***********************/
		/** El manejador de persistencia general de la aplicación. */
		private EpsAndesPersistencia pp;

		/* **********************
		 * 			Métodos
		 ***********************/
		/**
		 * Constructor.
		 *
		 * @param pp - El Manejador de persistencia de la aplicación
		 */
		public  SQLRolesEnSistema (EpsAndesPersistencia pp)
		{
			this.pp = pp;
		}
		
		/**
		 * Crea y ejecuta la sentencia SQL para adicionar un ROL a la base de datos de EPSAndes.
		 *
		 * @param pm - El manejador de persistencia
		 * @param nombre el nombre
		 * @return EL número de tuplas insertadas
		 */
		public long adicionarRol(PersistenceManager pm, String nombre) 
		{
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRolesEnSistema() + "(NOMBRE) values (?)");
	        q.setParameters(nombre);
	        return (long) q.executeUnique();
		}

		/**
		 * Crea y ejecuta la sentencia SQL para eliminar UN ROL de la base de datos de EPSAndes, por sus identificador.
		 *
		 * @param pm - El manejador de persistencia
		 * @param nombre el nombre
		 * @return EL número de tuplas eliminadas
		 */
		public long eliminarRol (PersistenceManager pm, String nombre)
		{
	        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRolesEnSistema() + " WHERE NOMBRE = ?");
	        q.setParameters(nombre);
	        return (long) q.executeUnique();
		}

		/**
		 * Crea y ejecuta la sentencia SQL para encontrar la información de los ROLES de la 
		 * base de datos de EPSAndes.
		 *
		 * @param pm - El manejador de persistencia
		 * @return Una lista de objetos ROL
		 */
		public List<RolesEnSistema> darRoles (PersistenceManager pm)
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRolesEnSistema());
			q.setResultClass(RolesEnSistema.class);
			List<RolesEnSistema> resp = (List<RolesEnSistema>) q.execute();
			return resp;
		}

	}
