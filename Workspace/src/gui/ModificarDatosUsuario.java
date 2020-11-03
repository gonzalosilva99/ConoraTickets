package gui;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;

import controladores.Fabrica;
import datatypes.DtUsuario;
import interfaces.IUsuario;

import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarDatosUsuario extends JInternalFrame {
	private JTextField textFieldLink;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldRol;
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
		Fabrica fabric = Fabrica.getInstancia();
		IUsuario iusu = fabric.getIUsuario();
		Boolean esArtista=false;
		
		setTitle("Modificar Datos de Usuario");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		Button buttonModificar = new Button("Modificar");
		
		springLayout.putConstraint(SpringLayout.NORTH, buttonModificar, -44, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonModificar, -104, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonModificar, -16, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonModificar, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(buttonModificar);
		buttonModificar.setEnabled(false);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -44, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 311, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -12, SpringLayout.WEST, buttonModificar);
		getContentPane().add(buttonCancelar);
		
		JPanel panelExterior = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panelExterior, -6, SpringLayout.NORTH, buttonModificar);
		springLayout.putConstraint(SpringLayout.WEST, panelExterior, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelExterior, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panelExterior);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		springLayout.putConstraint(SpringLayout.NORTH, panelExterior, 6, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUsuario, 32, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 3, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 0, SpringLayout.WEST, panelExterior);
		SpringLayout sl_panelExterior = new SpringLayout();
		panelExterior.setLayout(sl_panelExterior);
		
		JLabel lblNickname = new JLabel("Nickname:");
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblNickname, 10, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblNickname, 35, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblNickname, -412, SpringLayout.EAST, panelExterior);
		panelExterior.add(lblNickname);
		
		JLabel lblNombre = new JLabel("E-Mail:");
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblNombre, 23, SpringLayout.SOUTH, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblNombre, 0, SpringLayout.WEST, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblNombre, -412, SpringLayout.EAST, panelExterior);
		panelExterior.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Nombre:");
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblApellido, 10, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblApellido, 0, SpringLayout.EAST, lblNickname);
		panelExterior.add(lblApellido);
		
		JLabel lblEmail = new JLabel("apellido:");
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblApellido, -17, SpringLayout.NORTH, lblEmail);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblEmail, 160, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblEmail, 10, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblEmail, 179, SpringLayout.NORTH, panelExterior);
		panelExterior.add(lblEmail);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblNickname, -2, SpringLayout.NORTH, lblNacimiento);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblNacimiento, 18, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblNacimiento, 255, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblNacimiento, 339, SpringLayout.WEST, panelExterior);
		panelExterior.add(lblNacimiento);
		
		Panel panelInterior = new Panel();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, panelInterior, 190, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, panelInterior, 0, SpringLayout.WEST, panelExterior);
		panelExterior.add(panelInterior);
		panelInterior.setVisible(false);
		
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
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldNickname, 6, SpringLayout.EAST, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldNickname, 16, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldNickname, -21, SpringLayout.WEST, lblNacimiento);
		panelExterior.add(textFieldNickname);
		textFieldNickname.setColumns(10);
		textFieldNickname.setEditable(false);
		
		textFieldNombre = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldNombre, 6, SpringLayout.EAST, lblApellido);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldNombre, 0, SpringLayout.EAST, textFieldNickname);
		textFieldNombre.setColumns(10);
		panelExterior.add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldApellido, 6, SpringLayout.EAST, lblEmail);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, textFieldApellido, 182, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldApellido, 0, SpringLayout.EAST, textFieldNickname);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldApellido, 158, SpringLayout.NORTH, panelExterior);
		textFieldApellido.setColumns(10);
		panelExterior.add(textFieldApellido);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, dateChooser, 16, SpringLayout.NORTH, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.WEST, dateChooser, 344, SpringLayout.WEST, panelExterior);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, dateChooser, -150, SpringLayout.NORTH, panelInterior);
		sl_panelExterior.putConstraint(SpringLayout.EAST, dateChooser, 489, SpringLayout.WEST, panelExterior);
		panelExterior.add(dateChooser);
		getContentPane().add(lblUsuario);
		
		
		
		//Cargo la lista de los usuarios
		Set<DtUsuario> listaUsuarios = iusu.listarUsuarios();		
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxUsuario.addItem("");
		Iterator<DtUsuario> itr = listaUsuarios.iterator();
		while (itr.hasNext()){
			DtUsuario aux = itr.next();
			 String nick = aux.getNickname();
			 String nom = aux.getNombre();
			 String ape = aux.getApellido();
			 String ope = nick+" "+nom+" "+ape;
			 comboBoxUsuario.addItem(ope);
			}
		
		
		
		
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxUsuario, 5, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxUsuario, 6, SpringLayout.EAST, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxUsuario, -257, SpringLayout.EAST, getContentPane());
	
		
		textFieldEmail = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldEmail, 17, SpringLayout.SOUTH, textFieldNickname);
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldEmail, 6, SpringLayout.EAST, lblNombre);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldEmail, 0, SpringLayout.EAST, textFieldNickname);
		textFieldEmail.setColumns(10);
		panelExterior.add(textFieldEmail);
		getContentPane().add(comboBoxUsuario);
		textFieldEmail.setEditable(false);
		
		JLabel lblRol = new JLabel("Rol:");
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblApellido, 14, SpringLayout.SOUTH, lblRol);
		sl_panelExterior.putConstraint(SpringLayout.WEST, lblRol, 0, SpringLayout.WEST, lblNickname);
		sl_panelExterior.putConstraint(SpringLayout.EAST, lblRol, 0, SpringLayout.EAST, lblNickname);
		panelExterior.add(lblRol);
		lblRol.setVisible(false);
		
		textFieldRol = new JTextField();
		sl_panelExterior.putConstraint(SpringLayout.NORTH, lblRol, 0, SpringLayout.NORTH, textFieldRol);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, lblRol, 19, SpringLayout.NORTH, textFieldRol);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldNombre, 13, SpringLayout.SOUTH, textFieldRol);
		sl_panelExterior.putConstraint(SpringLayout.SOUTH, textFieldNombre, 34, SpringLayout.SOUTH, textFieldRol);
		sl_panelExterior.putConstraint(SpringLayout.NORTH, textFieldRol, 20, SpringLayout.SOUTH, textFieldEmail);
		sl_panelExterior.putConstraint(SpringLayout.EAST, textFieldRol, 0, SpringLayout.EAST, textFieldNickname);
		sl_panelExterior.putConstraint(SpringLayout.WEST, textFieldRol, 0, SpringLayout.WEST, textFieldNickname);
		textFieldRol.setEditable(false);
		textFieldRol.setColumns(10);
		panelExterior.add(textFieldRol);
		textFieldRol.setVisible(false);
		textFieldRol.setVisible(false);
		textFieldNickname.setVisible(false);
		textFieldNombre.setVisible(false);
		textFieldApellido.setVisible(false);
		textFieldEmail.setVisible(false);
		dateChooser.setVisible(false);
		dateChooser.setVisible(false);
		lblNickname.setVisible(false);
		lblNombre.setVisible(false);
		lblApellido.setVisible(false);
		lblEmail.setVisible(false);
		lblNacimiento.setVisible(false);
		
		
		
		comboBoxUsuario.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				
				String nicknameselec = comboBoxUsuario.getSelectedItem().toString();
				String[] nick = nicknameselec.split(" ");
				if (iusu.esArtista(nick[0])) {
					panelInterior.setVisible(true);
					textFieldNickname.setText(iusu.mostrarArtista(nick[0]).getNickname());
					textFieldNombre.setText(iusu.mostrarArtista(nick[0]).getNombre());
					textFieldApellido.setText(iusu.mostrarArtista(nick[0]).getApellido());
					textFieldEmail.setText(iusu.mostrarArtista(nick[0]).getEmail());
					dateChooser.setDate(iusu.mostrarArtista(nick[0]).getNacimiento());
					textPaneDescGeneral.setText(iusu.mostrarArtista(nick[0]).getDescgeneral());
					textPaneBiografia.setText(iusu.mostrarArtista(nick[0]).getBiografia());
					textFieldLink.setText(iusu.mostrarArtista(nick[0]).getLink());
					lblRol.setVisible(true);
					textFieldRol.setVisible(true);
					textFieldRol.setText("Artista");
					buttonModificar.setEnabled(true);
					textFieldNickname.setVisible(true);
					textFieldNombre.setVisible(true);
					textFieldApellido.setVisible(true);
					textFieldEmail.setVisible(true);
					dateChooser.setVisible(true);
					lblNickname.setVisible(true);
					lblNombre.setVisible(true);
					lblApellido.setVisible(true);
					lblEmail.setVisible(true);
					lblNacimiento.setVisible(true);
					
				}
				else if (comboBoxUsuario.getSelectedItem().toString().equals("")) {
					panelInterior.setVisible(false);
					textFieldNickname.setText("");
					textFieldNombre.setText("");
					textFieldApellido.setText("");
					textFieldEmail.setText("");
					dateChooser.setDate(null);
					textPaneDescGeneral.setText("");
					textPaneBiografia.setText("");
					textFieldLink.setText("");
					lblRol.setVisible(false);
					textFieldRol.setVisible(false);
					textFieldNickname.setVisible(false);
					textFieldNombre.setVisible(false);
					textFieldApellido.setVisible(false);
					textFieldEmail.setVisible(false);
					dateChooser.setVisible(false);
					dateChooser.setVisible(false);
					lblNickname.setVisible(false);
					lblNombre.setVisible(false);
					lblApellido.setVisible(false);
					lblEmail.setVisible(false);
					lblNacimiento.setVisible(false);
				}
				else {
					panelInterior.setVisible(false);
					textFieldNickname.setText(iusu.mostrarEspectador(nick[0]).getNickname());
					textFieldNombre.setText(iusu.mostrarEspectador(nick[0]).getNombre());
					textFieldApellido.setText(iusu.mostrarEspectador(nick[0]).getApellido());
					textFieldEmail.setText(iusu.mostrarEspectador(nick[0]).getEmail());
					dateChooser.setDate(iusu.mostrarEspectador(nick[0]).getNacimiento());
					textPaneDescGeneral.setText("");
					textPaneBiografia.setText("");
					textFieldLink.setText("");
					lblRol.setVisible(true);
					textFieldRol.setVisible(true);
					textFieldRol.setText("Espectador");
					buttonModificar.setEnabled(true);
					textFieldNickname.setVisible(true);
					textFieldNombre.setVisible(true);
					textFieldApellido.setVisible(true);
					textFieldEmail.setVisible(true);
					dateChooser.setVisible(true);
					dateChooser.setVisible(true);
					lblNickname.setVisible(true);
					lblNombre.setVisible(true);
					lblApellido.setVisible(true);
					lblEmail.setVisible(true);
					lblNacimiento.setVisible(true);
				}
			}
		});
		
		
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				if (textFieldRol.getText().equals("Artista")) {
					iusu.modificarArtista(textFieldNickname.getText(), textFieldNombre.getText(), textFieldApellido.getText(), dateChooser.getDate(), textPaneDescGeneral.getText(), textPaneBiografia.getText(), textFieldLink.getText());
				}
				else if (textFieldRol.getText().equals("Espectador")) {
					iusu.modificarEspectador(textFieldNickname.getText(), textFieldNombre.getText(), textFieldApellido.getText(), dateChooser.getDate());
				}
				JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
			}
		});
	}
	
	
}
