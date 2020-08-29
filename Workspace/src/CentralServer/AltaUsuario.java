package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JRadioButton;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaUsuario extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldNickname;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
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
	public AltaUsuario() {
		setTitle("Alta de Usuario");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblNickname = new JLabel("Nickname: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNickname, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNickname, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNickname, 40, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNickname, -419, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 6, SpringLayout.SOUTH, lblNickname);
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNombre, 36, SpringLayout.SOUTH, lblNickname);
		springLayout.putConstraint(SpringLayout.EAST, lblNombre, 0, SpringLayout.EAST, lblNickname);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblApellido, 6, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblApellido, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblApellido, 36, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.EAST, lblApellido, 0, SpringLayout.EAST, lblNickname);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 6, SpringLayout.SOUTH, lblApellido);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, 36, SpringLayout.SOUTH, lblApellido);
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblNickname);
		getContentPane().add(lblEmail);
		
		JLabel lblNacimiento = new JLabel("Nacimiento: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNacimiento, 6, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lblNacimiento, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNacimiento, 36, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.EAST, lblNacimiento, 0, SpringLayout.EAST, lblNickname);
		getContentPane().add(lblNacimiento);
		
		textFieldNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNombre, 5, SpringLayout.NORTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNombre, 6, SpringLayout.EAST, lblNombre);
		textFieldNombre.setColumns(10);
		getContentPane().add(textFieldNombre);
		
		textFieldNickname = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textFieldNombre, 0, SpringLayout.EAST, textFieldNickname);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNickname, 5, SpringLayout.NORTH, lblNickname);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNickname, 6, SpringLayout.EAST, lblNickname);
		springLayout.putConstraint(SpringLayout.EAST, textFieldNickname, 206, SpringLayout.EAST, lblNickname);
		textFieldNickname.setColumns(10);
		getContentPane().add(textFieldNickname);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 5, SpringLayout.NORTH, lblApellido);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblApellido);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textFieldNickname);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 5, SpringLayout.NORTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textFieldNombre);
		textField_3.setColumns(10);
		getContentPane().add(textField_3);
		
		JSpinner spinnerAnio = new JSpinner();
		springLayout.putConstraint(SpringLayout.EAST, spinnerAnio, 108, SpringLayout.EAST, lblNacimiento);
		spinnerAnio.setModel(new SpinnerDateModel(new Date(1598670000000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerAnio.setEditor(new JSpinner.DateEditor(spinnerAnio, "dd/MM/yyyy"));
		springLayout.putConstraint(SpringLayout.NORTH, spinnerAnio, 5, SpringLayout.NORTH, lblNacimiento);
		springLayout.putConstraint(SpringLayout.WEST, spinnerAnio, 6, SpringLayout.EAST, lblNacimiento);
		getContentPane().add(spinnerAnio);
		
		JRadioButton rdbtnEspectador = new JRadioButton("Espectador");
		buttonGroup.add(rdbtnEspectador);
		rdbtnEspectador.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnEspectador, 6, SpringLayout.SOUTH, lblNacimiento);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnEspectador, 0, SpringLayout.WEST, lblNickname);
		getContentPane().add(rdbtnEspectador);
		
		JRadioButton rdbtnArtista = new JRadioButton("Artista");
		
		buttonGroup.add(rdbtnArtista);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnArtista, 11, SpringLayout.SOUTH, spinnerAnio);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnArtista, 7, SpringLayout.EAST, rdbtnEspectador);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnArtista, 86, SpringLayout.EAST, rdbtnEspectador);
		getContentPane().add(rdbtnArtista);
		
		Panel panel = new Panel();
		panel.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, rdbtnEspectador);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 253, SpringLayout.SOUTH, rdbtnEspectador);
		springLayout.putConstraint(SpringLayout.EAST, panel, 499, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		
		rdbtnArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setEnabled(true);
			}
		});
		rdbtnEspectador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setEnabled(false);
			}
		});
		
		JLabel lblDescGeneral = new JLabel("Desc. General:");
		
		JTextPane textPaneDescGeneral = new JTextPane();
		
		JLabel lblBiografia = new JLabel("Biografia:");
		
		JTextPane textPane = new JTextPane();
		
		JLabel lblLink = new JLabel("Link:");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addComponent(textPaneDescGeneral, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addComponent(lblDescGeneral)
						.addComponent(lblBiografia)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLink)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescGeneral)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneDescGeneral, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBiografia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLink)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -105, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, 44, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -101, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, 44, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);

	}
}
