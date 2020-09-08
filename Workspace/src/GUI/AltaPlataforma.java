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
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 5, SpringLayout.NORTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNombre, 1, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, -260, SpringLayout.EAST, panel);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescGeneral = new JLabel("Desc. General:");
		sl_panel.putConstraint(SpringLayout.WEST, lblDescGeneral, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, lblDescGeneral, 121, SpringLayout.WEST, panel);
		panel.add(lblDescGeneral);
		
		textFieldDescGeneral = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDescGeneral, -6, SpringLayout.NORTH, textFieldDescGeneral);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDescGeneral, 105, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDescGeneral, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDescGeneral, -252, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDescGeneral, -10, SpringLayout.EAST, panel);
		panel.add(textFieldDescGeneral);
		textFieldDescGeneral.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblUrl, -383, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescGeneral, 6, SpringLayout.SOUTH, lblUrl);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUrl, 6, SpringLayout.SOUTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblUrl, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.EAST, lblUrl, -28, SpringLayout.EAST, lblNombre);
		panel.add(lblUrl);
		
		textFieldURL = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldURL, 6, SpringLayout.SOUTH, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldURL, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldURL, -260, SpringLayout.EAST, panel);
		textFieldURL.setColumns(10);
		panel.add(textFieldURL);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -22, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(buttonCancelar);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -104, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -96, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -22, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, 0, SpringLayout.EAST, scrollPane);
		getContentPane().add(buttonAceptar);

	}
}
