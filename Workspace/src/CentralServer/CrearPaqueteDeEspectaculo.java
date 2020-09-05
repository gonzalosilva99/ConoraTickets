package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class CrearPaqueteDeEspectaculo extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPaqueteDeEspectaculo frame = new CrearPaqueteDeEspectaculo();
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
	public CrearPaqueteDeEspectaculo() {
		setTitle("Crear Paquete De Espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -14, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 21, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 135, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -161, SpringLayout.EAST, getContentPane());
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 255, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -161, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 230, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 135, SpringLayout.WEST, getContentPane());
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancelar, 0, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnCancelar, -6, SpringLayout.WEST, btnNewButton);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("Descuento:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 25, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 5, SpringLayout.NORTH, textField_1);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 66, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -20, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 350, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDescripcin, 25, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblDescripcin, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDescripcin, 0, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(lblDescripcin);
		
		JLabel lblInicioVigencia = new JLabel("Inicio vigencia:");
		springLayout.putConstraint(SpringLayout.NORTH, lblInicioVigencia, 84, SpringLayout.SOUTH, lblDescripcin);
		springLayout.putConstraint(SpringLayout.WEST, lblInicioVigencia, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblInicioVigencia, 0, SpringLayout.EAST, lblNewLabel);
		getContentPane().add(lblInicioVigencia);
		
		JLabel lblDescripcin_1_1 = new JLabel("Fin vigencia:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblInicioVigencia, -6, SpringLayout.NORTH, lblDescripcin_1_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDescripcin_1_1, 221, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDescripcin_1_1, 0, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblDescripcin_1_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblDescripcin_1_1, 196, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblDescripcin_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooser, 165, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -26, SpringLayout.NORTH, dateChooser);
		springLayout.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textField);
		getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooser_1, 196, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooser_1, -9, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooser, -6, SpringLayout.NORTH, dateChooser_1);
		springLayout.putConstraint(SpringLayout.WEST, dateChooser_1, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.EAST, dateChooser_1, 0, SpringLayout.EAST, textField);
		getContentPane().add(dateChooser_1);

	}
}
