package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Button;
import javax.swing.JTextField;

public class ConsultaEspectaculo extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEspectaculo frame = new ConsultaEspectaculo();
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
	public ConsultaEspectaculo() {
		setTitle("Consulta de Espectaculo");
		setBounds(100, 100, 525, 596);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 44, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 58, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 37, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -212, SpringLayout.EAST, getContentPane());
		comboBox.addItem("");
		comboBox.addItem("Pan");
		comboBox.addItem("Manteca");
		getContentPane().add(comboBox);
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculos, 37, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculos, 115, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblEspectaculos);
		lblEspectaculos.setVisible(false);
		
		JComboBox comboBox_1 = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 6, SpringLayout.NORTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 36, SpringLayout.EAST, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, 24, SpringLayout.NORTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 0, SpringLayout.EAST, comboBox);
		comboBox_1.addItem("");
		comboBox_1.addItem("Pan");
		comboBox_1.addItem("Manteca");
		getContentPane().add(comboBox_1);
		comboBox_1.setVisible(false);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblEspectaculos.setVisible(true);
				comboBox_1.setVisible(true);
			}
		});
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 100, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 508, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 37, SpringLayout.NORTH, panel);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descripcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 70, SpringLayout.NORTH, panel);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Duracion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1, 39, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 0, SpringLayout.EAST, lblNewLabel_1_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1, 0, SpringLayout.WEST, lblNewLabel_1);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Espect. minimos:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_1, 142, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1, -6, SpringLayout.NORTH, lblNewLabel_1_2_1_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_1, -239, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1, 0, SpringLayout.EAST, lblNewLabel_1_2_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Espect. maximos:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_2, 175, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_2, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_2, 33, SpringLayout.SOUTH, lblNewLabel_1_2_1_1);
		panel.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("URL:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_2_1, 6, SpringLayout.SOUTH, lblNewLabel_1_2_1_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_2_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_2_1, 33, SpringLayout.SOUTH, lblNewLabel_1_2_1_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1_2_1, 0, SpringLayout.EAST, lblNewLabel_1_2_1_1);
		panel.add(lblNewLabel_1_2_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Costo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_2_2, 6, SpringLayout.SOUTH, lblNewLabel_1_2_1_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_2_2, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2, -140, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1_2_2, 0, SpringLayout.EAST, lblNewLabel_1_2_1_1);
		panel.add(lblNewLabel_1_2_1_2_2);
		
		JLabel lblNewLabel_1_2_1_2_2_1 = new JLabel("Fecha de alta:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_2_2_1, 6, SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_2_2_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2_1, 33, SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1_2_2_1, 0, SpringLayout.EAST, lblNewLabel_1_1);
		panel.add(lblNewLabel_1_2_1_2_2_1);
		
		JLabel lblNewLabel_1_2_1_2_2_2 = new JLabel("Paquetes:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_2_2_2, 6, SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_2_2_2, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2_2, 33, SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1_2_2_2, 0, SpringLayout.EAST, lblNewLabel_1_1);
		panel.add(lblNewLabel_1_2_1_2_2_2);
		
		JLabel lblNewLabel_1_2_1_2_2_3 = new JLabel("Funciones:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1_2_2_3, 6, SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1_2_2_3, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2_3, 33, SpringLayout.SOUTH, lblNewLabel_1_2_1_2_2_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2_1_2_2_3, 119, SpringLayout.WEST, lblNewLabel_1);
		panel.add(lblNewLabel_1_2_1_2_2_3);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, 46, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -93, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, 0, SpringLayout.EAST, panel);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 4, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 88, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 252, SpringLayout.EAST, lblNewLabel_1);
		textField.setColumns(10);
		panel.add(textField);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 4, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, 56, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 300, SpringLayout.WEST, textField);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 4, SpringLayout.NORTH, lblNewLabel_1_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 4, SpringLayout.NORTH, lblNewLabel_1_2_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 4, SpringLayout.NORTH, lblNewLabel_1_2_1_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, 4, SpringLayout.NORTH, lblNewLabel_1_2_1_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_5, 23, SpringLayout.NORTH, lblNewLabel_1_2_1_2_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, textField);
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_6, 4, SpringLayout.NORTH, lblNewLabel_1_2_1_2_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_6, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_6, 0, SpringLayout.EAST, textField);
		textField_6.setColumns(10);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_7, 4, SpringLayout.NORTH, lblNewLabel_1_2_1_2_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_7, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_7, 0, SpringLayout.EAST, textField);
		textField_7.setColumns(10);
		panel.add(textField_7);
		
		JComboBox comboBox_2 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_2, 4, SpringLayout.NORTH, lblNewLabel_1_2_1_2_2_2);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_2, 33, SpringLayout.SOUTH, textField_7);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_2, 0, SpringLayout.EAST, textField);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_3, 17, SpringLayout.SOUTH, comboBox_2);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_3, 29, SpringLayout.EAST, lblNewLabel_1_2_1_2_2_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_3, 36, SpringLayout.SOUTH, comboBox_2);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_3, 0, SpringLayout.EAST, textField);
		panel.add(comboBox_3);
		getContentPane().add(buttonAceptar);
		
		Button buttonAceptar_1 = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1, -40, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1, -99, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1, 0, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonAceptar_1);
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});

	}
}
