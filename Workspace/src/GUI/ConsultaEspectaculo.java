package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;

import Clases.Espectaculo;
import Controladores.Fabrica;
import DataTypes.DtPlataforma;
import DataTypes.DtFuncion;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import Interfaces.IPlataforma;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaEspectaculo extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldEspectMin;
	private JTextField textFieldEspectMax;
	private JTextField textFieldURL;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaAlta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEspectaculo frame = new ConsultaEspectaculo();
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
	public ConsultaEspectaculo() {
		setTitle("Consulta de Espectaculo");
		setBounds(100, 100, 525, 596);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, 44, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBoxPlataforma = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, 17, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 158, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -189, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, -4, SpringLayout.NORTH, comboBoxPlataforma);
		comboBoxPlataforma.addItem("");
		getContentPane().add(comboBoxPlataforma);
		Fabrica fabric = Fabrica.getInstancia();
		IPlataforma iplataforma = fabric.getIPlataforma();
		Set<DtPlataforma> listaPlataformas = iplataforma.listarPlataformas();
		Iterator<DtPlataforma> itrp = listaPlataformas.iterator();
		while(itrp.hasNext())
		{
			comboBoxPlataforma.addItem(itrp.next().getNombre());
			}
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 6, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculos, -384, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 0, SpringLayout.WEST, lblEspectaculos);
		getContentPane().add(lblEspectaculos);
		lblEspectaculos.setVisible(false);
		

		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 100, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculos, -19, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNombre, 37, SpringLayout.NORTH, panel);
		panel.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescripcion, 6, SpringLayout.SOUTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblDescripcion, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDescripcion, 70, SpringLayout.NORTH, panel);
		panel.add(lblDescripcion);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDuracion, 39, SpringLayout.SOUTH, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.EAST, lblDescripcion, 0, SpringLayout.EAST, lblDuracion);
		sl_panel.putConstraint(SpringLayout.WEST, lblDuracion, 0, SpringLayout.WEST, lblNombre);
		panel.add(lblDuracion);
		
		JLabel lblEspectMin = new JLabel("Espect. minimos:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectMin, 142, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDuracion, -6, SpringLayout.NORTH, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEspectMin, -239, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblDuracion, 0, SpringLayout.EAST, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectMin, 0, SpringLayout.WEST, lblNombre);
		panel.add(lblEspectMin);
		
		JLabel lblEspectMax = new JLabel("Espect. maximos:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectMax, 175, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectMax, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEspectMax, 33, SpringLayout.SOUTH, lblEspectMin);
		panel.add(lblEspectMax);
		
		JLabel lblURL = new JLabel("URL:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblURL, 6, SpringLayout.SOUTH, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.WEST, lblURL, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblURL, 33, SpringLayout.SOUTH, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.EAST, lblURL, 0, SpringLayout.EAST, lblEspectMin);
		panel.add(lblURL);
		
		JLabel lblCosto = new JLabel("Costo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCosto, 6, SpringLayout.SOUTH, lblURL);
		sl_panel.putConstraint(SpringLayout.WEST, lblCosto, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCosto, -140, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblCosto, 0, SpringLayout.EAST, lblEspectMin);
		panel.add(lblCosto);
		
		JLabel lblFecha = new JLabel("Fecha de alta:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFecha, 6, SpringLayout.SOUTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.WEST, lblFecha, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblFecha, 33, SpringLayout.SOUTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.EAST, lblFecha, 0, SpringLayout.EAST, lblDescripcion);
		panel.add(lblFecha);
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblPaquetes, 6, SpringLayout.SOUTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.WEST, lblPaquetes, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblPaquetes, 33, SpringLayout.SOUTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.EAST, lblPaquetes, 0, SpringLayout.EAST, lblDescripcion);
		panel.add(lblPaquetes);
		
		JLabel lblFunciones = new JLabel("Funciones:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFunciones, 6, SpringLayout.SOUTH, lblPaquetes);
		sl_panel.putConstraint(SpringLayout.WEST, lblFunciones, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblFunciones, 33, SpringLayout.SOUTH, lblPaquetes);
		sl_panel.putConstraint(SpringLayout.EAST, lblFunciones, 119, SpringLayout.WEST, lblNombre);
		panel.add(lblFunciones);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -109, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -46, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -6, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		
		textFieldNombre = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 4, SpringLayout.NORTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNombre, 98, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldNombre, 0, SpringLayout.SOUTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, -117, SpringLayout.EAST, panel);
		textFieldNombre.setColumns(10);
		panel.add(textFieldNombre);
		
		textFieldDescripcion = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDescripcion, 39, SpringLayout.EAST, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDescripcion, 0, SpringLayout.EAST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDescripcion, 4, SpringLayout.NORTH, lblDescripcion);
		textFieldDescripcion.setColumns(10);
		panel.add(textFieldDescripcion);
		
		textFieldDuracion = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDuracion, 40, SpringLayout.EAST, lblDuracion);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDuracion, -117, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDescripcion, -6, SpringLayout.NORTH, textFieldDuracion);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDuracion, 4, SpringLayout.NORTH, lblDuracion);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDuracion, 0, SpringLayout.SOUTH, lblDuracion);
		textFieldDuracion.setColumns(10);
		panel.add(textFieldDuracion);
		
		textFieldEspectMin = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectMin, 4, SpringLayout.NORTH, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectMin, 40, SpringLayout.EAST, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldEspectMin, 0, SpringLayout.SOUTH, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectMin, -116, SpringLayout.EAST, panel);
		textFieldEspectMin.setColumns(10);
		panel.add(textFieldEspectMin);
		
		textFieldEspectMax = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectMax, 4, SpringLayout.NORTH, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectMax, 37, SpringLayout.EAST, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldEspectMax, 0, SpringLayout.SOUTH, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectMax, -117, SpringLayout.EAST, panel);
		textFieldEspectMax.setColumns(10);
		panel.add(textFieldEspectMax);
		
		textFieldURL = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldURL, 4, SpringLayout.NORTH, lblURL);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldURL, 40, SpringLayout.EAST, lblURL);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldURL, 0, SpringLayout.SOUTH, lblURL);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldURL, -117, SpringLayout.EAST, panel);
		textFieldURL.setColumns(10);
		panel.add(textFieldURL);
		
		textFieldCosto = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldCosto, 4, SpringLayout.NORTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldCosto, 40, SpringLayout.EAST, lblCosto);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldCosto, 0, SpringLayout.SOUTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldCosto, -117, SpringLayout.EAST, panel);
		textFieldCosto.setColumns(10);
		panel.add(textFieldCosto);
		
		textFieldFechaAlta = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldFechaAlta, 4, SpringLayout.NORTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldFechaAlta, 40, SpringLayout.EAST, lblFecha);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldFechaAlta, 0, SpringLayout.SOUTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldFechaAlta, -117, SpringLayout.EAST, panel);
		textFieldFechaAlta.setColumns(10);
		panel.add(textFieldFechaAlta);
		
		JComboBox comboBoxPaquetes = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxPaquetes, 10, SpringLayout.SOUTH, textFieldFechaAlta);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxPaquetes, 40, SpringLayout.EAST, lblPaquetes);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBoxPaquetes, 0, SpringLayout.SOUTH, lblPaquetes);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxPaquetes, -117, SpringLayout.EAST, panel);
		panel.add(comboBoxPaquetes);
		
		JComboBox comboBoxFunciones = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxFunciones, 2, SpringLayout.NORTH, lblFunciones);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxFunciones, 40, SpringLayout.EAST, lblFunciones);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBoxFunciones, 0, SpringLayout.SOUTH, lblFunciones);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxFunciones, -117, SpringLayout.EAST, panel);
		panel.add(comboBoxFunciones);
		getContentPane().add(buttonAceptar);
		
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -46, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -99, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -6, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);
		
		JComboBox comboBoxEspectaculos = new JComboBox();
		comboBoxEspectaculos.addItem("");
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectaculos, 158, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectaculos, 11, SpringLayout.SOUTH, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxEspectaculos, -24, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectaculos, 0, SpringLayout.EAST, comboBoxPlataforma);
		getContentPane().add(comboBoxEspectaculos);
		comboBoxEspectaculos.setVisible(false);
		
		comboBoxPlataforma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxEspectaculos.removeAllItems();
				comboBoxEspectaculos.setVisible(true);	
				lblEspectaculos.setVisible(true);	
				Set<DtEspectaculoDatos> listaEspectaculoDatos = iplataforma.listarEspectaculoDatosDePlataforma(comboBoxPlataforma.getSelectedItem().toString());	
				Iterator<DtEspectaculoDatos> itre = listaEspectaculoDatos .iterator();
				DtEspectaculoDatos datosEspectaculo;
				while(itre.hasNext())
				{
					datosEspectaculo = itre.next();
					comboBoxEspectaculos.addItem(datosEspectaculo.getNombre());
					textFieldNombre.setText(datosEspectaculo.getNombre());
					textFieldDescripcion.setText(datosEspectaculo.getDescripcion());
					textFieldDuracion.setText(datosEspectaculo.getDuracion().toString());
					textFieldCosto.setText(datosEspectaculo.getCosto().toString());  
					textFieldURL.setText(datosEspectaculo.getURL().toString());
					textFieldFechaAlta.setText(datosEspectaculo.getRegistro().toString());
					textFieldEspectMin.setText(datosEspectaculo.getCantMin().toString());
					textFieldEspectMax.setText(datosEspectaculo.getCantMax().toString());
					textFieldNombre.setEditable(false);
					textFieldDescripcion.setEditable(false);
					textFieldDuracion.setEditable(false);
					textFieldCosto.setEditable(false);
					textFieldURL.setEditable(false);
					textFieldFechaAlta.setEditable(false);
					textFieldEspectMin.setEditable(false);
					textFieldEspectMax.setEditable(false);
					
					comboBoxFunciones.removeAllItems();
					comboBoxFunciones.setVisible(true);	
					lblFunciones.setVisible(true);	
					Set<DtFuncion> listaFunciones = datosEspectaculo.getFunciones();
					Iterator<DtFuncion> iterf = listaFunciones.iterator();
					while(iterf.hasNext()) {
						comboBoxFunciones.removeAllItems();
						comboBoxFunciones.addItem(iterf.next().getNombre()); }
					}
				
				
			}
		} );  
		
		comboBoxEspectaculos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});
		

    
	}
}    