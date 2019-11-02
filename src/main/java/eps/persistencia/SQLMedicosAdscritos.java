/**
 * 
 */
package eps.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.MedicosAdscritos;
import uniandes.isis2304.parranderos.negocio.Gustan;

/**
 * @author je.hernandezr
 *
 */
public class SQLMedicosAdscritos {
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
	public SQLMedicosAdscritos (EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Medicos adscritos a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarMedicoAdscrito(PersistenceManager pm, BigDecimal Id_Ips, BigDecimal Medico_Num_Cc) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMedicosAdscritos() + "(Id_Ips, Medico_Num_Cc) values (?, ?)");
        q.setParameters(Id_Ips, Medico_Num_Cc);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN  Medicos adscritos de la base de datos de Parranderos, por sus identificador
	 * @param pm - El manejador de persistencia
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarMedicosAdscrito (PersistenceManager pm, long Id_Ips, long Medico_Num_Cc)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedicosAdscritos() + " WHERE Id_Ips = ? AND Medico_Num_Cc = ?");
        q.setParameters(Id_Ips, Medico_Num_Cc);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los Medicos adscritos de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Medicos adscritos
	 */
	public List<MedicosAdscritos> darMedicosAdscritos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedicosAdscritos());
		q.setResultClass(Gustan.class);
		List<MedicosAdscritos> resp = (List<MedicosAdscritos>) q.execute();
		return resp;
	}

}
