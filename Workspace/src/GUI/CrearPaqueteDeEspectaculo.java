package GUI;

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
	private JTextField textFieldNombre;
	private JTextField textFieldDescuento;
	private JTextField textFieldDescripcion;

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
		
		JLabel lblNombre = new JLabel("Nombre:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 26, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblNombre, -14, SpringLayout.WEST, textFieldNombre);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNombre, 21, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldNombre, 135, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldNombre, -161, SpringLayout.EAST, getContentPane());
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDescuento = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldDescuento, 255, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldDescuento, -161, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textFieldDescuento, 230, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldDescuento, 135, SpringLayout.WEST, getContentPane());
		textFieldDescuento.setColumns(10);
		getContentPane().add(textFieldDescuento);
		
		JLabel lblNewLabel_2 = new JLabel("Descuento:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 25, SpringLayout.NORTH, textFieldDescuento);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNombre);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 5, SpringLayout.NORTH, textFieldDescuento);
		getContentPane().add(lblNewLabel_2);
		
		textFieldDescripcion = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldDescripcion, 66, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldNombre, -20, SpringLayout.NORTH, textFieldDescripcion);
		springLayout.putConstraint(SpringLayout.EAST, textFieldDescripcion, 350, SpringLayout.WEST, textFieldNombre);
		springLayout.putConstraint(SpringLayout.WEST, textFieldDescripcion, 0, SpringLayout.WEST, textFieldNombre);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDescripcion, 25, SpringLayout.SOUTH, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblDescripcion, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDescripcion, 0, SpringLayout.EAST, lblNombre);
		getContentPane().add(lblDescripcion);
		
		JLabel lblInicioVigencia = new JLabel("Inicio vigencia:");
		springLayout.putConstraint(SpringLayout.NORTH, lblInicioVigencia, 84, SpringLayout.SOUTH, lblDescripcion);
		springLayout.putConstraint(SpringLayout.WEST, lblInicioVigencia, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblInicioVigencia, 0, SpringLayout.EAST, lblNombre);
		getContentPane().add(lblInicioVigencia);
		
		JLabel lblFin = new JLabel("Fin vigencia:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblInicioVigencia, -6, SpringLayout.NORTH, lblFin);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFin, 221, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblFin, 0, SpringLayout.EAST, lblNombre);
		springLayout.putConstraint(SpringLayout.WEST, lblFin, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblFin, 196, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblFin);
		
		JDateChooser dateChooserInicio = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooserInicio, 165, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldDescripcion, -26, SpringLayout.NORTH, dateChooserInicio);
		springLayout.putConstraint(SpringLayout.WEST, dateChooserInicio, 0, SpringLayout.WEST, textFieldNombre);
		springLayout.putConstraint(SpringLayout.EAST, dateChooserInicio, 0, SpringLayout.EAST, textFieldNombre);
		getContentPane().add(dateChooserInicio);
		
		JDateChooser dateChooserFin = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooserFin, 196, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooserFin, -9, SpringLayout.NORTH, textFieldDescuento);
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooserInicio, -6, SpringLayout.NORTH, dateChooserFin);
		springLayout.putConstraint(SpringLayout.WEST, dateChooserFin, 0, SpringLayout.WEST, textFieldNombre);
		springLayout.putConstraint(SpringLayout.EAST, dateChooserFin, 0, SpringLayout.EAST, textFieldNombre);
		getContentPane().add(dateChooserFin);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -104, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 311, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);

	}
}