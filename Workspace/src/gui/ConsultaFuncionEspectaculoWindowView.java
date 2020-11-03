package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datatypes.DtFuncionDatos;

import javax.swing.JDesktopPane;

public class ConsultaFuncionEspectaculoWindowView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionEspectaculoWindowView frame = new ConsultaFuncionEspectaculoWindowView();
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
	public ConsultaFuncionEspectaculoWindowView() {
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		desktopPane.setLayout(new BorderLayout(0, 0));
		
		ConsultaFuncionEspectaculo consultaFuncionEspectaculo = new ConsultaFuncionEspectaculo();
		desktopPane.add(consultaFuncionEspectaculo);
		consultaFuncionEspectaculo.show();
	}
	
	public ConsultaFuncionEspectaculoWindowView(DtFuncionDatos datosFuncion) {
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		
		ConsultaFuncionEspectaculo consultaFuncionEspectaculo = new ConsultaFuncionEspectaculo();
		consultaFuncionEspectaculo.setDatosFuncion(datosFuncion);
		desktopPane.add(consultaFuncionEspectaculo);
		consultaFuncionEspectaculo.show();
		try {
			consultaFuncionEspectaculo.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
