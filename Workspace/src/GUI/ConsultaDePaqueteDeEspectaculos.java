package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataTypes.DtCategoria;
import DataTypes.DtEspectaculo;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;
import Interfaces.IPaquete;
import Controladores.Fabrica;

import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaDePaqueteDeEspectaculos extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescuento;
	private DtPaquete datosPaquete;
	private JComboBox comboBoxPaquetes;
	private JComboBox comboBoxEspectaculos;
	private JComboBox comboBoxCategorias;
	private JPanel panel;
	private JTextPane textPaneDescripcion ;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFin;
	private Button buttonCancelar;
	private JLabel lblPaquetes;
	private JLabel lblCategorias;
	/**
	 * Launch the application.
	 */
	
	public void setDatosPaquete(DtPaquete dtpaquete) {
		datosPaquete = dtpaquete;
		comboBoxPaquetes.setVisible(false);
		panel.setVisible(true); 
		
		
		Fabrica fabric = Fabrica.getInstancia();
		IPaquete ipaquete = fabric.getIPaquete();
		DtPaqueteDatos paqueteDatos = ipaquete.getPaqueteDatos(dtpaquete.getNombre());
		textFieldNombre.setText(paqueteDatos.getNombre()); 
		textFieldDescuento.setText(paqueteDatos.getDescuento().toString());
		textPaneDescripcion.setText(paqueteDatos.getDescripcion());
		dateChooserInicio.setDate(paqueteDatos.getInicio());
		dateChooserFin.setDate(paqueteDatos.getFin()); 
		buttonCancelar.setVisible(false);
		lblPaquetes.setVisible(false);
		Set<DtEspectaculo> listaEspectaculos = paqueteDatos.getEspectaculos();
		Iterator<DtEspectaculo> itr = listaEspectaculos.iterator();
		while(itr.hasNext()) {
			DtEspectaculo aux = itr.next(); 
			 comboBoxEspectaculos.addItem(aux.getNombre());
		}
		
		Set<DtCategoria> listaCategorias = paqueteDatos.getCategorias();
		Iterator<DtCategoria> itrc = listaCategorias.iterator();
		
		while(itrc.hasNext()) {
			 DtCategoria aux = itrc.next();
			 comboBoxCategorias.addItem(aux.getNomCategoria());
		}
		
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDePaqueteDeEspectaculos frame = new ConsultaDePaqueteDeEspectaculos();
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
	
	public ConsultaDePaqueteDeEspectaculos() {
		Fabrica fabric = Fabrica.getInstancia();
		setTitle("Consulta de Paquete de Espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		
		
		lblPaquetes = new JLabel("Paquetes:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPaquetes, 15, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPaquetes, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPaquetes);
		
		comboBoxPaquetes = new JComboBox();
		IPaquete ipaquete = fabric.getIPaquete();
		Set<DtPaquete> listaPaquetes = ipaquete.ListarPaquetes();		
		comboBoxPaquetes.addItem("");
		Iterator<DtPaquete> itr = listaPaquetes.iterator();
		while(itr.hasNext())
			{ datosPaquete = itr.next();
			 String nom = datosPaquete.getNombre();
			 String des = datosPaquete.getDescripcion();
			 String op = nom+"-"+des;
			 comboBoxPaquetes.addItem(op);
			}
		
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPaquetes, 41, SpringLayout.EAST, lblPaquetes);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxPaquetes, 34, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPaquetes, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPaquetes, -191, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPaquetes);
		
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, lblPaquetes, -10, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -74, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, comboBoxPaquetes);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblPaquetes);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		panel.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textPaneDescripcion = new JTextPane();
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		
		
		
		comboBoxEspectaculos = new JComboBox();
		
		JLabel lblInicioVigencia = new JLabel("Inicio vigencia:");
		
		JLabel lblFin = new JLabel("Fin vigencia:");
		
		JLabel lblNewLabel_2 = new JLabel("Descuento:");
		
		dateChooserInicio = new JDateChooser();
		
		dateChooserFin = new JDateChooser();
		
		textFieldDescuento = new JTextField();
		textFieldDescuento.setColumns(10);
		
		lblCategorias = new JLabel("Categorias:");
		
		comboBoxCategorias = new JComboBox();
		comboBoxCategorias.setEditable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNombre)
							.addGap(51)
							.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPaneDescripcion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblEspectaculos)
											.addComponent(lblCategorias, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
										.addGap(14))
									.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addGap(1))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblFin, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addGap(1)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblInicioVigencia, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addGap(1)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooserFin, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldDescuento, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBoxCategorias, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBoxEspectaculos, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)))
							.addGap(138))
						.addComponent(lblDescripcion))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(lblDescripcion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneDescripcion, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInicioVigencia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooserFin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDescuento, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEspectaculos)
						.addComponent(comboBoxEspectaculos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxCategorias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategorias))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		textFieldNombre.setEditable(false);
		textPaneDescripcion.setEditable(false);
		dateChooserFin.getCalendarButton().setEnabled(false);
		dateChooserInicio.getCalendarButton().setEnabled(false);
		dateChooserFin.getDateEditor().setEnabled(false);
		dateChooserInicio.getDateEditor().setEnabled(false);
		textFieldDescuento.setEditable(false);
		comboBoxEspectaculos.setEditable(false);
		buttonCancelar = new Button("Atras");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -49, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -108, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);
		
		comboBoxPaquetes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxEspectaculos.removeAllItems();
				comboBoxCategorias.removeAllItems();
				if(comboBoxPaquetes.getSelectedItem().toString().equals("")) {
					panel.setVisible(false);
					comboBoxEspectaculos.addItem("");
				}
				else {
					panel.setVisible(true);
					String paquete = comboBoxPaquetes.getSelectedItem().toString();
					String[] nom = paquete.split("-");
					textFieldNombre.setText(ipaquete.MostrarPaquete(nom[0]).getNombre());
					textPaneDescripcion.setText(ipaquete.MostrarPaquete(nom[0]).getDescripcion());
					dateChooserFin.setDate(ipaquete.MostrarPaquete(nom[0]).getInicio());
					dateChooserInicio.setDate(ipaquete.MostrarPaquete(nom[0]).getFin());
					Double descuento = ipaquete.MostrarPaquete(nom[0]).getDescuento();
					textFieldDescuento.setText(ipaquete.MostrarPaquete(nom[0]).getDescuento().toString());
					Iterator<DtEspectaculo> itr = ipaquete.MostrarPaquete(nom[0]).getEspectaculos().iterator();
					while(itr.hasNext()) {
						DtEspectaculo aux = itr.next();
						 String nomE = aux.getNombre();
						 String des = aux.getDescripcion();
						 String op = nomE+" | "+des;
						 comboBoxEspectaculos.addItem(op);
					}
					
					Iterator<DtCategoria> itrc = ipaquete.ListarCategorias(nom[0]).iterator();
					
					while(itrc.hasNext()) {
						 DtCategoria aux = itrc.next();
						 comboBoxCategorias.addItem(aux.getNomCategoria());
					}
					
				}

			}
		});

	}
}
