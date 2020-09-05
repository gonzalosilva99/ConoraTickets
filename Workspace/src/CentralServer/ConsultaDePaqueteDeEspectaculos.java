package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.awt.event.ItemEvent;
import java.awt.Button;

public class ConsultaDePaqueteDeEspectaculos extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDePaqueteDeEspectaculos frame = new ConsultaDePaqueteDeEspectaculos();
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
	public ConsultaDePaqueteDeEspectaculos() {
		setTitle("Consulta de Paquete de Espectaculo");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPaquetes, 15, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPaquetes, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblPaquetes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Pan");
		comboBox.addItem("Manteca");
		
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 41, SpringLayout.EAST, lblPaquetes);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 34, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -191, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, lblPaquetes, -10, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -241, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblPaquetes);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		panel.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		
		JLabel lblEspectaculos = new JLabel("Espectaculos:");
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				panel.setVisible(true);
			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Espectaculo1");
		comboBox_1.addItem("Espectaculo2");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNombre)
							.addGap(41)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEspectaculos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDescripcion))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDescripcion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEspectaculos)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -49, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -108, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonCancelar);

	}
}
