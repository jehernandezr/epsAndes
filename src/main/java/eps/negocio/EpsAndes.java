/**
 * 
 */
package eps.negocio;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import eps.persistencia.EpsAndesPersistencia;
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
	public EpsAndes()
	{

		Ep = EpsAndesPersistencia.getInstance ();
	}

	public EpsAndes(JsonObject tableConfig)
	{
		Ep=EpsAndesPersistencia.getInstance(tableConfig);
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

	/**
	 * Elimnar un administrador
	 * @param numcc número de cédula del administrador
	 */
	public void eliminarAdministrador(String numcc)
	{

	}
	public boolean existeAdmin( String NumCc) 
	{
		return Ep.darAdministradorPorId(NumCc) !=null? true:false;
	}

	public boolean existeRecepcionista(String NumCc) {
		return Ep.darRecepcionistaPorId(NumCc) !=null? true:false;
	}
	public boolean existeAfiliado(String NumCc) {
		return Ep.darAfiliadoPorId(NumCc) !=null? true:false;

	}
	public boolean existeMedico(String NumCc) {
		return Ep.darMedicoPorId(NumCc) !=null? true:false;
	}

	public boolean existeIps(String nombre) {
		return Ep.darIpsPorId(nombre) !=null? true:false;
	}

	public Administrador crearAdministrador(String nombre,  String pCorreo,String numCc)
	{
		return Ep.adicionarAdministrador(nombre, pCorreo, numCc);
	}

	public void crearMedico( String numCc,String nombre, String numRegistro, Especializacion esp, BigDecimal Id_Servicio_Asociado, String correo, BigDecimal Id_Adscritos)
	{
		Ep.adicionarMedico(numCc, nombre, numRegistro, esp, Id_Servicio_Asociado, correo, Id_Adscritos);
	}

	public Afiliado crearAfiliado(String nombre, String correo,TipoDeDocumento tipoDoc, String numDoc, String fechaNac ) {

		return Ep.adicionarAfiliado(nombre, correo, tipoDoc, numDoc, fechaNac);
	}

	public Recepcionista crearRecepcionista(String nombre, String numcc, String correo, long ips )
	{
		return Ep.adicionarRecepcionista(nombre, numcc, correo, ips);
	}

	public Ips crearIps(String nit, String nombre, String localizacion) {

		return Ep.adicionarIps(nit, nombre, localizacion);
	}

	public void agregarMedicoIps(String nombreIps,String Medico_Num_Cc)
	{
		BigDecimal id= Ep.darIpsPorId(nombreIps).getId(); 
		long cedula = Long.valueOf(Medico_Num_Cc);
		Ep.adicionarMedicoAdscrito(id, BigDecimal.valueOf(cedula));
	}


	public Consulta crearServicioConsulta(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		Ep.adicionarServicioConsulta(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
			
		return null;
	}

	public ConsultaUrgencia crearServicioConsultaUrgencia(String nit, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
	
		return Ep.adicionarServicioConsultaUrgencia(nit, respSemana, horaInicial, horaFinal, numAfiliado);
	}

	public ProcedimientoEspecializado crearServicioProcedimiento(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
	
		return Ep.adcionarProcedimiento(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
	}

	public Hospitalizacion crearServicioHospitalizacion(String nit, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		return Ep.adicionarHospitalizacion(nit, respSemana, horaInicial, horaFinal, numAfiliado);
		
	}

	public Examen crearServicioExamen(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		return Ep.adicionarExamen(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
		
	}

	public Terapia crearServicioTerapia(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		return Ep.adicionarTerapia(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
		
	}

	public boolean verficarLaOrden(String numCc, String id_Orden) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean consultaUrgenciasDadoAlta() {
		// TODO Auto-generated method stub
		return false;
	}

	public void cambiarTriage(String triage, String numDoc) 
	{
		
	}

	public boolean existeCitaReservada(String idCitaReservada) 
	{
		return Ep.darCitaReservada(idCitaReservada) !=null? true:false;
	}

	public void cambiarACumplidaCitaReservada(String idCitaReservada, String numCcRecepcionista)
	{
		Ep.cambiarACitaCumplida(idCitaReservada, numCcRecepcionista);
	}

	public void cambiarACancelarCitaReservada(String idCitaReservada, String numCcRecepcionista)
	{
		Ep.cambiarACitaCancelada(idCitaReservada, numCcRecepcionista);
	}

	public String reqConsulta7() 
	{
		return Ep.consulta7();
	}

	public String reqConsulta8() {
		return Ep.consulta8();
	}

	
	
}
