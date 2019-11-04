/**
 * 
 */
package eps.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Afiliado;
import eps.negocio.Campanias;


/**
 * @author jonat
 *
 */
public class SQLCampanias {

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
	public SQLCampanias(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un AFILIADO a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarCampania (PersistenceManager pm, BigDecimal id, String campania_Acepta, String estado_Campania,BigDecimal id_Ips, BigDecimal id_OrganizadorCampania) 
	{

		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampanias() + "( id, campania_Acepta,estado_Campania, id_Ips, id_OrganizadorCampania) values (?, ?, ?, ?, ?)");
		q.setParameters( id, campania_Acepta,estado_Campania, id_Ips, id_OrganizadorCampania);
		return (long) q.executeUnique();
	}

	/**y
	 * Crea y ejecuta la sentencia SQL para eliminar UN AFILIADO, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarCampaniaPorId (PersistenceManager pm, BigDecimal id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampanias() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN AFILIADO, por su identificador
	 * @return El objeto campanias que tiene el identificador dado
	 */
	public Campanias darCampaniaPorId (PersistenceManager pm, String id ) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampanias()+ " WHERE id = ?");
		q.setParameters(id);
		q.setResultClass(Campanias.class);
		return (Campanias) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS, por su nombre
	 * @return Una lista de objetos campanias que tienen el nombre dado
	 */
	public List<Campanias> darCampaniasPorEstado (PersistenceManager pm, String estado_Campania) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampanias() + " WHERE estado_Campania= ?");
		q.setResultClass(Campanias.class);
		q.setParameters(estado_Campania);
		return (List<Campanias>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Campanias
	 */
	public List<Campanias> darCampanias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampanias());
		q.setResultClass(Campanias.class);
		return (List<Campanias>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarAceptaCampania (PersistenceManager pm, String id, String newAcepta) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET Campania_Acepta = ? WHERE id = ?");
		q.setParameters(newAcepta, id);
		return (long) q.executeUnique();            
	}
	public void cambiarCumplidaCampaña(PersistenceManager pm, String id) {
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET ESTADO_CAMPANIA = 'cumplida' WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
		q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET Campania_Acepta = 'T' WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	public void cambiarEnProcesoCampaña(PersistenceManager pm, String id) {
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET ESTADO_CAMPANIA = 'en_proceso' WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
		q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET Campania_Acepta = 'T' WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	public void cambiarConfirmadaCampaña(PersistenceManager pm, String id) {
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET ESTADO_CAMPANIA = 'confirmada' WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
		q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET Campania_Acepta = 'T' WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	public long agregarCampaNa(PersistenceManager pm, String id_ips, long id, String numCc) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampanias() + "( id, campania_Acepta, estado_Campania, id_Ips, id_OrganizadorCampania) values (?, 'F', 'por_confirmar', ?, ?)");
		q.setParameters( id, id_ips, numCc);
		return (long) q.executeUnique();		
	}

}
