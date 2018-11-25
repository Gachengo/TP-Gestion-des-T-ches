package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DefaultPanel extends JPanel{
	
	private JPanel paneZero = new JPanel();
	private JPanel paneUn = new JPanel();
	private JPanel paneDeux = new JPanel();
	private JPanel paneTrois = new JPanel();
	private JPanel paneLast = new JPanel();
	
	private JLabel lblUn = new JLabel();
	private JLabel lblDeux = new JLabel();
	private JLabel lblTrois = new JLabel();
	
	private String txtUn = " BIENVENUE DANS ";
	private String txtDeux = " LE SYSTEME DE ";
	private String txtTrois = " GESTION DES TACHES";
	
	Font police = new Font("Liberation Serif", Font.BOLD, 45);
	
	public DefaultPanel() {
		
		lblUn.setText(txtUn);
		lblUn.setForeground(Color.BLUE);
		lblUn.setFont(police);
		
		lblDeux.setText(txtDeux);
		lblDeux.setForeground(Color.darkGray);
		lblDeux.setFont(police);
		
		lblTrois.setText(txtTrois);
		lblTrois.setForeground(Color.BLUE);
		lblTrois.setFont(police);
		
		paneUn.add(lblUn);
		paneDeux.add(lblDeux);
		paneTrois.add(lblTrois);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createBevelBorder(HEIGHT));
		this.add(paneZero);
		this.add(paneUn);
		this.add(paneDeux);
		this.add(paneTrois);
		this.add(paneLast);
	}

}
