
package eps.InterfazApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;
import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import eps.negocio.EpsAndes;
import eps.negocio.Especializacion;
import eps.negocio.TipoDeDocumento;
/**
 * Clase principal de la interfaz
 */
@SuppressWarnings("serial")
public class InterfazEPSAndesAdministrador extends JFrame implements ActionListener
{
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazEPSAndesAdministrador.class.getName());
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigAppAdministrador.json"; 
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	/**
	 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
	 */
	private JsonObject tableConfig;
	/**
	 * Asociación a la clase principal del negocio.
	 */

	private EpsAndes epsAndes;
	/**
	 * Objeto JSON con la configuración de interfaz de la app.
	 */
	private JsonObject guiConfig;
	/**
	 * Panel de despliegue de interacción para los requerimientos
	 */
	private PanelDatos panelDatos;
	/**
	 * Menú de la aplicación
	 */
	private JMenuBar menuBar;
	/**
	 * Número de cédula
	 */
	private String numCc;
	/**
	 * Construye la ventana principal de la aplicación. <br>
	 * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
	 */
	public InterfazEPSAndesAdministrador()
	{
		guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);

		configurarFrame ( );
		if (guiConfig != null) 	   
		{
			crearMenu( guiConfig.getAsJsonArray("menuBar") );
		}

		tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
		epsAndes = new EpsAndes();

		String path = guiConfig.get("bannerPath").getAsString();
		panelDatos = new PanelDatos( );

		setLayout (new BorderLayout());
		add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
		add( panelDatos, BorderLayout.CENTER );        
	}
	/**
	 * Registrar el número de cédula del administrador
	 * @param numCc
	 */
	public void registrarNumCcIngresado(String numCc)
	{
		this.numCc = numCc;

	}
	/**
	 * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
	 * @param tipo - El tipo de configuración deseada
	 * @param archConfig - Archivo Json que contiene la configuración
	 * @return Un objeto JSON con la configuración del tipo especificado
	 *			NULL si hay un error en el archivo.
	 */
	private JsonObject openConfig (String tipo, String archConfig)
	{
		JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
			//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "EPSAndes App", JOptionPane.ERROR_MESSAGE);
		}	
		return config;
	}  
	/**
	 * Método para configurar el frame principal de la aplicación
	 */
	private void configurarFrame(  )
	{
		int alto = 0;
		int ancho = 0;
		String titulo = "";	

		if ( guiConfig == null )
		{
			log.info ( "Se aplica configuración por defecto" );			
			titulo = "ESPAndes APP Default";
			alto = 300;
			ancho = 500;
		}
		else
		{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
			titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
		}

		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setLocation (50,50);
		setResizable( true );
		setBackground( Color.WHITE );

		setTitle( titulo );
		setSize ( ancho, alto);        
	}
	/**
	 * Método para crear el menú de la aplicación con base em el objeto JSON leído
	 * Genera una barra de menú y los menús con sus respectivas opciones
	 * @param jsonMenu - Arreglo Json con los menùs deseados
	 */
	private void crearMenu(  JsonArray jsonMenu )
	{    	
		// Creación de la barra de menús
		menuBar = new JMenuBar();       
		for (JsonElement men : jsonMenu)
		{
			// Creación de cada uno de los menús
			JsonObject jom = men.getAsJsonObject(); 

			String menuTitle = jom.get("menuTitle").getAsString();        	
			JsonArray opciones = jom.getAsJsonArray("options");

			JMenu menu = new JMenu( menuTitle);

			for (JsonElement op : opciones)
			{       	
				// Creación de cada una de las opciones del menú
				JsonObject jo = op.getAsJsonObject(); 
				String lb =   jo.get("label").getAsString();
				String event = jo.get("event").getAsString();

				JMenuItem mItem = new JMenuItem( lb );
				mItem.addActionListener( this );
				mItem.setActionCommand(event);

				menu.add(mItem);
			}       
			menuBar.add( menu );
		}        
		setJMenuBar ( menuBar );	
	}

	/** Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
	 * @param e - La excepción recibida
	 * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
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
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y EpsAndes.log para más detalles";
		return resultado;
	}


	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
	/**
	 * Este método ejecuta la aplicación, creando una nueva interfaz
	 * @param args Arreglo de argumentos que se recibe por línea de comandos
	 */
	public static void main( String[] args )
	{
		try
		{

			BasicConfigurator.configure();
			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
			InterfazEPSAndesAdministrador interfaz = new InterfazEPSAndesAdministrador( );
			interfaz.setVisible( true );
			
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
	/**
	 * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
	 * Invoca al método correspondiente según el evento recibido
	 * @param pEvento - El evento del usuario
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
		try 
		{
			Method req = InterfazEPSAndesAdministrador.class.getMethod ( evento );			
			req.invoke ( this );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	/**
	 * Registra un médico al sistema
	 */
	public void registrarMedico()
	{
		new PanelRegistrarMedico(this);
	}
	/**
	 * Registra una IPS al sistema
	 */
	public void registrarIPS()
	{
		new PanelRegistrarIPS(this);
	}
	/**
	 * Registrar un afiliado al sistema
	 */
	public void registrarAfiliado()
	{
		new PanelRegistrarAfiliado(this);
	}
	public void registrarRecepcionista()
	{
		new PanelRegistrarRecepcionista(this);
	}
	public void registrarOrganizador()
	{
		new PanelRegistrarOrganizador(this);
	}
	public void registrarServicioSalud()
	{
		String [] servicios ={"Consulta médica","Consulta de urgencia","Hospitalización","Examenes","Terapias","Procedimiento especializado"}; 
		Object opcion = JOptionPane.showInputDialog(null,"Seleccionar un servicio de salud", "¿Qué servicio de salud desea agregar?",JOptionPane.QUESTION_MESSAGE,null,servicios, servicios[0]);    	
		String esp = opcion.toString();
		new PanelRegistrarServicioSalud(this, esp);
	}
	public void registrarMedicoDatos(String nombre, String correo, String numCc, String numRegistro, Especializacion esp)
	{
		try {
			if (numCc != null && nombre != null && correo != null && numRegistro != null && esp != null)
			{
				boolean existe = epsAndes.existeMedico(numCc);
				if(!existe)
				{
					epsAndes.crearMedico(numCc, nombre, numRegistro, esp, null, correo, null);

				}
				else
					panelDatos.actualizarInterfaz("Ya existe un médico con ese numero de cedula.");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarIPSDatos(String nombre, String localizacion, String nit) 
	{
		try {
			if ( nombre != null && localizacion != null&& nit!=null)
			{
				boolean existe = epsAndes.existeIps(nit);
				if(!existe)
				{
					epsAndes.crearIps(nit,nombre, localizacion);
					panelDatos.actualizarInterfaz("Se agregó la Ips : "+ nombre +".  Correctamente");
				}
				else
					panelDatos.actualizarInterfaz("Ya se encuentra una ips registrada con ese id.");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarAfiliadoDatos(String nombre, String correo, TipoDeDocumento tipoDoc,String numDoc, String fechaNac)
	{		
		try {
			if ( nombre != null && correo != null &&  numDoc != null && tipoDoc != null)
			{
				boolean existe = epsAndes.existeAfiliado(numDoc);
				if(!existe)
				{
					epsAndes.crearAfiliado(nombre, correo,tipoDoc ,numDoc,fechaNac);
					panelDatos.actualizarInterfaz("Se agregó el afiliado : "+ nombre +".  Correctamente");
				}
				else
					panelDatos.actualizarInterfaz("Ya se encuentra un afiliado registrado con ese numero de Cedula.");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarRecepcionistaDatos(String nombre, String numcc, String correo, String ips)
	{
		try {
			if (nombre != null && correo != null &&  numcc != null && ips != null)
			{
				long idIps =0;
				try{
					idIps=Long.parseLong(ips);
				}
				catch (Exception e) {
					panelDatos.actualizarInterfaz(generarMensajeError(e));
				}
				boolean existe = epsAndes.existeRecepcionista(numcc);
				if(!existe)
				{
					epsAndes.crearRecepcionista(nombre, numcc, correo, idIps);
					panelDatos.actualizarInterfaz("El usuario  : "+nombre+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Esta cedula : "+numcc+" ya está registrada como recepcionista ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	public void registrarOrganizadorDatos(String nombre, String numcc, String correo)
	{
		try {
			if (nombre != null && correo != null &&  numcc != null)
			{
				boolean existe = epsAndes.existeOrganizador(numcc);
				if(!existe)
				{
					epsAndes.crearOrganizador(nombre, numcc, correo);
					panelDatos.actualizarInterfaz("El usuario  : "+nombre+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Esta cedula : "+numcc+" ya está registrada como organizador ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	public void registrarMedicoAIps(String nombre, String numcc, String respSemana, String horaInicial, String horaFinal, String numAfiliado)
	{
		try {
			if (nombre != null &&  numcc != null)
			{
				
				boolean existe = epsAndes.existeMedico(numcc);
				boolean existe2 = epsAndes.existeIps(nombre);
				if(existe&existe2)
				{
					epsAndes.agregarMedicoIps(nombre, numcc);
					panelDatos.actualizarInterfaz("El usuario  : "+nombre+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Esta cedula : "+numcc+" ya está registrada como recepcionista ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarServicioConsulta(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) 
	{
		try {
			if (nit != null &&  tipo != null)
			{
				
				boolean existe = epsAndes.existeIps(nit);
				if(existe)
				{
					epsAndes.crearServicioConsulta(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
					panelDatos.actualizarInterfaz("El servico de consulta  : "+tipo+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Esta consulta : "+tipo+" ya está registrada ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarServicioConsultaUrgencia(String nit, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		try {
			if (nit != null)
			{
				
				boolean existe = epsAndes.existeIps(nit);
				if(existe)
				{
					epsAndes.crearServicioConsultaUrgencia(nit, respSemana, horaInicial, horaFinal, numAfiliado);
					panelDatos.actualizarInterfaz("El servico de consulta  urgencia : "+nit+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Esta consulta de urgencia: "+nit+" ya está registrada ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarServicioProcedimiento(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		try {
			if (nit != null &&  tipo != null)
			{
				
				boolean existe = epsAndes.existeIps(nit);
				if(existe)
				{
					epsAndes.crearServicioProcedimiento(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
					panelDatos.actualizarInterfaz("El servico de Procedimiento  : "+ tipo+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Este Procedimiento : "+ tipo +" ya está registrada en la ips "+ nit);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarServicioTerapia(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		try {
			if (nit != null &&  tipo != null)
			{
				
				boolean existe = epsAndes.existeIps(nit);
				if(existe)
				{
					epsAndes.crearServicioTerapia(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
					panelDatos.actualizarInterfaz("El servico de Terapia  : "+tipo+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Esta Terapia : "+tipo+" ya está registrada ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarServicioExamen(String nit, String tipo, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		try {
			if (nit != null &&  tipo != null)
			{
				
				boolean existe = epsAndes.existeIps(nit);
				if(existe)
				{
					epsAndes.crearServicioExamen(nit, tipo, respSemana, horaInicial, horaFinal, numAfiliado);
					panelDatos.actualizarInterfaz("El servico de Examen  : "+tipo+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Este Examen : "+tipo+" ya está registrada ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void registrarServicioHospitalizacion(String nit, String respSemana, String horaInicial, String horaFinal, String numAfiliado) {
		try {
			if (nit != null )
			{
				
				boolean existe = epsAndes.existeIps(nit);
				if(existe)
				{
					epsAndes.crearServicioHospitalizacion(nit, respSemana, horaInicial, horaFinal, numAfiliado);
					panelDatos.actualizarInterfaz("El servico de Hospitalizacion  : "+nit+" fue registrado con exito ");
				}
				else
					panelDatos.actualizarInterfaz("Esta Hospitalizacion : "+nit+" ya está registrada ");
			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}
		} catch (Exception e)
		{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void habilitarServicio()
	{
		String id = JOptionPane.showInputDialog(null, "Ingresar identificador del servicio", "Habilitar un servicio");
        if (id != "" || id != null) 
        {
    	JOptionPane.showConfirmDialog(null, "¿Se habilitar el servicio?", "Habilitar el servicio de salud", JOptionPane.YES_NO_OPTION);
		epsAndes.habilitarServicio(id);
        }
        else 
        {
           System.exit(0);
        }
	}
	public void deshabilitarServicio()
	{
		String id = JOptionPane.showInputDialog(null, "Ingresar identificador del servicio", "Deshabilitar un servicio");
        if (id != "" || id != null) 
        {
    	JOptionPane.showConfirmDialog(null, "¿Se deshabilitar el servicio?", "Deshabilitar el servicio de salud", JOptionPane.YES_NO_OPTION);
		epsAndes.deshabilitarServicio(id);
        }
        else 
        {
           System.exit(0);
        }
	}
}
