package uniandes.isis2304.parranderos.interfazApp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Diálogo para agregar un nuevo socio al club.
 */
public class PanelRegistrarAdmin 
{
	   public PanelRegistrarAdmin(InterfazEPSAndes interfaz)
	   {
		      JTextField nombre = new JTextField(5);
		      JTextField correo = new JTextField(5);
		      JTextField numCc = new JTextField(5);

		      JPanel myPanel = new JPanel();
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