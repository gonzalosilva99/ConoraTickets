package GUI;

import java.awt.EventQueue;
import javax.swing.ListSelectionModel;
import DataTypes.DtEspectaculo;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import DataTypes.DtFuncion;
import Controladores.Fabrica;
import DataTypes.DtPlataforma;
import DataTypes.DtEspectador;
import Interfaces.IPlataforma;
import Interfaces.IUsuario;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import DataTypes.DtPaquete;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
public class RegistroFuncionDeEspectaculo extends JInternalFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroFuncionDeEspectaculo frame = new RegistroFuncionDeEspectaculo();
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
	public RegistroFuncionDeEspectaculo() {
		Integer contador = 0;
		setTitle("Registrar Espectador a Funcion de Espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, -377, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblPlataforma);
		
		
		
		

		JComboBox comboBoxPlataforma = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, -5, SpringLayout.NORTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 17, SpringLayout.EAST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -152, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPlataforma);
		comboBoxPlataforma.addItem("");
	

		//1)--------------> Cargamos las plataformas
		Fabrica fabric = Fabrica.getInstancia();
		IPlataforma iplataforma = fabric.getIPlataforma();
		IUsuario iusu = fabric.getIUsuario();
		Set<DtPlataforma> listaPlataformas = iplataforma.listarPlataformas();
		Iterator<DtPlataforma> itr = listaPlataformas.iterator();
		while(itr.hasNext())
			{comboBoxPlataforma.addItem(itr.next().getNombre());}
		

		
		
		JLabel lblEspectaculos = new JLabel("Espectaculo: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 15, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculos, -377, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblEspectaculos);
		
		Panel panel = new Panel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 3, SpringLayout.SOUTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 499, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblFuncion = new JLabel("Funcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFuncion, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFuncion, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblFuncion, -342, SpringLayout.EAST, panel);
		panel.add(lblFuncion);
		
		
		
		JComboBox comboBoxFuncion = new JComboBox();
		
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxFuncion, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxFuncion, -110, SpringLayout.EAST, panel);
		panel.add(comboBoxFuncion);
		
		JComboBox comboBoxEspectador = new JComboBox();
		comboBoxEspectador.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxEspectador, 3, SpringLayout.SOUTH, comboBoxFuncion);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxEspectador, 179, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxEspectador, -110, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxFuncion, 0, SpringLayout.WEST, comboBoxEspectador);
		comboBoxEspectador.setEnabled(false);
		panel.add(comboBoxEspectador);
		Set<DtEspectador> especs = iusu.listarEspectadores();
		Iterator<DtEspectador> itesp = especs.iterator();
		while(itesp.hasNext()) {
			comboBoxEspectador.addItem(itesp.next().getNickname());
		}
		
		comboBoxFuncion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxEspectador.setEnabled(true);
			}
			
		});
		
		
		
		JLabel lblEspectador = new JLabel("Espectador: ");
		sl_panel.putConstraint(SpringLayout.EAST, lblEspectador, -342, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectador, 12, SpringLayout.SOUTH, lblFuncion);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectador, 10, SpringLayout.WEST, panel);
		panel.add(lblEspectador);
		
		JCheckBox chckbxCanjear = new JCheckBox("Canjear la Funcion?");
		Panel panelInterior = new Panel();
		sl_panel.putConstraint(SpringLayout.NORTH, panelInterior, 94, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panelInterior, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, chckbxCanjear, -6, SpringLayout.NORTH, panelInterior);
		panelInterior.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.WEST, panelInterior, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panelInterior, 479, SpringLayout.WEST, panel);
		panel.add(panelInterior);
		SpringLayout sl_panelInterior = new SpringLayout();
		panelInterior.setLayout(sl_panelInterior);
		panelInterior.setVisible(false);
		
		
		
		
		
		chckbxCanjear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				panelInterior.setVisible(!panelInterior.isVisible());
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, chckbxCanjear, 10, SpringLayout.WEST, panel);
		panel.add(chckbxCanjear);
		
		
		
		JComboBox comboBoxEspectaculo = new JComboBox();
		
		//Cuando selecciono espectaculo cargo las funciones vigentes 
		comboBoxEspectaculo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxEspectaculo.getSelectedItem().toString() != "") {
					comboBoxFuncion.setEnabled(true);
					comboBoxFuncion.removeAllItems();
					comboBoxFuncion.addItem("");
					Set<DtFuncion> listafunciones = iplataforma.listarFuncionesVigentesEspectaculo(comboBoxEspectaculo.getSelectedItem().toString(), comboBoxPlataforma.getSelectedItem().toString());
					Iterator<DtFuncion> itfun = listafunciones.iterator();
					while(itfun.hasNext()) {
						comboBoxFuncion.addItem(itfun.next().getNombre());
					}
				}
				
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectaculo, 6, SpringLayout.SOUTH, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectaculo, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectaculo, 0, SpringLayout.EAST, comboBoxPlataforma);
		getContentPane().add(comboBoxEspectaculo);
		
		//  2)------>   cuando se selecciona una plataforma listo los espectaculos de esa plataforma 
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxEspectaculo.setEnabled(true);
				comboBoxEspectaculo.removeAllItems();
				Set<DtEspectaculo> listarEspecsDePlat = iplataforma.listarEspectaculosDePlataforma(comboBoxPlataforma.getSelectedItem().toString());
				Iterator<DtEspectaculo> itr = listarEspecsDePlat.iterator();
				comboBoxEspectaculo.addItem("");
				while(itr.hasNext())
					{comboBoxEspectaculo.addItem(itr.next().getNombre());}
			}
		});
		
		
		
		
		JLabel lblCanjearPor = new JLabel("Canjear por:");
		sl_panelInterior.putConstraint(SpringLayout.NORTH, lblCanjearPor, 10, SpringLayout.NORTH, panelInterior);
		sl_panelInterior.putConstraint(SpringLayout.WEST, lblCanjearPor, 10, SpringLayout.WEST, panelInterior);
		panelInterior.add(lblCanjearPor);
		

		JLabel lblListaPaquetesFunciones = new JLabel("Paquetes por los que puede canjear:");
		sl_panelInterior.putConstraint(SpringLayout.NORTH, lblListaPaquetesFunciones, 54, SpringLayout.SOUTH, lblCanjearPor);
		sl_panelInterior.putConstraint(SpringLayout.WEST, lblListaPaquetesFunciones, 0, SpringLayout.WEST, lblCanjearPor);
		panelInterior.add(lblListaPaquetesFunciones);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panelInterior.putConstraint(SpringLayout.NORTH, scrollPane, 9, SpringLayout.SOUTH, lblListaPaquetesFunciones);
		sl_panelInterior.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblCanjearPor);
		sl_panelInterior.putConstraint(SpringLayout.SOUTH, scrollPane, 164, SpringLayout.SOUTH, lblListaPaquetesFunciones);
		sl_panelInterior.putConstraint(SpringLayout.EAST, scrollPane, 410, SpringLayout.WEST, panelInterior);
		panelInterior.add(scrollPane);
		
		
		JList<? extends String> list = new JList();
		scrollPane.add(list);
		
		
		
		//Si selecciono canjear por paquetes los cargo
		JRadioButton rdbtnPaquete = new JRadioButton("Paquete");
		
		
		rdbtnPaquete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnPaquete.isSelected()) {
					DefaultListModel listapaquetes = new DefaultListModel();
					Set<DtPaquete> listpaqcanj = iusu.listarPaquetesCanjeables(comboBoxEspectador.getSelectedItem().toString(), comboBoxEspectaculo.getSelectedItem().toString());
					Iterator<DtPaquete> itpaq = listpaqcanj.iterator();
					listapaquetes.addElement("");
					while(itpaq.hasNext()) {
						DtPaquete dtpaq = itpaq.next();
						listapaquetes.addElement(dtpaq.getNombre());
					}
					list.setModel(listapaquetes);
					scrollPane.setViewportView(list);
				}
				
			}
		});
		
		
		buttonGroup.add(rdbtnPaquete);
		sl_panelInterior.putConstraint(SpringLayout.NORTH, rdbtnPaquete, -4, SpringLayout.NORTH, lblCanjearPor);
		sl_panelInterior.putConstraint(SpringLayout.WEST, rdbtnPaquete, 6, SpringLayout.EAST, lblCanjearPor);
		panelInterior.add(rdbtnPaquete);
		
		JRadioButton rdbtnFuncion = new JRadioButton("Tres Funciones");
		buttonGroup.add(rdbtnFuncion);
		sl_panelInterior.putConstraint(SpringLayout.NORTH, rdbtnFuncion, 4, SpringLayout.SOUTH, rdbtnPaquete);
		sl_panelInterior.putConstraint(SpringLayout.WEST, rdbtnFuncion, 0, SpringLayout.WEST, rdbtnPaquete);
		panelInterior.add(rdbtnFuncion);
		
		Button buttonAnadir = new Button("+");
		sl_panelInterior.putConstraint(SpringLayout.SOUTH, buttonAnadir, -121, SpringLayout.SOUTH, panelInterior);
		sl_panelInterior.putConstraint(SpringLayout.EAST, buttonAnadir, -10, SpringLayout.EAST, panelInterior);
		panelInterior.add(buttonAnadir);
		
		Button buttonQuitar = new Button("-");
		sl_panelInterior.putConstraint(SpringLayout.SOUTH, buttonQuitar, -87, SpringLayout.SOUTH, panelInterior);
		sl_panelInterior.putConstraint(SpringLayout.EAST, buttonQuitar, -10, SpringLayout.EAST, panelInterior);
		panelInterior.add(buttonQuitar);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panelInterior.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblCanjearPor);
		sl_panelInterior.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, panelInterior);
		panelInterior.add(lblNewLabel);
		
		
		
		
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -15, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -42, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 323, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -104, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 6, SpringLayout.EAST, buttonCancelar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -42, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		buttonCancelar.setActionCommand("Cancelar");
		getContentPane().add(buttonCancelar);
		
		

	}
}
