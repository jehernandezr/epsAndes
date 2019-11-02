package eps.InterfazApp;


import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
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
		GridLayout layout;
		JTextField idIPS;
		int result;
		switch(opcionSeleccionada)
		{
		case "Consulta médica":
			layout = new GridLayout(2,2);
			myPanel.setLayout(layout);
			idIPS = new JTextField(15);
			myPanel.add(new JLabel("NIT de la IPS:"));
			myPanel.add(idIPS);
			myPanel.add(new JLabel("Tipo de consulta:"));
			String[] tipoCita = {"CONTROL", "GENERAL", "ESPECIALISTA" };
			JComboBox consulta = new JComboBox<String>(tipoCita);
			myPanel.add(consulta);
			
			result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio de salud", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
				
			}
			break;
		case "Consulta de urgencia":
			layout = new GridLayout(1,2);
			myPanel.setLayout(layout);
			idIPS = new JTextField(15);
			myPanel.add(new JLabel("NIT de la IPS:"));
			myPanel.add(idIPS);
			
			result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio de salud", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
				
			}
			break;
		case "Hospitalización":
			layout = new GridLayout(1,2);
			myPanel.setLayout(layout);
			idIPS = new JTextField(15);
			myPanel.add(new JLabel("NIT de la IPS:"));
			myPanel.add(idIPS);
			
			result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio de salud", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
				
			}
			break;
		case "Examenes":
			layout = new GridLayout(2,2);
			myPanel.setLayout(layout);
			idIPS = new JTextField(15);
			myPanel.add(new JLabel("NIT de la IPS:"));
			myPanel.add(idIPS);
			myPanel.add(new JLabel("Tipo de examen:"));
			String[] tipoExamen = {"Presión alta", "Coresterol", "Oculares", "Sangre - General", "ETS", "Diabetes" };
			JComboBox tExamen = new JComboBox<String>(tipoExamen);
			myPanel.add(tExamen);
			
			result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio de salud", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
				
			}
			break;
		case "Terapias":
			layout = new GridLayout(2,2);
			myPanel.setLayout(layout);
			idIPS = new JTextField(15);
			myPanel.add(new JLabel("NIT de la IPS:"));
			myPanel.add(idIPS);
			myPanel.add(new JLabel("Tipo de terapias:"));
			String[] tipoTerapias = {"Ultrasonidos", "Electroterapia", "Magnetoterapia", "Hidroterapia", "Masoterapia", "Sueroterapia", "Termoterapia" };
			JComboBox tTerapias = new JComboBox<String>(tipoTerapias);
			myPanel.add(tTerapias);
			
			result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio de salud", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
				
			}
			break;
		case "Procedimiento especializado":
			layout = new GridLayout(2,2);
			myPanel.setLayout(layout);
			idIPS = new JTextField(15);
			myPanel.add(new JLabel("NIT de la IPS:"));
			myPanel.add(idIPS);
			myPanel.add(new JLabel("Tipo de procedimiento:"));
			String[] tipoProcedimiento = {"Intervenciones", "Cirugia", "Cirugia Ambulatoria", "Dialisis" };
			JComboBox tProcedimiento = new JComboBox<String>(tipoProcedimiento);
			myPanel.add(tProcedimiento);
			
			result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio de salud", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION)
			{
			}
			
			break;
		}
		
	}
}