package gui;

import java.awt.EventQueue;

import controladores.Fabrica;
import datatypes.DtArtista;
import datatypes.DtCategoria;
import datatypes.DtPlataforma;
import excepciones.CheckDatos;
import interfaces.ICategoria;
import interfaces.IPlataforma;
import interfaces.IUsuario;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;

public class AltaEspectaculo extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextPane textFieldDescripcion;
	private JTextField textFieldEspectMin;
	private JTextField textFieldEspectMax;
	private JTextField textFieldURL;
	private JTextField textFieldCosto;
	private JTextField textFieldDuracion;
	private JTextField textFieldImagen;
	private Set<String> categoriasADevolver;
	private JTextField textField_urlVideo;
	private JTextField textField_premio;
	private JTextField textField_cantidadPremios;
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
		Map<Integer, DtCategoria> listCats = new HashMap<Integer, DtCategoria>();
		setTitle("Alta de espectaculo");
		setBounds(100, 100, 530, 751);
		
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
		ICategoria icategoria = fabric.getICategoria();
		Set<DtPlataforma> listaPlataformas = iplataforma.listarPlataformas();
		Iterator<DtPlataforma> itr = listaPlataformas.iterator();
		while (itr.hasNext()){
			comboBoxPlataforma.addItem(itr.next().getNombre()); }
		
		

		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		springLayout.putConstraint(SpringLayout.WEST, lblPlataforma, 21, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblPlataforma, 30, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lblPlataforma);
		
		Button buttonCancelar = new Button("Cancelar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancelar, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonCancelar, 335, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonCancelar, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonCancelar, -101, SpringLayout.EAST, getContentPane());
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				dispose();
			}
		});
		getContentPane().add(buttonCancelar);
		
		Button buttonAceptar = new Button("Aceptar");
		springLayout.putConstraint(SpringLayout.NORTH, buttonAceptar, 0, SpringLayout.NORTH, buttonCancelar);
		springLayout.putConstraint(SpringLayout.WEST, buttonAceptar, 6, SpringLayout.EAST, buttonCancelar);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAceptar, 37, SpringLayout.NORTH, buttonCancelar);
		springLayout.putConstraint(SpringLayout.EAST, buttonAceptar, -10, SpringLayout.EAST, getContentPane());
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
		while (itra.hasNext()){
			DtArtista aux = itra.next();
			String nick = aux.getNickname();
			 String nom = aux.getNombre();
			 String ape = aux.getApellido();
			 String ope = nick+" "+nom+" "+ape;
			 comboBoxArtista.addItem(ope);
			}
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 2, SpringLayout.SOUTH, comboBoxArtista);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -81, SpringLayout.SOUTH, getContentPane());
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
		
		textFieldDescripcion = new JTextPane();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDescripcion, 13, SpringLayout.SOUTH, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDescripcion, 16, SpringLayout.EAST, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDescripcion, 10, SpringLayout.SOUTH, lblDescripcion);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDescripcion, -141, SpringLayout.EAST, panel);
		panel.add(textFieldDescripcion);
		//textFieldDescripcion.setCo
		
		textFieldEspectMin = new JTextField();
		textFieldEspectMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent eve) {
				char caracter = eve.getKeyChar();

			      // Verificar si la tecla pulsada no es un digito
			      if ((caracter < '0' ||
			         caracter > '9') &&
			         caracter != '\b' /*corresponde a BACK_SPACE*/){
			         eve.consume();  // ignorar el evento de teclado
			      }
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldEspectMin, 137, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldEspectMin, 16, SpringLayout.EAST, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldEspectMin, -141, SpringLayout.EAST, panel);
		panel.add(textFieldEspectMin);
		textFieldEspectMin.setColumns(10);
		
		textFieldEspectMax = new JTextField();
		textFieldEspectMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent eve) {
				char caracter = eve.getKeyChar();

			      // Verificar si la tecla pulsada no es un digito
			      if ((caracter < '0' ||
			         caracter > '9') &&
			         caracter != '\b' /*corresponde a BACK_SPACE*/){
			         eve.consume();  // ignorar el evento de teclado
			      }
			}
		});
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
		
		JLabel lblCosto = new JLabel("Costo $U:");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblURL, -14, SpringLayout.NORTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.NORTH, lblCosto, 248, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCosto, 267, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblCosto, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblCosto, 0, SpringLayout.EAST, lblNombre);
		panel.add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent eve) {
				char caracter = eve.getKeyChar();

			      // Verificar si la tecla pulsada no es un digito
			      if ((caracter < '0' ||
			         caracter > '9') &&
			         caracter != '\b' /*corresponde a BACK_SPACE*/){
			         eve.consume();  // ignorar el evento de teclado
			      }
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, textFieldCosto, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldCosto, 14, SpringLayout.SOUTH, textFieldURL);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldCosto, -141, SpringLayout.EAST, panel);
		panel.add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de alta:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFecha, 19, SpringLayout.SOUTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblFecha, 34, SpringLayout.SOUTH, lblCosto);
		sl_panel.putConstraint(SpringLayout.EAST, lblFecha, 0, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblFecha, 10, SpringLayout.WEST, panel);
		panel.add(lblFecha);
		
		JLabel lblDuracion = new JLabel("Duración(minutos):");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDuracion, 15, SpringLayout.SOUTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDuracion, 30, SpringLayout.SOUTH, lblFecha);
		sl_panel.putConstraint(SpringLayout.EAST, lblDuracion, 0, SpringLayout.EAST, lblNombre);
		sl_panel.putConstraint(SpringLayout.WEST, lblDuracion, 10, SpringLayout.WEST, panel);
		panel.add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent eve) {
				char caracter = eve.getKeyChar();

			      // Verificar si la tecla pulsada no es un digito
			      if ((caracter < '0' ||
			         caracter > '9') &&
			         caracter != '\b' /*corresponde a BACK_SPACE*/){
			         eve.consume();  // ignorar el evento de teclado
			      }
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldDuracion, 50, SpringLayout.SOUTH, textFieldCosto);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldDuracion, 16, SpringLayout.EAST, lblDuracion);
		sl_panel.putConstraint(SpringLayout.SOUTH, textFieldDuracion, 69, SpringLayout.SOUTH, textFieldCosto);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldDuracion, -141, SpringLayout.EAST, panel);
		panel.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 15, SpringLayout.SOUTH, textFieldCosto);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, dateChooser, 34, SpringLayout.SOUTH, textFieldCosto);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, textFieldNombre);
		panel.add(dateChooser);
		
		JLabel lblImagen = new JLabel("Imagen(opc):");
		sl_panel.putConstraint(SpringLayout.WEST, lblImagen, 0, SpringLayout.WEST, lblNombre);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblImagen, -17, SpringLayout.NORTH, lblEspectMin);
		sl_panel.putConstraint(SpringLayout.EAST, lblImagen, 0, SpringLayout.EAST, lblNombre);
		panel.add(lblImagen);
		
		textFieldImagen = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldImagen, -2, SpringLayout.NORTH, lblImagen);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldImagen, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldImagen, 0, SpringLayout.EAST, textFieldNombre);
		textFieldImagen.setColumns(10);
		panel.add(textFieldImagen);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategorias, 15, SpringLayout.SOUTH, lblDuracion);
		sl_panel.putConstraint(SpringLayout.WEST, lblCategorias, 0, SpringLayout.WEST, lblNombre);
		panel.add(lblCategorias);
		JList list = new JList();
		JScrollPane scrollPane = new JScrollPane();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 8, SpringLayout.SOUTH, textFieldDuracion);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, -131, SpringLayout.SOUTH, panel);
		panel.add(scrollPane);
		scrollPane.setViewportView(list);
		
		Button buttonAnadir = new Button("+");
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, -209, SpringLayout.WEST, buttonAnadir);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, -12, SpringLayout.WEST, buttonAnadir);
		sl_panel.putConstraint(SpringLayout.WEST, buttonAnadir, 371, SpringLayout.WEST, panel);
		scrollPane.setViewportView(list);
		
		sl_panel.putConstraint(SpringLayout.NORTH, buttonAnadir, 346, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, buttonAnadir, 369, SpringLayout.NORTH, panel);
		panel.add(buttonAnadir);
		
		Button buttonQuitar = new Button("-");
		sl_panel.putConstraint(SpringLayout.WEST, buttonQuitar, 401, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, buttonAnadir, -6, SpringLayout.WEST, buttonQuitar);
		
		sl_panel.putConstraint(SpringLayout.NORTH, buttonQuitar, 346, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, buttonQuitar, 0, SpringLayout.SOUTH, buttonAnadir);
		sl_panel.putConstraint(SpringLayout.EAST, buttonQuitar, -75, SpringLayout.EAST, panel);
		panel.add(buttonQuitar);
		
		JLabel CategoriasSeleccionadas = new JLabel("");
		sl_panel.putConstraint(SpringLayout.WEST, CategoriasSeleccionadas, 22, SpringLayout.EAST, textFieldDuracion);
		sl_panel.putConstraint(SpringLayout.SOUTH, CategoriasSeleccionadas, 0, SpringLayout.SOUTH, lblDuracion);
		panel.add(CategoriasSeleccionadas);
		dateChooser.getDateEditor().setEnabled(false);
		
		
		categoriasADevolver = new HashSet<String>();
		Set<Integer> IndicesCategorias = new HashSet<Integer>();
		
		categoriasADevolver.clear();
		IndicesCategorias.clear();
		CategoriasSeleccionadas.setText("");
		
		JLabel lblNewLabel_1 = new JLabel("UrlVideo");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 63, SpringLayout.SOUTH, lblCategorias);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -107, SpringLayout.SOUTH, panel);
		panel.add(lblNewLabel_1);
		
		textField_urlVideo = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_urlVideo, 6, SpringLayout.SOUTH, scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, -152, SpringLayout.WEST, textField_urlVideo);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -92, SpringLayout.WEST, textField_urlVideo);
		sl_panel.putConstraint(SpringLayout.WEST, textField_urlVideo, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textField_urlVideo, 0, SpringLayout.EAST, textFieldNombre);
		panel.add(textField_urlVideo);
		textField_urlVideo.setColumns(10);
		
		JLabel label_premio = new JLabel("Premio");
		sl_panel.putConstraint(SpringLayout.NORTH, label_premio, -101, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, label_premio, -86, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, label_premio, 0, SpringLayout.EAST, lblCategorias);
		panel.add(label_premio);
		
		textField_premio = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, label_premio, -152, SpringLayout.WEST, textField_premio);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_premio, 6, SpringLayout.SOUTH, textField_urlVideo);
		sl_panel.putConstraint(SpringLayout.WEST, textField_premio, 0, SpringLayout.WEST, textFieldNombre);
		sl_panel.putConstraint(SpringLayout.EAST, textField_premio, 0, SpringLayout.EAST, textFieldNombre);
		panel.add(textField_premio);
		textField_premio.setColumns(10);
		
		JLabel lblCantidadDePremios = new JLabel("Cantidad de Premios:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCantidadDePremios, 6, SpringLayout.SOUTH, label_premio);
		sl_panel.putConstraint(SpringLayout.WEST, lblCantidadDePremios, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCantidadDePremios, -65, SpringLayout.SOUTH, panel);
		panel.add(lblCantidadDePremios);
		
		textField_cantidadPremios = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, lblCantidadDePremios, -6, SpringLayout.WEST, textField_cantidadPremios);
		sl_panel.putConstraint(SpringLayout.WEST, textField_cantidadPremios, 162, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_cantidadPremios, -141, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_cantidadPremios, 6, SpringLayout.SOUTH, textField_premio);
		panel.add(textField_cantidadPremios);
		textField_cantidadPremios.setColumns(10);
		DefaultListModel listaCategorias = new DefaultListModel();
		Set<DtCategoria> listCatAux = icategoria.listarCategorias();
		if (listCatAux!=null) {
		Iterator<DtCategoria> iterCategoria = listCatAux.iterator();
		listaCategorias.addElement(" ");
		for (Integer i=1; iterCategoria.hasNext(); i++) {
			DtCategoria DtCategoriaAux = iterCategoria.next();
			listCats.put(i, DtCategoriaAux);
			listaCategorias.addElement(i + ", " + DtCategoriaAux.getNomCategoria());
		}
		list.setModel(listaCategorias);
		scrollPane.setViewportView(list);
		}
		
		
		buttonAceptar.addActionListener(new ActionListener() {
			
			public boolean isNumeric(String str) {
		        return str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false;
		    }

			
			
			
			public void actionPerformed(ActionEvent arg0) {
				try{
					IPlataforma iplataform = fabric.getIPlataforma();
					String usuario = comboBoxArtista.getSelectedItem().toString();
					String[] nick = usuario.split(" ");
					if (comboBoxArtista.getItemCount() == 0 || comboBoxPlataforma.getItemCount() == 0 || textFieldNombre.getText().length()==0 || textFieldDescripcion.getText().length()==0 || textFieldURL.getText().length()==0 || dateChooser.getDate()==null) 
						throw new CheckDatos("No deben quedar campos vacios.");
					if (!(isNumeric(textFieldEspectMin.getText())))
						throw new CheckDatos("En el campo Espectadores Min. debe ingresar un entero");
					if (!(isNumeric(textFieldEspectMax.getText())))
						throw new CheckDatos("En el campo Espectadores Max. debe ingresar un entero");
					if (!(isNumeric(textFieldCosto.getText())))
						throw new CheckDatos("En el campo Costo debe ingresar un entero");
					if (!(isNumeric(textFieldDuracion.getText())))
						throw new CheckDatos("En el campo Duracion debe ingresar un entero");
					if (Integer.valueOf(textFieldEspectMax.getText())<Integer.valueOf(textFieldEspectMin.getText()))
						throw new CheckDatos("La cantidad de Espectadores minimos debe ser menor que Expectadores maximos");
					iplataform.altaEspectaculo(comboBoxPlataforma.getSelectedItem().toString(), nick[0] , 
							textFieldNombre.getText().trim(), textFieldDescripcion.getText().trim(),
							Integer.valueOf(textFieldEspectMin.getText()), Integer.valueOf(textFieldEspectMax.getText()), textFieldURL.getText().trim(),
							Integer.valueOf(textFieldCosto.getText()), dateChooser.getDate(), Integer.valueOf(textFieldDuracion.getText()), textFieldImagen.getText(), categoriasADevolver, textField_urlVideo.getText() , textField_premio.getText(), Integer.valueOf(textField_cantidadPremios.getText())); 
							 
					
					JOptionPane.showMessageDialog(null, "Espectaculo dado de alta con exito.");
							textFieldNombre.setText("");
							textFieldDescripcion.setText("");
							textFieldEspectMin.setText("");
							textFieldEspectMax.setText("");
							textFieldCosto.setText("");
							textFieldURL.setText("");
							textFieldDuracion.setText("");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
		
		

		
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		
		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex()!=0 & !(IndicesCategorias.contains(list.getSelectedIndex()))){
					IndicesCategorias.add(list.getSelectedIndex());
					categoriasADevolver.add(listCats.get(list.getSelectedIndex()).getNomCategoria());
					Iterator<Integer> iterArtistasString = IndicesCategorias.iterator();
					CategoriasSeleccionadas.setText("");
					while (iterArtistasString.hasNext()) {
						if (CategoriasSeleccionadas.getText()=="") {
							CategoriasSeleccionadas.setText(iterArtistasString.next().toString());
						}
						else {
							CategoriasSeleccionadas.setText(iterArtistasString.next().toString() + ", " + CategoriasSeleccionadas.getText());
						}
					}
				}
			}
		});
		
		buttonQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex()!=0 & (IndicesCategorias.contains(list.getSelectedIndex()))){
					
					categoriasADevolver.remove(listCats.get(list.getSelectedIndex()).getNomCategoria());
					IndicesCategorias.remove(list.getSelectedIndex());
					Iterator<Integer> iterArtistasString = IndicesCategorias.iterator();
					CategoriasSeleccionadas.setText("");
					while (iterArtistasString.hasNext()) {
						if (CategoriasSeleccionadas.getText()=="") {
							CategoriasSeleccionadas.setText(iterArtistasString.next().toString());
						}
						else {
							CategoriasSeleccionadas.setText(iterArtistasString.next().toString() + ", " + CategoriasSeleccionadas.getText());
						}
					}
				}
				
			}
		});
		
	}
}



