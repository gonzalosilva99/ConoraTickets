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
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 58, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, 110, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 4, SpringLayout.NORTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 26, SpringLayout.NORTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -219, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculo, 102, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 0, SpringLayout.WEST, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, -14, SpringLayout.NORTH, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculo, -399, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblEspectaculo);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 6, SpringLayout.NORTH, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, 28, SpringLayout.NORTH, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 0, SpringLayout.EAST, comboBox);
		getContentPane().add(comboBox_1);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -4, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculo, -30, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 167, SpringLayout.NORTH, getContentPane());
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
		
		JLabel lblNewLabel = new JLabel("Artistas Invitados:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 48, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 148, SpringLayout.EAST, comboBox);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, textField, 39, SpringLayout.EAST, comboBox);
		textField.setColumns(10);
		
		JLabel lblDatosFuncion = new JLabel("Datos de la Funcion");
		lblDatosFuncion.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		JButton btnAceptar = new JButton("Aceptar");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -30, SpringLayout.NORTH, btnAceptar);
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 16, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, lblHoraInicio, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 79, SpringLayout.EAST, lblFechaInicio);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 3, SpringLayout.NORTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 79, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.NORTH, lblFechaInicio, 87, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNombre, -208, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 46, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 18, SpringLayout.SOUTH, lblHoraInicio);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblHoraInicio);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -84, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblHoraInicio, -137, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFechaInicio, 0, SpringLayout.WEST, lblHoraInicio);
		sl_panel.putConstraint(SpringLayout.EAST, lblFechaInicio, 60, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDatosFuncion, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblDatosFuncion, 170, SpringLayout.WEST, panel);
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
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, -17, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblHoraInicio, -63, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblHoraInicio);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		panel.add(textField_1);
		textField_1.setColumns(10);
		springLayout.putConstraint(SpringLayout.EAST, btnAceptar, -4, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAceptar, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancelar, 0, SpringLayout.SOUTH, btnAceptar);
		springLayout.putConstraint(SpringLayout.EAST, btnCancelar, -6, SpringLayout.WEST, btnAceptar);
		getContentPane().add(btnCancelar);
		
	
		
		

	}
}
