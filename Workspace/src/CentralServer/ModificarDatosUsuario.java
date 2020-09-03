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

public class ModificarDatosUsuario extends JInternalFrame {
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
		
		Panel panel = new Panel();
		panel.setEnabled(false);
		getContentPane().add(panel);
		
		JTextPane textPaneBiografia = new JTextPane();
		
		JTextPane textPaneDescGeneral = new JTextPane();
		
		JLabel lblDescGeneral = new JLabel("Desc. General:");
		
		JLabel lblBiografia = new JLabel("Biografia:");
		
		JLabel lblLink = new JLabel("Link:");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 489, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneBiografia, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(textPaneDescGeneral, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(lblDescGeneral)
						.addComponent(lblBiografia)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLink)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 247, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescGeneral)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneDescGeneral, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBiografia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneBiografia, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLink)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JLabel lblNickname = new JLabel("Nickname: ");
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.WEST, lblNickname, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 5, SpringLayout.NORTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 28, SpringLayout.EAST, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNombre, -378, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblNombre);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_2, -283, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField_2);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField_1);
		textField_3.setColumns(10);
		getContentPane().add(textField_3);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 8, SpringLayout.NORTH, lblApellido);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 26, SpringLayout.EAST, lblApellido);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH, lblApellido);
		springLayout.putConstraint(SpringLayout.NORTH, lblApellido, 6, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblApellido, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblApellido, -338, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email: ");
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 46, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 6, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 6, SpringLayout.SOUTH, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, -412, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblEmail);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 15, SpringLayout.SOUTH, textField_4);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_4, -450, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_4, 15, SpringLayout.EAST, lblNickname);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, 145, SpringLayout.EAST, lblNickname);
		textField_4.setColumns(10);
		getContentPane().add(textField_4);
		
		JLabel lblNacimiento = new JLabel("Nacimiento: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNacimiento, 7, SpringLayout.NORTH, lblNickname);
		springLayout.putConstraint(SpringLayout.WEST, lblNacimiento, 34, SpringLayout.EAST, textField_4);
		getContentPane().add(lblNacimiento);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNickname, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNickname, 34, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 38, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 5, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 34, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 162, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(comboBox);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -44, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -88, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, 0, SpringLayout.EAST, panel);
		getContentPane().add(buttonAceptar);
		
		Button buttonAceptar_1 = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1, 0, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1, -100, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1, 0, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1, -12, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonAceptar_1);

	}
}
