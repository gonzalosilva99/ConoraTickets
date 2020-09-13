package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.awt.event.ItemEvent;
import java.awt.Button;
import Controladores.Fabrica;
import Interfaces.IUsuario;
import Interfaces.IPlataforma;
import DataTypes.DtUsuario;
import DataTypes.DtEspectador;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtArtista;
import DataTypes.DtFuncion;
import java.util.Set;
import java.util.Iterator;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConsultaUsuario extends JInternalFrame {
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldRol;
	private JTextField textFieldLink;
	private DtEspectaculoDatos datosEspectaculo;
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
	String EspectaculoAux;
	String FuncionAux;
	public ConsultaUsuario() {
		
		Fabrica fabric = Fabrica.getInstancia();
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		IUsuario iusuario = fabric.getIUsuario();
		Set<DtUsuario> listaUsuarios = iusuario.listarUsuarios();		
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxUsuario.addItem("");
		Iterator<DtUsuario> itr = listaUsuarios.iterator();
		while(itr.hasNext())
			{DtUsuario aux = itr.next();
			 String nick = aux.getNickname();
			 String nom = aux.getNombre();
			 String ap = aux.getApellido();
			 String op = nick+" "+nom+" "+ap;
			 comboBoxUsuario.addItem(op);
			}
		

		springLayout.putConstraint(SpringLayout.EAST, comboBoxUsuario, -115, SpringLayout.EAST, getContentPane());
		
		
		getContentPane().add(comboBoxUsuario);
		
		
		JLabel lblUsuario = new JLabel("Seleccionar usuario:");
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUsuario, -341, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxUsuario, -5, SpringLayout.NORTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxUsuario, 6, SpringLayout.EAST, lblUsuario);
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 22, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblUsuario);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 35, SpringLayout.SOUTH, comboBoxUsuario);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, lblUsuario);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		textFieldNickname = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNickname, 9, SpringLayout.NORTH, panel);
		textFieldNickname.setColumns(10);
		panel.add(textFieldNickname);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNombre, 99, SpringLayout.WEST, panel);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 12, SpringLayout.SOUTH, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNombre, 6, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, 120, SpringLayout.EAST, lblNombre);
		textFieldNombre.setColumns(10);
		panel.add(textFieldNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblApellido, 21, SpringLayout.SOUTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblApellido, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblApellido, 99, SpringLayout.WEST, panel);
		panel.add(lblApellido);
		
		textFieldApellido = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldApellido, 17, SpringLayout.SOUTH, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldApellido, 6, SpringLayout.EAST, lblApellido);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldApellido, 120, SpringLayout.EAST, lblApellido);
		textFieldApellido.setColumns(10);
		panel.add(textFieldApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEmail, 20, SpringLayout.SOUTH, lblApellido);
		sl_panel.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblEmail, 99, SpringLayout.WEST, panel);
		panel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldApellido, -17, SpringLayout.NORTH, textFieldEmail);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEmail, 0, SpringLayout.EAST, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEmail, 0, SpringLayout.WEST, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEmail, 112, SpringLayout.NORTH, panel);
		textFieldEmail.setColumns(10);
		panel.add(textFieldEmail);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 10, SpringLayout.SOUTH, textFieldEmail);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textFieldNickname);
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("dd-MM-yyyy");
		panel.add(dateChooser);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNacimiento, 134, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEmail, -3, SpringLayout.NORTH, lblNacimiento);
		sl_panel.putConstraint(SpringLayout.WEST, lblNacimiento, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, lblNacimiento, 0, SpringLayout.EAST, lblNombre);
		panel.add(lblNacimiento);
		
		JLabel lblNickname = new JLabel("Nickname:");
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNickname, 6, SpringLayout.EAST, lblNickname);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNickname, 120, SpringLayout.EAST, lblNickname);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 17, SpringLayout.SOUTH, lblNickname);
		sl_panel.putConstraint(SpringLayout.EAST, lblNickname, 99, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNickname, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNickname, 0, SpringLayout.WEST, panel);
		panel.add(lblNickname);
		
		JLabel lblEspectaculosRegistrados = new JLabel("Espectaculos:");
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectaculosRegistrados, 239, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblEspectaculosRegistrados, 343, SpringLayout.WEST, panel);
		panel.add(lblEspectaculosRegistrados);
		
		JComboBox comboBoxEspectaculos = new JComboBox();
		comboBoxEspectaculos.addItem("");
		
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxEspectaculos, 0, SpringLayout.EAST, lblEspectaculosRegistrados);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxEspectaculos, 142, SpringLayout.EAST, lblEspectaculosRegistrados);
		panel.add(comboBoxEspectaculos);
		
		JLabel lblRol = new JLabel("Rol:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectaculosRegistrados, 9, SpringLayout.SOUTH, lblRol);
		sl_panel.putConstraint(SpringLayout.WEST, lblRol, 20, SpringLayout.EAST, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.NORTH, lblRol, 9, SpringLayout.NORTH, panel);
		panel.add(lblRol);
		
		textFieldRol = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, lblRol, -6, SpringLayout.WEST, textFieldRol);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxEspectaculos, 9, SpringLayout.SOUTH, textFieldRol);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldRol, 485, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldRol, 343, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldRol, 28, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldRol, 5, SpringLayout.NORTH, panel);
		textFieldRol.setColumns(10);
		panel.add(textFieldRol);
		
		JLabel lblDescgeneral = new JLabel("DescGeneral:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNacimiento, -6, SpringLayout.NORTH, lblDescgeneral);
		sl_panel.putConstraint(SpringLayout.WEST, lblDescgeneral, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblDescgeneral, -53, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEspectaculosRegistrados, -116, SpringLayout.NORTH, lblDescgeneral);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDescgeneral, 192, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescgeneral, 173, SpringLayout.NORTH, panel);
		panel.add(lblDescgeneral);
		
		JLabel lblBiografia = new JLabel("Biografia:");
		sl_panel.putConstraint(SpringLayout.WEST, lblBiografia, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblBiografia, -53, SpringLayout.EAST, panel);
		panel.add(lblBiografia);
		
		JTextPane txtpndescgeneral = new JTextPane();
		sl_panel.putConstraint(SpringLayout.NORTH, lblBiografia, 6, SpringLayout.SOUTH, txtpndescgeneral);
		sl_panel.putConstraint(SpringLayout.EAST, txtpndescgeneral, 0, SpringLayout.EAST, lblDescgeneral);
		sl_panel.putConstraint(SpringLayout.NORTH, txtpndescgeneral, 198, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtpndescgeneral, 10, SpringLayout.WEST, lblDescgeneral);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtpndescgeneral, 248, SpringLayout.NORTH, panel);
		panel.add(txtpndescgeneral);
		
		JTextPane txtpnbiografia = new JTextPane();
		sl_panel.putConstraint(SpringLayout.SOUTH, lblBiografia, -6, SpringLayout.NORTH, txtpnbiografia);
		sl_panel.putConstraint(SpringLayout.EAST, txtpnbiografia, 0, SpringLayout.EAST, lblDescgeneral);
		sl_panel.putConstraint(SpringLayout.WEST, txtpnbiografia, 10, SpringLayout.WEST, lblBiografia);
		sl_panel.putConstraint(SpringLayout.NORTH, txtpnbiografia, 284, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtpnbiografia, 334, SpringLayout.NORTH, panel);
		panel.add(txtpnbiografia);
		
		JLabel lblLink = new JLabel("Link:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblLink, 350, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblLink, 0, SpringLayout.WEST, panel);
		panel.add(lblLink);
		
		textFieldLink = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, lblLink, -11, SpringLayout.WEST, textFieldLink);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldLink, 0, SpringLayout.EAST, lblDescgeneral);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldLink, -347, SpringLayout.EAST, lblDescgeneral);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldLink, 348, SpringLayout.NORTH, panel);
		textFieldLink.setColumns(10);
		panel.add(textFieldLink);
		
		Button buttonAtras = new Button("Atras");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, buttonAtras);
		
		Button buttonVerPaquetes = new Button("Ver mas");
		
		sl_panel.putConstraint(SpringLayout.NORTH, buttonVerPaquetes, 6, SpringLayout.SOUTH, comboBoxEspectaculos);
		sl_panel.putConstraint(SpringLayout.EAST, buttonVerPaquetes, 0, SpringLayout.EAST, comboBoxEspectaculos);
		panel.add(buttonVerPaquetes);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAtras, -48, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAtras, -91, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAtras, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAtras, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAtras);
		
		comboBoxUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
				String usuario = comboBoxUsuario.getSelectedItem().toString();
				String[] nick = usuario.split(" ");
				if(iusuario.EsArtista(nick[0])) {
					panel.setVisible(true);
					comboBoxEspectaculos.removeAllItems();
					lblEspectaculosRegistrados.setText("Espectaculos:");
					textFieldNickname.setEditable(false);
					textFieldNombre.setEditable(false);
					textFieldApellido.setEditable(false);
					textFieldNickname.setEditable(false);
					textFieldEmail.setEditable(false);
					txtpndescgeneral.setEditable(false);
					textFieldRol.setEditable(false);
					txtpnbiografia.setEditable(false);
					textFieldLink.setEditable(false);
					dateChooser.getCalendarButton().setEnabled(false);
					comboBoxEspectaculos.setEditable(false);
					txtpndescgeneral.setVisible(true);
					txtpnbiografia.setVisible(true);
					textFieldLink.setVisible(true);
					lblDescgeneral.setVisible(true);
					lblBiografia.setVisible(true);
					lblLink.setVisible(true);
					textFieldRol.setVisible(true);
					textFieldRol.setText("Artista");
					lblRol.setVisible(true);
					textFieldNickname.setText(iusuario.MostrarArtista(nick[0]).getNickname());
					textFieldNombre.setText(iusuario.MostrarArtista(nick[0]).getNombre());
					textFieldApellido.setText(iusuario.MostrarArtista(nick[0]).getApellido());
					textFieldEmail.setText(iusuario.MostrarArtista(nick[0]).getEmail());
					dateChooser.setDate(iusuario.MostrarArtista(nick[0]).getNacimiento());
					txtpndescgeneral.setText(iusuario.MostrarArtista(nick[0]).getDescgeneral());
					txtpnbiografia.setText(iusuario.MostrarArtista(nick[0]).getBiografia());
					textFieldLink.setText(iusuario.MostrarArtista(nick[0]).getLink());
					comboBoxEspectaculos.addItem("");
					Iterator<DtEspectaculo> itr = iusuario.MostrarArtista(nick[0]).getEspectaculos().iterator();
					while(itr.hasNext()) {
						DtEspectaculo aux = itr.next();
						 String nom = aux.getNombre();
						 String des = aux.getDescripcion();
						 String op = nom+"-"+des;
						 comboBoxEspectaculos.addItem(op);
					}
				}
				else if(comboBoxUsuario.getSelectedItem().toString().equals("")){
					panel.setVisible(false);
					textFieldRol.setVisible(false);
					lblRol.setVisible(false);
					comboBoxEspectaculos.removeAllItems();
					comboBoxEspectaculos.addItem("");
				}
				else {
					panel.setVisible(true);
					comboBoxEspectaculos.removeAllItems();
					lblEspectaculosRegistrados.setText("Funciones:");
					textFieldNickname.setEditable(false);
					textFieldNombre.setEditable(false);
					textFieldApellido.setEditable(false);
					textFieldNickname.setEditable(false);
					textFieldEmail.setEditable(false);
					textFieldRol.setEditable(false);
					txtpndescgeneral.setEditable(false);
					txtpnbiografia.setEditable(false);
					textFieldLink.setEditable(false);
					dateChooser.getCalendarButton().setEnabled(false);
					comboBoxEspectaculos.setEditable(false);
					txtpndescgeneral.setVisible(false);
					txtpnbiografia.setVisible(false);
					textFieldLink.setVisible(false);
					lblDescgeneral.setVisible(false);
					lblBiografia.setVisible(false);
					lblLink.setVisible(false);
					textFieldRol.setVisible(true);
					textFieldRol.setText("Espectador");
					lblRol.setVisible(true);
					textFieldNickname.setText(iusuario.MostrarEspectador(nick[0]).getNickname());
					textFieldNombre.setText(iusuario.MostrarEspectador(nick[0]).getNombre());
					textFieldApellido.setText(iusuario.MostrarEspectador(nick[0]).getApellido());
					textFieldEmail.setText(iusuario.MostrarEspectador(nick[0]).getEmail());
					dateChooser.setDate(iusuario.MostrarEspectador(nick[0]).getNacimiento());
					txtpndescgeneral.setText("");
					txtpnbiografia.setText("");
					textFieldLink.setText("");
					comboBoxEspectaculos.addItem("");
					Iterator<DtFuncion> itr = iusuario.MostrarEspectador(nick[0]).getFunciones().iterator();
					while(itr.hasNext()) {
						DtFuncion aux = itr.next();
						 String nom = aux.getNombre();
						 String ini = aux.getInicio().toString();
						 String op = nom+"-"+ini;
						 comboBoxEspectaculos.addItem(op);
					}
				}
			}
		});
		
		comboBoxEspectaculos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(textFieldRol.getText()=="Artista") {
					ConsultaEspectaculoWindowView consultaespR = new ConsultaEspectaculoWindowView();
					consultaespR.setLocationRelativeTo(null);
					consultaespR.setFocusable(true);
					consultaespR.setVisible(true);					
				}
			}
		});
		
		buttonVerPaquetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IPlataforma iplataforma = fabric.getIPlataforma();
				String esp = comboBoxEspectaculos.getSelectedItem().toString();
				String[] nom = esp.split("-");
				datosEspectaculo= iplataforma.findDatosEspectaculo(nom[0]);
				ConsultaEspectaculoWindowView ventana = new ConsultaEspectaculoWindowView(datosEspectaculo);
				
				ventana.setAlwaysOnTop(true);
				ventana.setVisible(true);
			}
		});

	}
}
