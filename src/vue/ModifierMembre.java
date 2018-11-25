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

public class ModifierMembre extends JPanel implements ActionListener{
	
	ModifierMembre parent;
	Operation operation = new Operation();
	ModeleTableMembre modeleMembre = new ModeleTableMembre();
	JTable tblMembre;
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JLabel label1 =  new JLabel();
	JTextField textSearch = new JTextField();
	JButton btnSearch = new JButton();
	JButton btnEdit = new JButton();
	
	public ModifierMembre() {
		
		this.parent = this;
		this.setLayout(new BorderLayout());
		btnSearch.setText("RECHERCHER");
		btnSearch.addActionListener(this);
		
		JPanel panneSearch = new JPanel();
		panneSearch.setLayout(new BoxLayout(panneSearch,BoxLayout.LINE_AXIS));
		panneSearch.setPreferredSize(new Dimension(400, this.getHeight()));
		panneSearch.add(textSearch);
		panneSearch.add(btnSearch);
		
		btnEdit.setText("MODIFIER");
		btnEdit.setActionCommand("MODIFIER");
		btnEdit.addActionListener(this);
		
		panel1.setLayout(new BorderLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Rechercher un membre à modifer"));
		panel1.add(panneSearch, BorderLayout.WEST);
		panel1.add(btnEdit, BorderLayout.EAST);
			
		tblMembre = new JTable(modeleMembre);
		tblMembre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(BorderFactory.createTitledBorder("Selectionner un membre à modifier"));
		panel2.add(new JScrollPane(tblMembre), BorderLayout.CENTER);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("MODIFIER")) {
			
			int [] selection =  tblMembre.getSelectedRows();
			
			if(selection.length < 1)
			{
				JOptionPane.showMessageDialog(null,"Veuillez selectionnez une ligne à modifier! ","Msg Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				for(int i = selection.length -1; i >= 0; i--) {
		
					String email = modeleMembre.getValueAt(selection[i], 4).toString();
					
					int ligne = selection[0];
							
					FormEditMember formEdit = new FormEditMember(null, "Modification", true, email, ligne, parent);
					
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
