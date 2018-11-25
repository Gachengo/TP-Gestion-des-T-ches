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

import controleur.ModeleTableTache;
import controleur.Tache;
import modele.Operation;

public class NouvelleTache extends JPanel implements ActionListener{
	
	Operation operation = new Operation();
	ModeleTableTache modeleTache = new ModeleTableTache();
	JTable tableTache;
	
	JLabel lbldesignation;
	JTextField txtdesignation;
	JLabel lbldescription;
	JTextField txtdescription;
	
	JLabel lbldatedebut;
	JDateChooser dateDebut;
		
	JLabel lbldatefin;
	JDateChooser dateFin;
	
	JLabel lbletat;
	JComboBox cmbetat;
	
	JButton btnsave;
	public NouvelleTache() {
		   //Date livraison du Document
		
		lbldesignation = new JLabel("Désignation : ");
		txtdesignation = new JTextField();
		JPanel pannedesignation = new JPanel();
		pannedesignation.setLayout(new BoxLayout(pannedesignation, BoxLayout.PAGE_AXIS));
		pannedesignation.add(lbldesignation);
		pannedesignation.add(txtdesignation);
		
		lbldescription = new JLabel("Description : ");
		txtdescription = new JTextField();
		JPanel pannedescription = new JPanel();
		pannedescription.setLayout(new BoxLayout(pannedescription, BoxLayout.PAGE_AXIS));
		pannedescription.add(lbldescription);
		pannedescription.add(txtdescription);
		
		lbldatedebut = new JLabel("Date début : ");
		dateDebut = new JDateChooser();
		dateDebut.setDateFormatString("yyyy-MM-dd");
		
		JPanel pannedatedebut = new JPanel();
		pannedatedebut.setLayout(new BoxLayout(pannedatedebut, BoxLayout.PAGE_AXIS));
		pannedatedebut.add(lbldatedebut);
		pannedatedebut.add(dateDebut);
		
		lbldatefin = new JLabel("Date Fin : ");
		dateFin = new JDateChooser();
		dateFin.setDateFormatString("yyyy-MM-dd");
		
		JPanel pannedatefin = new JPanel();
		pannedatefin.setLayout(new BoxLayout(pannedatefin, BoxLayout.PAGE_AXIS));
		pannedatefin.add(lbldatefin);
		pannedatefin.add(dateFin);

		lbletat = new JLabel("Etat : ");
		cmbetat = new JComboBox();
		cmbetat.addItem("Inittial");
		cmbetat.addItem("Encours");
		cmbetat.addItem("Arrêt temporaire");
		cmbetat.addItem("Achevée");
		JPanel panneetat = new JPanel();
		panneetat.setLayout(new BoxLayout(panneetat, BoxLayout.PAGE_AXIS));
		panneetat.add(lbletat);
		panneetat.add(cmbetat);
		
		btnsave = new JButton("Enregistrer");
		btnsave.addActionListener(this);
		btnsave.setActionCommand("SAVE");
		JPanel pannebtn = new JPanel();
		pannebtn.add(btnsave);
		
		JPanel panneContent = new JPanel();
		
        panneContent.setLayout(new BoxLayout(panneContent, BoxLayout.PAGE_AXIS));
        panneContent.setPreferredSize(new Dimension(280, 330));
        panneContent.setBorder(BorderFactory.createTitledBorder("AJOUT D'UNE TACHE"));
        panneContent.add(pannedesignation);
        panneContent.add(pannedescription);
        panneContent.add(pannedatedebut);
        panneContent.add(pannedatefin);
        panneContent.add(panneetat);
        panneContent.add(pannebtn);
        JPanel panneContentContent = new JPanel();
  //      panneContentContent.setBorder(BorderFactory.createLineBorder(Color.red));
        panneContentContent.setLayout(new BorderLayout());
        panneContentContent.add(panneContent, BorderLayout.WEST);
        
        JPanel panneContentTable =  new JPanel();
        tableTache = new JTable(modeleTache);
        tableTache.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panneContentTable.setLayout(new BorderLayout());
        panneContentTable.setBorder(BorderFactory.createTitledBorder("Tâches"));
        panneContentTable.add(new JScrollPane(tableTache), BorderLayout.CENTER);
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(panneContentContent);
        this.add(panneContentTable);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("SAVE")) {
				
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			int id = 1 + operation.getLastIdTache();
			String designation = "";
			String description = "";
			String dateDebutDate = "";
			String dateFinDate = "";
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
			if(! dateDebut.equals(null)) {
				
				dateDebutDate = df.format(dateDebut.getDate());
				error--;
			}
			if(! dateFin.equals(null)) {
				
				dateFinDate = df.format(dateFin.getDate());
				error--;
			}
			if(! cmbetat.getSelectedItem().equals(null)) {
				
				etat = (String) cmbetat.getSelectedItem();
				error--;
			}
			if(error == 0) {
				
				Tache tache = new Tache(id, designation, description, dateDebutDate, dateFinDate, etat);
				
				boolean set = operation.setTache(tache);
				
				if(set) {
					
					txtdesignation.setText("");
					txtdescription.setText("");
					dateDebut.cleanup();
					dateFin.cleanup();;
					cmbetat.setSelectedIndex(-1);;
					
					JOptionPane.showMessageDialog(null,"Enregistrement réussi avec succès ! ","Msg enregistrement",JOptionPane.INFORMATION_MESSAGE);
					
					modeleTache.addTache(tache);
				}
			}
		}
	}
}
