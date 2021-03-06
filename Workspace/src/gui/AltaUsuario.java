package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;

import controladores.Fabrica;
import excepciones.CheckDatos;
import interfaces.IUsuario;


public class AltaUsuario extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldNickname;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldLink;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldContrasena;
	private JTextField textFieldImagen;

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
		Fabrica fabric = Fabrica.getInstancia();
		
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
		
		JLabel lblApellido = new JLabel("apellido: ");
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
		springLayout.putConstraint(SpringLayout.NORTH, lblNacimiento, 8, SpringLayout.NORTH, lblNickname);
		springLayout.putConstraint(SpringLayout.EAST, lblNacimiento, -175, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooser, 5, SpringLayout.NORTH, lblNickname);
		springLayout.putConstraint(SpringLayout.WEST, dateChooser, 13, SpringLayout.EAST, lblNacimiento);
		springLayout.putConstraint(SpringLayout.EAST, dateChooser, -16, SpringLayout.EAST, getContentPane());
		BorderLayout borderLayout = (BorderLayout) dateChooser.getLayout();
		dateChooser.setToolTipText("");
		dateChooser.getDateEditor().setEnabled(false);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		getContentPane().add(dateChooser);
		
		textFieldNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNombre, 5, SpringLayout.NORTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNombre, 6, SpringLayout.EAST, lblNombre);
		springLayout.putConstraint(SpringLayout.EAST, textFieldNombre, -261, SpringLayout.EAST, getContentPane());
		textFieldNombre.setColumns(10);
		getContentPane().add(textFieldNombre);
		
		textFieldNickname = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblNacimiento, 6, SpringLayout.EAST, textFieldNickname);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNickname, 6, SpringLayout.EAST, lblNickname);
		springLayout.putConstraint(SpringLayout.EAST, textFieldNickname, -261, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNickname, 5, SpringLayout.NORTH, lblNickname);
		textFieldNickname.setColumns(10);
		getContentPane().add(textFieldNickname);
		
		textFieldApellido = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldApellido, 5, SpringLayout.NORTH, lblApellido);
		springLayout.putConstraint(SpringLayout.WEST, textFieldApellido, 6, SpringLayout.EAST, lblApellido);
		springLayout.putConstraint(SpringLayout.EAST, textFieldApellido, -261, SpringLayout.EAST, getContentPane());
		textFieldApellido.setColumns(10);
		getContentPane().add(textFieldApellido);
		
		textFieldEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldEmail, 5, SpringLayout.NORTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, textFieldEmail, 6, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.EAST, textFieldEmail, -261, SpringLayout.EAST, getContentPane());
		textFieldEmail.setColumns(10);
		getContentPane().add(textFieldEmail);
		
		JRadioButton rdbtnEspectador = new JRadioButton("Espectador");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnEspectador, 42, SpringLayout.SOUTH, lblEmail);
		buttonGroup.add(rdbtnEspectador);
		rdbtnEspectador.setSelected(true);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnEspectador, 0, SpringLayout.WEST, lblNickname);
		getContentPane().add(rdbtnEspectador);
		
		JRadioButton rdbtnArtista = new JRadioButton("Artista");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnArtista, 47, SpringLayout.SOUTH, textFieldEmail);
		
		buttonGroup.add(rdbtnArtista);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnArtista, 7, SpringLayout.EAST, rdbtnEspectador);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnArtista, 86, SpringLayout.EAST, rdbtnEspectador);
		getContentPane().add(rdbtnArtista);
		
		Panel panel = new Panel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, rdbtnEspectador);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 253, SpringLayout.SOUTH, rdbtnEspectador);
		panel.setVisible(false);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 499, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		
		rdbtnArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				panel.setVisible(true);
			}
		});
		rdbtnEspectador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				panel.setVisible(false);
			}
		});
		
		JLabel lblDescGeneral = new JLabel("Desc. General:");
		
		JTextPane textPaneDescGeneral = new JTextPane();
		
		JLabel lblBiografia = new JLabel("Biografia:");
		
		JTextPane textPaneBiografia = new JTextPane();
		
		JLabel lblLink = new JLabel("Link:");
		
		textFieldLink = new JTextField();
		textFieldLink.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneBiografia, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addComponent(textPaneDescGeneral, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addComponent(lblDescGeneral)
						.addComponent(lblBiografia)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLink)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldLink, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)))
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
					.addComponent(textPaneBiografia, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLink)
						.addComponent(textFieldLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if (textFieldNickname.getText().length()==0) {
						throw new CheckDatos("El Nickname no debe ser vac??o");
					}
					if (textFieldEmail.getText().length()==0) {
						throw new CheckDatos("El Email no debe ser vac??o");
					}
					IUsuario iusuario = fabric.getIUsuario();
					if (rdbtnArtista.isSelected()) {
						if (textFieldNickname.getText().indexOf(" ")>-1) {
							throw new CheckDatos("El Nickname no debe contener espacios");
						}
						
						iusuario.confirmarAltaArtista(textFieldNickname.getText().trim(), textFieldNombre.getText().trim(), textFieldApellido.getText().trim(), textFieldEmail.getText().trim(), dateChooser.getDate(), textFieldImagen.getText().trim(), textFieldContrasena.getText().trim(), textPaneDescGeneral.getText().trim(), textPaneBiografia.getText().trim(), textFieldLink.getText().trim());
						textPaneDescGeneral.setText("");
						textPaneBiografia.setText("");
						textFieldLink.setText("");
						
					}
					if (rdbtnEspectador.isSelected()) {
						if (textFieldNickname.getText().indexOf(" ")>-1) {
							throw new CheckDatos("El Nickname no debe contener espacios");
						}
						iusuario.confirmarAltaEspectador(textFieldNickname.getText().trim(), textFieldNombre.getText().trim(), textFieldApellido.getText().trim(), textFieldEmail.getText().trim(), dateChooser.getDate(), textFieldImagen.getText().trim(), textFieldContrasena.getText().trim());
					}
					textFieldNickname.setText("");
					textFieldNombre.setText("");
					textFieldApellido.setText("");
					textFieldEmail.setText("");
					dateChooser.setCalendar(null);
					
					JOptionPane.showMessageDialog(null, "Alta de Usuario con exito");
					//textFieldNickname.setText();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
				
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -46, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -105, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -46, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 309, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);
		
		textFieldContrasena = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldContrasena, 6, SpringLayout.NORTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, textFieldContrasena, 0, SpringLayout.WEST, dateChooser);
		springLayout.putConstraint(SpringLayout.EAST, textFieldContrasena, 0, SpringLayout.EAST, dateChooser);
		textFieldContrasena.setColumns(10);
		getContentPane().add(textFieldContrasena);
		
		textFieldImagen = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldImagen, 6, SpringLayout.NORTH, lblApellido);
		springLayout.putConstraint(SpringLayout.WEST, textFieldImagen, 0, SpringLayout.WEST, dateChooser);
		springLayout.putConstraint(SpringLayout.EAST, textFieldImagen, 0, SpringLayout.EAST, dateChooser);
		textFieldImagen.setColumns(10);
		getContentPane().add(textFieldImagen);
		
		JLabel lblContrasena = new JLabel("Contras: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblContrasena, 8, SpringLayout.NORTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblContrasena, 0, SpringLayout.WEST, lblNacimiento);
		springLayout.putConstraint(SpringLayout.EAST, lblContrasena, -6, SpringLayout.WEST, textFieldContrasena);
		getContentPane().add(lblContrasena);
		
		JLabel lblImagen = new JLabel("Imagen: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblImagen, 8, SpringLayout.NORTH, lblApellido);
		springLayout.putConstraint(SpringLayout.WEST, lblImagen, 0, SpringLayout.WEST, lblNacimiento);
		springLayout.putConstraint(SpringLayout.EAST, lblImagen, -1, SpringLayout.WEST, textFieldImagen);
		getContentPane().add(lblImagen);
		
		

	}
}
