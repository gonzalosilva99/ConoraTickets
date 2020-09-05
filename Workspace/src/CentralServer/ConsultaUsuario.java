package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Button;

public class ConsultaUsuario extends JInternalFrame {
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
					ConsultaUsuario frame = new ConsultaUsuario();
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
	public ConsultaUsuario() {
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -115, SpringLayout.EAST, getContentPane());
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Usuario1", "Usuario2", "Usuario3"}));
		getContentPane().add(comboBox);
		
		
		JLabel lblNewLabel = new JLabel("Seleccionar usuario:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -341, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -5, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField, 95, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 7, SpringLayout.NORTH, panel);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, panel);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 3, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -45, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 14, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 21, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, 0, SpringLayout.EAST, lblNewLabel_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_2, 3, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 95, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 15, SpringLayout.SOUTH, textField_1);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1_1, -10, SpringLayout.EAST, lblNewLabel_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 13, SpringLayout.SOUTH, textField_2);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 3, SpringLayout.NORTH, textField_3);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 10, SpringLayout.SOUTH, textField_3);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textField);
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("dd-MM-yyyy");
		panel.add(dateChooser);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nacimiento:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1, 0, SpringLayout.SOUTH, dateChooser);
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nickname:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 3, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 0, SpringLayout.WEST, panel);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblEspectaculosRegistrados = new JLabel("Espectaculos:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectaculosRegistrados, 2, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectaculosRegistrados, 24, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, lblEspectaculosRegistrados, -176, SpringLayout.EAST, panel);
		panel.add(lblEspectaculosRegistrados);
		
		JComboBox comboBox_1 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 0, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, lblEspectaculosRegistrados);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_1, 24, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, -28, SpringLayout.EAST, panel);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Rol:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2_1, 0, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2_1, 0, SpringLayout.WEST, lblEspectaculosRegistrados);
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_2_1);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, -3, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 91, SpringLayout.EAST, lblNewLabel_1_1_2_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, 19, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -28, SpringLayout.EAST, panel);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		Button buttonAceptar_1 = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -195, SpringLayout.NORTH, buttonAceptar_1);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1, -48, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1, -191, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1, -110, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar_1);
		
		Button buttonAceptar_1_1 = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1_1, 0, SpringLayout.NORTH, buttonAceptar_1);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1_1, -85, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1_1, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1_1, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar_1_1);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});

	}
}
