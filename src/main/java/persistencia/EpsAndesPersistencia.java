
package persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

/**
 * @author dianis y jonatan
 *
 */
public class EpsAndesPersistencia 
{
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(EpsAndesPersistencia.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static EpsAndesPersistencia instance;
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden.
	 */
	private List <String> tablas;
	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private EpsAndesPersistencia()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("EpsAndes");		

		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("EPSAndes_sequence");
		tablas.add ("AFILIADOS");
		tablas.add("GERENTES");
		tablas.add("ADMINISTRADORES");
		tablas.add("RECEPCIONISTAS");
		tablas.add("MEDICOS");
		tablas.add("IPS");
		tablas.add("PROCEDIMIENTOS_ESPECIALIZADOS");
		tablas.add("TERAPIAS");
		tablas.add("EXAMENES");
		tablas.add("CONSULTAS");
		tablas.add("CONSUSLTAS_URGENCIA");
		tablas.add("RECETAS");
		tablas.add("HOSPITALIZACIONES");
		tablas.add("CITAS_RESERVADAS");
		tablas.add("HORARIOS_DE_ATENCION");
		tablas.add("Medicos_Adscritos");
		tablas.add("Roles_En_Sistema");
		tablas.add("Servicio_De_Salud");
		tablas.add("Servicios_Requeridos");
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqEpsAndes ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de AFILIADO
	 */
	public String darTablaAfiliado()
	{
		return tablas.get(1);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de GERENTE
	 */
	public String darTablaGerente()
	{
		return tablas.get(2);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de ADMINISTRADOR
	 */
	public String darTablaAdministrador()
	{
		return tablas.get(3);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de RECEPCIONISTA
	 */
	public String darTablaRecepcionista()
	{
		return tablas.get(4);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de MEDICOS
	 */
	public String darTablaMedico()
	{
		return tablas.get(5);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de MEDICOS
	 */
	public String darTablaIPS()
	{
		return tablas.get(6);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de PROCEDIMIENTOS_ESPECIALIZADOS
	 */
	public String darTablaProcedimientoEspecializado()
	{
		return tablas.get(7);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TERAPIAS
	 */
	public String darTablaTerapia()
	{
		return tablas.get(8);
	}
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de EXAMENES
	 */
	public String darTablaExamen()
	{
		return tablas.get(9);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de CONSULTAS
	 */
	public String darTablaConsulta()
	{
		return tablas.get(10);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de CONSULTAS_URGENCIAS
	 */
	public String darTablaConsultaUrgencia()
	{
		return tablas.get(11);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de RECETAS
	 */
	public String darTablaReceta()
	{
		return tablas.get(12);
	}	
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de HOSPITALIZACIONES
	 */
	public String darTablaHospitalizacion()
	{
		return tablas.get(13);
	}	
	
	public String darTablaCitaReservada()
	{
		return tablas.get(14);
	}
	
	public String darTablaHorariosDeAtencion()
	{
		return tablas.get(15);
	}
	
	public String darTablaMedicosAdscritos()
	{
		return tablas.get(16);
	}
	
	public String darTablaRolesEnSistema()
	{
		return tablas.get(17);
	}
	
	public String darTablaServicioDeSalud()
	{
		return tablas.get(18);
	}
	public String darTablaServiciosRequeridos()
	{
		return tablas.get(19);
	}
	public static  EpsAndesPersistencia getInstance() {
		if (instance == null)
		{
			instance = new EpsAndesPersistencia ();
		}
		return instance;
	}
	
	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	public long[] limpiarEpsAndes() {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarEpsAndes (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
}
