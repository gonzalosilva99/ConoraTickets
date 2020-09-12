package GUI;

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

import Controladores.Fabrica;
import Interfaces.IUsuario;

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
import java.text.SimpleDateFormat;

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
		
		/*** CARGAR DATOS DE PRUEBA ***/
		Fabrica fab = Fabrica.getInstancia();
		IUsuario iusuario = fab.getIUsuario();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// ESPECTADORES (Nickname, Nombre, Apellido, Email, Fecha_Nac)
	Date fechaNac = formato.parse("31/12/1971");
	/**	 iusuario.confirmarAltaEspectador("eleven11", "Eleven", "Ten", "eleven11@gmail.com", fechaNac);
		fechaNac = formato.parse("15/11/1983");
		iusuario.confirmarAltaEspectador("costas", "Gerardo", "Costas", "gcostas@gmail.com", fechaNac);
		fechaNac = formato.parse("//");
		iusuario.confirmarAltaEspectador("", "", "", "", fechaNac);
		fechaNac = formato.parse("//");
		iusuario.confirmarAltaEspectador("", "", "", "", fechaNac);
		fechaNac = formato.parse("//");
		iusuario.confirmarAltaEspectador("", "", "", "", fechaNac);
		fechaNac = formato.parse("//");
		iusuario.confirmarAltaEspectador("", "", "", "", fechaNac);
		fechaNac = formato.parse("//");
		iusuario.confirmarAltaEspectador("", "", "", "", fechaNac);
		fechaNac = formato.parse("//");
		iusuario.confirmarAltaEspectador("", "", "", "", fechaNac);
		fechaNac = formato.parse("//");
		iusuario.confirmarAltaEspectador("", "", "", "", fechaNac);
		
		**/
		//Cargar Artista de prueba
		IPlataforma iplataforma = fab.getIPlataforma();
		iusuario.confirmarAltaArtista("Peke77", "Jacinto" , "Vera" , "peke77@gmail.com" , fechaNac, "Soy rapero" , "naci blabla", "peke77.com");
		iplataforma.AltaPlataforma("Facebook", "Una descricpion" ," facebook.com"); 
		iplataforma.AltaPlataforma("Youtube", "Una descricpion" ," youtube.com"); 
		iplataforma.AltaPlataforma("Instagram", "Una descricpion" ," instagram.com"); 
		
		
		
		
		/*** FIN CARGAR DATOS DE PRUEBA ***/
		
		
		
		
		
		frmMainWindow = new JFrame();
		frmMainWindow.setResizable(false);
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
		mntmAltaFuncionDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaFuncionEspectaculo altafuncionesp = new AltaFuncionEspectaculo();
				desktopPane.add(altafuncionesp);
				altafuncionesp.show();
				try {
					altafuncionesp.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mnAltas.add(mntmAltaFuncionDe);
		
		JMenuItem mntmAltaDePlataforma = new JMenuItem("Alta de Plataforma");
		mntmAltaDePlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaPlataforma altaplataforma = new AltaPlataforma();
				desktopPane.add(altaplataforma);
				altaplataforma.show();
				try {
					altaplataforma.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnAltas.add(mntmAltaDePlataforma);
		
		JMenuItem mntmCrearPaqueteDe = new JMenuItem("Crear Paquete de Espectaculo");
		mntmCrearPaqueteDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearPaqueteDeEspectaculo crearpaqueteesp = new CrearPaqueteDeEspectaculo();
				desktopPane.add(crearpaqueteesp);
				crearpaqueteesp.show();
				try {
					crearpaqueteesp.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnAltas.add(mntmCrearPaqueteDe);
		
		JMenu mnRegistros = new JMenu("Registros");
		menuBar.add(mnRegistros);
		
		JMenuItem mntmRegistroFuncionDe = new JMenuItem("Registro Funcion de Espectaculo");
		mntmRegistroFuncionDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroFuncionDeEspectaculo registrofuncionespectaculo = new RegistroFuncionDeEspectaculo();
				desktopPane.add(registrofuncionespectaculo);
				registrofuncionespectaculo.show();
				try {
					registrofuncionespectaculo.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRegistros.add(mntmRegistroFuncionDe);
		
		JMenuItem mntmAgregarEspectaculoA = new JMenuItem("Agregar Espectaculo a Paquete");
		mntmAgregarEspectaculoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarEspectaculoAPaquete agregarespapaquete = new AgregarEspectaculoAPaquete();
				desktopPane.add(agregarespapaquete);
				agregarespapaquete.show();
				try {
					agregarespapaquete.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRegistros.add(mntmAgregarEspectaculoA);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmConsultaDeUsuario = new JMenuItem("Consulta de Usuario");
		mntmConsultaDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConsultaUsuario consultausuario = new ConsultaUsuario();
				desktopPane.add(consultausuario);
				consultausuario.show();
				try {
					consultausuario.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnConsultas.add(mntmConsultaDeUsuario);
		
		JMenuItem mntmConsultaDeEspectaculo = new JMenuItem("Consulta de Espectaculo");
		mntmConsultaDeEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaEspectaculo consultaespectaculo = new ConsultaEspectaculo();
				desktopPane.add(consultaespectaculo);
				consultaespectaculo.show();
				try {
					consultaespectaculo.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConsultas.add(mntmConsultaDeEspectaculo);
		
		JMenuItem mntmConsultaDeFuncion = new JMenuItem("Consulta de Funcion de Espectaculo");
		mntmConsultaDeFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaFuncionEspectaculo consultafuncionespectaculo= new ConsultaFuncionEspectaculo();
				desktopPane.add(consultafuncionespectaculo);
				consultafuncionespectaculo.show();
				try {
					consultafuncionespectaculo.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConsultas.add(mntmConsultaDeFuncion);
		
		JMenuItem mntmConsultaDePaquete = new JMenuItem("Consulta de Paquete de Espectaculos");
		mntmConsultaDePaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaDePaqueteDeEspectaculos consultapaquetedeespectaculo= new ConsultaDePaqueteDeEspectaculos ();
				desktopPane.add(consultapaquetedeespectaculo);
				consultapaquetedeespectaculo.show();
				try {
					consultapaquetedeespectaculo.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConsultas.add(mntmConsultaDePaquete);
		
		JMenu mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);
		
		JMenuItem mntmDatosDeUsuario = new JMenuItem("Modificar Datos de Usuario");
		mntmDatosDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDatosUsuario modificar = new ModificarDatosUsuario();
				desktopPane.add(modificar);
				modificar.show();
				try {
					modificar.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnModificar.add(mntmDatosDeUsuario);
	}
}
