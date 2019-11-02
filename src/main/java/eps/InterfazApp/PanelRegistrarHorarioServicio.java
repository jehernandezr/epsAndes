package eps.InterfazApp;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Dialogo para agregar un nuevo recepcionista al sistema.
 */
public class PanelRegistrarHorarioServicio implements ChangeListener
{
	private JCheckBox lunes;
	private JCheckBox martes;
	private JCheckBox miercoles;
	private JCheckBox jueves;
	private JCheckBox viernes;
	private JCheckBox sabado;
	private JCheckBox domingo;
	
	public String respSemana;
	public String horaInicial;
	public String horaFinal;
	public String numAfiliado;

	public PanelRegistrarHorarioServicio(InterfazEPSAndesAdministrador interfaz)
	{
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Días de atención:"));

		JPanel myPanelDias = new JPanel();
		GridLayout layoutDias = new GridLayout(3,3);
		myPanelDias.setLayout(layoutDias);
		lunes = new JCheckBox("Lunes");
		lunes.addChangeListener(this);        
		myPanelDias.add(lunes);
		martes = new JCheckBox("Martes");
		martes.addChangeListener(this);        
		myPanelDias.add(martes);
		miercoles = new JCheckBox("Miércoles");
		miercoles.addChangeListener(this);        
		myPanelDias.add(miercoles);
		jueves = new JCheckBox("Jueves");
		jueves.addChangeListener(this);        
		myPanelDias.add(jueves);
		viernes = new JCheckBox("Viernes");
		viernes.addChangeListener(this);        
		myPanelDias.add(viernes);
		sabado = new JCheckBox("Sábado");
		sabado.addChangeListener(this);        
		myPanelDias.add(sabado);
		myPanelDias.add(new JLabel(""));
		domingo = new JCheckBox("Domingo");
		domingo.addChangeListener(this);        
		myPanelDias.add(domingo);
		myPanel.add(myPanelDias);

		JPanel myPanelDatos = new JPanel();
		GridLayout layoutDatos = new GridLayout(3,3);
		myPanelDatos.setLayout(layoutDatos);
		myPanelDatos.add(new JLabel("Hora de inicio:"));
		JTextField horaInicio = new JTextField(15);
		myPanelDatos.add(horaInicio);
		myPanelDatos.add(new JLabel("Hora de finalización:"));
		JTextField horaFinal = new JTextField(15);
		myPanelDatos.add(horaFinal);
		myPanelDatos.add(new JLabel("Número de afiliados:"));
		JTextField numAfiliados = new JTextField(15);
		myPanelDatos.add(numAfiliados);
		myPanel.add(myPanelDatos);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar un horario", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION)
		{
			stateChanged(null);
			this.numAfiliado = numAfiliados.getText();
			this.horaInicial = horaInicio.getText();
			this.horaFinal = horaFinal.getText();
		}
	}
	public void stateChanged(ChangeEvent e)
	{
		respSemana="";
		if (lunes.isSelected()==true)
			respSemana="l-";
		if (martes.isSelected()==true)
			respSemana=respSemana+"m-";
		if (miercoles.isSelected()==true)
			respSemana=respSemana+"x-";
		if (jueves.isSelected()==true)
			respSemana=respSemana+"j-";
		if (viernes.isSelected()==true)
			respSemana=respSemana+"v-";
		if (sabado.isSelected()==true)
			respSemana=respSemana+"s-";
		if (domingo.isSelected()==true)
			respSemana=respSemana+"d";
	}
	private String estadoSeleccionados()
	{
		return respSemana;		
	}
}