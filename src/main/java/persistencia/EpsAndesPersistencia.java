
package persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * @author dianis
 *
 */
public class EpsAndesPersistencia 
{
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
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
		pmf = JDOHelper.getPersistenceManagerFactory("Parranderos");		

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
	 * @return La cadena de caracteres con el nombre de la tabla de RECETAS
	 */
	public String darTablaReceta()
	{
		return tablas.get(12);
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
}
