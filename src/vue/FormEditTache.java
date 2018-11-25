package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.toedter.calendar.JDateChooser;

import controleur.Membre;
import controleur.Tache;
import modele.Operation;

public class FormEditTache extends JDialog implements ActionListener{

	ModifierTache paneparent = new ModifierTache();
	Operation operation = new Operation();
	ModifierTache editTache = new ModifierTache();
	
	JLabel lbldesignation;
	JTextField txtdesignation;
	
	JLabel lbldescription;
	JTextField txtdescription;
	
	JLabel lbldateDebut;
	JDateChooser txtdateDebut;
	
	JLabel lbldateFin;
	JDateChooser txtdateFin;
	
	JLabel lbletat;
	JComboBox txtetat;

	JButton btnsave;
	JButton btncancel;
	
	private int colonne;
	private int ligne;
	private int id;
	
	public FormEditTache(JFrame parent, String titre, boolean modal, int colonne, int ligne, ModifierTache paneparent) {
		super(parent, titre, modal);
		
		this.paneparent = paneparent;
		this.colonne = colonne;
		this.ligne = ligne;
		this.setSize(260,320);
		this.setLocationRelativeTo(null);
		
		Object [][] infoTache = (Object[][]) operation.getInfoTache(colonne);
		
		JPanel panneFirst = new JPanel();
		panneFirst.setPreferredSize(new Dimension(this.getWidth(),15));
		
		this.id = (int) infoTache[0][0];
		
		lbldesignation = new JLabel("Designation :");
		txtdesignation = new JTextField();
		txtdesignation.setText((String)infoTache[0][1]);
		
		JPanel panneDesignation = new JPanel();
		panneDesignation.setLayout(new BoxLayout(panneDesignation, BoxLayout.PAGE_AXIS));
		panneDesignation.add(lbldesignation);
		panneDesignation.add(txtdesignation);
		
		lbldescription = new JLabel("Description :");
		txtdescription = new JTextField();
		txtdescription.setText((String)infoTache[0][2]);
		
		JPanel panneDescription = new JPanel();
		panneDescription.setLayout(new BoxLayout(panneDescription, BoxLayout.PAGE_AXIS));
		panneDescription.add(lbldescription);
		panneDescription.add(txtdescription);
		
		lbldateDebut = new JLabel("Date début :");
		txtdateDebut = new JDateChooser();
		txtdateDebut.setDateFormatString("yyyy-MM-dd");
		txtdateDebut.setDate((Date) infoTache[0][3]);
		
		JPanel panneDateDebut = new JPanel();
		panneDateDebut.setLayout(new BoxLayout(panneDateDebut, BoxLayout.PAGE_AXIS));
		panneDateDebut.add(lbldateDebut);
		panneDateDebut.add(txtdateDebut);
		
		lbldateFin = new JLabel("Date fin :");
		txtdateFin = new JDateChooser();
		txtdateFin.setDateFormatString("yyyy-MM-dd");
		txtdateFin.setDate((Date)infoTache[0][4]);
		
		JPanel panneDateFin = new JPanel();
		panneDateFin.setLayout(new BoxLayout(panneDateFin, BoxLayout.PAGE_AXIS));
		panneDateFin.add(lbldateFin);
		panneDateFin.add(txtdateFin);
		
		lbletat = new JLabel("Etat :");
		txtetat = new JComboBox();
		txtetat.addItem("Inittial");
		txtetat.addItem("Encours");
		txtetat.addItem("Arrêt temporaire");
		txtetat.addItem("Achevée");
		txtetat.setSelectedItem((String)infoTache[0][5]);
		
		JPanel panneEtat = new JPanel();
		panneEtat.setLayout(new BoxLayout(panneEtat, BoxLayout.PAGE_AXIS));
		panneEtat.add(lbletat);
		panneEtat.add(txtetat);
		
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
		panneContent.add(panneDesignation);
		panneContent.add(panneDescription);
		panneContent.add(panneDateDebut);
		panneContent.add(panneDateFin);
		panneContent.add(panneEtat);
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
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			String designation = "";
			String description = "";
			String dateD = "";
			String dateF = "";
			String etat = "";
			
			int error = 5;
			
			if(txtdesignation.getText() != "") {
			
				designation = txtdesignation.getText();
				error--;
			}
			if(txtdescription.getText() != "") {
				
				description = txtdescription.getText();
				error--;
			}
			if(! txtdateDebut.getDate().equals(null)) {
				
				dateD = df.format(txtdateDebut.getDate());
				error--;
			}
			if(! txtdateFin.getDate().equals(null)) {
				
				dateF = df.format(txtdateFin.getDate());
				error--;
			}
			if(txtetat.getSelectedItem() != "") {
				
				etat = (String)txtetat.getSelectedItem();
				error--;
			}
			if(error == 0)
			{
				Tache tache = new Tache(this.id, designation, description, dateD, dateF, etat);
				
				boolean update = operation.updateTache(tache);
				
				if(update) {
				
					dispose();
					
					JOptionPane.showMessageDialog(null,"Modifications appliquées avec succès ! ","Msg confirmation",JOptionPane.INFORMATION_MESSAGE);
						
					paneparent.modeleTache.removeTache(ligne);
					
					paneparent.modeleTache.replaceTache(tache, ligne);
					
				}
			}
		}
	}

}
