package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ModificarDatosUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;

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
		setTitle("Modificar Datos de Usuario");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -44, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -104, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -16, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonAceptar_1 = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1, -44, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1, 311, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1, -12, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonAceptar_1);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		panel.setVisible(false);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUsuario, 32, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 3, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 0, SpringLayout.WEST, panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNickname = new JLabel("Nickname:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNickname, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNickname, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNickname, 40, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNickname, -401, SpringLayout.EAST, panel);
		panel.add(lblNickname);
		
		JLabel lblNombre = new JLabel("E-Mail:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 6, SpringLayout.SOUTH, lblNickname);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 0, SpringLayout.WEST, lblNickname);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNombre, 36, SpringLayout.SOUTH, lblNickname);
		sl_panel.putConstraint(SpringLayout.EAST, lblNombre, 84, SpringLayout.WEST, lblNickname);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.WEST, lblApellido, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblApellido, 0, SpringLayout.EAST, lblNickname);
		panel.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Apellido:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblApellido, -6, SpringLayout.NORTH, lblEmail);
		sl_panel.putConstraint(SpringLayout.NORTH, lblEmail, 154, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblNickname);
		sl_panel.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblNickname);
		panel.add(lblEmail);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNacimiento, 88, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNacimiento, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNacimiento, 0, SpringLayout.EAST, lblNickname);
		panel.add(lblNacimiento);
		
		Panel panel_1 = new Panel();
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEmail, -6, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 190, SpringLayout.NORTH, panel);
		panel_1.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		panel.add(panel_1);
		
		JTextPane textPaneBiografia = new JTextPane();
		
		JTextPane textPaneDescGeneral = new JTextPane();
		
		JLabel lblDescGeneral = new JLabel("Desc. General:");
		
		JLabel lblBiografia = new JLabel("Biografia:");
		
		JLabel lblLink = new JLabel("Link:");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 489, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneBiografia, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(textPaneDescGeneral, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(lblDescGeneral)
						.addComponent(lblBiografia)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblLink)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 235, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescGeneral)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneDescGeneral, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBiografia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneBiografia, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLink)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 16, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 117, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -218, SpringLayout.EAST, panel);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, -2, SpringLayout.NORTH, lblApellido);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, -218, SpringLayout.EAST, panel);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 6, SpringLayout.NORTH, lblEmail);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -218, SpringLayout.EAST, panel);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 88, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNacimiento, 0, SpringLayout.SOUTH, dateChooser);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, -13, SpringLayout.NORTH, textField_3);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textField_1);
		panel.add(dateChooser);
		getContentPane().add(lblUsuario);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 5, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -257, SpringLayout.EAST, getContentPane());
		comboBox.addItem("");
		comboBox.addItem("Pan");
		comboBox.addItem("Manteca");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 52, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField_1);
		textField_2.setColumns(10);
		panel.add(textField_2);
		getContentPane().add(comboBox);

	}
}
