package eps.InterfazApp;


import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialogo para reservar un nuevo servicio de salud al sistema.
 */

public class PanelReservarServicioSaludAfiliado 
{
	public PanelReservarServicioSaludAfiliado(InterfazEPSAndesAfiliado interfaz, String opcionSeleccionada)
	{
		JPanel myPanel = new JPanel();
		GridLayout layout;
		String numOrden;
		switch(opcionSeleccionada)
		{
		case "Consulta médica G":
			layout = new GridLayout(5,2);
			myPanel.setLayout(layout);

			JTextField general = new JTextField("CITA GENERAL");
			myPanel.add(new JLabel("Tipo de consulta:"));
			general.setEnabled(true);
			myPanel.add(general);
			
			

			break;
		case "Consulta médica E":
			numOrden = JOptionPane.showInputDialog("Ingresar el número de la orden del servicio");
			boolean verificacion = interfaz.verificarOrden(numOrden);
			if(verificacion)
			{

			}
			else
			{

			}
			break;
		case "Consulta médica C":
			numOrden = JOptionPane.showInputDialog("Ingresar el número de la orden del servicio");

			break;
		case "Examenes":
			numOrden = JOptionPane.showInputDialog("Ingresar el número de la orden del servicio");

			break;
		case "Terapias":
			numOrden = JOptionPane.showInputDialog("Ingresar el número de la orden del servicio");

			break;
		case "Procedimiento especializado":
			numOrden = JOptionPane.showInputDialog("Ingresar el número de la orden del servicio");

			break;
		}

	}
}