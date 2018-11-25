package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.ConnexionMembre;
import modele.Operation;

public class Connexion extends JFrame{
	
	Operation operation = new Operation();
	JPanel panel1 = null;
	JPanel panel2 = null;
	JPanel panel3 = null;
	
	JLabel login = null;
	JTextField loginfield = null;
	
	JLabel mdp = null;
	JPasswordField mdpfield = null;
	
	JButton btnConnexion = null;
	JButton btnAnnuler = null;
	
	public Connexion()
	{
		this.setTitle("Connexion");
		this.setSize(460, 230);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
				
		panel1 = new JPanel();
		JLabel cadenat = new JLabel(new ImageIcon("image/cadenat1.jpg"));
		panel1.add(cadenat);
		
		JPanel firstpane = new JPanel();
		firstpane.setPreferredSize(new Dimension(this.getWidth(),20));
		
		login = new JLabel();
		login.setText("Login : ");
		loginfield = new JTextField();
		loginfield.setPreferredSize(new Dimension(200, 30));
		
		JPanel logpane = new JPanel();
		logpane.setPreferredSize(new Dimension(210,100));
		logpane.add(login);
		logpane.add(loginfield);
		
		mdp = new JLabel();
		mdp.setText("Mot de passe :");
		mdpfield = new JPasswordField();
		mdpfield.setPreferredSize(new Dimension(200,30));
		
		JPanel logpass = new JPanel();
		logpass.setPreferredSize(new Dimension(this.getWidth(), 20));
		
		JPanel passpane = new JPanel();
		passpane.setPreferredSize(new Dimension(210,100));
		passpane.add(mdp);
		passpane.add(mdpfield);
		
		btnConnexion = new JButton();
		btnConnexion.setText("Connexion");
		btnConnexion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				connexion(e);
			}
		});
		btnAnnuler = new JButton();
		btnAnnuler.setText("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				annuler();
			}
			
		});
		JPanel mdpbtn = new JPanel();
		mdpbtn.setPreferredSize(new Dimension(this.getWidth(), 20));
		
		JPanel lastpanel = new JPanel();
		lastpanel.setPreferredSize(new Dimension(this.getWidth(), 20));
		
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout (panel2, BoxLayout.PAGE_AXIS));
		panel2.add(firstpane);
		panel2.add(logpane);
		panel2.add(logpass);
		panel2.add(passpane);
		
		JPanel boutonPanel = new JPanel();
		boutonPanel.add(btnConnexion);
		boutonPanel.add(btnAnnuler);
		
		panel2.add(mdpbtn);
		panel2.add(boutonPanel);
		panel2.add(lastpanel);
		
		panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(15,this.getHeight()));
		panel3.setBorder(BorderFactory.createLineBorder(Color.decode(("#000"))));
		
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));
		this.getContentPane().add(panel1);
		this.getContentPane().add(panel2);
		this.getContentPane().add(panel3);
	}
	public void annuler()
	{
	  String[] option ={"OUI","NON"};
	  int choix = JOptionPane.showOptionDialog(null,"Voulez-vous vraiment annuler ?","Confirmation",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
	  if(choix == JOptionPane.OK_OPTION)
	  {
		  this.loginfield.setText("");
		  this.mdpfield.setText("");
	  }
	}
	public void connexion(ActionEvent event)
	{
		ResultSet result = null;
		ConnexionMembre con_m = new ConnexionMembre();
	  
	    con_m.setLogin(loginfield.getText());
	    con_m.setMdp(mdpfield.getText());
	  
	    result = operation.connecte_membre(con_m);
	    try {
	    	if(result.next())
	    	{
	    		int idM = result.getInt("idMembre");
	    		String type = result.getString("type");
	    		
	            MainMain main = new MainMain(type);
	              
	            dispose();
	        }
	        else if(loginfield.getText().equals("") || mdpfield.getText().equals("")){
	        	
	                JOptionPane.showMessageDialog(null,"Veuillez vérifier votre login ou mot de passe svp ! ","Echec connexion",JOptionPane.INFORMATION_MESSAGE);
	        }
	        else {
	        	JOptionPane.showMessageDialog(null,"Utilisateur non reconnu ou bloqué! ","Echec connexion",JOptionPane.INFORMATION_MESSAGE);
	        }
	     }catch (SQLException ex) {
	   
	         Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
	     }
	 }
}
