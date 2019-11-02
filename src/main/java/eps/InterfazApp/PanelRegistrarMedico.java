package eps.InterfazApp;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eps.negocio.Especializacion;

/**
 * Dialogo para agregar un nuevo médico al sistema.
 */

public class PanelRegistrarMedico 
{
	   public PanelRegistrarMedico(InterfazEPSAndesAdministrador interfaz)
	   {
		      JTextField nombre = new JTextField(15);
		      JTextField correo = new JTextField(15);
		      JTextField numCc = new JTextField(15);
		      JTextField numRegistro = new JTextField(15);
		      
		      String[] especialidad = {"INTERNA", "ODONTOLOGIA", "CIRUGIA", "CARDIOLOGIA","ORTOPEDIA", "DERMATOLOGIA", "PEDIATRIA", "TRAUMATOLOGIA", "NEUMOLOGIA", "GENERAL" };
		      JComboBox especializacion = new JComboBox<String>(especialidad);
		      
		      GridLayout layout = new GridLayout(5,2);

		      JPanel myPanel = new JPanel();
		      myPanel.setLayout(layout);
		      myPanel.add(new JLabel("Nombre:"));
		      myPanel.add(nombre);
		      myPanel.add(new JLabel("Correo:"));
		      myPanel.add(correo);
		      myPanel.add(new JLabel("Número de cédula:"));
		      myPanel.add(numCc);
		      myPanel.add(new JLabel("Número de registro:"));
		      myPanel.add(numRegistro);
		      myPanel.add(new JLabel("Especialización:"));
		      myPanel.add(especializacion);

		      int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un médico"
		      		+ "", JOptionPane.OK_CANCEL_OPTION);
		      Especializacion esp = Especializacion.valueOf(especializacion.getSelectedItem().toString());
		      if (result == JOptionPane.OK_OPTION)
		      {
		    	  interfaz.registrarMedicoDatos(nombre.getText(), correo.getText(), numCc.getText(), numRegistro.getText(), esp);
		      }
		   }
		}