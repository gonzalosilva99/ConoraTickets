package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConsultaFuncionEspectaculo extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionEspectaculo frame = new ConsultaFuncionEspectaculo();
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
	public ConsultaFuncionEspectaculo() {
		setTitle("Consulta de función de espectáculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Plataforma:");
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 113, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -141, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Espect\u00E1culo:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -141, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Funcion");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 136, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, comboBox_1);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2, 118, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -15, SpringLayout.NORTH, comboBox_2);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_2, -374, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, comboBox_2);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 16, SpringLayout.SOUTH, comboBox_2);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2, 0, SpringLayout.EAST, comboBox);
		getContentPane().add(comboBox_2);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 199, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, -21, SpringLayout.NORTH, panel);
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("Datos de la funci\u00F3n ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 193, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre: ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 39, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de inicio:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 71, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de alta:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 104, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Artistas:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 19, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre de espect\u00E1culo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 20, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_8, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Descripci\u00F3n de espect\u00E1culo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 18, SpringLayout.SOUTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_9, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_9);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, 19, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -127, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 87, SpringLayout.EAST, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -127, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblNewLabel_5);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, -3, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 95, SpringLayout.EAST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -127, SpringLayout.EAST, panel);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_3, -3, SpringLayout.NORTH, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_3, 129, SpringLayout.EAST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_3, 3, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_3, -127, SpringLayout.EAST, panel);
		panel.add(comboBox_3);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 13, SpringLayout.SOUTH, comboBox_3);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 38, SpringLayout.EAST, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, -127, SpringLayout.EAST, panel);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_3, -8, SpringLayout.NORTH, textField_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, 265, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 18, SpringLayout.EAST, lblNewLabel_9);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -127, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 201, SpringLayout.NORTH, panel);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar datos");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 474, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, -261, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -124, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, -105, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton_1);

	}
}
