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

import controleur.ModeleTableMembre;
import modele.Operation;

public class SupprimerMembre extends JPanel implements ActionListener{
	
	Operation operation = new Operation();
	ModeleTableMembre modeleMembre = new ModeleTableMembre();
	JTable tblMembre;
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JLabel label1 =  new JLabel();
	JTextField textSearch = new JTextField();
	JButton btnSearch = new JButton();
	JButton btnDelete = new JButton();
	
	public SupprimerMembre() {
		
		this.setLayout(new BorderLayout());
		btnSearch.setText("RECHERCHER");
		btnSearch.setActionCommand("RECHERCHER");
		btnSearch.addActionListener(this);
		
		JPanel panneSearch = new JPanel();
		panneSearch.setLayout(new BoxLayout(panneSearch,BoxLayout.LINE_AXIS));
		panneSearch.setPreferredSize(new Dimension(400, this.getHeight()));
		panneSearch.add(textSearch);
		panneSearch.add(btnSearch);
		
		btnDelete.setText("SUPPRIMER");
		btnDelete.setActionCommand("SUPPRIMER");
		btnDelete.addActionListener(this);
		
		panel1.setLayout(new BorderLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Rechercher un membre à supprimer"));
		panel1.add(panneSearch, BorderLayout.WEST);
		panel1.add(btnDelete, BorderLayout.EAST);
			
		tblMembre = new JTable(modeleMembre);
		tblMembre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Selectionner un membre"));
		panel2.add(new JScrollPane(tblMembre), BorderLayout.CENTER);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("SUPPRIMER")) {
			
			int [] selection =  tblMembre.getSelectedRows();
			
			if(selection.length < 1)
			{
				JOptionPane.showMessageDialog(null,"Veuillez selectionnez une ligne à supprimer! ","Msg Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				for(int i = selection.length -1; i >= 0; i--) {
					
					String[] option ={"OUI","NON"};
					
					int choix = JOptionPane.showOptionDialog(null,"Voulez-vous vraiment supprimer " + selection.length + " élement ?","Msg confirm",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
					
					if(choix == JOptionPane.OK_OPTION)
					{
						String email = (String)modeleMembre.getValueAt(selection[i], 4);
						
						boolean delete = operation.deleteMembre(email);
						
						if(delete)
						{
							System.out.println(modeleMembre.getValueAt(selection[i], 4));
						
							modeleMembre.removeMembre(selection[i]);
						}
					}
				}
			}
		}
		else if(e.getActionCommand().equals("RECHERCHER")) {

			String motcles = textSearch.getText();
			
			String result[]	= motcles.split(" ", 2);
	
			for(int i = 0; i <= result.length - 1; i++) {
				
				System.out.println(result[i]);
			}
		}
	}
}
