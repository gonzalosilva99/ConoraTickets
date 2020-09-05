package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Button;

public class AgregarEspectaculoAPaquete extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEspectaculoAPaquete frame = new AgregarEspectaculoAPaquete();
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
	public AgregarEspectaculoAPaquete() {
		setTitle("Agregar Espectaculo a Paquete");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 9, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -46, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -11, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPaquetes, 47, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPaquetes, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPaquetes, 82, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPaquetes, 110, SpringLayout.WEST, getContentPane());
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 52, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 153, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -212, SpringLayout.EAST, getContentPane());
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 88, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, -395, SpringLayout.SOUTH, getContentPane());
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, 99, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 153, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -212, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, -43, SpringLayout.WEST, comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1_1, 153, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1_1, -212, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1_1, 3, SpringLayout.SOUTH, comboBox_1);
		
		JLabel lblEspectaculo = new JLabel("Espectaculos:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEspectaculo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlataforma, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPaquetes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(181, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPaquetes, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlataforma, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEspectaculo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 419, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -8, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(buttonAceptar);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -32, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -92, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, 0, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);

	}
}
