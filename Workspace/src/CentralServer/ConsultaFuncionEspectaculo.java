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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Button;

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
		setTitle("Consulta de funcion de espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 42, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 4, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 80, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -174, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Pan");
		comboBox.addItem("Manteca");
		
		JLabel lblNewLabel_1 = new JLabel("Espect\u00E1culo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 38, SpringLayout.SOUTH, lblNewLabel);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JComboBox comboBox_1 = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -169, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("Pan");
		comboBox_1.addItem("Manteca");
		comboBox_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Funcion:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 38, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JComboBox comboBox_2 = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 15, SpringLayout.SOUTH, comboBox_2);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2, 3, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2, -176, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox_2);
		comboBox_2.addItem("");
		comboBox_2.addItem("Pan");
		comboBox_2.addItem("Manteca");
		comboBox_2.setVisible(false);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, -25, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -110, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Datos de la funcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre: ");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_4);
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
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 31, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 147, SpringLayout.EAST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -113, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -13, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, -5, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, 17, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 109, SpringLayout.EAST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_2, 20, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -113, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, -2, SpringLayout.NORTH, lblNewLabel_6);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_3, 149, SpringLayout.EAST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_3, -114, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_3, -3, SpringLayout.NORTH, lblNewLabel_7);
		panel.add(comboBox_3);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 13, SpringLayout.SOUTH, comboBox_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 38, SpringLayout.EAST, lblNewLabel_8);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_3, -11, SpringLayout.NORTH, textField_4);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 205, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 12, SpringLayout.EAST, lblNewLabel_9);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -49, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -116, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblNewLabel_1.setVisible(true);
				comboBox_2.setVisible(true);
			}
		});
		
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblNewLabel_2.setVisible(true);
				comboBox_1.setVisible(true);
			}
		});
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});

	}
}
