package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;
import DataTypes.DtPaquete;
import DataTypes.DtEspectaculoDatos;

public class ConsultaEspectaculoWindowView extends JFrame {

	private JPanel contentPane;
	private DtPaquete datosPaquete;
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

	public ConsultaEspectaculoWindowView() {
		
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 596);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new SpringLayout());
		
		
	}
	public ConsultaEspectaculoWindowView(DtEspectaculoDatos dtesp) {
		
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 596);
		
		JDesktopPane desktopPane = new JDesktopPane(); 
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new SpringLayout());
		
		
		ConsultaEspectaculo consultaEspectaculo = new ConsultaEspectaculo();
		consultaEspectaculo.setDatosEspectaculo(dtesp);
		desktopPane.add(consultaEspectaculo);
		consultaEspectaculo.show();
		try {
			consultaEspectaculo.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
