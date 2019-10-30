package persistencia;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author jonatan
 */
class SQLUtil
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = EpsAndesPersistencia.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private EpsAndesPersistencia pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLUtil (EpsAndesPersistencia pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqEpsAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con el numero de tuplas borradas
	 */
	public long [] limpiarEpsAndes (PersistenceManager pm)
	{
        Query qAfiliado = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAfiliado());          
        Query qGerente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaGerente());
        Query qAdministrador = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAdministrador());
        Query qRecepcionista = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRecepcionista());
        Query qMedico = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedico());
        Query qIps = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIPS());
        Query qProcedimientoEspecializado = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProcedimientoEspecializado());
        Query qTerapia = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTerapia());
        Query qExamen = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaExamen());
        Query qConsulta = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsulta());
        Query qConsultaUrgencia = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsultaUrgencia());
        Query qReceta = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReceta());
        Query qHospitalizacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHospitalizacion());
        Query qCitaReservada = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCitaReservada() );
        Query qMedicosAdscritos = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedicosAdscritos() );
        Query qRolesEnSistema = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRolesEnSistema() );
        Query qServicios = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicioDeSalud() );
        Query qServiciosRequeridos = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciosRequeridos());
        Query qHorarioDeAtencion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCitaReservada() );
        long afiliadosEliminados = (long) qAfiliado.executeUnique ();
        long gerenteEliminados = (long) qGerente.executeUnique ();
        long administradorEliminadas = (long) qAdministrador.executeUnique ();
        long recepcionistaEliminadas = (long) qRecepcionista.executeUnique ();
        long medicoEliminados = (long) qMedico.executeUnique ();
        long ipsEliminados = (long) qIps.executeUnique ();
        long procedimientoEspecializadoEliminados = (long) qProcedimientoEspecializado.executeUnique ();
        long terapiaEliminadas= (long) qTerapia.executeUnique();
        long examenEliminados =(long) qExamen.executeUnique();
        long consultaEliminados =(long) qConsulta.executeUnique();
        long consultaUrgenciaEliminados =(long) qConsultaUrgencia.executeUnique();
        long recetaEliminados =(long) qReceta.executeUnique();
        long hospitalizacionEliminados =(long) qHospitalizacion.executeUnique();
        long citasEliminadas = (long) qCitaReservada.executeUnique();
        long medicosAdscritosEliminados =(long) qMedicosAdscritos.executeUnique();
        long rolesEliminados =(long) qRolesEnSistema.executeUnique();
        long servicioseliminados =(long) qServicios.executeUnique();
        long serviciosrequeridosEliminados =(long) qServiciosRequeridos.executeUnique();
        long horariosDeAtencionEliminados = (long)qHorarioDeAtencion.executeUnique();
        return new long[] {afiliadosEliminados, gerenteEliminados, administradorEliminadas, recepcionistaEliminadas, 
        		medicoEliminados, ipsEliminados, procedimientoEspecializadoEliminados,terapiaEliminadas,examenEliminados,
        		consultaEliminados,consultaUrgenciaEliminados,recetaEliminados, hospitalizacionEliminados, citasEliminadas,
        		medicosAdscritosEliminados, rolesEliminados, servicioseliminados, serviciosrequeridosEliminados, horariosDeAtencionEliminados};
	}

}
