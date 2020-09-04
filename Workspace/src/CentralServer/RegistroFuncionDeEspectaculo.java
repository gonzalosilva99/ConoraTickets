package CentralServer;

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
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBoxPlataforma = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 12, SpringLayout.EAST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -131, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lblEspectaculos = new JLabel("Espectaculo: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 15, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblEspectaculos);
		
		Panel panel = new Panel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 9, SpringLayout.SOUTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 499, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Funcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, comboBoxPlataforma);
		comboBox.setEnabled(false);
		
		JComboBox comboBoxFuncion = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxFuncion, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxFuncion, 24, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxFuncion, -122, SpringLayout.EAST, panel);
		panel.add(comboBoxFuncion);
		
		JComboBox comboBoxEspectador = new JComboBox();
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxEspectador, 0, SpringLayout.WEST, comboBoxFuncion);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxEspectador, 0, SpringLayout.EAST, comboBoxFuncion);
		comboBoxEspectador.setEnabled(false);
		panel.add(comboBoxEspectador);
		
		JLabel lblNewLabel_2 = new JLabel("Espectador: ");
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxEspectador, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 12, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		panel.add(lblNewLabel_2);
		
		JCheckBox chckbxCanjear = new JCheckBox("Canjear la Funcion?");
		sl_panel.putConstraint(SpringLayout.WEST, chckbxCanjear, 10, SpringLayout.WEST, panel);
		panel.add(chckbxCanjear);
		
		Panel panel_1 = new Panel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 94, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxCanjear, -6, SpringLayout.NORTH, panel_1);
		panel_1.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 479, SpringLayout.WEST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Canjear por:");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel);
		
		JRadioButton rdbtnPaquete = new JRadioButton("Paquete");
		buttonGroup.add(rdbtnPaquete);
		sl_panel_1.putConstraint(SpringLayout.NORTH, rdbtnPaquete, -4, SpringLayout.NORTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, rdbtnPaquete, 6, SpringLayout.EAST, lblNewLabel);
		panel_1.add(rdbtnPaquete);
		
		JRadioButton rdbtnFuncion = new JRadioButton("Tres Funciones");
		buttonGroup.add(rdbtnFuncion);
		sl_panel_1.putConstraint(SpringLayout.NORTH, rdbtnFuncion, 4, SpringLayout.SOUTH, rdbtnPaquete);
		sl_panel_1.putConstraint(SpringLayout.WEST, rdbtnFuncion, 0, SpringLayout.WEST, rdbtnPaquete);
		panel_1.add(rdbtnFuncion);
		
		JLabel lblListaPaquetesFunciones = new JLabel("Paquetes por los que puede canjear:");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblListaPaquetesFunciones, 54, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblListaPaquetesFunciones, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblListaPaquetesFunciones);
		
		JList<? extends String> list = new JList();
		sl_panel_1.putConstraint(SpringLayout.NORTH, list, 6, SpringLayout.SOUTH, lblListaPaquetesFunciones);
		sl_panel_1.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, list, 196, SpringLayout.SOUTH, lblListaPaquetesFunciones);
		sl_panel_1.putConstraint(SpringLayout.EAST, list, 459, SpringLayout.WEST, panel_1);
		panel_1.add(list);
		getContentPane().add(comboBox);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -15, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 476, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -98, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, 15, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 317, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		buttonCancelar.setActionCommand("Cancelar");
		getContentPane().add(buttonCancelar);

	}
}
