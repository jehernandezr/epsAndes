package eps.InterfazApp;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

/**
 * Dialogo para agregar un nuevo recepcionista al sistema.
 */

public class PanelRegistrarReceta 
{
	public PanelRegistrarReceta(InterfazEPSAndesMedico interfaz)
	{
		String[] tipoServicio = {"GENERAL", "URGENCIAS"};
		JComboBox tipoSevicioSolicitado = new JComboBox<String>(tipoServicio);

		JPanel myPanel = new JPanel();
		GridLayout layout = new GridLayout(3,2);
		myPanel.setLayout(layout);
		
		JTextField idCitaMedica = new JTextField(15);		
		
		//Bloque panel de dialogo de calendario
				JDateChooser jd = new JDateChooser();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				myPanel.add(jd); 

		myPanel.add(new JLabel("Tipo de consulta:"));
		myPanel.add(tipoSevicioSolicitado);
		myPanel.add(new JLabel("Id de la consulta:"));
		myPanel.add(idCitaMedica);
		myPanel.add(new JLabel("Fecha de solicitud:"));
		myPanel.add(jd);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar una receta"
				+ "", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION)
		{
			String fecha1="";
			fecha1 = sdf.format(jd.getDate()).toString();
			interfaz.registrarRecetaDatos(fecha1, idCitaMedica.getText(), tipoSevicioSolicitado.getSelectedItem().toString());
		}
	}
}