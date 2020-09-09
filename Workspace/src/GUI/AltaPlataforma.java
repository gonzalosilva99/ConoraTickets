package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaPlataforma extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescGeneral;
	private JTextField textFieldURL;
	private JTextField textField;

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
		setTitle("Alta de Plataforma");
		setBounds(100, 100, 525, 550);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 460, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 499, SpringLayout.WEST, getContentPane());
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		scrollPane.setViewportView(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNombre, 39, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNombre, -416, SpringLayout.EAST, panel);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 3, SpringLayout.NORTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNombre, 32, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, -229, SpringLayout.EAST, panel);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescGeneral = new JLabel("Desc. General:");
		sl_panel.putConstraint(SpringLayout.WEST, lblDescGeneral, 0, SpringLayout.WEST, lblNombre);
		panel.add(lblDescGeneral);
		
		textFieldDescGeneral = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDescGeneral, -6, SpringLayout.NORTH, textFieldDescGeneral);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDescGeneral, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDescGeneral, -204, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDescGeneral, -10, SpringLayout.EAST, panel);
		panel.add(textFieldDescGeneral);
		textFieldDescGeneral.setColumns(10);
		
		JLabel lblUrl = new JLabel("Descripci\u00F3n:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescGeneral, 60, SpringLayout.SOUTH, lblUrl);
		sl_panel.putConstraint(SpringLayout.EAST, lblDescGeneral, 23, SpringLayout.EAST, lblUrl);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDescGeneral, 88, SpringLayout.SOUTH, lblUrl);
		sl_panel.putConstraint(SpringLayout.EAST, lblUrl, 15, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblUrl, -383, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUrl, 6, SpringLayout.SOUTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblUrl, 0, SpringLayout.WEST, lblNombre);
		panel.add(lblUrl);
		
		textFieldURL = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFieldURL, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldURL, -229, SpringLayout.EAST, panel);
		textFieldURL.setColumns(10);
		panel.add(textFieldURL);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 71, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldURL, -6, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textFieldNombre);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel lblUrl_2 = new JLabel("Url:");
		sl_panel.putConstraint(SpringLayout.WEST, lblUrl_2, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblUrl_2, 0, SpringLayout.SOUTH, textField);
		panel.add(lblUrl_2);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -22, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(buttonCancelar);
		
		Button buttonAceptar = new Button("Aceptar");
		
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -104, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -96, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -22, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, 0, SpringLayout.EAST, scrollPane);
		getContentPane().add(buttonAceptar);

	}
}
