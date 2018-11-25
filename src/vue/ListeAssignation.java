package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controleur.ModeleTableAssignation;
import modele.Operation;

public class ListeAssignation extends JPanel implements ActionListener{
	
	Operation operation = new Operation();
	ModeleTableAssignation modeleAssignation = new ModeleTableAssignation();
	JTable tableAssignation;
	
	
	
	public ListeAssignation() {
		   
		        
        JPanel paneAssignation =  new JPanel();
        tableAssignation = new JTable(modeleAssignation);
        tableAssignation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        paneAssignation.setLayout(new BorderLayout());
        paneAssignation.setBorder(BorderFactory.createTitledBorder("Tâches"));
        paneAssignation.add(new JScrollPane(tableAssignation), BorderLayout.CENTER);
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(paneAssignation);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ASSIGNER")) {
			
		}
	}
}
