package gui;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;

import controladores.Fabrica;
import datatypes.DtEspectaculo;
import interfaces.IPlataforma;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AceptarRechazarEspectaculo extends JInternalFrame {
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceptarRechazarEspectaculo frame = new AceptarRechazarEspectaculo();
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
	public AceptarRechazarEspectaculo() {
		
		
		
		setTitle("Aceptar o Rechazar Espectaculo");
		setBounds(100, 100, 525, 596);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblEspectaculos);
		
		comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 20, SpringLayout.EAST, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -228, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 5, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 39, SpringLayout.NORTH, getContentPane());
		getContentPane().add(comboBox);
		
		Fabrica fabric = Fabrica.getInstancia();
		IPlataforma iplataforma = fabric.getIPlataforma();
		
		Set<DtEspectaculo> listaPlataformas = iplataforma.listarEspectaculosIngresados();
		Iterator<DtEspectaculo> itrp = listaPlataformas.iterator();
		
		while (itrp.hasNext()){
			comboBox.addItem(itrp.next().getNombre());
			}
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iplataforma.aceptarEspectaculo(comboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Espectaculo aceptado con exito.");
				comboBox.removeAllItems();
				Set<DtEspectaculo> listaPlataformas = iplataforma.listarEspectaculosIngresados();
				Iterator<DtEspectaculo> itrp = listaPlataformas.iterator();
				while (itrp.hasNext()){
					comboBox.addItem(itrp.next().getNombre());
					}
			}
		});
		getContentPane().add(buttonAceptar);
		
		Button buttonRechazar = new Button("Rechazar");
		buttonRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iplataforma.rechazarEspectaculo(comboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Espectaculo rechazado con exito.");
				comboBox.removeAllItems();
				Set<DtEspectaculo> listaPlataformas = iplataforma.listarEspectaculosIngresados();
				Iterator<DtEspectaculo> itrp = listaPlataformas.iterator();
				while (itrp.hasNext()){
					comboBox.addItem(itrp.next().getNombre());
					}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 0, SpringLayout.WEST, buttonRechazar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -11, SpringLayout.NORTH, buttonRechazar);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, 0, SpringLayout.EAST, buttonRechazar);
		springLayout.putConstraint(SpringLayout.WEST, buttonRechazar, 320, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, buttonRechazar, 58, SpringLayout.NORTH, getContentPane());
		getContentPane().add(buttonRechazar);
		
		Button buttonAtras = new Button("Atras");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, buttonAtras, -41, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAtras, -94, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAtras, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAtras, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAtras);
	}
}
