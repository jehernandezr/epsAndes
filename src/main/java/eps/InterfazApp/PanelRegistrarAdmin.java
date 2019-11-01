package eps.InterfazApp;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialogo para agregar un nuevo administrador al sistema.
 */

public class PanelRegistrarAdmin 
{
	   public PanelRegistrarAdmin(InterfazEPSAndes interfaz)
	   {
		      JTextField nombre = new JTextField(15);
		      JTextField correo = new JTextField(15);
		      JTextField numCc = new JTextField(15);
		      
		      GridLayout layout = new GridLayout(3,2);

		      JPanel myPanel = new JPanel();
		      myPanel.setLayout(layout);
		      myPanel.add(new JLabel("Nombre:"));
		      myPanel.add(nombre);
		      myPanel.add(new JLabel("Correo:"));
		      myPanel.add(correo);
		      myPanel.add(new JLabel("Número de cédula:"));
		      myPanel.add(numCc);

		      int result = JOptionPane.showConfirmDialog(null, myPanel, 
		               "Registrar un administrador", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION)
		      {
		    	  interfaz.registroDeDatosAdmin(nombre.getText(), correo.getText(), numCc.getText());
		      }
		   }
		}