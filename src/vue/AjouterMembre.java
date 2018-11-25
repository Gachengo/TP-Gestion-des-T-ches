package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controleur.Membre;
import controleur.ModeleTableMembre;
import modele.Operation;

public class AjouterMembre extends JPanel implements ActionListener{
	
	Operation operation = new Operation();
	ModeleTableMembre modeleMembre = new ModeleTableMembre();
	JTable tblMembre;
	
	JPanel paneAddMember = new JPanel();
	JPanel paneListMember = new JPanel();
	
	JLabel titleAjout = new JLabel();
	JLabel lblNom = new JLabel("Nom : ");
	JTextField nom = new JTextField();
	JLabel lblPrenom = new JLabel("Prénom : ");
	JTextField prenom = new JTextField();
	JLabel lblAdresse = new JLabel("Adresse : ");
	JTextField adresse = new JTextField();
	JLabel lblTelephone = new JLabel("Téléphone :");
	JTextField telephone = new JTextField();
	JLabel lblEmail = new JLabel("E-mail : ");
	JTextField email = new JTextField();
	JLabel lblType = new JLabel("Type : ");
	JComboBox type = new JComboBox();
	JButton btnEnregistrer = new JButton("Enregistrer");
	JButton btnCancel = new JButton("Annuler");
	
	public AjouterMembre() {
		
		JPanel paneNom = new JPanel();
		paneNom.setLayout(new BoxLayout(paneNom, BoxLayout.PAGE_AXIS));
		paneNom.add(lblNom);
		paneNom.add(nom);
		
		JPanel panePrenom = new JPanel();
		panePrenom.setLayout(new BoxLayout(panePrenom, BoxLayout.PAGE_AXIS));
		panePrenom.add(lblPrenom);
		panePrenom.add(prenom);

		JPanel paneTelephone = new JPanel();
		paneTelephone.setLayout(new BoxLayout(paneTelephone, BoxLayout.PAGE_AXIS));
		paneTelephone.add(lblTelephone);
		paneTelephone.add(telephone);

		JPanel paneEmail = new JPanel();
		paneEmail.setLayout(new BoxLayout(paneEmail, BoxLayout.PAGE_AXIS));
		paneEmail.add(lblEmail);
		paneEmail.add(email);

		JPanel paneAdresse = new JPanel();
		paneAdresse.setLayout(new BoxLayout(paneAdresse, BoxLayout.PAGE_AXIS));
		paneAdresse.add(lblAdresse);
		paneAdresse.add(adresse);
		
		type.addItem("Chef d'Equipe");
		type.addItem("Membre");
		type.setPreferredSize(new Dimension(130,31));
		JPanel paneType = new JPanel();
		paneType.setLayout(new BoxLayout(paneType, BoxLayout.PAGE_AXIS));
		paneType.add(lblType);
		paneType.add(type);
		
		JPanel paneBtnSave = new JPanel();
	//	paneBtnSave.setLayout(new BorderLayout());
		btnEnregistrer.addActionListener(this);
		btnEnregistrer.setActionCommand("BTNSAVED");
		paneBtnSave.add(btnEnregistrer);
		
		JPanel paneBeforeBtn1 = new JPanel();
		paneBeforeBtn1.setPreferredSize(new Dimension(this.getWidth(),6));
		
		JPanel paneBeforeBtn2 = new JPanel();
		paneBeforeBtn2.setPreferredSize(new Dimension(this.getWidth(),6));
		
		JPanel paneBtnCancel = new JPanel();
//		paneBtnCancel.setLayout(new BorderLayout());
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("BTNCANCEL");
		paneBtnCancel.add(btnCancel);
		
		JPanel paneFormsMember = new JPanel();
		paneFormsMember.setBorder(BorderFactory.createTitledBorder("Informations personnel"));
		paneFormsMember.setLayout(new BoxLayout(paneFormsMember, BoxLayout.LINE_AXIS));
		paneFormsMember.setPreferredSize(new Dimension(520,210));
		
		JPanel paneFormsMemberLeft = new JPanel();
		paneFormsMemberLeft.setLayout(new BoxLayout(paneFormsMemberLeft, BoxLayout.PAGE_AXIS));
		paneFormsMemberLeft.add(paneNom);
		paneFormsMemberLeft.add(panePrenom);
		paneFormsMemberLeft.add(paneTelephone);
		paneFormsMemberLeft.add(paneBeforeBtn1);
		paneFormsMemberLeft.add(paneBtnSave);
		
		JPanel paneFormsMemberCenter = new JPanel();
		paneFormsMemberCenter.setPreferredSize(new Dimension(20,this.getHeight()));
		
		JPanel paneFormsMemberRight = new JPanel();
		paneFormsMemberRight.setLayout(new BoxLayout(paneFormsMemberRight, BoxLayout.PAGE_AXIS));
		paneFormsMemberRight.add(paneEmail);
		paneFormsMemberRight.add(paneAdresse);
		paneFormsMemberRight.add(paneType);
		paneFormsMemberRight.add(paneBeforeBtn2);
		paneFormsMemberRight.add(paneBtnCancel);
		
		paneFormsMember.add(paneFormsMemberLeft);
		paneFormsMember.add(paneFormsMemberCenter);
		paneFormsMember.add(paneFormsMemberRight);
		
		paneAddMember.setLayout(new BorderLayout());
		paneAddMember.add(paneFormsMember, BorderLayout.WEST);
		
		tblMembre = new JTable(modeleMembre);
		tblMembre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paneListMember.setLayout(new BorderLayout());
		paneListMember.setBorder(BorderFactory.createTitledBorder("Liste de Membres"));
		paneListMember.add(new JScrollPane(tblMembre), BorderLayout.CENTER);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(paneAddMember);
		this.add(paneListMember);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("BTNSAVED")) {
			
			int id = 1 + operation.getLastID();
			String nomM = nom.getText();
			String prenomM = prenom.getText();
			String adresseM = adresse.getText();
			String telM = telephone.getText();
			String emailM = email.getText();
			String typeM = (String)type.getSelectedItem();
			
			String login = emailM;
			String password = "123456";
			
			Membre membre = new Membre(id, nomM, prenomM, telM, emailM, adresseM,typeM);
		
			boolean set = operation.setMembre(membre);
			
			if(set)
			{
				String result [] = login.split("@", 2);
				
				boolean setLogin = operation.setLogin(id, result[0], password);
				
				if(setLogin)
				{
					JOptionPane.showMessageDialog(null,"Enregistrement réussi avec succès !","Msg confirmation",JOptionPane.INFORMATION_MESSAGE);
					
					nom.setText("");
					prenom.setText("");
					adresse.setText("");
					telephone.setText("");
					email.setText("");
					type.setSelectedIndex(-1);
					
					modeleMembre.addMembre(membre);
				}
			}
		}
		if(e.getActionCommand().equals("BTNCANCEL")) {
			
			 String[] option ={"OUI","NON"};
			 
			 int choix = JOptionPane.showOptionDialog(null,"Voulez-vous vraiment annuler ?","Confirmation",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
			  if(choix == JOptionPane.OK_OPTION)
			  {
				  nom.setText("");
				  prenom.setText("");
				  adresse.setText("");
				  telephone.setText("");
				  email.setText("");
				  type.setSelectedIndex(-1);

			  }
		}
	}
}
