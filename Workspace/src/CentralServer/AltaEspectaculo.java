package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class AltaEspectaculo extends JInternalFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaEspectaculo frame = new AltaEspectaculo();
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
	public AltaEspectaculo() {
		setTitle("Alta de Espectaculo");
		setBounds(100, 100, 525, 550);
		
		JLabel lblNewLabel = new JLabel("Plataforma:");
		
		JLabel lblArtista = new JLabel("Artista:");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre espect:");
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		
		JTextPane textPaneDescGeneral = new JTextPane();
		
		JLabel lblNewLabel_2_1 = new JLabel("Duracion:");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Espect. minimos:");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1, -383, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -370, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -383, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 6, SpringLayout.SOUTH, lblNewLabel_2_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1, -235, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 6, SpringLayout.SOUTH, textPaneDescGeneral);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 0, SpringLayout.WEST, textPaneDescGeneral);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, 36, SpringLayout.SOUTH, textPaneDescGeneral);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -418, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textPaneDescGeneral, 6, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, textPaneDescGeneral, -307, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textPaneDescGeneral, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textPaneDescGeneral, 475, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -406, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblArtista);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblArtista, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblArtista, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblArtista, 76, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 40, SpringLayout.NORTH, getContentPane());
		getContentPane().setLayout(springLayout);
		getContentPane().add(lblNewLabel_2_1);
		getContentPane().add(lblNewLabel_2_1_1);
		getContentPane().add(textPaneDescGeneral);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblArtista);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Espect. maximos:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1, 6, SpringLayout.SOUTH, lblNewLabel_2_1_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1, 0, SpringLayout.WEST, lblNewLabel_2_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1, -199, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("URL:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1_1, 325, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_2_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1_1, 36, SpringLayout.SOUTH, lblNewLabel_2_1_1_1);
		getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Costo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1_2, 6, SpringLayout.SOUTH, lblNewLabel_2_1_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1_2, 0, SpringLayout.WEST, lblNewLabel_2_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1_2, 36, SpringLayout.SOUTH, lblNewLabel_2_1_1_1_1);
		getContentPane().add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_3 = new JLabel("Fecha de alta:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1_3, 6, SpringLayout.SOUTH, lblNewLabel_2_1_1_1_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1_3, 0, SpringLayout.WEST, lblNewLabel_2_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1_1_1_3, 36, SpringLayout.SOUTH, lblNewLabel_2_1_1_1_2);
		getContentPane().add(lblNewLabel_2_1_1_1_3);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -60, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -197, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -23, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -110, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 0, SpringLayout.NORTH, buttonCancelar);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -93, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, 0, SpringLayout.SOUTH, buttonCancelar);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 65, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 25, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -196, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -196, SpringLayout.EAST, getContentPane());
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, -196, SpringLayout.EAST, getContentPane());
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.NORTH, lblNewLabel_2_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, -196, SpringLayout.EAST, getContentPane());
		textField_3.setColumns(10);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 6, SpringLayout.NORTH, lblNewLabel_2_1_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_4, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, -196, SpringLayout.EAST, getContentPane());
		textField_4.setColumns(10);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_5, 6, SpringLayout.NORTH, lblNewLabel_2_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_5, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, textField_5, -196, SpringLayout.EAST, getContentPane());
		textField_5.setColumns(10);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_6, 6, SpringLayout.NORTH, lblNewLabel_2_1_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_6, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, textField_6, -196, SpringLayout.EAST, getContentPane());
		textField_6.setColumns(10);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_7, 6, SpringLayout.NORTH, lblNewLabel_2_1_1_1_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_7, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, textField_7, -196, SpringLayout.EAST, getContentPane());
		textField_7.setColumns(10);
		getContentPane().add(textField_7);
		
		JSpinner spinnerAnio = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, spinnerAnio, 6, SpringLayout.NORTH, lblNewLabel_2_1_1_1_3);
		springLayout.putConstraint(SpringLayout.WEST, spinnerAnio, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, spinnerAnio, -196, SpringLayout.EAST, getContentPane());
		getContentPane().add(spinnerAnio);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, 25, SpringLayout.NORTH, lblArtista);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 95, SpringLayout.EAST, lblArtista);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -196, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 6, SpringLayout.NORTH, lblArtista);
		getContentPane().add(comboBox_1);

	}
}
