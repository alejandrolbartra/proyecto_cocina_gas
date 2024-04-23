package cibertec;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class Consultar_cocina extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVender;
	private JButton btnCerrar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<String> cboModelo;
	private JTextField txtPre;
	private JTextField txtCan;
	private JScrollPane scrollPane;
	private JTextArea txtArea;
	private DecimalFormat df = new DecimalFormat("###,###,##0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consultar_cocina dialog = new Consultar_cocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @return 
	 */
	public Consultar_cocina() {
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(341, 10, 85, 21);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(341, 36, 85, 21);
		contentPanel.add(btnCerrar);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 14, 82, 13);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio(S/.)");
		lblNewLabel_1.setBounds(10, 40, 82, 13);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setToolTipText("Cantidad");
		lblNewLabel_2.setBounds(10, 65, 82, 13);
		contentPanel.add(lblNewLabel_2);
		
		cboModelo = new JComboBox<String>();
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(102, 10, 144, 21);
		contentPanel.add(cboModelo);
		
		txtPre = new JTextField();
		txtPre.setEditable(false);
		txtPre.setBounds(102, 37, 144, 19);
		contentPanel.add(txtPre);
		txtPre.setColumns(10);
		
		txtCan = new JTextField();
		txtCan.setBounds(102, 62, 144, 19);
		contentPanel.add(txtCan);
		txtCan.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 416, 159);
		contentPanel.add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnVender(ActionEvent e) {
		//1. Declarar y leer variables 
		
			int sMod, nCan;
			double nPre = 0;
			double nImpCom, nImpDes = 0, nImpPag;
			
			
			sMod = cboModelo.getSelectedIndex();
			nCan = Integer.parseInt(txtCan.getText());
		
		//2. C�lculos
			
			if(sMod == 0) {
				nPre = 949.0;
			}
			if(sMod == 1) {
				nPre = 1089.0;
			}
			if(sMod == 2) {
				nPre = 850.0;
			}
			if(sMod == 3) {
				nPre = 629.0;
			}
			if(sMod == 4) {
				nPre = 489.0;
			}
			
			nImpCom = nPre * nCan;
			
			if(nCan > 0 && nCan < 6) {
				nImpDes = nImpCom * 0.01;
			}
			if(nCan >= 6 && nCan < 11) {
				nImpDes = nImpCom * 0.02;
			}
			if(nCan >= 11  && nCan < 16) {
				nImpDes = nImpCom * 0.03;
			}
			if(nCan >= 16) {
				nImpDes = nImpCom * 0.04;
			}
			
			nImpPag = nImpCom - nImpDes;
						
		
		
		//3. Mostrar resultados 
			
			txtCan.setEditable(false);
		
			txtPre.setText("" + nPre);
			txtArea.setText("BOLETA DE VENTA" + "\n");
			txtArea.append("\n");
			txtArea.append("Modelo 		: " + cboModelo.getSelectedItem().toString() + "\n");			
			txtArea.append("Precio 		: S/. " + df.format(nPre) + "\n");			
			txtArea.append("Cantidad 		: " + nCan + "\n");			
			txtArea.append("Importe de compra 	: S/. " + df.format(nImpCom) + "\n");
			txtArea.append("Importe de descuento 	: S/." + df.format(nImpDes) + "\n");
			txtArea.append("Importe a pagar 	: S/." + df.format(nImpPag) + "\n");
	
		

	}
}
