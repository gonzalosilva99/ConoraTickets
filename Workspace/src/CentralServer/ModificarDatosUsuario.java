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
	private JTextField textFieldLink;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;

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
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -44, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 311, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -12, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);
		
		JPanel panelExterior = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panelExterior, -6, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, panelExterior, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelExterior, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panelExterior);
		panelExterior.setVisible(false);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		springLayout.putConstraint(SpringLayout.NORTH, panelExterior, 6, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUsuario, 32, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 3, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 0, SpringLayout.WEST, panelExterior);
		SpringLayout sl_panelExterior = new SpringLayout();
		panelExterior.setLayout(sl_panelExterior);
		
		JLabel lblNickname = new JLabel("Nickname:");
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblNickname, 10, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblNickname, 10, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblNickname, 40, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblNickname, -401, SpringLayout.EAST, panelExterior);
		panelExterior.add(lblNickname);
		
		JLabel lblNombre = new JLabel("E-Mail:");
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblNombre, 6, SpringLayout.SOUTH, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblNombre, 0, SpringLayout.WEST, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblNombre, 36, SpringLayout.SOUTH, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblNombre, 84, SpringLayout.WEST, lblNickname);
		panelExterior.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Nombre:");
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblApellido, 10, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblApellido, 0, SpringLayout.EAST, lblNickname);
		panelExterior.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Apellido:");
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblApellido, -6, SpringLayout.NORTH, lblEmail);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblEmail, 154, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblNickname);
		panelExterior.add(lblEmail);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblNacimiento, 88, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblNacimiento, 10, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblNacimiento, 0, SpringLayout.EAST, lblNickname);
		panelExterior.add(lblNacimiento);
		
		Panel panelInterior = new Panel();
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblEmail, -6, SpringLayout.NORTH, panelInterior);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, panelInterior, 190, SpringLayout.NORTH, panelExterior);
		panelInterior.setEnabled(false);
		sl_panelExterior.putConstraint(SpringLayout.WEST, panelInterior, 0, SpringLayout.WEST, panelExterior);
		panelExterior.add(panelInterior);
		
		JTextPane textPaneBiografia = new JTextPane();
		
		JTextPane textPaneDescGeneral = new JTextPane();
		
		JLabel lblDescGeneral = new JLabel("Desc. General:");
		
		JLabel lblBiografia = new JLabel("Biografia:");
		
		JLabel lblLink = new JLabel("Link:");
		
		textFieldLink = new JTextField();
		textFieldLink.setColumns(10);
		GroupLayout gl_panelInterior = new GroupLayout(panelInterior);
		gl_panelInterior.setHorizontalGroup(
			gl_panelInterior.createParallelGroup(Alignment.LEADING)
				.addGap(0, 489, Short.MAX_VALUE)
				.addGroup(gl_panelInterior.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInterior.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneBiografia, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(textPaneDescGeneral, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(lblDescGeneral)
						.addComponent(lblBiografia)
						.addGroup(gl_panelInterior.createSequentialGroup()
							.addComponent(lblLink)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldLink, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelInterior.setVerticalGroup(
			gl_panelInterior.createParallelGroup(Alignment.LEADING)
				.addGap(0, 235, Short.MAX_VALUE)
				.addGroup(gl_panelInterior.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescGeneral)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneDescGeneral, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBiografia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneBiografia, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelInterior.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLink)
						.addComponent(textFieldLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panelInterior.setLayout(gl_panelInterior);
		
		textFieldNickname = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldNickname, 16, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldNickname, 117, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldNickname, -218, SpringLayout.EAST, panelExterior);
		panelExterior.add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		textFieldNombre = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldNombre, -2, SpringLayout.NORTH, lblApellido);
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldNombre, 0, SpringLayout.WEST, textFieldNickname);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldNombre, -218, SpringLayout.EAST, panelExterior);
		textFieldNombre.setColumns(10);
		panelExterior.add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldApellido, 6, SpringLayout.NORTH, lblEmail);
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldApellido, 0, SpringLayout.WEST, textFieldNickname);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldApellido, -218, SpringLayout.EAST, panelExterior);
		textFieldApellido.setColumns(10);
		panelExterior.add(textFieldApellido);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, dateChooser, 88, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblNacimiento, 0, SpringLayout.SOUTH, dateChooser);
		sl_panelExterior.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textFieldNickname);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, dateChooser, -13, SpringLayout.NORTH, textFieldNombre);
		sl_panelExterior.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textFieldNickname);
		panelExterior.add(dateChooser);
		getContentPane().add(lblUsuario);
		
		JComboBox comboBoxUsuario = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxUsuario, 5, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxUsuario, 6, SpringLayout.EAST, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxUsuario, -257, SpringLayout.EAST, getContentPane());
		comboBoxUsuario.addItem("");
		comboBoxUsuario.addItem("Pan");
		comboBoxUsuario.addItem("Manteca");
		comboBoxUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panelExterior.setVisible(true);
			}
		});
		textFieldEmail = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldEmail, 52, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldEmail, 0, SpringLayout.WEST, textFieldNickname);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldEmail, 0, SpringLayout.EAST, textFieldNickname);
		textFieldEmail.setColumns(10);
		panelExterior.add(textFieldEmail);
		getContentPane().add(comboBoxUsuario);

	}
}
