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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Interfaces.IPaquete;
import Controladores.ControladorPaquete;
import Controladores.Fabrica;
import Interfaces.IPlataforma;
import Manejadores.ManejadorPaquetes;
import Controladores.ControladorPlataforma;
import DataTypes.DtPlataforma;
import DataTypes.DtEspectaculo;


import java.util.Iterator;
import java.util.Set;

import DataTypes.DtArtista;
import DataTypes.DtPaquete;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AgregarEspectaculoAPaquete extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEspectaculoAPaquete frame = new AgregarEspectaculoAPaquete();
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
	public AgregarEspectaculoAPaquete() {
		Fabrica fabricosa = Fabrica.getInstancia();
		setTitle("Agregar Espectaculo a Paquete");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 9, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -46, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -11, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPaquetes, 47, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPaquetes, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPaquetes, 82, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPaquetes, 110, SpringLayout.WEST, getContentPane());
		
		JComboBox comboBoxPaquetes = new JComboBox();
		
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPaquetes, 52, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPaquetes, 153, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPaquetes, -212, SpringLayout.EAST, getContentPane());
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 88, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, -395, SpringLayout.SOUTH, getContentPane());
		
		JComboBox comboBoxPlataformas = new JComboBox();
	

		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataformas,  99, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataformas,  153, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataformas,  -212, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, -43, SpringLayout.WEST, comboBoxPlataformas);
		
		JComboBox comboBoxEspectaculos = new JComboBox();
	
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectaculos,  153, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectaculos,  -212, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectaculos,  3, SpringLayout.SOUTH, comboBoxPlataformas);
		
		JLabel lblEspectaculo = new JLabel("Espectaculos:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEspectaculo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlataforma, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPaquetes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxPlataformas,  GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxEspectaculos, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(181, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPaquetes, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxPlataformas,  GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlataforma, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEspectaculo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxEspectaculos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		Button buttonAceptar = new Button("Aceptar");
	
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 419, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -8, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -32, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -92, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, 0, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);
		
		IPaquete paquetosa = fabricosa.getIPaquete();
		Set<DtPaquete> DtPaquetes = paquetosa.ListarPaquetes();
		Iterator<DtPaquete> iterador = DtPaquetes.iterator();
		comboBoxPaquetes.addItem("");
		comboBoxPlataformas.addItem("");
		comboBoxEspectaculos.addItem("");
	
		
		
		while(iterador.hasNext()) {
			comboBoxPaquetes.addItem(iterador.next().getNombre());
		}
		
		
		
		comboBoxPaquetes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				
	IPlataforma plataformosa = fabricosa.getIPlataforma();
				
				Set<DtPlataforma> DtPlataformas = plataformosa.listarPlataformas();
				Iterator<DtPlataforma> iterador2 = DtPlataformas.iterator();
				comboBoxPlataformas.removeAllItems();
				comboBoxPlataformas.addItem("");
				while(iterador2.hasNext()) {
					comboBoxPlataformas.addItem(iterador2.next().getNombre()); }
			}
		});
		

		
		
		comboBoxPlataformas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBoxPlataformas.isFocusOwner()) {
				String a = comboBoxPaquetes.getSelectedItem().toString();
				if (a != "") {
					comboBoxEspectaculos.removeAllItems();
					comboBoxEspectaculos.addItem("");
					
					IPlataforma plataformosa = fabricosa.getIPlataforma();
				String b = comboBoxPlataformas.getSelectedItem().toString();
				
				Set<DtEspectaculo> EspectaculosNoPaquete = plataformosa.listarEspectaculosEnPlataformaNoPaquete(a ,b);
				
				Iterator<DtEspectaculo> iterador3 = EspectaculosNoPaquete.iterator();
					
					while(iterador3.hasNext()) {
						comboBoxEspectaculos.addItem(iterador3.next().getNombre());
					}
						
				}
				}
			}
		});
	
		
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = comboBoxPaquetes.getSelectedItem().toString();
				String b = comboBoxPlataformas.getSelectedItem().toString();
				String c = comboBoxEspectaculos.getSelectedItem().toString();
			if ((a!="") && (b!="") && (c!="")) {
				IPaquete pac = fabricosa.getIPaquete();
				pac.ConfirmarAgregarEspectaculoPaquete(a, b, c);
				JOptionPane.showMessageDialog(null, "Espectaculo agregado a paquete con exito");
				comboBoxEspectaculos.removeAllItems();
				comboBoxPlataformas.removeAllItems();
				comboBoxPaquetes.removeAllItems();
				comboBoxPaquetes.addItem("");
				Set<DtPaquete> DtPaquetes = paquetosa.ListarPaquetes();
				Iterator<DtPaquete> iterador = DtPaquetes.iterator();
				while(iterador.hasNext()) {
					comboBoxPaquetes.addItem(iterador.next().getNombre());
					
				}
				
				

			}
			
				
			}
		});
		
		
	

		
		
		
		
		

	}
}
