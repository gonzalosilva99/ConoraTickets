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
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 66, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -405, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 63, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 2, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textField, -203, SpringLayout.EAST, getContentPane());
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 236, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -161, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		springLayout.putConstraint(SpringLayout.WEST, lblFechaInicio, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblFechaInicio, -350, SpringLayout.EAST, getContentPane());
		
		JLabel lblFechaInicio_1 = new JLabel("Fecha Inicio");
		
		JLabel lblVigencia = new JLabel("Vigencia:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(171)
							.addComponent(lblVigencia, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblFechaInicio, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaInicio_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(224, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblVigencia)
					.addGap(18)
					.addComponent(lblFechaInicio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFechaInicio_1)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -203, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 23, SpringLayout.SOUTH, panel);
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
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 32, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 20, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -61, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDescripcin, 0, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, lblDescripcin, 0, SpringLayout.WEST, lblNewLabel);
		getContentPane().add(lblDescripcin);

	}
}
