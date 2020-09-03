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
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 53, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -89, SpringLayout.EAST, getContentPane());
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Usuario1", "Usuario2", "Usuario3"}));
		getContentPane().add(comboBox);
		
		
		JLabel lblNewLabel = new JLabel("Seleccionar usuario:");
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 48, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 32, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 83, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -319, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -263, SpringLayout.SOUTH, getContentPane());
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
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 20, SpringLayout.WEST, panel);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 2, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -12, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 14, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 17, SpringLayout.WEST, panel);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 95, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, -6, SpringLayout.WEST, textField_2);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -286, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 2, SpringLayout.NORTH, textField_2);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 15, SpringLayout.SOUTH, textField_1);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 10, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 36, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1_1, 43, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1_1, -6, SpringLayout.WEST, textField_3);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 7, SpringLayout.NORTH, lblNewLabel_1_1_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 6, SpringLayout.SOUTH, lblNewLabel_1_1_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textField);
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("dd-MM-yyyy");
		panel.add(dateChooser);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nacimiento:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1, 6, SpringLayout.SOUTH, lblNewLabel_1_1_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 0, SpringLayout.WEST, panel);
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nickname:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 2, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_2, 0, SpringLayout.EAST, lblNewLabel_1_1);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblEspectaculosRegistrados = new JLabel("Espectaculos:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectaculosRegistrados, -7, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectaculosRegistrados, 18, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEspectaculosRegistrados, 25, SpringLayout.NORTH, textField);
		panel.add(lblEspectaculosRegistrados);
		
		JComboBox comboBox_1 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.EAST, lblEspectaculosRegistrados, -6, SpringLayout.WEST, comboBox_1);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, -28, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, -3, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 123, SpringLayout.EAST, textField);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Rol:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2_1, 0, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_2_1, 0, SpringLayout.EAST, lblEspectaculosRegistrados);
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1_1_2_1);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, -2, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, comboBox_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, comboBox_1);
		textField_4.setColumns(10);
		panel.add(textField_4);
		

	}
}
