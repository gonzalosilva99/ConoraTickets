package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
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

public class ConsultaEspectaculoReferenciado extends JDialog {
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
					ConsultaEspectaculoReferenciado frame = new ConsultaEspectaculoReferenciado();
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
	public ConsultaEspectaculoReferenciado() {
		setTitle("Espectaculo");
		setBounds(100, 100, 525, 596);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		

		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, getContentPane());
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
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -106, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 509, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
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
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldEspectMin, 4, SpringLayout.SOUTH, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectMin, -116, SpringLayout.EAST, panel);
		textFieldEspectMin.setColumns(10);
		panel.add(textFieldEspectMin);
		
		textFieldEspectMax = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectMax, 4, SpringLayout.NORTH, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectMax, 37, SpringLayout.EAST, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldEspectMax, 4, SpringLayout.SOUTH, lblEspectMax);
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
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, 212, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 7, SpringLayout.EAST, buttonCancelar);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 316, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -116, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);
		

    
	}
}    