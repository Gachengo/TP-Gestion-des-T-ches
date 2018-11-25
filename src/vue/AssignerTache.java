package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controleur.Assignation;
import controleur.ModeleTableAssignation;
import controleur.ModeleTableTache;
import controleur.Tache;
import modele.Operation;

public class AssignerTache extends JPanel implements ActionListener{
	
	Operation operation = new Operation();
	ModeleTableAssignation modeleAssignation = new ModeleTableAssignation();
	JTable tableAssignation;
	
	JLabel lblid;
	JTextField txtid;
	
	JLabel lbldesignation;
	JComboBox txtdesignation;
	
	JLabel lbldescription;
	JTextField txtdescription;
	
	JLabel lbldatedebut;
	JDateChooser dateDebut;
		
	JLabel lbldatefin;
	JDateChooser dateFin;
	
	JLabel lbletat;
	JComboBox cmbetat;
	
	
	JLabel lblidMembre;
	JTextField txtidMembre;
	
	JLabel lblMembre;
	JComboBox cmbMembre;
	
	JLabel lbltel;
	JTextField txttel;
	
	JLabel lblemail;
	JTextField txtemail;
	
	JLabel lbladresse;
	JTextField txtadresse;
	
	JLabel lbltype;
	JTextField txttype;
	
	JButton btnsave;
	
