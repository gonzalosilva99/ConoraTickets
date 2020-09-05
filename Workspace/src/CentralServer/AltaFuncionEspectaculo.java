package CentralServer;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTree;

public class AltaFuncionEspectaculo extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

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
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 27, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, 57, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 31, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 116, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -219, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, -6, SpringLayout.WEST, comboBox);
		getContentPane().add(comboBox);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculo, 6, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculo, 41, SpringLayout.SOUTH, lblPlataforma);
		getContentPane().add(lblEspectaculo);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculo, 0, SpringLayout.WEST, comboBox_1);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -16, SpringLayout.NORTH, comboBox_1);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, 91, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 69, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 116, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 0, SpringLayout.EAST, comboBox);
		getContentPane().add(comboBox_1);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -118, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -4, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 16, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 26, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNombre, 51, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNombre, 126, SpringLayout.EAST, comboBox);
		
		JLabel lblFechaInicio = new JLabel("Fecha:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFechaInicio, 25, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFechaInicio, 54, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFechaInicio, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblFechaInicio, 154, SpringLayout.EAST, comboBox);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		springLayout.putConstraint(SpringLayout.NORTH, lblHoraInicio, 25, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblHoraInicio, 41, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, lblHoraInicio, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblHoraInicio, 141, SpringLayout.EAST, comboBox);
		
		JLabel lblNewLabel = new JLabel("Invitados:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 48, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 148, SpringLayout.EAST, comboBox);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, textField, 39, SpringLayout.EAST, comboBox);
		textField.setColumns(10);
		
		JLabel lblDatosFuncion = new JLabel("Datos de la Funcion:");
		lblDatosFuncion.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("dd-MM-yyyy");
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 182, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblHoraInicio, 7, SpringLayout.SOUTH, lblFechaInicio);
		sl_panel.putConstraint(SpringLayout.WEST, lblHoraInicio, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblHoraInicio, -17, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNombre, 48, SpringLayout.SOUTH, lblDatosFuncion);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblFechaInicio, 6, SpringLayout.SOUTH, dateChooser);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 122, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFechaInicio, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblFechaInicio, -6, SpringLayout.WEST, dateChooser);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, -204, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblFechaInicio, 0, SpringLayout.NORTH, dateChooser);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 14, SpringLayout.SOUTH, lblDatosFuncion);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 122, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNombre, -6, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, 114, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, 45, SpringLayout.SOUTH, lblDatosFuncion);
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 86, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 17, SpringLayout.SOUTH, lblDatosFuncion);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -204, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblDatosFuncion, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDatosFuncion, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDatosFuncion, 28, SpringLayout.NORTH, panel);
		panel.setLayout(sl_panel);
		panel.add(lblHoraInicio);
		panel.add(lblNewLabel);
		panel.add(lblNombre);
		panel.add(lblFechaInicio);
		panel.add(textField);
		panel.add(lblDatosFuncion);
		panel.add(dateChooser);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 14, SpringLayout.SOUTH, dateChooser);
		sl_panel.putConstraint(SpringLayout.EAST, lblHoraInicio, -6, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 122, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -204, SpringLayout.EAST, panel);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -21, SpringLayout.NORTH, comboBox_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, comboBox_2);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_2, -5, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_2, 122, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_2, 0, SpringLayout.EAST, textField);
		panel.add(comboBox_2);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -86, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, 0, SpringLayout.EAST, panel);
		getContentPane().add(buttonAceptar);
		buttonAceptar.setSize(95, 36);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -92, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);
		
	
		
		

	}
}
