package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Membre;
import modele.Operation;

public class FormEditMember extends JDialog implements ActionListener{

	ModifierMembre parentparent = new ModifierMembre();
	Operation operation = new Operation();
	
	JLabel lblnom;
	JTextField txtnom;
	
	JLabel lblprenom;
	JTextField txtprenom;
	
	JLabel lbladresse;
	JTextField txtadresse;
	
	JLabel lbltel;
	JTextField txttel;
	
	JLabel lblemail;
	JTextField txtemail;
	
	JLabel lbltype;
	JComboBox txttype;
	
	JButton btnsave;
	JButton btncancel;
	
	private String email;
	private int ligne;
	private int id;
	
	public FormEditMember(JFrame parent, String titre, boolean modal, String email, int ligne, ModifierMembre parentparent) {
		super(parent, titre, modal);
		
		this.parentparent = parentparent;
		this.email = email;
		this.ligne = ligne;
		this.setSize(300,400);
		this.setLocationRelativeTo(null);
		
		Object [][] infoMembre = (Object[][]) operation.getInfoMembre(email);
		
		JPanel panneFirst = new JPanel();
		panneFirst.setPreferredSize(new Dimension(this.getWidth(),15));
		
		this.id = (int) infoMembre[0][0];
		
		lblnom = new JLabel("Nom :");
		txtnom = new JTextField();
		txtnom.setText((String)infoMembre[0][1]);
		
		JPanel panneNom = new JPanel();
		panneNom.setLayout(new BoxLayout(panneNom, BoxLayout.PAGE_AXIS));
		panneNom.add(lblnom);
		panneNom.add(txtnom);
		
		lblprenom = new JLabel("Prénom :");
		txtprenom = new JTextField();
		txtprenom.setText((String)infoMembre[0][2]);
		
		JPanel pannePrenom = new JPanel();
		pannePrenom.setLayout(new BoxLayout(pannePrenom, BoxLayout.PAGE_AXIS));
		pannePrenom.add(lblprenom);
		pannePrenom.add(txtprenom);
		
		lbladresse = new JLabel("Adresse :");
		txtadresse = new JTextField();
		txtadresse.setText((String)infoMembre[0][5]);
		JPanel panneAdresse = new JPanel();
		panneAdresse.setLayout(new BoxLayout(panneAdresse, BoxLayout.PAGE_AXIS));
		panneAdresse.add(lbladresse);
		panneAdresse.add(txtadresse);
		
		lbltel = new JLabel("Téléphone :");
		txttel = new JTextField();
		txttel.setText((String)infoMembre[0][3]);
		JPanel panneTel = new JPanel();
		panneTel.setLayout(new BoxLayout(panneTel, BoxLayout.PAGE_AXIS));
		panneTel.add(lbltel);
		panneTel.add(txttel);
		
		lblemail = new JLabel("E-mail :");
		txtemail = new JTextField();
		txtemail.setText((String)infoMembre[0][4]);
		JPanel panneEmail = new JPanel();
		panneEmail.setLayout(new BoxLayout(panneEmail, BoxLayout.PAGE_AXIS));
		panneEmail.add(lblemail);
		panneEmail.add(txtemail);
		
		lbltype = new JLabel("Type :");
		txttype = new JComboBox();
		txttype.setSelectedItem(infoMembre[0][6]);
		txttype.addItem("Chef d'Equipe");
		txttype.addItem("Membre");
		JPanel panneType = new JPanel();
		panneType.setLayout(new BoxLayout(panneType, BoxLayout.PAGE_AXIS));
		panneType.add(lbltype);
		panneType.add(txttype);
		
		btnsave = new JButton("Enregistrer");
		btnsave.setActionCommand("SAVE");
		btnsave.addActionListener(this);
		btncancel = new JButton("Annuler");
		btncancel.setActionCommand("CANCEL");
		btncancel.addActionListener(this);

		JPanel panneButton = new JPanel();
		panneButton.add(btnsave);
		panneButton.add(btncancel);
		
		JPanel panneContent = new JPanel();
		panneContent.setLayout(new BoxLayout(panneContent, BoxLayout.PAGE_AXIS));
		panneContent.setBorder(BorderFactory.createTitledBorder("Informations"));
		panneContent.add(panneFirst);
		panneContent.add(panneNom);
		panneContent.add(pannePrenom);
		panneContent.add(panneAdresse);
		panneContent.add(panneTel);
		panneContent.add(panneEmail);
		panneContent.add(panneType);
		panneContent.add(panneButton);
		
		this.add(panneContent, BorderLayout.CENTER);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("CANCEL")) {
			
			String[] option ={"OUI","NON"};
			
			int choix = JOptionPane.showOptionDialog(null,"Voulez-vous vraiment annuler ?","Msg Confirmation",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
			
			if(choix == JOptionPane.OK_OPTION)
			  {
					dispose();
			  }
		}
		else if(e.getActionCommand().equals("SAVE")) {
				
			String nom = "";
			String prenom = "";
			String adresse = "";
			String tel = "";
			String email = "";
			String type = "";
			
			int error = 6;
			
			if(txtnom.getText() != "") {
			
				nom = txtnom.getText();
				error--;
			}
			if(txtprenom.getText() != "") {
				
				prenom = txtprenom.getText();
				error--;
			}
			if(txtadresse.getText() != "") {
				
				adresse = txtadresse.getText();
				error--;
			}
			if(txttel.getText() != "") {
				tel = txttel.getText();
				error--;
			}
			if(txtemail.getText() != "") {
				
				email = txtemail.getText();
				error--;
			}
			if(!txttype.getSelectedItem().equals(""))
			{
				type = (String)txttype.getSelectedItem();
				error--;
			}
			if(error == 0)
			{
				Membre membre = new Membre(this.id, nom, prenom, tel, email,adresse, type);
				
				boolean update = operation.updateMembre(membre);
				
				if(update) {
				
					dispose();
					
					JOptionPane.showMessageDialog(null,"Modifications appliquées avec succès ! ","Msg confirmation",JOptionPane.INFORMATION_MESSAGE);
				
					parentparent.modeleMembre.removeMembre(ligne);
					
					parentparent.modeleMembre.replaceMembre(membre, ligne);
					
				}
			}
		}
	}

}
