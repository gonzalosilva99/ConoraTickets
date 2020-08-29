package CentralServer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

public class Main {

	private JFrame frame;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JInternalFrame internalFrame = new JInternalFrame("Alta Usuario");
		frame.getContentPane().add(internalFrame, BorderLayout.CENTER);
		SpringLayout springLayout = new SpringLayout();
		internalFrame.getContentPane().setLayout(springLayout);
		
		JLabel lblNickname = new JLabel("Nickname: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNickname, 12, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNickname, 12, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNickname, 47, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNickname, 123, SpringLayout.WEST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 6, SpringLayout.SOUTH, lblNickname);
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNombre, 88, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNombre, 123, SpringLayout.WEST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblApellido, 6, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblApellido, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblApellido, 129, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblApellido, -417, SpringLayout.EAST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 6, SpringLayout.SOUTH, lblApellido);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 12, SpringLayout.WEST, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, -240, SpringLayout.SOUTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblNickname);
		internalFrame.getContentPane().add(lblEmail);
		
		JLabel lblNacimiento = new JLabel("Nacimiento: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNacimiento, 6, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lblNacimiento, 0, SpringLayout.WEST, lblNickname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNacimiento, -199, SpringLayout.SOUTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNacimiento, 123, SpringLayout.WEST, internalFrame.getContentPane());
		internalFrame.getContentPane().add(lblNacimiento);
		
		textFieldNickname = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNickname, 20, SpringLayout.NORTH, internalFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldNickname, 6, SpringLayout.EAST, lblNickname);
		springLayout.putConstraint(SpringLayout.EAST, textFieldNickname, 166, SpringLayout.EAST, lblNickname);
		internalFrame.getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		textFieldNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNombre, 22, SpringLayout.SOUTH, textFieldNickname);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNombre, 6, SpringLayout.EAST, lblNombre);
		springLayout.putConstraint(SpringLayout.EAST, textFieldNombre, 0, SpringLayout.EAST, textFieldNickname);
		internalFrame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		internalFrame.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mnAltas.add(mntmAltaUsuario);
		
		JMenuItem mntmAltaDeEspectaculo = new JMenuItem("Alta de Espectaculo");
		mnAltas.add(mntmAltaDeEspectaculo);
		
		JMenuItem mntmAltaFuncionDe = new JMenuItem("Alta Funcion de Espectaculo");
		mnAltas.add(mntmAltaFuncionDe);
		
		JMenuItem mntmAltaDePlataforma = new JMenuItem("Alta de Plataforma");
		mnAltas.add(mntmAltaDePlataforma);
		
		JMenuItem mntmCrearPaqueteDe = new JMenuItem("Crear Paquete de Espectaculo");
		mnAltas.add(mntmCrearPaqueteDe);
		
		JMenu mnRegistros = new JMenu("Registros");
		menuBar.add(mnRegistros);
		
		JMenuItem mntmRegistroFuncionDe = new JMenuItem("Registro Funcion de Espectaculo");
		mnRegistros.add(mntmRegistroFuncionDe);
		
		JMenuItem mntmAgregarEspectaculoA = new JMenuItem("Agregar Espectaculo a Paquete");
		mnRegistros.add(mntmAgregarEspectaculoA);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmConsultaDeUsuario = new JMenuItem("Consulta de Usuario");
		mnConsultas.add(mntmConsultaDeUsuario);
		
		JMenuItem mntmConsultaDeEspectaculo = new JMenuItem("Consulta de Espectaculo");
		mnConsultas.add(mntmConsultaDeEspectaculo);
		
		JMenuItem mntmConsultaDeFuncion = new JMenuItem("Consulta de Funcion de Espectaculo");
		mnConsultas.add(mntmConsultaDeFuncion);
		
		JMenuItem mntmConsultaDePaquete = new JMenuItem("Consulta de Paquete de Espectaculos");
		mnConsultas.add(mntmConsultaDePaquete);
		
		JMenu mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);
		
		JMenuItem mntmDatosDeUsuario = new JMenuItem("Modificar Datos de Usuario");
		mnModificar.add(mntmDatosDeUsuario);
	}
}
