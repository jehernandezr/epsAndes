
package uniandes.isis2304.parranderos.interfazApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

import negocio.EpsAndes;
import uniandes.isis2304.parranderos.negocio.VOTipoBebida;
/**
 * Clase principal de la interfaz
 */
@SuppressWarnings("serial")
public class InterfazEPSAndes extends JFrame implements ActionListener
{
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazEPSAndes.class.getName());
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
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
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazEPSAndes( )
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
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Eps Andes App", JOptionPane.ERROR_MESSAGE);
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
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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
    /**
     * Inicializa como administrador del sistema
     */
    public void iniciarAdmin()
    {
    	try 
    	{
    		String numCc = JOptionPane.showInputDialog (this, "Ingrese su número de cédula", "Ingresar como administrador", JOptionPane.QUESTION_MESSAGE);
    		if (numCc != null)
    		{
    			
    			boolean existe = epsAndes.existeAdmin(numCc);
    			if(existe)
    			{
    				InterfazEPSAndesAdministrador interfaz = new InterfazEPSAndesAdministrador();
    				interfaz.registrarNumCcIngresado(numCc);
    	            interfaz.setVisible( true );
    			}
    			else
        			panelDatos.actualizarInterfaz("El administrador no existe");
    		}
    		else
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
		} 
    	catch (Exception e) 
    	{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    /**
     * Inicializa como recepcionista del sistema
     */
    public void iniciarRecepcionista()
    {
    	try 
    	{
    		String numCc = JOptionPane.showInputDialog (this, "Ingrese su número de cédula", "Ingresar como recepcionista", JOptionPane.QUESTION_MESSAGE);
    		if (numCc != null)
    		{
    			long idNumCc = Long.valueOf (numCc);
    			boolean existe = epsAndes.existeRecepcionista(idNumCc);
    			if(existe)
    			{
    				InterfazEPSAndesRecepcionista interfaz = new InterfazEPSAndesRecepcionista();
    				interfaz.registrarNumCcIngresado(idNumCc);
    	            interfaz.setVisible( true );
    			}
    			else
    			{
        			panelDatos.actualizarInterfaz("El recepcionista no existe");
    			}
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    /**
     * Inicializa como afiliado del sistema
     */
    public void iniciarAfiliado()
    {
    	try 
    	{
    		String numCc = JOptionPane.showInputDialog (this, "Ingrese su número de cédula", "Ingresar como afiliado", JOptionPane.QUESTION_MESSAGE);
    		if (numCc != null)
    		{
    			long idNumCc = Long.valueOf (numCc);
    			boolean existe = epsAndes.existeAfiliado(idNumCc);
    			if(existe)
    			{
    				InterfazEPSAndesAfiliado interfaz = new InterfazEPSAndesAfiliado();
    				interfaz.registrarNumCcIngresado(idNumCc);
    	            interfaz.setVisible( true );
    			}
    			else
    			{
        			panelDatos.actualizarInterfaz("El afiliado no existe");
    			}
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    /**
     * Inicializa como médico del sistema
     */
    public void iniciarMedico()
    {
    	try 
    	{
    		String numCc = JOptionPane.showInputDialog (this, "Ingrese su número de cédula", "Ingresar como médico", JOptionPane.QUESTION_MESSAGE);
    		if (numCc != null)
    		{
    			long idNumCc = Long.valueOf (numCc);
    			boolean existe = epsAndes.existeMedico(idNumCc);
    			if(existe)
    			{
    				InterfazEPSAndesMedico interfaz = new InterfazEPSAndesMedico();
    				interfaz.registrarNumCcIngresado(idNumCc);
    	            interfaz.setVisible( true );
    			}
    			else
    			{
        			panelDatos.actualizarInterfaz("El médico no existe");
    			}
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    /**
     * Registrar un nuevo admisnitador al sistema
     */
    public void registrarAdmin()
    {
		new PanelRegistrarAdmin(this);
    }
    /**
     * Eliminar un administrador por número de cédula
     */
    public void eliminarAdmin()
    {
    	try 
    	{
    		String numCc = JOptionPane.showInputDialog (this, "Ingrese su número de cédula", "Eliminar administrador", JOptionPane.QUESTION_MESSAGE);
    		if (numCc != null)
    		{
    			long idNumCc = Long.valueOf (numCc);
    			epsAndes.eliminarAdministrador(numCc);
    		}
    		else
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
		} 
    	catch (Exception e) 
    	{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    /**
     * Limpiar base de datos - Realizar por el administrador
     */
    public void limpiarBD()
    {
    	try
    	{
    		int response = JOptionPane.showConfirmDialog(null,  "¿Quieres eliminar la base de datos de EPSAndes?", "Selecciona una opción",JOptionPane.YES_NO_OPTION);
    		if(response == 0)
    			epsAndes.limpiarEpsAndes();
    	}
    	catch(Exception e)
    	{
    		String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
    	}
    }
    /**
     * Registro de un administrador
     */
    public void registroDeDatosAdmin(String nombre, String correo, String numCc)
    {
    	try {
    		if (numCc != null && nombre != null && correo != null)
    		{
    		
    			boolean existe = epsAndes.existeAdmin(numCc);
    			if(!existe)
    			{
    				epsAndes.crearAdministrador(nombre, correo, numCc);
    				InterfazEPSAndesAdministrador interfaz = new InterfazEPSAndesAdministrador();
    				interfaz.registrarNumCcIngresado(numCc);
    	            interfaz.setVisible( true );
    			}
    			else
    			{
        			panelDatos.actualizarInterfaz("El administrador no existe");
    			}
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
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
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral()
	{
		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
	}
	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Parranderos.pdf");
	}
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Parranderos.pdf");
	}
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaParranderos.sql");
	}
	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			Method req = InterfazEPSAndes.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
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
        	UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazEPSAndes interfaz = new InterfazEPSAndes( );
            interfaz.setVisible( true );
            BasicConfigurator.configure();
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
