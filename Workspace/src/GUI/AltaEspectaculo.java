package GUI;

import java.awt.EventQueue;
import Controladores.ControladorPlataforma;
import Controladores.ControladorUsuario;
import Controladores.Fabrica;
import DataTypes.DtUsuario;
import Interfaces.IUsuario;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controladores.Fabrica;
import Interfaces.IPlataforma;
import DataTypes.DtPlataforma;
import DataTypes.DtArtista;
import com.toedter.calendar.JDateChooser;

public class AltaEspectaculo extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldEspectMin;
	private JTextField textFieldEspectMax;
	private JTextField textFieldURL;
	private JTextField textFieldCosto;
	private JTextField textFieldDuracion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaEspectaculo frame = new AltaEspectaculo();
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
	public AltaEspectaculo() {
		setTitle("Alta de espectaculo");
		setBounds(100, 100, 525, 550);
		
		JLabel lblNewLabel = new JLabel("Plataforma:");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 44, SpringLayout.NORTH, getContentPane());
		getContentPane().setLayout(springLayout);
		
		JComboBox comboBoxPlataforma = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, 26, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -150, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBoxPlataforma);
		
		Fabrica fabric = Fabrica.getInstancia();
		IPlataforma iplataforma = fabric.getIPlataforma();
		Set<DtPlataforma> listaPlataformas = iplataforma.listarPlataformas();
		Iterator<DtPlataforma> itr = listaPlataformas.iterator();
		while(itr.hasNext())
			{comboBoxPlataforma.addItem(itr.next().getNombre());}
		
		

		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 30, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblPlataforma);
		
		Button buttonCancelar = new Button("Cancelar");
		getContentPane().add(buttonCancelar);
		
		Button buttonAceptar = new Button("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "ERROR");

				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -37, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, -85, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, 0, SpringLayout.SOUTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(buttonAceptar);
		
		JLabel lblArtista = new JLabel("Artista:");
		springLayout.putConstraint(SpringLayout.NORTH, lblArtista, 26, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblArtista, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, 0, SpringLayout.EAST, lblArtista);
		getContentPane().add(lblArtista);
		
		JComboBox comboBoxArtista = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBoxArtista, 172, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblArtista, -21, SpringLayout.WEST, comboBoxArtista);
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxArtista, 66, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxArtista, -150, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 0, SpringLayout.WEST, comboBoxArtista);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxPlataforma, -18, SpringLayout.NORTH, comboBoxArtista);
		getContentPane().add(comboBoxArtista);
		IUsuario iusuario= fabric.getIUsuario();
		Set<DtArtista> listaArtistas = iusuario.listarArtistas();
		Iterator<DtArtista> itra = listaArtistas.iterator();
		while(itra.hasNext())
			{DtArtista aux = itra.next();
			String nick = aux.getNickname();
			 String nom = aux.getNombre();
			 String ap = aux.getApellido();
			 String op = nick+" "+nom+" "+ap;
			 comboBoxArtista.addItem(op);
			}
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 19, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, -85, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -66, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, 0, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 21, SpringLayout.SOUTH, comboBoxArtista);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNombre, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNombre, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNombre, 32, SpringLayout.NORTH, panel);
		panel.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescripcion, 44, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblDescripcion, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblDescripcion, 0, SpringLayout.EAST, lblNombre);
		panel.add(lblDescripcion);
		
		JLabel lblEspectMin = new JLabel("Espectadores min.:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectMin, 79, SpringLayout.SOUTH, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.EAST, lblNombre, 0, SpringLayout.EAST, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectMin, 10, SpringLayout.WEST, panel);
		panel.add(lblEspectMin);
		
		JLabel lblEspectMax = new JLabel("Espectadores max.:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEspectMin, -22, SpringLayout.NORTH, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.NORTH, lblEspectMax, 176, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblEspectMax, 10, SpringLayout.WEST, panel);
		panel.add(lblEspectMax);
		
		textFieldNombre = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldNombre, 12, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldNombre, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldNombre, -141, SpringLayout.EAST, panel);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDescripcion, 13, SpringLayout.SOUTH, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDescripcion, 16, SpringLayout.EAST, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDescripcion, -141, SpringLayout.EAST, panel);
		panel.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldEspectMin = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectMin, 137, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDescripcion, -12, SpringLayout.NORTH, textFieldEspectMin);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectMin, 16, SpringLayout.EAST, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectMin, -141, SpringLayout.EAST, panel);
		panel.add(textFieldEspectMin);
		textFieldEspectMin.setColumns(10);
		
		textFieldEspectMax = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectMax, 18, SpringLayout.SOUTH, textFieldEspectMin);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectMax, 13, SpringLayout.EAST, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectMax, -141, SpringLayout.EAST, panel);
		panel.add(textFieldEspectMax);
		textFieldEspectMax.setColumns(10);
		
		JLabel lblURL = new JLabel("Url:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblURL, 24, SpringLayout.SOUTH, lblEspectMax);
		sl_panel.putConstraint(SpringLayout.WEST, lblURL, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblURL, 0, SpringLayout.EAST, lblNombre);
		panel.add(lblURL);
		
		textFieldURL = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFieldURL, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldURL, 22, SpringLayout.SOUTH, textFieldEspectMax);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldURL, -141, SpringLayout.EAST, panel);
		panel.add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblURL, -14, SpringLayout.NORTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.NORTH, lblCosto, 248, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCosto, 267, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblCosto, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblCosto, 0, SpringLayout.EAST, lblNombre);
		panel.add(lblCosto);
		
		textFieldCosto = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFieldCosto, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldCosto, 14, SpringLayout.SOUTH, textFieldURL);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldCosto, -141, SpringLayout.EAST, panel);
		panel.add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFecha, 19, SpringLayout.SOUTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblFecha, 34, SpringLayout.SOUTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.EAST, lblFecha, 0, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblFecha, 10, SpringLayout.WEST, panel);
		panel.add(lblFecha);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDuracion, 15, SpringLayout.SOUTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDuracion, 30, SpringLayout.SOUTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.EAST, lblDuracion, 0, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblDuracion, 10, SpringLayout.WEST, panel);
		panel.add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDuracion, 50, SpringLayout.SOUTH, textFieldCosto);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDuracion, 16, SpringLayout.EAST, lblDuracion);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDuracion, -5, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDuracion, -141, SpringLayout.EAST, panel);
		panel.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 15, SpringLayout.SOUTH, textFieldCosto);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, 34, SpringLayout.SOUTH, textFieldCosto);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textFieldNombre);
		panel.add(dateChooser);
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					IPlataforma iplataform = fabric.getIPlataforma();
					iplataform.altaEspectaculo( comboBoxPlataforma.getSelectedItem().toString(),comboBoxArtista.getSelectedItem().toString() , textFieldNombre.getText(), textFieldDescripcion.getText(),
							Integer.valueOf(textFieldEspectMin.getText()), Integer.valueOf(textFieldEspectMax.getText()), textFieldURL.getText(),
							Integer.valueOf( textFieldCosto.getText() ), dateChooser.getDate(), Integer.valueOf( textFieldDuracion.getText() )); 
							JOptionPane.showMessageDialog(null, "Espectaculo dado de alta con exito.");
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "ERROR");

				}
			}
		});

		
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

	}
}
