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

public class SupprimerTache extends JPanel implements ActionListener{
	
	Operation operation = new Operation();
	ModeleTableTache modeleTache = new ModeleTableTache();
	JTable tblTache;
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JLabel label1 =  new JLabel();
	JTextField textSearch = new JTextField();
	JButton btnSearch = new JButton();
	JButton btnDel = new JButton();
	
	public SupprimerTache() {
		
		this.setLayout(new BorderLayout());
		btnSearch.setText("RECHERCHER");
		btnSearch.setActionCommand("RECHERCHER");
		btnSearch.addActionListener(this);
		
		JPanel panneSearch = new JPanel();
		panneSearch.setLayout(new BoxLayout(panneSearch,BoxLayout.LINE_AXIS));
		panneSearch.setPreferredSize(new Dimension(400, this.getHeight()));
		panneSearch.add(textSearch);
		panneSearch.add(btnSearch);
		
		btnDel.setText("DELETE");
		btnDel.setActionCommand("DELETE");
		btnDel.addActionListener(this);
		
		panel1.setLayout(new BorderLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Rechercher une tâche"));
		panel1.add(panneSearch, BorderLayout.WEST);
		panel1.add(btnDel, BorderLayout.EAST);
			
		tblTache = new JTable(modeleTache);
		tblTache.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Selectionner une tâche"));
		panel2.add(new JScrollPane(tblTache), BorderLayout.CENTER);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("DELETE")) {
			
			int [] selection =  tblTache.getSelectedRows();
			
			if(selection.length < 1)
			{
				JOptionPane.showMessageDialog(null,"Veuillez selectionnez une ligne à modifier! ","Msg Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				for(int i = selection.length -1; i >= 0; i--) {
					
					String[] option ={"OUI","NON"};
					
					int choix = JOptionPane.showOptionDialog(null,"Voulez-vous vraiment supprimer " + selection.length + " élement ?","Msg confirm",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
					
					if(choix == JOptionPane.OK_OPTION)
					{
						int id = (int)modeleTache.getValueAt(selection[i], 0);
						
						boolean delete = operation.deleteTache(id);
						
						if(delete)
						{
							System.out.println(modeleTache.getValueAt(selection[i], 4));
						
							modeleTache.removeTache(selection[i]);
						}
					}
				}

			}

		}
	}

}