	public AssignerTache() {
		   
		lblid = new JLabel("ID Tâche : ");
		txtid = new JTextField();
		txtid.setEnabled(false);
		JPanel paneIdentifiant = new JPanel();
		paneIdentifiant.setLayout(new BoxLayout(paneIdentifiant, BoxLayout.PAGE_AXIS));
		paneIdentifiant.add(lblid);
		paneIdentifiant.add(txtid);
		
		lbldesignation = new JLabel("Désignation : ");
		txtdesignation = new JComboBox();
		txtdesignation.addItem("Choisir la tâche");
		txtdesignation.addActionListener(this);
		txtdesignation.setActionCommand("DESIGNATION");
		Object [][] tache = (Object[][]) operation.getListeTacheNonAssigner();
		for(int i = 0; i <= tache.length -1; i++) {
			
			txtdesignation.addItem(tache[i][0]);
		}
		JPanel panedesignation = new JPanel();
		panedesignation.setLayout(new BoxLayout(panedesignation, BoxLayout.PAGE_AXIS));
		panedesignation.add(lbldesignation);
		panedesignation.add(txtdesignation);
		
		lbldescription = new JLabel("Description : ");
		txtdescription = new JTextField();
		txtdescription.setEnabled(false);
		JPanel panedescription = new JPanel();
		panedescription.setLayout(new BoxLayout(panedescription, BoxLayout.PAGE_AXIS));
		panedescription.add(lbldescription);
		panedescription.add(txtdescription);
		
		lbldatedebut = new JLabel("Date début : ");
		dateDebut = new JDateChooser();
		dateDebut.setEnabled(false);
		dateDebut.setDateFormatString("yyyy-MM-dd");
		JPanel panedatedebut = new JPanel();
		panedatedebut.setLayout(new BoxLayout(panedatedebut, BoxLayout.PAGE_AXIS));
		panedatedebut.add(lbldatedebut);
		panedatedebut.add(dateDebut);
		
		lbldatefin = new JLabel("Date Fin : ");
		dateFin = new JDateChooser();
		dateFin.setEnabled(false);
		dateFin.setDateFormatString("yyyy-MM-dd");
		JPanel panedatefin = new JPanel();
		panedatefin.setLayout(new BoxLayout(panedatefin, BoxLayout.PAGE_AXIS));
		panedatefin.add(lbldatefin);
		panedatefin.add(dateFin);

		lbletat = new JLabel("Etat : ");
		cmbetat = new JComboBox();
		cmbetat.addItem("Choisir état");
		cmbetat.addItem("Initial");
		cmbetat.addItem("Encours");
		cmbetat.addItem("Arrêt temporaire");
		cmbetat.addItem("Achevée");
		JPanel paneetat = new JPanel();
		paneetat.setLayout(new BoxLayout(paneetat, BoxLayout.PAGE_AXIS));
		paneetat.add(lbletat);
		paneetat.add(cmbetat);
		
				
		JPanel paneTache = new JPanel();
        paneTache.setLayout(new BoxLayout(paneTache, BoxLayout.PAGE_AXIS));
        paneTache.setPreferredSize(new Dimension(280, 330));
        paneTache.setBorder(BorderFactory.createTitledBorder("Tâche"));
        paneTache.add(paneIdentifiant);
        paneTache.add(panedesignation);
        paneTache.add(panedescription);
        paneTache.add(panedatedebut);
        paneTache.add(panedatefin);
        paneTache.add(paneetat);
        
        btnsave = new JButton("Assigner");
		btnsave.addActionListener(this);
		btnsave.setActionCommand("ASSIGNER");
		JPanel panebtn = new JPanel();
		panebtn.add(btnsave);

		lblidMembre = new JLabel("ID Membre : ");
		txtidMembre = new JTextField();
		txtidMembre.setEnabled(false);
		JPanel paneIdMembre = new JPanel();
		paneIdMembre.setLayout(new BoxLayout(paneIdMembre,BoxLayout.PAGE_AXIS));
		paneIdMembre.add(lblidMembre);
		paneIdMembre.add(txtidMembre);
		
		lblMembre = new JLabel("Membre : ");
		cmbMembre = new JComboBox();
		cmbMembre.addItem("Choisir Membre");
		cmbMembre.setActionCommand("MEMBRE");
		cmbMembre.addActionListener(this);
		Object [][] membre = (Object[][]) operation.getListeMembre();
		for(int i = 1; i <= membre.length - 1; i++) {
			cmbMembre.addItem(membre[i][1] +" "+membre[i][2]);
		}
		JPanel paneNomMembre = new JPanel();
		paneNomMembre.setLayout(new BoxLayout(paneNomMembre,  BoxLayout.PAGE_AXIS));
		paneNomMembre.add(lblMembre);
		paneNomMembre.add(cmbMembre);
		
		lbltel = new JLabel("Téléphone : ");
		txttel = new JTextField();
		txttel.setEnabled(false);
		JPanel paneTelMembre = new JPanel();
		paneTelMembre.setLayout(new BoxLayout(paneTelMembre, BoxLayout.PAGE_AXIS));
		paneTelMembre.add(lbltel);
		paneTelMembre.add(txttel);
		
		lblemail = new JLabel("E-mail : ");
		txtemail = new JTextField();
		txtemail.setEnabled(false);
		JPanel paneEmailMembre = new JPanel();
		paneEmailMembre.setLayout(new BoxLayout(paneEmailMembre, BoxLayout.PAGE_AXIS));
		paneEmailMembre.add(lblemail);
		paneEmailMembre.add(txtemail);

		lbladresse = new JLabel("Adresse : ");
		txtadresse = new JTextField();
		txtadresse.setEnabled(false);
		JPanel paneAdresseMembre = new JPanel();
		paneAdresseMembre.setLayout(new BoxLayout(paneAdresseMembre, BoxLayout.PAGE_AXIS));
		paneAdresseMembre.add(lbladresse);
		paneAdresseMembre.add(txtadresse);
		
		lbltype = new JLabel("Type : ");
		txttype = new JTextField();
		txttype.setEnabled(false);
		JPanel paneType = new JPanel();
		paneType.setLayout(new BoxLayout(paneType, BoxLayout.PAGE_AXIS));
		paneType.add(lbltype);
		paneType.add(txttype);
		
		JPanel paneMembre = new JPanel();
		paneMembre.setLayout(new BoxLayout(paneMembre, BoxLayout.PAGE_AXIS));
		paneMembre.setPreferredSize(new Dimension(280, 330));
		paneMembre.setBorder(BorderFactory.createTitledBorder("Membre"));
		paneMembre.add(paneIdMembre);
		paneMembre.add(paneNomMembre);
		paneMembre.add(paneTelMembre);
		paneMembre.add(paneEmailMembre);
		paneMembre.add(paneAdresseMembre);
		paneMembre.add(paneType);
		
        JPanel paneAssigner = new JPanel();
        paneAssigner.setLayout(new BorderLayout());
        paneAssigner.add(paneTache, BorderLayout.WEST);
        paneAssigner.add(panebtn, BorderLayout.CENTER);
        paneAssigner.add(paneMembre, BorderLayout.EAST);
        
        JPanel paneAssignation =  new JPanel();
        tableAssignation = new JTable(modeleAssignation);
        tableAssignation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        paneAssignation.setLayout(new BorderLayout());
        paneAssignation.setBorder(BorderFactory.createTitledBorder("Tâches"));
        paneAssignation.add(new JScrollPane(tableAssignation), BorderLayout.CENTER);
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(paneAssigner);
        this.add(paneAssignation);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ASSIGNER")) {
			
			int idTache;
			int idMembre;
			
			int error = 2;
			
			if(! this.txtid.getText().equals("")) {
				
				idTache = Integer.parseInt(this.txtid.getText());
				error--;
			}
			else {
				
				JOptionPane.showMessageDialog(null,"Veuillez choisir une tâche à assigner !","Msg error",JOptionPane.INFORMATION_MESSAGE);

				return ;
			}
			if(! this.txtidMembre.getText().equals("")) {
				
				idMembre = Integer.parseInt(this.txtid.getText());
				error--;
			}
			else {
				JOptionPane.showMessageDialog(null,"Veuillez choisir un membre qui va travailler sur la tâche !","Msg error",JOptionPane.INFORMATION_MESSAGE);

				return ;
			}
			if(error == 0) {
				
				boolean set = operation.setAssignation(idTache, idMembre);
				
				if(set) {
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String tache = (String)this.txtdesignation.getSelectedItem();
					String membre = (String)this.cmbMembre.getSelectedItem();
					String dateAssignation = df.format(this.dateDebut.getDate());
					String dateD = df.format(this.dateDebut.getDate());		
					String dateF = df.format(this.dateFin.getDate());
					String etat = (String)this.cmbetat.getSelectedItem();
					
					Assignation assign = new Assignation(idTache,tache, membre, dateAssignation,dateD, dateF, etat);
					
					modeleAssignation.addAssignation(assign);
					
					JOptionPane.showMessageDialog(null,"Assignation effectuée avec succès !","Msg confirm",JOptionPane.INFORMATION_MESSAGE);
					
					this.txtdesignation.removeItem(tache);
					this.txtdesignation.setSelectedIndex(0);
					this.cmbMembre.setSelectedIndex(0);
				}
			}
			
		}
		else if(e.getActionCommand().equals("DESIGNATION")) {
			
			String designation = (String)txtdesignation.getSelectedItem();
			
			Object [][] tache = (Object[][]) operation.getInfoTacheByDesignation(designation);
			
			this.txtid.setText((String)tache[0][0]);
			this.txtdescription.setText((String) tache[0][2]);
			this.dateDebut.setDate((Date)tache[0][3]);
			this.dateFin.setDate((Date)tache[0][4]);
			this.cmbetat.setSelectedItem(tache[0][5]);
			
		}
		else if(e.getActionCommand().equals("MEMBRE")) {
			
			String nomprenom = (String)cmbMembre.getSelectedItem();
			
		    String result[]	= nomprenom.split(" ", 2);
						
			Object [][] membre = (Object[][]) operation.getInfoMembreByNom(result[0], result[1]);
			
			this.txtidMembre.setText((String) membre[0][0]);
			this.txttel.setText((String) membre[0][3]);
			this.txtemail.setText((String) membre[0][4]);
			this.txtadresse.setText((String) membre[0][5]);
			this.txttype.setText((String) membre[0][6]);
			
		}
		
	}
}
