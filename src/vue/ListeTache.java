package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controleur.ModeleTableTache;
import modele.Operation;

public class ListeTache extends JPanel implements ActionListener{
	
	Operation operation = new Operation();
	ModeleTableTache modeleTache = new ModeleTableTache();
	JTable tblTache;
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JTextField textSearch = new JTextField();
	JButton btnSearch = new JButton();
	
	public ListeTache() {
		
		this.setLayout(new BorderLayout());
		btnSearch.setText("RECHERCHER");
		btnSearch.setActionCommand("SEARCH");
		btnSearch.addActionListener(this);
		
		JPanel panneSearch = new JPanel();
		panneSearch.setLayout(new BoxLayout(panneSearch,BoxLayout.LINE_AXIS));
		panneSearch.setPreferredSize(new Dimension(400, 28));
		panneSearch.add(textSearch);
		panneSearch.add(btnSearch);
		
		panel1.setLayout(new BorderLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Liste de Tâches"));
		panel1.add(panneSearch, BorderLayout.EAST);
			
		tblTache = new JTable(modeleTache);
		tblTache.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel2.setLayout(new BorderLayout());
		panel2.add(new JScrollPane(tblTache), BorderLayout.CENTER);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("SEARCH")) {
			
			
		}
	}
}
