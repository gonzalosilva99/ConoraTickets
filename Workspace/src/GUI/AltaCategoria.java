package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;

import Controladores.Fabrica;
import Excepciones.CheckDatos;
import Interfaces.ICategoria;
import Interfaces.IUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaCategoria extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCategoria frame = new AltaCategoria();
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
	public AltaCategoria() {
		Fabrica fabric = Fabrica.getInstancia();
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblNombreCategoria = new JLabel("Nombre Categoria: ");
		springLayout.putConstraint(SpringLayout.WEST, lblNombreCategoria, 20, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNombreCategoria);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 28, SpringLayout.EAST, lblNombreCategoria);
		springLayout.putConstraint(SpringLayout.EAST, textField, -109, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNombreCategoria, 5, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 45, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 20, SpringLayout.NORTH, getContentPane());
		textField.setColumns(10);
		getContentPane().add(textField);
		
		Button buttonAceptar = new Button("Aceptar");
		
		buttonAceptar.setActionCommand("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -41, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -96, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonAceptar_1 = new Button("Cancelar");
		buttonAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar_1, 0, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar_1, -86, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar_1, 0, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar_1, 0, SpringLayout.EAST, textField);
		buttonAceptar_1.setActionCommand("Aceptar");
		getContentPane().add(buttonAceptar_1);
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					if(textField.getText().length()==0) {
						throw new CheckDatos("El Nombre no debe ser vacío");
					}
					ICategoria icategoria = fabric.getICategoria();
					icategoria.AltaCategoria(textField.getText());
					textField.setText("");
					JOptionPane.showMessageDialog(null, "Alta de Categoria con exito");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				
					}
			}	
				
		});

	

}
	}
