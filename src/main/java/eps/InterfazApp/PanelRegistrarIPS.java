package eps.InterfazApp;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Dialogo para agregar una nueva IPS al sistema.
 */

public class PanelRegistrarIPS 
{
	   public PanelRegistrarIPS(InterfazEPSAndesAdministrador interfaz)
	   {
		      JTextField nombre = new JTextField(15);
		      JTextField localizacion = new JTextField(15);
		      GridLayout layout = new GridLayout(2,2);

		      JPanel myPanel = new JPanel();
		      myPanel.setLayout(layout);
		      myPanel.add(new JLabel("Nombre:"));
		      myPanel.add(nombre);
		      myPanel.add(new JLabel("Dirección:"));
		      myPanel.add(localizacion);
		      

		      int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un IPS"
		      		+ "", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION)
		      {
		    	  interfaz.registrarIPSDatos(nombre.getText(), localizacion.getText());
		      }
		   }
		}