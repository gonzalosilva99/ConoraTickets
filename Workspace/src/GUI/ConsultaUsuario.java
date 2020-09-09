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
import java.awt.event.ItemEvent;
import java.awt.Button;
import Controladores.Fabrica;
import Interfaces.IUsuario;
import DataTypes.DtUsuario;
import java.util.Set;
import java.util.Iterator;

public class ConsultaUsuario extends JInternalFrame {
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
		Fabrica fabric = Fabrica.getInstancia();
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		IUsuario iusuario = fabric.getIUsuario();
		Set<DtUsuario> listaUsuarios = iusuario.listarUsuarios();
		
		JComboBox comboBoxUsuario = new JComboBox();
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
		springLayout.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH, comboBoxUsuario);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblUsuario);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -243, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		textFieldNickname = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNickname, 95, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNickname, 7, SpringLayout.NORTH, panel);
		textFieldNickname.setColumns(10);
		panel.add(textFieldNickname);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNombre, 84, SpringLayout.WEST, panel);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 2, SpringLayout.NORTH, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 14, SpringLayout.SOUTH, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, 0, SpringLayout.EAST, textFieldNickname);
		textFieldNombre.setColumns(10);
		panel.add(textFieldNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		sl_panel.putConstraint(SpringLayout.WEST, lblApellido, 0, SpringLayout.WEST, panel);
		panel.add(lblApellido);
		
		textFieldApellido = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblApellido, 4, SpringLayout.NORTH, textFieldApellido);
		sl_panel.putConstraint(SpringLayout.EAST, lblApellido, -11, SpringLayout.WEST, textFieldApellido);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldApellido, 15, SpringLayout.SOUTH, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldApellido, 0, SpringLayout.EAST, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldApellido, 95, SpringLayout.WEST, panel);
		textFieldApellido.setColumns(10);
		panel.add(textFieldApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		sl_panel.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, panel);
		panel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, lblEmail, -11, SpringLayout.WEST, textFieldEmail);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEmail, 110, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldApellido, -13, SpringLayout.NORTH, textFieldEmail);
		sl_panel.putConstraint(SpringLayout.NORTH, lblEmail, 3, SpringLayout.NORTH, textFieldEmail);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEmail, 0, SpringLayout.WEST, textFieldNickname);
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
		sl_panel.putConstraint(SpringLayout.WEST, lblNacimiento, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNacimiento, 0, SpringLayout.SOUTH, dateChooser);
		panel.add(lblNacimiento);
		
		JLabel lblNickname = new JLabel("Nickname:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNickname, 3, SpringLayout.NORTH, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.WEST, lblNickname, 0, SpringLayout.WEST, panel);
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNickname);
		
		JLabel lblEspectaculosRegistrados = new JLabel("Espectaculos:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectaculosRegistrados, 2, SpringLayout.NORTH, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectaculosRegistrados, 24, SpringLayout.EAST, textFieldNickname);
		panel.add(lblEspectaculosRegistrados);
		
		JComboBox comboBoxEspectaculos = new JComboBox();
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxEspectaculos, 343, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxEspectaculos, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblEspectaculosRegistrados, -6, SpringLayout.WEST, comboBoxEspectaculos);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxEspectaculos, -3, SpringLayout.NORTH, textFieldNickname);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBoxEspectaculos, 21, SpringLayout.NORTH, textFieldNickname);
		panel.add(comboBoxEspectaculos);
		
		JLabel lblRol = new JLabel("Rol:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblRol, 19, SpringLayout.SOUTH, lblEspectaculosRegistrados);
		sl_panel.putConstraint(SpringLayout.WEST, lblRol, 0, SpringLayout.WEST, lblEspectaculosRegistrados);
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRol);
		
		textFieldRol = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldRol, 12, SpringLayout.SOUTH, comboBoxEspectaculos);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldRol, 0, SpringLayout.WEST, comboBoxEspectaculos);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldRol, -156, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldRol, 0, SpringLayout.EAST, comboBoxEspectaculos);
		textFieldRol.setColumns(10);
		panel.add(textFieldRol);
		
		Button buttonAceptar_1 = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1, -48, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(buttonAceptar_1);
		
		Button buttonAceptar_1_1 = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1, -87, SpringLayout.WEST, buttonAceptar_1_1);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1, -6, SpringLayout.WEST, buttonAceptar_1_1);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1_1, -48, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1_1, -91, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1_1, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1_1, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar_1_1);
		
		comboBoxUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});

	}
}
