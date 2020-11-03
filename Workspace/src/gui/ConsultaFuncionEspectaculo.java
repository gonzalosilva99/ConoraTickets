package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;

import controladores.Fabrica;
import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPlataforma;
import interfaces.IPlataforma;
import interfaces.IUsuario;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaFuncionEspectaculo extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldEspectaculo;
	private JDateChooser dateChooser;
	private JDateChooser dateChooserAlta;
	private JComboBox comboBoxArtistas;
	private JComboBox comboBoxEspectaculos;
	private JComboBox comboBoxPlataforma;
	private JComboBox comboBoxFuncion ;
	private TextArea textArea1;
	private JPanel panel;
	private JLabel lblPlataforma;
	private JLabel lblEspectaculos;
	private JLabel lblFuncion ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionEspectaculo frame = new ConsultaFuncionEspectaculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setDatosFuncion(DtFuncionDatos datosFuncion) {
		lblPlataforma.setVisible(false);
		lblEspectaculos.setVisible(false);
		lblFuncion.setVisible(false);
		comboBoxPlataforma.setVisible(false);
		comboBoxFuncion.setVisible(false);
		comboBoxEspectaculos.setVisible(false);
		textFieldNombre.setText(datosFuncion.getNombre());
		textFieldEspectaculo.setText(datosFuncion.getEspectaculo().getNombre());
		dateChooserAlta.setDate(datosFuncion.getAlta());
		dateChooser.setDate(datosFuncion.getInicio());
		textArea1.setText(datosFuncion.getEspectaculo().getDescripcion());
		comboBoxArtistas.removeAllItems();
		Set<DtArtista> listaArtistas = datosFuncion.getArtistas();
		Iterator<DtArtista> itra = listaArtistas.iterator();
		while (itra.hasNext()){
			comboBoxArtistas.addItem(itra.next().getNombre());
		}
		
		
		
		panel.setVisible(true);
	}
	
	private void llenarParametrosFuncion(DtFuncionDatos dtfuncion) {
		
		
	}
	/**
	 * Create the frame.
	 */
	public ConsultaFuncionEspectaculo() {
		setTitle("Consulta de funcion de espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, 42, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblPlataforma);
		
		comboBoxPlataforma = new JComboBox();
		comboBoxPlataforma.setMaximumRowCount(4);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, 4, SpringLayout.NORTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 80, SpringLayout.EAST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -174, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPlataforma);
		
		lblEspectaculos = new JLabel("Espect\u00E1culo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 6, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculos, 38, SpringLayout.SOUTH, lblPlataforma);
		getContentPane().add(lblEspectaculos);
		
		comboBoxFuncion = new JComboBox();
		comboBoxFuncion.setMaximumRowCount(2);;
		springLayout.putConstraint(SpringLayout.WEST, comboBoxFuncion, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxFuncion, -169, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxFuncion);
		
		lblFuncion = new JLabel("Funcion:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFuncion, 6, SpringLayout.SOUTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, lblFuncion, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFuncion, 38, SpringLayout.SOUTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.EAST, lblFuncion, 0, SpringLayout.EAST, lblEspectaculos);
		getContentPane().add(lblFuncion);
		
		comboBoxEspectaculos = new JComboBox();
		comboBoxEspectaculos.setMaximumRowCount(2);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxFuncion, 15, SpringLayout.SOUTH, comboBoxEspectaculos);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectaculos, 3, SpringLayout.NORTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectaculos, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectaculos, -176, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxEspectaculos);
		
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxFuncion, -26, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 22, SpringLayout.SOUTH, lblFuncion);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -73, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		JLabel lblDatos = new JLabel("Datos de la funcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDatos, 10, SpringLayout.NORTH, panel);
		panel.add(lblDatos);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		sl_panel.putConstraint(SpringLayout.WEST, lblDatos, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 39, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, panel);
		panel.add(lblNombre);
		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFechaInicio, 71, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFechaInicio, 10, SpringLayout.WEST, panel);
		panel.add(lblFechaInicio);
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFechaAlta, 104, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFechaAlta, 10, SpringLayout.WEST, panel);
		panel.add(lblFechaAlta);
		
		JLabel lblArtistas = new JLabel("Artistas:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblArtistas, 19, SpringLayout.SOUTH, lblFechaAlta);
		sl_panel.putConstraint(SpringLayout.WEST, lblArtistas, 10, SpringLayout.WEST, panel);
		panel.add(lblArtistas);
		
		JLabel lblEspectaculo = new JLabel("Nombre de espect\u00E1culo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectaculo, 20, SpringLayout.SOUTH, lblArtistas);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectaculo, 10, SpringLayout.WEST, panel);
		panel.add(lblEspectaculo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n de espect\u00E1culo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescripcion, 18, SpringLayout.SOUTH, lblEspectaculo);
		sl_panel.putConstraint(SpringLayout.WEST, lblDescripcion, 10, SpringLayout.WEST, panel);
		panel.add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 31, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNombre, 147, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, -113, SpringLayout.EAST, panel);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		comboBoxArtistas = new JComboBox();
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldNombre, -82, SpringLayout.NORTH, comboBoxArtistas);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxArtistas, 149, SpringLayout.EAST, lblArtistas);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxArtistas, -114, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxArtistas, -3, SpringLayout.NORTH, lblArtistas);
		panel.add(comboBoxArtistas);
		comboBoxArtistas.setMaximumRowCount(2);
		
		textFieldEspectaculo = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectaculo, 13, SpringLayout.SOUTH, comboBoxArtistas);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectaculo, 38, SpringLayout.EAST, lblEspectaculo);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldEspectaculo, 35, SpringLayout.SOUTH, comboBoxArtistas);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectaculo, 200, SpringLayout.EAST, lblEspectaculo);
		textFieldEspectaculo.setEditable(false);
		panel.add(textFieldEspectaculo);
		textFieldEspectaculo.setColumns(10);
		
		dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 0, SpringLayout.NORTH, lblFechaInicio);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, 22, SpringLayout.NORTH, lblFechaInicio);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textFieldNombre);
		dateChooser.setEnabled(false);
		panel.add(dateChooser);
		
		dateChooserAlta = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooserAlta, 0, SpringLayout.NORTH, lblFechaAlta);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooserAlta, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooserAlta, 22, SpringLayout.NORTH, lblFechaAlta);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooserAlta, 0, SpringLayout.EAST, textFieldNombre);
		dateChooserAlta.setEnabled(false);
		
		panel.add(dateChooserAlta);
		
		/**JTextArea textArea = new JTextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, 12, SpringLayout.SOUTH, textFieldEspectaculo);
		sl_panel.putConstraint(SpringLayout.WEST, textArea, 12, SpringLayout.EAST, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, -21, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, -24, SpringLayout.EAST, panel);
		panel.add(textArea);**/
		
		textArea1 = new TextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, textArea1, 12, SpringLayout.SOUTH, textFieldEspectaculo);
		sl_panel.putConstraint(SpringLayout.WEST, textArea1, 12, SpringLayout.EAST, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea1, -21, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textArea1, -24, SpringLayout.EAST, panel);
		panel.add(textArea1);
		
		Button buttonCancelar = new Button("Atras");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -49, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -116, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);
		
			
		
		
		
		
		
		/** COMIENZA EL CODIGO **/
			Fabrica fabric = Fabrica.getInstancia();
			IPlataforma iplataforma = fabric.getIPlataforma();
			IUsuario iusuario = fabric.getIUsuario();
			
			//Cargar Plataformas
			Set<DtPlataforma> listaPlataformas = iplataforma.listarPlataformas();
			Iterator<DtPlataforma> itr = listaPlataformas.iterator();
			comboBoxPlataforma.addItem("");
			while (itr.hasNext()){
				comboBoxPlataforma.addItem(itr.next().getNombre()); }
			
			//Al seleccionar una plataforma
			comboBoxPlataforma.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if (comboBoxPlataforma.getSelectedIndex()!=0) {
						comboBoxEspectaculos.removeAllItems();
						Set<DtEspectaculo> listaEspectaculosPlataforma = iplataforma.listarEspectaculosDePlataforma(comboBoxPlataforma.getSelectedItem().toString());
						Iterator<DtEspectaculo> itr = listaEspectaculosPlataforma.iterator();
						comboBoxEspectaculos.addItem("");
						while (itr.hasNext()){
							comboBoxEspectaculos.addItem(itr.next().getNombre()); }
					}
				}
			});
			
			//Selecciono un Espectaculo
			comboBoxEspectaculos.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if (comboBoxEspectaculos.isFocusOwner() & comboBoxEspectaculos.getSelectedIndex()!=0) {
						comboBoxFuncion.removeAllItems();
						Set<DtFuncion> listaFuncionesEspectaculo = iplataforma.listarFuncionesDeEspectaculo(comboBoxPlataforma.getSelectedItem().toString(), comboBoxEspectaculos.getSelectedItem().toString());
						Iterator<DtFuncion> itr = listaFuncionesEspectaculo.iterator();
						comboBoxFuncion.addItem("");
						while (itr.hasNext()){
							comboBoxFuncion.addItem(itr.next().getNombre()); }
					}
				}
			});
		
			//Selecciono una Funcion
			comboBoxFuncion.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if (comboBoxFuncion.isFocusOwner() & comboBoxFuncion.getSelectedIndex()!=0) {
						panel.setVisible(true);
						DtFuncionDatos DatosDeFuncion = iplataforma.mostrarFuncion(comboBoxPlataforma.getSelectedItem().toString(), comboBoxEspectaculos.getSelectedItem().toString(), comboBoxFuncion.getSelectedItem().toString());
						textFieldNombre.setText(DatosDeFuncion.getNombre());
						dateChooser.setDate(DatosDeFuncion.getInicio());
						dateChooserAlta.setDate(DatosDeFuncion.getAlta());
						textFieldEspectaculo.setText(DatosDeFuncion.getEspectaculo().getNombre());
						textArea1.setText(DatosDeFuncion.getEspectaculo().getDescripcion());
						Iterator<DtArtista> iterArtista = DatosDeFuncion.getArtistas().iterator();
						comboBoxArtistas.removeAllItems();
						comboBoxArtistas.addItem("");
						while (iterArtista.hasNext()) {
							DtArtista DtArtistaAux = iterArtista.next();
							comboBoxArtistas.addItem(DtArtistaAux.getNombre() + " " + DtArtistaAux.getApellido());
						}
						
					}
				}
			});

		/** FIN CODIGO **/
		
	}
}
