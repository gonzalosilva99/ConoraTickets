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
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmMainWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMainWindow.setVisible(true);
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
		frmMainWindow = new JFrame();
		frmMainWindow.setTitle("Main Window");
		frmMainWindow.setBounds(100, 100, 550, 650);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainWindow.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		frmMainWindow.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmMainWindow.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaUsuario altausuario = new AltaUsuario();
				desktopPane.add(altausuario);
				altausuario.show();
				try {
					altausuario.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmAltaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mnAltas.add(mntmAltaUsuario);
		
		JMenuItem mntmAltaDeEspectaculo = new JMenuItem("Alta de Espectaculo");
		mntmAltaDeEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaEspectaculo altaespectaculo = new AltaEspectaculo();
				desktopPane.add(altaespectaculo);
				altaespectaculo.show();
				try {
					altaespectaculo.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
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