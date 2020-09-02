package CentralServer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Button;

public class AltaPlataforma extends JInternalFrame {
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
					AltaPlataforma frame = new AltaPlataforma();
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
	public AltaPlataforma() {
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 510, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 499, SpringLayout.WEST, getContentPane());
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Nombre de la plataforma:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 45, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -2, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -134, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Desc. General:");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 212, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -134, SpringLayout.EAST, panel);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblUrl, 40, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblUrl, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblUrl);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, lblUrl);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblUrl);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		Button buttonCancelar = new Button("Cancelar");
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -64, SpringLayout.NORTH, buttonCancelar);
		sl_panel.putConstraint(SpringLayout.WEST, buttonCancelar, -118, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, buttonCancelar, 0, SpringLayout.EAST, textField);
		panel.add(buttonCancelar);
		
		Button buttonAceptar = new Button("Aceptar");
		sl_panel.putConstraint(SpringLayout.NORTH, buttonAceptar, 430, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, buttonAceptar, 6, SpringLayout.EAST, buttonCancelar);
		sl_panel.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, buttonCancelar, 0, SpringLayout.NORTH, buttonAceptar);
		panel.add(buttonAceptar);

	}
}
