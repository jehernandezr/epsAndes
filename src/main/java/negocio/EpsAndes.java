/**
 * 
 */
package negocio;

import org.apache.log4j.Logger;


import persistencia.EpsAndesPersistencia;
import uniandes.isis2304.parranderos.negocio.Bebedor;


/**
 * @author jonat
 *
 */
public class EpsAndes {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(EpsAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private EpsAndesPersistencia Ep;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	 public EpsAndes() {
	
		Ep = EpsAndesPersistencia.getInstance ();
	}
	
	
	 
	 /**
		 * Encuentra un adminsitrador y su información básica, según su identificador
		 * @param numCc - El identificador del administrador buscado
		 * @return Un objeto Administrador que corresponde con el identificador buscado y lleno con su información básica
		 * 			null, si un Administrador con dicho identificador no existe
		 */
		public Administrador darAdminsitradorId (String numCc)
		{
	        log.info ("Dar información de un administrador por id: " + numCc);
	       Administrador administrador = Ep.darAdministradorPorId(numCc) ;
	        log.info ("Buscando Administrador por Id: " + administrador != null ? administrador : "NO EXISTE");
	        return administrador;
		}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		Ep.cerrarUnidadPersistencia ();
	}

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo 
	 */
	public long [] limpiarEpsAndes ()
	{
        log.info ("Limpiando la BD de EpsAndes");
        long [] borrrados = Ep.limpiarEpsAndes();	
        log.info ("Limpiando la BD de EpsAndes: Listo!");
        return borrrados;
	}
	
<<<<<<< HEAD
	public boolean existeAdmin(long idNumCc) {
		return Ep.darAdministradorPorId(idNumCc) !=null? true:false;
	}
	/**
	 * Elimnar un administrador
	 * @param numcc número de cédula del administrador
	 */
	public void eliminarAdministrador(String         numcc)
	{
		
=======
	public boolean existeAdmin( String NumCc) {
		return Ep.darAdministradorPorId(NumCc) !=null? true:false;
	
>>>>>>> 93d32b461edbb3d709bd568c00ddeb23451fd6ca
	}
	public boolean existeRecepcionista(long idNumCc) {
		return true;
	}
	public boolean existeAfiliado(long idNumCc) {
		return true;
	}
	public boolean existeMedico(long idNumCc) {
		return true;
	}
	
	public String crearAdministrador(String numCc, String nombre, String pCorreo)
	{
		return Ep.adicionarAdministrador(nombre, pCorreo, numCc).toString();
	}
}
