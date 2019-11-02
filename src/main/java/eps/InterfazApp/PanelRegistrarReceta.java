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
		String[] tipoServicio = {"CONSULTA", "URGENCIAS", "HOSPITALIZACION", "EXAMENES", "TERAPIAS", "PROCEDIMIENTO ESPECIALIZADO"};
		JComboBox tipoSevicioSolicitado = new JComboBox<String>(tipoServicio);

		JPanel myPanel = new JPanel();
		GridLayout layout = new GridLayout(5,2);
		myPanel.setLayout(layout);

		//Bloque panel de dialogo de calendario
		JDateChooser jd = new JDateChooser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		myPanel.add(jd);     

		JTextField numCcAfiliado = new JTextField(15);

		myPanel.add(new JLabel("Tipo de servicio:"));
		myPanel.add(tipoSevicioSolicitado);
		myPanel.add(new JLabel("Número de documento(Afiliado):"));
		myPanel.add(numCcAfiliado);
		myPanel.add(new JLabel("Fecha de solicitud:"));
		myPanel.add(jd);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un recepcionista"
				+ "", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION)
		{
			String fecha1="";
			fecha1 = sdf.format(jd.getDate()).toString();
			interfaz.registrarOrdenDatos(fecha1, numCcAfiliado.getText(), tipoSevicioSolicitado.getSelectedItem().toString());
		}
	}
}