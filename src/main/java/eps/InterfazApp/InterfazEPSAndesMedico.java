
package eps.InterfazApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import eps.negocio.EpsAndes;
/**
 * Clase principal de la interfaz
 */
@SuppressWarnings("serial")
public class InterfazEPSAndesMedico extends JFrame implements ActionListener
{
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazEPSAndesMedico.class.getName());
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigAppMedico.json"; 
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
	public InterfazEPSAndesMedico()
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
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
	 * Registrar una orden médica
	 */
	public void registrarOrden()
	{
		new PanelRegistrarOrden(this);
	}
	/**
	 * Registrar una receta médica
	 */
	public void registrarReceta()
	{
		new PanelRegistrarReceta(this);
	}
	/**
	 * Dar de alta a un afiliado
	 */
	public void darDeAlta()
	{
		String numCC = JOptionPane.showInputDialog(null, "Ingresar número de documento", "Dar de alta a un afiliado");
		if (numCC != "" || numCC != null) 
		{
			int reply = JOptionPane.showConfirmDialog(null, "¿Se desea dar de alta al afiliado?", "Dar de alta", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.OK_OPTION)
				epsAndes.consultaUrgenciasDadoAlta(numCC);
		}
		else 
		{
			System.exit(0);
		}
	}

	/**
	 * Cambiar el triage
	 */
	public void cambiarTriage()
	{
		JTextField id = new JTextField(15);
		JTextField triage = new JTextField(15);

		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("ID de la consulta:"));
		myPanel.add(id);
		myPanel.add(new JLabel("Triage nuevo:"));
		myPanel.add(triage);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Cambiar triage", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION)
			if(!epsAndes.consultaUrgenciasDadoAlta(id.getText()))
				epsAndes.cambiarTriage(triage.getText(), id.getText());
			else
				panelDatos.actualizarInterfaz("La consulta en urgencias no se encuentra habiliatada: Afiliado dado de alta");
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
			Method req = InterfazEPSAndesMedico.class.getMethod ( evento );			
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
			BasicConfigurator.configure();
			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
			InterfazEPSAndesMedico interfaz = new InterfazEPSAndesMedico( );
			interfaz.setVisible( true );

		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}

	public void registrarOrdenDatos(String fecha1, String numCcAfiliado, String tipoDeServicio) {

	}
	
	//Verificar que existe una consulta con el id
	public void registrarRecetaDatos(String fecha1, String text, String string) {

	}
}
