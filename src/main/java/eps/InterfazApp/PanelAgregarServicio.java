package eps.InterfazApp;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import eps.negocio.TipoDeDocumento;
import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;

/**
 * Dialogo para agregar un nuevo afiliado al sistema.
 */
public class PanelAgregarServicio 
{
	public PanelAgregarServicio(InterfazEPSAndesOrganizador interfaz)
	{
		JTextField numParticipantes = new JTextField(15);
		JTextField id_CampaNa = new JTextField(15);
		JTextField id_servicio = new JTextField(15);

		GridLayout layout = new GridLayout(5,2);

		JPanel myPanel = new JPanel();
		myPanel.setLayout(layout);
		myPanel.add(new JLabel("Identificador de la campaña:"));
		myPanel.add(id_CampaNa);
		myPanel.add(new JLabel("Número de participantes:"));
		myPanel.add(numParticipantes);
		myPanel.add(new JLabel("Servicio a asociar:"));
		myPanel.add(id_servicio);
		myPanel.add(new JLabel("Fecha de realización:"));
		
		//Bloque panel de dialogo de calendario
		JDateChooser jd = new JDateChooser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		myPanel.add(jd);     

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un servicio para la campaña"
				+ "", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION)
		{
			String fecha1="";
			fecha1 = sdf.format(jd.getDate()).toString();	
			interfaz.registrarServicioDatos(numParticipantes.getText(), id_CampaNa.getText(),id_servicio.getText(), fecha1);
		}
	}
}