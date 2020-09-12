package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.toedter.calendar.JDateChooser;

import Controladores.Fabrica;
import DataTypes.DtPlataforma;
import Interfaces.IPlataforma;
import Interfaces.IUsuario;
import DataTypes.DtArtista;
import DataTypes.DtEspectaculo;

import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ItemEvent;

public class AltaFuncionEspectaculo extends JInternalFrame {
	private JTextField textFieldNombre;

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
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 27, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPlataforma, 57, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblPlataforma);
		
		JComboBox comboBoxPlataforma = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxPlataforma, 31, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxPlataforma, 116, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxPlataforma, -219, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPlataforma, -6, SpringLayout.WEST, comboBoxPlataforma);
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEspectaculo, 6, SpringLayout.SOUTH, lblPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, lblEspectaculo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEspectaculo, 41, SpringLayout.SOUTH, lblPlataforma);
		getContentPane().add(lblEspectaculo);
		
		JComboBox comboBoxEspectaculo = new JComboBox();
		
		springLayout.putConstraint(SpringLayout.EAST, lblEspectaculo, 0, SpringLayout.WEST, comboBoxEspectaculo);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxPlataforma, -16, SpringLayout.NORTH, comboBoxEspectaculo);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxEspectaculo, 91, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxEspectaculo, 69, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxEspectaculo, 116, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBoxEspectaculo, 0, SpringLayout.EAST, comboBoxPlataforma);
		getContentPane().add(comboBoxEspectaculo);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, lblEspectaculo);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblPlataforma);
		springLayout.putConstraint(SpringLayout.EAST, panel, -4, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 42, 106, 34);
		springLayout.putConstraint(SpringLayout.NORTH, lblNombre, 16, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNombre, 26, SpringLayout.EAST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNombre, 51, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNombre, 126, SpringLayout.EAST, comboBoxPlataforma);
		
		JLabel lblFechaInicio = new JLabel("Fecha:");
		lblFechaInicio.setBounds(10, 86, 106, 34);
		springLayout.putConstraint(SpringLayout.NORTH, lblFechaInicio, 25, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFechaInicio, 54, SpringLayout.EAST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFechaInicio, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblFechaInicio, 154, SpringLayout.EAST, comboBoxPlataforma);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setBounds(10, 127, 106, 38);
		springLayout.putConstraint(SpringLayout.NORTH, lblHoraInicio, 25, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblHoraInicio, 41, SpringLayout.EAST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblHoraInicio, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblHoraInicio, 141, SpringLayout.EAST, comboBoxPlataforma);
		
		JLabel lblNewLabel = new JLabel("Invitados:");
		lblNewLabel.setBounds(10, 182, 106, 15);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 48, SpringLayout.EAST, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 148, SpringLayout.EAST, comboBoxPlataforma);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(122, 45, 175, 28);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNombre, 0, SpringLayout.NORTH, comboBoxPlataforma);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNombre, 39, SpringLayout.EAST, comboBoxPlataforma);
		textFieldNombre.setColumns(10);
		
		JLabel lblDatosFuncion = new JLabel("Datos de la Funcion:");
		lblDatosFuncion.setBounds(10, 0, 161, 28);
		lblDatosFuncion.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(122, 86, 175, 28);
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("yyyy-MM-dd ");
		panel.setLayout(null);
		panel.add(lblHoraInicio);
		panel.add(lblNewLabel);
		panel.add(lblNombre);
		panel.add(lblFechaInicio);
		panel.add(textFieldNombre);
		panel.add(lblDatosFuncion);
		panel.add(dateChooser);
		Button buttonAceptar = new Button("Aceptar");
		
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, buttonAceptar);
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 425, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -4, SpringLayout.EAST, getContentPane());
		
		JLabel lblArtistasSeleccionados = new JLabel("");
		lblArtistasSeleccionados.setBounds(122, 285, 335, 28);
		panel.add(lblArtistasSeleccionados);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 180, 337, 93);
		panel.add(scrollPane);
		
		JSpinner spinnerHora = new JSpinner();
		spinnerHora.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinnerHora.setBounds(122, 127, 49, 28);
		panel.add(spinnerHora);
		
		JSpinner spinnerMinutos = new JSpinner();
		spinnerMinutos.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinnerMinutos.setBounds(183, 127, 49, 28);
		panel.add(spinnerMinutos);
		
		getContentPane().add(buttonAceptar);
		buttonAceptar.setSize(95, 36);
		
		Button buttonAnadir = new Button("+");
		buttonAnadir.setBounds(463, 182, 28, 28);
		panel.add(buttonAnadir);
		
		Button buttonQuitar = new Button("-");
		buttonQuitar.setBounds(463, 216, 28, 28);
		panel.add(buttonQuitar);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 333, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -52, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -6, SpringLayout.WEST, buttonAceptar);
		getContentPane().add(buttonCancelar);
		
		/** COMIENZA EL CODIGO **/
		Fabrica fabric = Fabrica.getInstancia();
		IPlataforma iplataforma = fabric.getIPlataforma();
		IUsuario iusuario = fabric.getIUsuario();
		Set<DtPlataforma> listaPlataformas = iplataforma.listarPlataformas();
		Iterator<DtPlataforma> itr = listaPlataformas.iterator();
		comboBoxPlataforma.addItem("");
		while(itr.hasNext())
			{comboBoxPlataforma.addItem(itr.next().getNombre());}
		
		//Cuando selecciona el espectaculo cargo las funciones
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxEspectaculo.removeAllItems();
				Set<DtEspectaculo> listarEspecsDePlat = iplataforma.listarEspectaculosDePlataforma(comboBoxPlataforma.getSelectedItem().toString());
				Iterator<DtEspectaculo> itr = listarEspecsDePlat.iterator();
				comboBoxEspectaculo.addItem("");
				while(itr.hasNext())
					{comboBoxEspectaculo.addItem(itr.next().getNombre());}
			}
		});
		
		
		/** CREAR FUNCION DE LISTAR ARTISTAS NO ESPECTACULO *********ESTA CREADA PERO AUN NO FUNCIONA BIEN*************
		 ** SETEAR QUE SE HAGA CUANDO SE CAMBIA EN EL COMBOBOX DE ESPECTACULO :D ���������������HECHO!!!!!!!!!!!!
		 ** 
		 **/
		JList list = new JList();
		scrollPane.setViewportView(list);
		Map<Integer, DtArtista> listArts = new HashMap<Integer, DtArtista>();
		
		comboBoxEspectaculo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					if(comboBoxEspectaculo.isFocusOwner() & comboBoxEspectaculo.getSelectedIndex()!=0) {
						DefaultListModel listaArtistas = new DefaultListModel();
						Set<DtArtista> listArtsAux = iusuario.listarArtistasNoEspectaculo(comboBoxEspectaculo.getSelectedItem().toString());
						Iterator<DtArtista> iterArtista = listArtsAux.iterator();
						listaArtistas.addElement(" ");
						for(Integer i=1; iterArtista.hasNext();i++) {
							DtArtista DtArtistaAux = iterArtista.next();
							listArts.put(i, DtArtistaAux);
							listaArtistas.addElement(DtArtistaAux.getNickname() + ", " + DtArtistaAux.getNombre() + " " + DtArtistaAux.getApellido());
						}
						list.setModel(listaArtistas);
						scrollPane.setViewportView(list);
					}
						else {
							DefaultListModel listaArtistas = new DefaultListModel();
							list.setModel(listaArtistas);
							scrollPane.setViewportView(list);
						}
				
			}
		});
		
		
		
		/*** ***/ 
		
		
		Set<String> ArtistasADevolver = new HashSet<String>();
		Set<Integer> IndicesArtistas = new HashSet<Integer>();
		
		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()!=0 & !(IndicesArtistas.contains(list.getSelectedIndex()))){
					IndicesArtistas.add(list.getSelectedIndex());
					ArtistasADevolver.add(listArts.get(list.getSelectedIndex()).getNickname());
					Iterator<String> iterArtistasString = ArtistasADevolver.iterator();
					lblArtistasSeleccionados.setText("");
					while(iterArtistasString.hasNext()) {
						lblArtistasSeleccionados.setText(lblArtistasSeleccionados.getText() + ", " + iterArtistasString.next());
					}
				}
			}
		});
		
		
		buttonQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()!=0 & IndicesArtistas.contains(list.getSelectedIndex())){
					ArtistasADevolver.remove(listArts.get(list.getSelectedValue()).getNickname());
					IndicesArtistas.remove(list.getSelectedIndex());
					Iterator<String> iterArtistasString = ArtistasADevolver.iterator();
					lblArtistasSeleccionados.setText("");
					while(iterArtistasString.hasNext()) {
						lblArtistasSeleccionados.setText(lblArtistasSeleccionados.getText() + ", " + iterArtistasString.next());
					}
				}
			}
		});

		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//if(comboBoxPlataforma.getSelectedItem().toString()!="" & comboBoxEspectaculo.getSelectedItem().toString()!="" & !ArtistasADevolver.isEmpty() & textFieldNombre.text()!="" ) {
					SimpleDateFormat formatoInicio = new SimpleDateFormat("yyyy-MM-dd ");
					String dateInicio = formatoInicio.format(dateChooser.getDate()) + spinnerHora.getValue().toString() + ":" + spinnerMinutos.getValue().toString() + ":00"; 					
					formatoInicio = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date FechaInicio = formatoInicio.parse(dateInicio);
					String dateAlta = formatoInicio.format(LocalDate.now());
					Date FechaAlta = formatoInicio.parse(dateAlta);
					iplataforma.ConfirmarAltaFuncionEspectaculo(comboBoxPlataforma.getSelectedItem().toString(), comboBoxEspectaculo.getSelectedItem().toString(), textFieldNombre.getText(), FechaInicio, ArtistasADevolver, FechaAlta);
					
					//}
				}
				catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
	}
}
