package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class AltaEspectaculo extends JInternalFrame {
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
					AltaEspectaculo frame = new AltaEspectaculo();
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
	public AltaEspectaculo() {
		setTitle("Alta de espectaculo");
		setBounds(100, 100, 525, 550);
		
		JLabel lblNewLabel = new JLabel("Plataforma:");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 44, SpringLayout.NORTH, getContentPane());
		getContentPane().setLayout(springLayout);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 26, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -150, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 30, SpringLayout.NORTH, getContentPane());
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
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 26, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel_2);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 172, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -21, SpringLayout.WEST, comboBox_1);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 66, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -150, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, comboBox_1);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -18, SpringLayout.NORTH, comboBox_1);
		getContentPane().add(comboBox_1);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.SOUTH, comboBox_1);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -19, SpringLayout.NORTH, buttonAceptar_1);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, buttonAceptar_1);
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 32, SpringLayout.NORTH, panel);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 44, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_3);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Espectadores min.:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 79, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Espectadores max.:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -22, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 176, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_6);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 12, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -141, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 13, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 16, SpringLayout.EAST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -141, SpringLayout.EAST, panel);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 137, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -12, SpringLayout.NORTH, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 16, SpringLayout.EAST, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -141, SpringLayout.EAST, panel);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 18, SpringLayout.SOUTH, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 13, SpringLayout.EAST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, -141, SpringLayout.EAST, panel);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Url:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 24, SpringLayout.SOUTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_7, 0, SpringLayout.EAST, lblNewLabel_3);
		panel.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 22, SpringLayout.SOUTH, textField_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -141, SpringLayout.EAST, panel);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Costo:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, -14, SpringLayout.NORTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 248, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_8, 267, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_8, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_3);
		panel.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, 14, SpringLayout.SOUTH, textField_4);
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, -141, SpringLayout.EAST, panel);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Fecha:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 19, SpringLayout.SOUTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, 34, SpringLayout.SOUTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_9, 0, SpringLayout.EAST, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_9, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_6, 17, SpringLayout.SOUTH, textField_5);
		sl_panel.putConstraint(SpringLayout.WEST, textField_6, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_6, 36, SpringLayout.SOUTH, textField_5);
		sl_panel.putConstraint(SpringLayout.EAST, textField_6, -141, SpringLayout.EAST, panel);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Duraci\u00F3n");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 15, SpringLayout.SOUTH, lblNewLabel_9);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_10, 30, SpringLayout.SOUTH, lblNewLabel_9);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_10, 0, SpringLayout.EAST, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_10, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_7, 14, SpringLayout.SOUTH, textField_6);
		sl_panel.putConstraint(SpringLayout.WEST, textField_7, 16, SpringLayout.EAST, lblNewLabel_10);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_7, 33, SpringLayout.SOUTH, textField_6);
		sl_panel.putConstraint(SpringLayout.EAST, textField_7, -141, SpringLayout.EAST, panel);
		panel.add(textField_7);
		textField_7.setColumns(10);

	}
}
