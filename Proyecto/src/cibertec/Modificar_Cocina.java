package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class Modificar_Cocina extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblAnchocm;
	private JLabel lblAltocm;
	private JLabel lblFondocm;
	private JLabel lblPrecios;
	private JLabel lblQuemadores;
	private JComboBox cboModelo;
	private JTextArea txtPrecio;
	private JTextArea txtAncho;
	private JTextArea txtAlto;
	private JTextArea txtFondo;
	private JTextArea txtQuemadores;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modificar_Cocina dialog = new Modificar_Cocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modificar_Cocina() {
		setTitle("Modificar_Cocina");
		setBounds(100, 100, 450, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 19, 89, 14);
		contentPanel.add(lblNewLabel);
		
		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setBounds(10, 69, 89, 14);
		contentPanel.add(lblAnchocm);
		
		lblAltocm = new JLabel("Alto (cm)");
		lblAltocm.setBounds(10, 94, 89, 14);
		contentPanel.add(lblAltocm);
		
		lblFondocm = new JLabel("Fondo (cm)");
		lblFondocm.setBounds(10, 119, 89, 14);
		contentPanel.add(lblFondocm);
		
		lblPrecios = new JLabel("Precio (S/)");
		lblPrecios.setBounds(10, 44, 89, 14);
		contentPanel.add(lblPrecios);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 144, 83, 14);
		contentPanel.add(lblQuemadores);
		
		cboModelo = 
				new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(126, 11, 148, 22);
		contentPanel.add(cboModelo);
		
		txtPrecio = new JTextArea();
		txtPrecio.setEditable(true);
		txtPrecio.setBounds(126, 39, 148, 22);
		contentPanel.add(txtPrecio);
		
		txtAncho = new JTextArea();
		txtAncho.setEditable(true);
		txtAncho.setBounds(126, 64, 148, 22);
		contentPanel.add(txtAncho);
		
		txtAlto = new JTextArea();
		txtAlto.setEditable(true);
		txtAlto.setBounds(126, 89, 148, 22);
		contentPanel.add(txtAlto);
		
		txtFondo = new JTextArea();
		txtFondo.setEditable(true);
		txtFondo.setBounds(126, 114, 148, 22);
		contentPanel.add(txtFondo);
		
		txtQuemadores = new JTextArea();
		txtQuemadores.setEditable(true);
		txtQuemadores.setBounds(126, 139, 148, 22);
		contentPanel.add(txtQuemadores);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(335, 40, 89, 23);
		contentPanel.add(btnGrabar);
		
		/*llamar al metodo actionPerformedCboModelo para
		 mostrar autmaticamente los datos de la primera cocina */
		actionPerformedCboModelo(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
	//cerrar el jdialogo completo
		dispose();
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		//limpiar los jtextarea antes de mostrar los nuevos
		txtAlto.setText("");
		txtAncho.setText("");
		txtFondo.setText("");
		txtPrecio.setText("");
		txtQuemadores.setText("");
		
		//declaracion y lectura de variables
		int nQue=0, nMod;
		double nPre=0, nAnc=0, nAlt=0, nFon=0;
		
		nMod = cboModelo.getSelectedIndex();
		
		//Parte logica
		switch (nMod) {
		case 0:
			nPre = 949.0;
			nFon = 58.6;
			nAnc = 60.0;
			nAlt = 91.0;
			nQue = 4;
			break;
		case 1:
			nPre = 1089.0;
			nFon = 67.5;
			nAnc = 80.0;
			nAlt = 94.0;
			nQue = 6;
			break;
		case 2:
			nPre = 850.0;
			nFon = 50.0;
			nAnc = 60.0;
			nAlt = 90.0;
			nQue = 4;
			break;
		case 3:
			nPre = 629.0;
			nFon = 51.5;
			nAnc = 61.6;
			nAlt = 95.0;
			nQue = 5;
			break;
		case 4:
			nPre = 849.0;
			nFon = 66.0;
			nAnc = 75.4;
			nAlt = 94.5;
			nQue = 5;
			break;
		}
		 //mostrar resultados
		txtAlto.setText  	 (      nAlt + "\n");
		txtAncho.append 	 (      nAnc + "\n");
		txtFondo.append 	 (      nFon + "\n");
		txtPrecio.append 	 (      nPre + "\n");
		txtQuemadores.append (	    nQue + "\n");
	}
}
