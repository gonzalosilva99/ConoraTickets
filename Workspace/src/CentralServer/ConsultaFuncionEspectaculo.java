package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;

public class ConsultaFuncionEspectaculo extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldEspectaculo;
	private JTextField textFieldDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionEspectaculo frame = new ConsultaFuncionEspectaculo();
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
	public ConsultaFuncionEspectaculo() {
		setTitle("Consulta de funcion de espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, 42, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBoxPlataforma = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, 4, SpringLayout.NORTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 80, SpringLayout.EAST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -174, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPlataforma);
		comboBoxPlataforma.addItem("");
		comboBoxPlataforma.addItem("Pan");
		comboBoxPlataforma.addItem("Manteca");
		
		JLabel lblEspectaculos = new JLabel("Espect\u00E1culo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculos, 6, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculos, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculos, 38, SpringLayout.SOUTH, lblPlataforma);
		getContentPane().add(lblEspectaculos);
		lblEspectaculos.setVisible(false);
		
		JComboBox comboBoxFuncion = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.WEST, comboBoxFuncion, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxFuncion, -169, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxFuncion);
		comboBoxFuncion.addItem("");
		comboBoxFuncion.addItem("Pan");
		comboBoxFuncion.addItem("Manteca");
		comboBoxFuncion.setVisible(false);
		
		JLabel lblFuncion = new JLabel("Funcion:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFuncion, 6, SpringLayout.SOUTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, lblFuncion, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFuncion, 38, SpringLayout.SOUTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.EAST, lblFuncion, 0, SpringLayout.EAST, lblEspectaculos);
		getContentPane().add(lblFuncion);
		lblFuncion.setVisible(false);
		
		JComboBox comboBoxEspectaculos = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxFuncion, 15, SpringLayout.SOUTH, comboBoxEspectaculos);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectaculos, 3, SpringLayout.NORTH, lblEspectaculos);
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectaculos, 0, SpringLayout.WEST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectaculos, -176, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxEspectaculos);
		comboBoxEspectaculos.addItem("");
		comboBoxEspectaculos.addItem("Pan");
		comboBoxEspectaculos.addItem("Manteca");
		comboBoxEspectaculos.setVisible(false);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxFuncion, -25, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.SOUTH, lblFuncion);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -110, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setVisible(false);
		
		JLabel lblDatos = new JLabel("Datos de la funcion:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDatos, 10, SpringLayout.NORTH, panel);
		panel.add(lblDatos);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		sl_panel.putConstraint(SpringLayout.WEST, lblDatos, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 39, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, panel);
		panel.add(lblNombre);
		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFechaInicio, 71, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFechaInicio, 10, SpringLayout.WEST, panel);
		panel.add(lblFechaInicio);
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFechaAlta, 104, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblFechaAlta, 10, SpringLayout.WEST, panel);
		panel.add(lblFechaAlta);
		
		JLabel lblArtistas = new JLabel("Artistas:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblArtistas, 19, SpringLayout.SOUTH, lblFechaAlta);
		sl_panel.putConstraint(SpringLayout.WEST, lblArtistas, 10, SpringLayout.WEST, panel);
		panel.add(lblArtistas);
		
		JLabel lblEspectaculo = new JLabel("Nombre de espect\u00E1culo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectaculo, 20, SpringLayout.SOUTH, lblArtistas);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectaculo, 10, SpringLayout.WEST, panel);
		panel.add(lblEspectaculo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n de espect\u00E1culo:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescripcion, 18, SpringLayout.SOUTH, lblEspectaculo);
		sl_panel.putConstraint(SpringLayout.WEST, lblDescripcion, 10, SpringLayout.WEST, panel);
		panel.add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 31, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNombre, 147, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, -113, SpringLayout.EAST, panel);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JComboBox comboBoxArtistas = new JComboBox();
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldNombre, -82, SpringLayout.NORTH, comboBoxArtistas);
		sl_panel.putConstraint(SpringLayout.WEST, comboBoxArtistas, 149, SpringLayout.EAST, lblArtistas);
		sl_panel.putConstraint(SpringLayout.EAST, comboBoxArtistas, -114, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBoxArtistas, -3, SpringLayout.NORTH, lblArtistas);
		panel.add(comboBoxArtistas);
		
		textFieldEspectaculo = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectaculo, 13, SpringLayout.SOUTH, comboBoxArtistas);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectaculo, 0, SpringLayout.EAST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectaculo, 38, SpringLayout.EAST, lblEspectaculo);
		panel.add(textFieldEspectaculo);
		textFieldEspectaculo.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldEspectaculo, -11, SpringLayout.NORTH, textFieldDescripcion);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDescripcion, 205, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDescripcion, 12, SpringLayout.EAST, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDescripcion, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDescripcion, 0, SpringLayout.EAST, textFieldNombre);
		panel.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 0, SpringLayout.NORTH, lblFechaInicio);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, 22, SpringLayout.NORTH, lblFechaInicio);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textFieldNombre);
		panel.add(dateChooser);
		
		JDateChooser dateChooserAlta = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooserAlta, 0, SpringLayout.NORTH, lblFechaAlta);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooserAlta, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooserAlta, 22, SpringLayout.NORTH, lblFechaAlta);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooserAlta, 0, SpringLayout.EAST, textFieldNombre);
		panel.add(dateChooserAlta);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -49, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -116, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);
		
		comboBoxPlataforma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblEspectaculos.setVisible(true);
				comboBoxEspectaculos.setVisible(true);
			}
		});
		
		comboBoxEspectaculos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblFuncion.setVisible(true);
				comboBoxFuncion.setVisible(true);
			}
		});
		
		comboBoxFuncion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});

	}
}
