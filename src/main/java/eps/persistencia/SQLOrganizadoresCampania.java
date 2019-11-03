package eps.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import eps.negocio.Afiliado;
import eps.negocio.Campanias;
import eps.negocio.OrganizadorCampania;

public class SQLOrganizadoresCampania {


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
	public SQLOrganizadoresCampania (EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un AFILIADO a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarOrganizadorCampania (PersistenceManager pm, String nombre, String correo, String num_Cc) 
	{

		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOrganizadoresDeCampania() + "( nombre, correo,num_Cc) values (?, ?, ?)");
		q.setParameters(nombre,correo,num_Cc);
		return (long) q.executeUnique();
	}

	/**y
	 * Crea y ejecuta la sentencia SQL para eliminar UN AFILIADO, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarOrganizadorPorId (PersistenceManager pm, String id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampanias() + " WHERE num_Cc = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN AFILIADO, por su identificador
	 * @return El objeto campanias que tiene el identificador dado
	 */
	public OrganizadorCampania darOrganizadorPorId (PersistenceManager pm, String  id ) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrganizadoresDeCampania()+ " WHERE num_Cc = ?");
		q.setParameters(id);
		q.setResultClass(OrganizadorCampania.class);
		return (OrganizadorCampania) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Campanias
	 */
	public List<OrganizadorCampania> darOrganzadoresCampania (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrganizadoresDeCampania());
		q.setResultClass(OrganizadorCampania.class);
		return (List<OrganizadorCampania>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarcorreo (PersistenceManager pm, String id, String correo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCampanias() + " SET correo= ? WHERE num_Cc= ?");
		q.setParameters(correo, id);
		return (long) q.executeUnique();            
	}
	
}
