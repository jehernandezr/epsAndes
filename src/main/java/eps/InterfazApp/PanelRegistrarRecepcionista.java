package eps.InterfazApp;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialogo para agregar un nuevo recepcionista al sistema.
 */

public class PanelRegistrarRecepcionista 
{
	   public PanelRegistrarRecepcionista(InterfazEPSAndesAdministrador interfaz)
	   {
		      JTextField nombre = new JTextField(15);
		      JTextField numCc = new JTextField(15);
		      JTextField correo = new JTextField(15);
		      JTextField ips = new JTextField(15);
		      GridLayout layout = new GridLayout(4,2);

		      JPanel myPanel = new JPanel();
		      myPanel.setLayout(layout);
		      myPanel.add(new JLabel("Nombre:"));
		      myPanel.add(nombre);
		      myPanel.add(new JLabel("Número de cédula:"));
		      myPanel.add(numCc);
		      myPanel.add(new JLabel("Correo electrónico:"));
		      myPanel.add(correo);
		      myPanel.add(new JLabel("Id de la IPS:"));
		      myPanel.add(ips);

		      int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un recepcionista"
		      		+ "", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION)
		      {
		    	  interfaz.registrarRecepcionistaDatos(nombre.getText(), numCc.getText(), correo.getText(), ips.getText());
		      }
		   }
		}