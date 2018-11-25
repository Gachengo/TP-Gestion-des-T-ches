package controleur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.Operation;

public class ModeleTableMembre extends AbstractTableModel{

	Operation operation = new Operation();
	private final List<Membre> membres = new ArrayList<Membre>();
	private final String entete[] = {"N°", "Nom", "Prénom", "Téléphone", "E-mail", "Adresse", "Type"};
	
	public ModeleTableMembre() {
		super();
		
		Object [][] data = (Object[][]) operation.getListeMembre();
		
		for(int i = 0; i <= data.length -1 ; i++)
		{
			int id = (int) data[i][0];
			String nom = (String) data[i][1];
			String prenom = (String) data[i][2];
			String tel = (String) data[i][3];
			String email = (String) data[i][4];
			String adresse = (String) data[i][5];
			String type = (String) data[i][6];
			
			membres.add(new Membre(id,nom,prenom,tel,email,adresse,type));	
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return membres.size();
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
			return membres.get(rowIndex).getId();
		case 1:
			return membres.get(rowIndex).getNom();
		case 2:
			return membres.get(rowIndex).getPrenom();
		case 3:
			return membres.get(rowIndex).getTel();
		case 4:
			return membres.get(rowIndex).getEmail();
		case 5:
			return membres.get(rowIndex).getAdresse();
		case 6:
			return membres.get(rowIndex).getType();
		default:
			return null;
		}
	}
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}
	public void addMembre(Membre ami) {
		membres.add(ami);
		
		fireTableRowsInserted(membres.size() -1 ,membres.size() -1);
	}
	public void replaceMembre(Membre membre, int indexRow) {
		
		membres.add(indexRow, membre);
		
		fireTableRowsUpdated(indexRow , indexRow);
	}
	public void removeMembre(int rowIndex){
		membres.remove(rowIndex);
		
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	public void setValuAt(Object value, int row, int col) {
		
		
	}
	public void updateMembre(Membre membre, int rowIndex) {
		//Modification d'un Membre
		
		for(int i = 1; i <= getColumnCount(); i++) {
			
			fireTableCellUpdated(rowIndex,i);
		}
	}
}
