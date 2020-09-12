package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import DataTypes.DtEspectaculo;
import DataTypes.DtPaquete;
import Interfaces.IPaquete;
import Controladores.Fabrica;

import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;

public class ConsultaDePaqueteDeEspectaculos extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescuento;

	/**
	 * Launch the application.
	 */
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
		
		
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPaquetes, 15, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPaquetes, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPaquetes);
		
		JComboBox comboBoxPaquetes = new JComboBox();
		IPaquete ipaquete = fabric.getIPaquete();
		Set<DtPaquete> listaPaquetes = ipaquete.ListarPaquetes();		
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxPaquetes.addItem("");
		Iterator<DtPaquete> itr = listaPaquetes.iterator();
		while(itr.hasNext())
			{DtPaquete aux = itr.next();
			 String nom = aux.getNombre();
			 String des = aux.getDescripcion();
			 String op = nom+"|"+des;
			 comboBoxUsuario.addItem(op);
			}
		
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPaquetes, 41, SpringLayout.EAST, lblPaquetes);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxPaquetes, 34, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPaquetes, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPaquetes, -191, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPaquetes);
		
		JPanel panel = new JPanel();
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
		
		JTextPane textPaneDescripcion = new JTextPane();
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		
		
		
		JComboBox comboBoxEspectaculos = new JComboBox();
		comboBoxEspectaculos.addItem("Espectaculo1");
		comboBoxEspectaculos.addItem("Espectaculo2");
		
		JLabel lblInicioVigencia = new JLabel("Inicio vigencia:");
		
		JLabel lblFin = new JLabel("Fin vigencia:");
		
		JLabel lblNewLabel_2 = new JLabel("Descuento:");
		
		JDateChooser dateChooserInicio = new JDateChooser();
		
		JDateChooser dateChooserFin = new JDateChooser();
		
		textFieldDescuento = new JTextField();
		textFieldDescuento.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNombre)
							.addGap(62)
							.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPaneDescripcion, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
						.addComponent(lblDescripcion)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblInicioVigencia, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFin, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(dateChooserFin, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEspectaculos))
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxEspectaculos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldDescuento, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDescripcion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneDescripcion, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInicioVigencia, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooserInicio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooserFin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldDescuento, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEspectaculos)
						.addComponent(comboBoxEspectaculos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		textFieldNombre.setEditable(false);
		textPaneDescripcion.setEditable(false);
		dateChooserFin.getCalendarButton().setEnabled(false);
		dateChooserInicio.getCalendarButton().setEnabled(false);
		textFieldDescuento.setEditable(false);
		comboBoxEspectaculos.setEditable(false);
		Button buttonCancelar = new Button("Atras");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -49, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -108, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);
		
		comboBoxPaquetes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxEspectaculos.removeAllItems();
				if(comboBoxPaquetes.getSelectedItem().toString().equals("")) {
					panel.setVisible(false);
					comboBoxEspectaculos.addItem("");
				}
				else {
					panel.setVisible(true);
					String paquete = comboBoxPaquetes.getSelectedItem().toString();
					String[] nom = paquete.split("|");
					textFieldNombre.setText(ipaquete.MostrarPaquete(nom[0]).getNombre());
					textPaneDescripcion.setText(ipaquete.MostrarPaquete(nom[0]).getDescripcion());
					dateChooserFin.setDate(ipaquete.MostrarPaquete(nom[0]).getInicio());
					dateChooserInicio.setDate(ipaquete.MostrarPaquete(nom[0]).getFin());
					textFieldDescuento.setText(ipaquete.MostrarPaquete(nom[0]).getDescuento().toString());
					Iterator<DtEspectaculo> itr = ipaquete.MostrarPaquete(nom[0]).getEspectaculos().iterator();
					while(itr.hasNext()) {
						DtEspectaculo aux = itr.next();
						 String nomE = aux.getNombre();
						 String des = aux.getDescripcion();
						 String op = nomE+" | "+des;
						 comboBoxEspectaculos.addItem(op);
					}
				}

			}
		});

	}
}
