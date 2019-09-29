
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
		tablas.add ("AFILIADO");
		tablas.add("GERENTE");
		tablas.add("ADMINISTRADOR");
		tablas.add("RECEPCIONISTA");
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
}
