package controleur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Operation;

public class ModeleTableTache extends AbstractTableModel{

	Operation operation = new Operation();
	private final List<Tache> taches = new ArrayList<Tache>();
	private final String entete[] = {"N°", "Désignation", "Description", "Date début", "Date fin", "Etat"};
	
	public ModeleTableTache() {
		super();
		
		Object [][] data = (Object[][]) operation.getListeTache();
		
		for(int i = 0; i <= data.length -1 ; i++)
		{
			int id = (int) data[i][0];
			String designation = (String) data[i][1];
			String description = (String) data[i][2];
			String dateDebut = (String) data[i][3];
			String dateFin =  (String) data[i][4];
			String etat = (String) data[i][5];
			
			taches.add(new Tache(id,designation,description,dateDebut,dateFin,etat));	
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return taches.size();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entete.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0:
			return taches.get(rowIndex).getId();
		case 1:
			return taches.get(rowIndex).getDesignation();
		case 2:
			return taches.get(rowIndex).getDescription();
		case 3:
			return taches.get(rowIndex).getDateDebut();
		case 4:
			return taches.get(rowIndex).getDateFin();
		case 5:
			return taches.get(rowIndex).getEtat();
		default:
			return null;
		}
	}
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}
	public void addTache(Tache tache) {
		taches.add(tache);
		
		fireTableRowsInserted(taches.size() -1 ,taches.size() -1);
	}
	public void replaceTache(Tache tache, int indexRow) {
		
		taches.add(indexRow, tache);
		
		fireTableRowsUpdated(indexRow , indexRow);
	}
	public void removeTache(int rowIndex){
		taches.remove(rowIndex);
		
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	public void setValuAt(Object value, int row, int col) {
		//
	}
	public void updateMembre(Membre membre, int rowIndex) {
		//Modification d'un Membre
		
		for(int i = 1; i <= getColumnCount(); i++) {
			
			fireTableCellUpdated(rowIndex,i);
		}
	}
}
