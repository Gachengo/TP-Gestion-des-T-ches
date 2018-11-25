package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import modele.Operation;

public class MainMain extends JFrame implements ActionListener{
	
	Operation operation = new Operation();
	
	//Les PANNES DE DIFFERENTE FENETRE
	CardLayout cardLayout = new CardLayout();
	
	JPanel pannePrincipal = new JPanel();
	DefaultPanel defaultPanel = new DefaultPanel();
	ModifierMembre panneEditMembre = new ModifierMembre();
	AjouterMembre panneAjouterMembre = new AjouterMembre();
	SupprimerMembre panneSupprimerMembre = new SupprimerMembre();
	ListeMembre panneListeMembre = new ListeMembre();
	NouvelleTache panneNouvelleTache = new NouvelleTache();
	ModifierTache panneEditTache = new ModifierTache();
	SupprimerTache panneDelTask = new SupprimerTache();
	ListeTache panneListTask = new ListeTache();
	AssignerTache panneAssignerTache = new AssignerTache();
	ListeAssignation panneListeAssign = new ListeAssignation();
	Apropos panneApropos = new Apropos();
	
	JMenuBar menubar = new JMenuBar();
	JMenu membre = new JMenu("Membre");
	JMenu tache = new JMenu("Tâche");
	JMenu assignation = new JMenu("Assigner");
	JMenu help = new JMenu("?");
	
	JMenuItem ajouterMembre = new JMenuItem("Ajouter");
	JMenuItem modifierMembre = new JMenuItem("Modifier");
	JMenuItem supprimerMembre = new JMenuItem("Supprimer");
	JMenuItem listeMembre = new JMenuItem("Lister");
	JMenuItem quitter = new JMenuItem("Quitter");
	
	JMenuItem creerTache = new JMenuItem("Créer");
	JMenuItem modifierTache = new JMenuItem("Modifier");
	JMenuItem supprimerTache = new JMenuItem("Supprimer");
	JMenuItem listeTache = new JMenuItem("Lister");
	
	JMenuItem assignerTache = new JMenuItem("Assigner");
	JMenuItem listeAssignation = new JMenuItem("Assignations");
	
	JMenuItem apropos = new JMenuItem("A Propos");
		
	private String typeMembre;
	
	public MainMain(String type) {
		this.typeMembre = type;
		this.setTitle("Gestions des tâches");
		this.setSize(900, 580);
		this.setLocationRelativeTo(null);
		
		this.ajouterMembre.setActionCommand("ADDMEMBER");
		this.ajouterMembre.addActionListener(this);
		
		this.modifierMembre.setActionCommand("EDITMEMBER");
		this.modifierMembre.addActionListener(this);
		
		this.supprimerMembre.setActionCommand("DELETEMEMBER");
		this.supprimerMembre.addActionListener(this);
		
		this.listeMembre.setActionCommand("LISTMEMBER");
		this.listeMembre.addActionListener(this);
		
		this.quitter.setActionCommand("QUITTER");
		this.quitter.addActionListener(this);
		
		this.creerTache.setActionCommand("CREATETASK");
		this.creerTache.addActionListener(this);
		
		this.modifierTache.setActionCommand("EDITTASK");
		this.modifierTache.addActionListener(this);
		
		this.supprimerTache.setActionCommand("DELTASK");
		this.supprimerTache.addActionListener(this);
		
		this.listeTache.setActionCommand("LISTTASK");
		this.listeTache.addActionListener(this);
		
		this.assignerTache.setActionCommand("ASSIGNTASK");
		this.assignerTache.addActionListener(this);
		
		this.listeAssignation.setActionCommand("LISTASSIGN");
		this.listeAssignation.addActionListener(this);
		
		this.apropos.setActionCommand("ABOUT");
		this.apropos.addActionListener(this);
		
		this.membre.add(ajouterMembre);
		this.membre.add(modifierMembre);
		this.membre.add(supprimerMembre);
		this.membre.add(listeMembre);
		this.membre.add(quitter);
		
		this.tache.add(creerTache);
		this.tache.add(modifierTache);
		this.tache.add(supprimerTache);
		this.tache.add(listeTache);
		
		this.assignation.add(assignerTache);
		this.assignation.add(listeAssignation);
		
		this.help.add(apropos);
		
		this.menubar.add(membre);
		this.menubar.add(tache);
		this.menubar.add(assignation);
		this.menubar.add(help);
		
		this.pannePrincipal.setLayout(cardLayout);
		this.pannePrincipal.add(defaultPanel, "DEFAULT");
		this.pannePrincipal.add(panneAjouterMembre, "ADDMEMBER");
		this.pannePrincipal.add(panneEditMembre, "EDITMEMBER");
		this.pannePrincipal.add(panneSupprimerMembre, "DELETEMEMBER");
		this.pannePrincipal.add(panneListeMembre,"LISTMEMBER");
		this.pannePrincipal.add(panneNouvelleTache, "CREATETASK");
		this.pannePrincipal.add(panneEditTache, "EDITTASK");
		this.pannePrincipal.add(panneDelTask, "DELTASK");
		this.pannePrincipal.add(panneListTask, "LISTTASK");
		this.pannePrincipal.add(panneAssignerTache, "ASSIGNTASK");
		this.pannePrincipal.add(panneListeAssign, "LISTASSIGN");
		this.pannePrincipal.add(panneApropos, "ABOUT");
		this.setJMenuBar(menubar);
		this.getContentPane().add(pannePrincipal, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ADDMEMBER")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("EDITMEMBER")) {
		
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("DELETEMEMBER")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("LISTMEMBER")) {
			
			this.cardLayout.show(pannePrincipal,  e.getActionCommand());
		}
		else if(e.getActionCommand().equals("CREATETASK")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("EDITTASK")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("DELTASK")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("LISTTASK")) {
			
			this.cardLayout.show(pannePrincipal,  e.getActionCommand());
		}
		else if(e.getActionCommand().equals("ASSIGNTASK")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("LISTASSIGN")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("ABOUT")) {
			
			this.cardLayout.show(pannePrincipal, e.getActionCommand());
		}
		else if(e.getActionCommand().equals("QUITTER")) {
			
			Connexion connexion = new Connexion();
			
			connexion.setVisible(true);
			
			dispose();
		}
	}

}
