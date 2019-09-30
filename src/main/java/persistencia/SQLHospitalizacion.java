package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Afiliado;
import negocio.Hospitalizacion;
import negocio.TipoDeDocumento;

public class SQLHospitalizacion {
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
	public SQLHospitalizacion (EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un AFILIADO a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarHospitalizacion (PersistenceManager pm, long Id, boolean Fue_Dado_De_Alta, long Id_Servicio_Requerido) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHospitalizacion() + "(Id, Fue_Dado_De_Alta, Id_Servicio_Requerido) values (?, ?, ?)");
		q.setParameters(Id, Fue_Dado_De_Alta?"T":"F", Id_Servicio_Requerido);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UNA HOSPITALIZACION, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarHospitalizacionPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHospitalizacion() + " WHERE Id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN AFILIADO, por su identificador
	 * @return El objeto HOSPITALIZACION que tiene el identificador dado
	 */
	public Hospitalizacion darHospitalizacionPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospitalizacion() + " WHERE Id= ?");
		q.setResultClass(Hospitalizacion.class);
		q.setParameters(id);
		return (Hospitalizacion) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS, poR SI FUE DADO DE ALTA
	 * @return Una lista de objetos HOSPITALIZACION que tienen el nombre dado
	 */
	public List<Hospitalizacion> darHospitaliacionesPorDadosDeAlta (PersistenceManager pm, String verd) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAfiliado() + " WHERE Fue_Dado_Alta = ?");
		q.setResultClass(Afiliado.class);
		q.setParameters(verd);
		return (List<Hospitalizacion>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS AFILIADOS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AFILIADOS
	 */
	public List<Afiliado> darAfiliado (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAfiliado());
		q.setResultClass(Afiliado.class);
		return (List<Afiliado>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarCorreoAfiliado (PersistenceManager pm, long id, String correo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaAfiliado() + " SET Correo_Electronico = ? WHERE Num_Documento = ?");
		q.setParameters(correo, id);
		return (long) q.executeUnique();            
	}
}
