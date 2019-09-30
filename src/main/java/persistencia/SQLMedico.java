package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Especializacion;
import negocio.Medico;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto MEDICO de EPSAndes
 * @author diani
 */
public class SQLMedico 
{
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
	public SQLMedico(EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un MEDICO a la base de datos
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarMedico(PersistenceManager pm, String pNumCc, int numRegistro, String pCorreo, Especializacion pEspecializacion, Integer Id_Servicios_Asociados, Integer Id_Adscritos, String pNombre) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMedico() + "(Num_Cc, Nombre, Correo_Electronico, Num_Registro, Especialidad, Id_Servicio_Asociado, Id_Adscritos) values (?, ?, ?, ?, ?, ?, ?)");
		q.setParameters(pNumCc, pNombre, pCorreo, numRegistro, pEspecializacion, Id_Servicios_Asociados, Id_Adscritos);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar MEDICO, por su nombre
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarMedicoPorNombre (PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedico() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN MEDICO, por su identificador
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarMedicoPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedico() + " WHERE Num_Cc = ?");
		q.setParameters(id);
		return (long) q.executeUnique();            
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN MEDICO, por su identificador
	 * @return El objeto GERENTE que tiene el identificador dado
	 */
	public Medico darMedicoPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico() + " WHERE Num_Cc = ?");
		q.setResultClass(Medico.class);
		q.setParameters(id);
		return (Medico) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS MEDICOS, por su nombre
	 * @return Una lista de objetos MEDICOS que tienen el nombre dado
	 */
	public List<Medico> darMedicoPorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico() + " WHERE nombre = ?");
		q.setResultClass(Medico.class);
		q.setParameters(nombre);
		return (List<Medico>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS MEDICOS
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos MEDICOS
	 */
	public List<Medico> darMedicos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico());
		q.setResultClass(Medico.class);
		return (List<Medico>) q.executeList();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS MEDICOS, por su especializacion
	 * @return Una lista de objetos MEDICOS que tienen el nombre dado
	 */
	public List<Medico> darMedicoPorEspecializacion (PersistenceManager pm, Especializacion pEspecializacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico() + " WHERE Especialidad = ?");
		q.setResultClass(Medico.class);
		q.setParameters(pEspecializacion);
		return (List<Medico>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para cambiar el correo
	 * @return El número de tuplas modificadas
	 */
	public long cambiarCorreoMedico (PersistenceManager pm, long id, String correo) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaMedico() + " SET Correo_Electronico = ? WHERE Num_Cc = ?");
		q.setParameters(correo, id);
		return (long) q.executeUnique();            
	}

}
