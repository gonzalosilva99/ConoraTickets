package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datatypes.DtPaquete;

import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;

public class ConsultaPaqueteEspectaculoWindowView extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPaqueteEspectaculoWindowView frame = new ConsultaPaqueteEspectaculoWindowView();
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

	public ConsultaPaqueteEspectaculoWindowView() {		
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 596);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new SpringLayout());
		
		
	}
	public ConsultaPaqueteEspectaculoWindowView(DtPaquete dtpaquete) {
		
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 596);
		
		JDesktopPane desktopPane = new JDesktopPane(); 
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new SpringLayout());
		
		
		ConsultaDePaqueteDeEspectaculos consultapaquetedeespectaculo = new ConsultaDePaqueteDeEspectaculos();
		consultapaquetedeespectaculo.setDatosPaquete(dtpaquete);
		desktopPane.add(consultapaquetedeespectaculo);
		consultapaquetedeespectaculo.show();
		try {
			consultapaquetedeespectaculo.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
