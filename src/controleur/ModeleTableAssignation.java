package controleur;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Operation;

public class ModeleTableAssignation extends AbstractTableModel{

	Operation operation = new Operation();
	private final List<Assignation> assignation = new ArrayList<Assignation>();
	private final String entete[] = {"ID TACHE", "TACHE", "MEMBRE", "DATE ASSIGNATION", "DATE DEBUT", "DATE FIN", "ETAT"};
	
	public ModeleTableAssignation() {
		super();
		
		Object [][] data = (Object[][]) operation.getListeAssignation();
		
		for(int i = 0; i <= data.length -1 ; i++)
		{
			int idTache = (int) data[i][0];
			String tache = (String) data[i][1];
			String membre = (String) data[i][2] +" "+ (String)data[i][3];
			String dateAssignation = (String) data[i][4];
			String dateDebut =  (String) data[i][5];
			String dateFin = (String) data[i][6];
			String etat = (String) data[i][7];
			
			assignation.add(new Assignation(idTache, tache,membre,dateAssignation,dateDebut,dateFin,etat));	
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return assignation.size();
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
			return assignation.get(rowIndex).getIdTache();
		case 1:
			return assignation.get(rowIndex).getTache();
		case 2:
			return assignation.get(rowIndex).getMembre();
		case 3:
			return assignation.get(rowIndex).getDateAssignation();
		case 4:
			return assignation.get(rowIndex).getDateDebut();
		case 5:
			return assignation.get(rowIndex).getDateFin();
		case 6:
			return assignation.get(rowIndex).getEtat();
		default:
			return null;
		}
	}
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}
	public void addAssignation(Assignation assign) {
		assignation.add(assign);
		
		fireTableRowsInserted(assignation.size() -1 ,assignation.size() -1);
	}
	public void replaceAssignation(Assignation assign, int indexRow) {
		
		assignation.add(indexRow, assign);
		
		fireTableRowsUpdated(indexRow , indexRow);
	}
	public void removeAssignation(int rowIndex){
		assignation.remove(rowIndex);
		
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
