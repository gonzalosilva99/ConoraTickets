package CentralServer;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AltaFuncionEspectaculo extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaFuncionEspectaculo frame = new AltaFuncionEspectaculo();
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
	public AltaFuncionEspectaculo() {
		setTitle("Alta Funcion Espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, 40, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, 110, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 16, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 46, SpringLayout.EAST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 196, SpringLayout.EAST, lblPlataforma);
		getContentPane().add(comboBox);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculo, 6, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculo, 41, SpringLayout.SOUTH, lblPlataforma);
		getContentPane().add(lblEspectaculo);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 6, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculo, -46, SpringLayout.WEST, comboBox_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 306, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 156, SpringLayout.WEST, getContentPane());
		getContentPane().add(comboBox_1);
		
		JLabel lblDatosDeLa = new JLabel("Datos de la funcion");
		springLayout.putConstraint(SpringLayout.NORTH, lblDatosDeLa, 6, SpringLayout.SOUTH, comboBox_1);
		springLayout.putConstraint(SpringLayout.WEST, lblDatosDeLa, 46, SpringLayout.EAST, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDatosDeLa, 41, SpringLayout.SOUTH, comboBox_1);
		getContentPane().add(lblDatosDeLa);
		
		JLabel lblNombre = new JLabel("Nombre");
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 119, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNombre, 154, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblNombre);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblNombre, -45, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 154, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 127, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 306, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 155, SpringLayout.WEST, getContentPane());
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		springLayout.putConstraint(SpringLayout.NORTH, lblFecha, 5, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblFecha, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblFecha, 40, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.EAST, lblFecha, -405, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblFecha);
		
		JLabel lblNewLabel = new JLabel("Hora de inicio");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, lblFecha);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 41, SpringLayout.SOUTH, lblFecha);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblPlataforma);
		getContentPane().add(lblNewLabel);
		
		JLabel lblArtistasInvitados = new JLabel("Artistas invitados");
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistasInvitados, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistasInvitados, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblArtistasInvitados, 41, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblArtistasInvitados, 25, SpringLayout.EAST, lblPlataforma);
		getContentPane().add(lblArtistasInvitados);
		
		JComboBox comboBox_2 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2, 5, SpringLayout.NORTH, lblArtistasInvitados);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2, 150, SpringLayout.WEST, comboBox);
		getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("Confirmar");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 162, SpringLayout.SOUTH, lblArtistasInvitados);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 92, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 187, SpringLayout.SOUTH, lblArtistasInvitados);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 168, SpringLayout.SOUTH, comboBox_2);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 56, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 193, SpringLayout.SOUTH, comboBox_2);
		getContentPane().add(btnNewButton_1);
		
	
		
		

	}
}
