package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificarDatosUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosUsuario frame = new ModificarDatosUsuario();
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
	public ModificarDatosUsuario() {
		setTitle("Modificar datos de espectáculo");
		setBounds(100, 100, 525, 550);
		
		JLabel lblNewLabel = new JLabel("Plataforma:");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 44, SpringLayout.NORTH, getContentPane());
		getContentPane().setLayout(springLayout);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 116, SpringLayout.WEST, getContentPane());
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -431, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_1);
		
		Button buttonAceptar_1 = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1, -89, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar_1);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 321, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -20, SpringLayout.WEST, buttonAceptar_1);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1, 0, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1, 0, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(buttonAceptar);
		
		JLabel lblNewLabel_2 = new JLabel("Artista:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 109, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 106, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 64, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -243, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, comboBox_1);
		getContentPane().add(comboBox_1);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, -31, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 159, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, buttonAceptar_1);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, buttonAceptar_1);
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 18, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Minimos espectadores:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_3);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Maximos espectadores:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 176, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -21, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel_3);
		panel.add(lblNewLabel_6);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 98, SpringLayout.EAST, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -145, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 9, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 78, SpringLayout.EAST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 133, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -19, SpringLayout.NORTH, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_2, -18, SpringLayout.NORTH, textField_3);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, -3, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 13, SpringLayout.EAST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Url:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 24, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel_3);
		panel.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, -3, SpringLayout.NORTH, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 127, SpringLayout.EAST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Costo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 17, SpringLayout.SOUTH, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblNewLabel_3);
		panel.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, -3, SpringLayout.NORTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 111, SpringLayout.EAST, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, textField);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Fecha:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblNewLabel_3);
		panel.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_6, 109, SpringLayout.EAST, lblNewLabel_9);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_6, -4, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_6, -145, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 3, SpringLayout.NORTH, textField_6);
		panel.add(textField_6);
		textField_6.setColumns(10);
	}
}
