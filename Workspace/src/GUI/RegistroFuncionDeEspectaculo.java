package GUI;

import java.awt.EventQueue;
import DataTypes.DtRegistro;
import DataTypes.DtEspectaculo;

import javax.swing.ListSelectionModel;
import DataTypes.DtEspectaculoDatos;

import DataTypes.TipoRegistro;
import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

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
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import DataTypes.DtPaquete;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
public class RegistroFuncionDeEspectaculo extends JInternalFrame {
	private Integer contadorseleccionadas;
	private Integer cantpaqseleccionado;
	private Boolean existe=false;
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
		cantpaqseleccionado = 0;
		contadorseleccionadas = 0;
		setTitle("Registrar Espectador a Funcion de Espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma: ");
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, -377, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblPlataforma);
		
		
		
		

		JComboBox comboBoxPlataforma = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 3, SpringLayout.NORTH, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, 8, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 149, SpringLayout.WEST, getContentPane());
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
		
		
		
		JCheckBox chckbxCanjear = new JCheckBox("Canjear la Funcion?");
		springLayout.putConstraint(SpringLayout.WEST, chckbxCanjear, 0, SpringLayout.WEST, lblPlataforma);
		getContentPane().add(chckbxCanjear);

		JComboBox comboBoxEspectaculo = new JComboBox();
		JComboBox comboBoxFuncion = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxFuncion, 6, SpringLayout.SOUTH, comboBoxEspectaculo);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxFuncion, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxFuncion, 0, SpringLayout.EAST, comboBoxPlataforma);
		getContentPane().add(comboBoxFuncion);
		
		JComboBox comboBoxEspectador = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, chckbxCanjear, 47, SpringLayout.SOUTH, comboBoxEspectador);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectador, 6, SpringLayout.SOUTH, comboBoxFuncion);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectador, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectador, 0, SpringLayout.EAST, comboBoxPlataforma);
		getContentPane().add(comboBoxEspectador);
		comboBoxEspectador.setEnabled(false);
		
		
		JLabel lblEspectaculos = new JLabel("Espectaculo: ");
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 0, SpringLayout.WEST, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculos, -377, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblEspectaculos);
		Set<DtEspectador> especs = iusu.listarEspectadores();
		Iterator<DtEspectador> itesp = especs.iterator();
		while(itesp.hasNext()) {
			comboBoxEspectador.addItem(itesp.next().getNickname());
		}
				
		//Cuando selecciono espectaculo cargo las funciones vigentes 
		comboBoxEspectaculo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxEspectaculo.isFocusOwner()) {
					if(comboBoxEspectaculo.getSelectedItem().toString() != "") {
						comboBoxFuncion.setEnabled(true);
						comboBoxFuncion.removeAllItems();
						comboBoxFuncion.addItem("");
						Set<DtFuncion> listafunciones = iplataforma.listarFuncionesVigentesEspectaculo(comboBoxEspectaculo.getSelectedItem().toString(), comboBoxPlataforma.getSelectedItem().toString());
						int cant = listafunciones.size();
						Iterator<DtFuncion> itfun = listafunciones.iterator();
						while(itfun.hasNext()) {
							comboBoxFuncion.addItem(itfun.next().getNombre());
						}
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
				comboBoxFuncion.removeAllItems();
				Set<DtEspectaculo> listarEspecsDePlat = iplataforma.listarEspectaculosDePlataforma(comboBoxPlataforma.getSelectedItem().toString());
				Iterator<DtEspectaculo> itr = listarEspecsDePlat.iterator();
				comboBoxEspectaculo.addItem("");
				while(itr.hasNext())
					{comboBoxEspectaculo.addItem(itr.next().getNombre());}
			}
		});
		
		
		
		
		
		Button buttonAceptar = new Button("Aceptar");
		
		
		
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -42, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		

		
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 323, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -104, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 6, SpringLayout.EAST, buttonCancelar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -42, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		buttonCancelar.setActionCommand("Cancelar");
		getContentPane().add(buttonCancelar);
		
		Button buttonAnadir = new Button("+");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAnadir, 360, SpringLayout.NORTH, getContentPane());
		getContentPane().add(buttonAnadir);
		buttonAnadir.setVisible(false);
		
		Button buttonQuitar = new Button("-");
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAnadir, 0, SpringLayout.SOUTH, buttonQuitar);
		springLayout.putConstraint(SpringLayout.EAST, buttonAnadir, -23, SpringLayout.WEST, buttonQuitar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonQuitar, 362, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonQuitar, -88, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonQuitar, -43, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonQuitar);
		buttonQuitar.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		
		JLabel lblFuncion = new JLabel("Funcion:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculos, -7, SpringLayout.NORTH, lblFuncion);
		springLayout.putConstraint(SpringLayout.NORTH, lblFuncion, 3, SpringLayout.NORTH, comboBoxFuncion);
		springLayout.putConstraint(SpringLayout.WEST, lblFuncion, 0, SpringLayout.WEST, lblPlataforma);
		getContentPane().add(lblFuncion);
		
		JLabel lblListaPaquetesFunciones = new JLabel("Paquetes por los que puede canjear:");
		springLayout.putConstraint(SpringLayout.WEST, lblListaPaquetesFunciones, 31, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblListaPaquetesFunciones);
		lblListaPaquetesFunciones.setVisible(false);
		
		
		
		JLabel lblEspectador = new JLabel("Espectador: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectador, 3, SpringLayout.NORTH, comboBoxEspectador);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectador, 0, SpringLayout.WEST, lblPlataforma);
		getContentPane().add(lblEspectador);
		
		
		
		JLabel lblCanjearPor = new JLabel("Canjear por:");
		springLayout.putConstraint(SpringLayout.WEST, lblCanjearPor, 10, SpringLayout.WEST, chckbxCanjear);
		getContentPane().add(lblCanjearPor);
		lblCanjearPor.setVisible(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, buttonAnadir, 28, SpringLayout.EAST, scrollPane_1);
		springLayout.putConstraint(SpringLayout.WEST, buttonQuitar, 80, SpringLayout.EAST, scrollPane_1);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 305, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblListaPaquetesFunciones, -6, SpringLayout.NORTH, scrollPane_1);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 0, SpringLayout.EAST, comboBoxPlataforma);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setVisible(false);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		Map<Integer,Integer> codigos = new HashMap<Integer,Integer>();
		Set<Integer> codigosseleccionados = new HashSet<Integer>();
		
		
		JRadioButton rdbtnFuncion = new JRadioButton("Tres Funciones");
		rdbtnFuncion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(rdbtnFuncion.isSelected()) {
					lblListaPaquetesFunciones.setText("Seleccione las 3 funciones a canjear: ");
					DefaultListModel listafuncionescanj = new DefaultListModel();
					Set<DtRegistro> listfuncanj = iusu.listarRegistrosSinCanjeaer(comboBoxEspectador.getSelectedItem().toString());
					Iterator<DtRegistro> itfuncanj = listfuncanj.iterator();
					listafuncionescanj.addElement("");
					for(Integer i=1;itfuncanj.hasNext();i++) {
						DtRegistro dtreg = itfuncanj.next();
						listafuncionescanj.addElement(dtreg.getNombreFuncion());
						codigos.put(i,dtreg.getCodigo());
					}
					list.setModel(listafuncionescanj);
					scrollPane_1.setViewportView(list);
				}
			}
		});
		getContentPane().add(rdbtnFuncion);
		buttonGroup.add(rdbtnFuncion);
		rdbtnFuncion.setVisible(false);
		
		
		
		//Si selecciono canjear por paquetes los cargo
		JRadioButton rdbtnPaquete = new JRadioButton("Paquete");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnPaquete, 21, SpringLayout.EAST, lblCanjearPor);
		springLayout.putConstraint(SpringLayout.NORTH, lblCanjearPor, 4, SpringLayout.NORTH, rdbtnPaquete);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnFuncion, 2, SpringLayout.SOUTH, rdbtnPaquete);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnFuncion, 0, SpringLayout.WEST, rdbtnPaquete);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnPaquete, 6, SpringLayout.SOUTH, chckbxCanjear);
		getContentPane().add(rdbtnPaquete);
		rdbtnPaquete.setVisible(false);
		
		
		rdbtnPaquete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnPaquete.isSelected()) {
					lblListaPaquetesFunciones.setText("Seleccione el paquete a canjear:");
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
		
		JLabel lblSeleccionados = new JLabel("Seleccionadas: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblSeleccionados, 448, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -17, SpringLayout.NORTH, lblSeleccionados);
		springLayout.putConstraint(SpringLayout.WEST, lblSeleccionados, 0, SpringLayout.WEST, lblPlataforma);
		getContentPane().add(lblSeleccionados);
		lblSeleccionados.setVisible(false);
		
		
		
		Set<String> listaseleccionados = new HashSet<String>();
		
		
		
		// Cuando selecciona para agregar funcion seleccionada para canjear
		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnFuncion.isSelected() && contadorseleccionadas < 3 && contadorseleccionadas>=0) {
					existe=false;
					Iterator<String> itp = listaseleccionados.iterator();
					while(itp.hasNext() && !existe)
						if(itp.next().toString().equals(list.getSelectedValue().toString()))
							existe=true;
					if(!existe) {
						
						listaseleccionados.add(list.getSelectedValue().toString());
						if(contadorseleccionadas > 0) 
							lblSeleccionados.setText(lblSeleccionados.getText() + ", " + list.getSelectedValue().toString());
						else
							lblSeleccionados.setText(lblSeleccionados.getText() + list.getSelectedValue().toString());
						contadorseleccionadas = contadorseleccionadas + 1 ;
						codigosseleccionados.add(codigos.get(list.getSelectedIndex()));
					}
				}
				else if(rdbtnPaquete.isSelected() && cantpaqseleccionado == 0 ) {
					//aqui iria codigo de agrear a la lista;
				}
					
				
			}
		});
		
		
		
		comboBoxFuncion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxEspectador.setEnabled(true);
			}
			
		});
		
		//cuando selecciona eliminar uno de los seleccionados 
		buttonQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contadorseleccionadas > 0 && contadorseleccionadas <=3 && !list.isSelectionEmpty() ) {
					existe=false;
					Iterator<String> itp = listaseleccionados.iterator();
					while(itp.hasNext() && !existe)
						if(itp.next().toString().equals(list.getSelectedValue().toString()))
							existe=true;
					if(existe) {
						listaseleccionados.remove(list.getSelectedValue().toString());
						codigosseleccionados.remove(codigos.get(list.getSelectedIndex()));
						contadorseleccionadas--;
						Iterator<String> itr = listaseleccionados.iterator();
						lblSeleccionados.setText("Seleccionadas: ");
						while(itr.hasNext()) {
							lblSeleccionados.setText(lblSeleccionados.getText() + itr.next().toString());
						}
					}
				}
			}
		});
		
		comboBoxEspectador.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnPaquete.setSelected(true);
				rdbtnFuncion.setSelected(true);
				listaseleccionados.clear();
				lblSeleccionados.setText("Funciones seleccionadas: ");
			}
		});
		
		
		
		chckbxCanjear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblCanjearPor.setVisible(!lblCanjearPor.isVisible());
				rdbtnPaquete.setVisible(!rdbtnPaquete.isVisible());
				rdbtnFuncion.setVisible(!rdbtnFuncion.isVisible());
				lblListaPaquetesFunciones.setVisible(!lblListaPaquetesFunciones.isVisible());
				scrollPane_1.setVisible(!scrollPane_1.isVisible());
				buttonAnadir.setVisible(!buttonAnadir.isVisible());
				buttonQuitar.setVisible(!buttonQuitar.isVisible());
				lblSeleccionados.setVisible(!lblSeleccionados.isVisible());
				
			}
		});
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(comboBoxPlataforma.getSelectedItem().toString().equals("") || comboBoxEspectaculo.getSelectedItem().toString().equals("") || comboBoxFuncion.getSelectedItem().toString().equals("")  || comboBoxEspectador.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Error, falta seleccionar datos.");
						return;
					}
					String nombreplataforma = comboBoxPlataforma.getSelectedItem().toString();
					String nombreespectaculo = comboBoxEspectaculo.getSelectedItem().toString();
					String nombrefuncion = comboBoxFuncion.getSelectedItem().toString();
					TipoRegistro registro = TipoRegistro.Tipo_1;
					String nickname = comboBoxEspectador.getSelectedItem().toString();
					Date today = Calendar.getInstance().getTime();
					DtEspectaculoDatos dtespec = iplataforma.getDatosEspectaculo(comboBoxPlataforma.getSelectedItem().toString(), comboBoxEspectaculo.getSelectedItem().toString());
					
					if(!chckbxCanjear.isSelected())
						registro= TipoRegistro.Tipo_1;
					else if(rdbtnPaquete.isSelected())
						registro = TipoRegistro.Tipo_3;
					else if(rdbtnFuncion.isSelected())
						registro = TipoRegistro.Tipo_2;
					if(chckbxCanjear.isSelected() && !rdbtnPaquete.isSelected() && !rdbtnFuncion.isSelected()) {
						JOptionPane.showMessageDialog(null, "No se han ingresado todos los datos.");
						return;
					}
					
					
					if(registro == TipoRegistro.Tipo_2) {
						if(listaseleccionados.size()==3) {
							Iterator<Integer> itr = codigosseleccionados.iterator();
							Integer codselarray[] = new Integer[3];
							codselarray = codigosseleccionados.toArray(codselarray);
							iusu.confirmarRegistroFuncionEspectaculo(nombreplataforma, nombreespectaculo, nickname, nombrefuncion, today, registro, codselarray[0], codselarray[1], codselarray[2], "", dtespec.getCosto().doubleValue());
							JOptionPane.showMessageDialog(null, "Se ha registrado con exito a la funcion.");
							chckbxCanjear.setSelected(false);
							rdbtnPaquete.setSelected(false);
							rdbtnFuncion.setSelected(false);
							rdbtnFuncion.setSelected(true);
							DefaultListModel vacia = new DefaultListModel();
							vacia.addElement("");
							list.setModel(vacia);
							list.removeAll();
							lblSeleccionados.setText("Seleccionadas: ");
							listaseleccionados.clear();
							registro = TipoRegistro.Tipo_1;
						}
					}
					else if(registro == TipoRegistro.Tipo_1) {
						iusu.confirmarRegistroFuncionEspectaculo(nombreplataforma, nombreespectaculo, nickname, nombrefuncion, today, registro, 0, 0, 0, "", dtespec.getCosto().doubleValue());
						JOptionPane.showMessageDialog(null, "Se ha registrado con exito a la funcion.");
						chckbxCanjear.setSelected(false);
						rdbtnPaquete.setSelected(false);
						rdbtnFuncion.setSelected(false);
						lblSeleccionados.setText("Seleccionadas: ");
						buttonGroup.clearSelection();
						DefaultListModel vacia = new DefaultListModel();
						vacia.addElement("");
						list.setModel(vacia);
						scrollPane_1.setViewportView(list);
						listaseleccionados.clear();
						registro = TipoRegistro.Tipo_1;
					}
					else if(registro == TipoRegistro.Tipo_3) {
						if(cantpaqseleccionado != 1 ) {
							JOptionPane.showMessageDialog(null, "No se ha seleccionado paquete.");
							return;
						}
						
							
					}
						
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo luego.");
				}
				
			}
		});
		
		
		
		

	}
}
