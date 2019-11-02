package eps.InterfazApp;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialogo para agregar un nuevo servicio de salud al sistema.
 */

public class PanelRegistrarServicioSalud 
{
	public PanelRegistrarServicioSalud(InterfazEPSAndesAdministrador interfaz, String opcionSeleccionada)
	{
		JPanel myPanel = new JPanel();
		JTextField nombreIps = new JTextField();
		JTextField HorarioAtencion = new JTextField();
		JTextField HorarioAtencio = new JTextField();
		switch(opcionSeleccionada)
		{
		case "Consulta médica":
			
			
			break;
		case "Consulta de urgencia":
			
			break;
		case "Hospitalización":
			
			break;
		case "Exámenes":
			
			break;
		case "Terapias":
			
			break;
		case "Procedimiento especializado":
			
			break;
		}
		int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio de salud", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION)
		{
		}
	}
}