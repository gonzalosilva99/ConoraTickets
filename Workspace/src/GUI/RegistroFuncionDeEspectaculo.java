package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RegistroFuncionDeEspectaculo extends JInternalFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFuncionDeEspectaculo frame = new RegistroFuncionDeEspectaculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroFuncionDeEspectaculo() {
		setTitle("Registrar Espectador a Funcion de Espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, -377, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBoxPlataforma = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, -5, SpringLayout.NORTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -152, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lblEspectaculos = new JLabel("Espectaculo: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 15, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculos, -377, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblEspectaculos);
		
		Panel panel = new Panel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 499, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblFuncion = new JLabel("Funcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFuncion, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFuncion, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblFuncion, -342, SpringLayout.EAST, panel);
		panel.add(lblFuncion);
		
		JComboBox comboBoxEspectaculo = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 3, SpringLayout.SOUTH, comboBoxEspectaculo);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectaculo, 8, SpringLayout.SOUTH, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectaculo, 17, SpringLayout.EAST, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectaculo, -152, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 0, SpringLayout.WEST, comboBoxEspectaculo);
		comboBoxEspectaculo.setEnabled(false);
		
		JComboBox comboBoxFuncion = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxFuncion, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxFuncion, -110, SpringLayout.EAST, panel);
		panel.add(comboBoxFuncion);
		
		JComboBox comboBoxEspectador = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxEspectador, 3, SpringLayout.SOUTH, comboBoxFuncion);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxEspectador, 179, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxEspectador, -110, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxFuncion, 0, SpringLayout.WEST, comboBoxEspectador);
		comboBoxEspectador.setEnabled(false);
		panel.add(comboBoxEspectador);
		
		JLabel lblEspectador = new JLabel("Espectador: ");
		sl_panel.putConstraint(SpringLayout.EAST, lblEspectador, -342, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectador, 12, SpringLayout.SOUTH, lblFuncion);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectador, 10, SpringLayout.WEST, panel);
		panel.add(lblEspectador);
		
		JCheckBox chckbxCanjear = new JCheckBox("Canjear la Funcion?");
		sl_panel.putConstraint(SpringLayout.WEST, chckbxCanjear, 10, SpringLayout.WEST, panel);
		panel.add(chckbxCanjear);
		
		Panel panelInterior = new Panel();
		sl_panel.putConstraint(SpringLayout.NORTH, panelInterior, 94, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panelInterior, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxCanjear, -6, SpringLayout.NORTH, panelInterior);
		panelInterior.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.WEST, panelInterior, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panelInterior, 479, SpringLayout.WEST, panel);
		panel.add(panelInterior);
		SpringLayout sl_panelInterior = new SpringLayout();
		panelInterior.setLayout(sl_panelInterior);
		
		JLabel lblCanjearPor = new JLabel("Canjear por:");
		sl_panelInterior.putConstraint(SpringLayout.NORTH, lblCanjearPor, 10, SpringLayout.NORTH, panelInterior);
		sl_panelInterior.putConstraint(SpringLayout.WEST, lblCanjearPor, 10, SpringLayout.WEST, panelInterior);
		panelInterior.add(lblCanjearPor);
		
		JRadioButton rdbtnPaquete = new JRadioButton("Paquete");
		buttonGroup.add(rdbtnPaquete);
		sl_panelInterior.putConstraint(SpringLayout.NORTH, rdbtnPaquete, -4, SpringLayout.NORTH, lblCanjearPor);
		sl_panelInterior.putConstraint(SpringLayout.WEST, rdbtnPaquete, 6, SpringLayout.EAST, lblCanjearPor);
		panelInterior.add(rdbtnPaquete);
		
		JRadioButton rdbtnFuncion = new JRadioButton("Tres Funciones");
		buttonGroup.add(rdbtnFuncion);
		sl_panelInterior.putConstraint(SpringLayout.NORTH, rdbtnFuncion, 4, SpringLayout.SOUTH, rdbtnPaquete);
		sl_panelInterior.putConstraint(SpringLayout.WEST, rdbtnFuncion, 0, SpringLayout.WEST, rdbtnPaquete);
		panelInterior.add(rdbtnFuncion);
		
		JLabel lblListaPaquetesFunciones = new JLabel("Paquetes por los que puede canjear:");
		sl_panelInterior.putConstraint(SpringLayout.NORTH, lblListaPaquetesFunciones, 54, SpringLayout.SOUTH, lblCanjearPor);
		sl_panelInterior.putConstraint(SpringLayout.WEST, lblListaPaquetesFunciones, 0, SpringLayout.WEST, lblCanjearPor);
		panelInterior.add(lblListaPaquetesFunciones);
		
		JList<? extends String> list = new JList();
		sl_panelInterior.putConstraint(SpringLayout.NORTH, list, 6, SpringLayout.SOUTH, lblListaPaquetesFunciones);
		sl_panelInterior.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, panelInterior);
		sl_panelInterior.putConstraint(SpringLayout.SOUTH, list, 196, SpringLayout.SOUTH, lblListaPaquetesFunciones);
		sl_panelInterior.putConstraint(SpringLayout.EAST, list, 459, SpringLayout.WEST, panelInterior);
		panelInterior.add(list);
		getContentPane().add(comboBoxEspectaculo);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -15, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -42, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 323, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -104, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 6, SpringLayout.EAST, buttonCancelar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -42, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		buttonCancelar.setActionCommand("Cancelar");
		getContentPane().add(buttonCancelar);

	}
}