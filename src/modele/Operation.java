package modele;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import controleur.ConnexionMembre;
import controleur.Membre;
import controleur.Tache;

public class Operation {
		
	 static Connection connection = connectionJM();
	 static ResultSet resultat;
	 Statement statement;
	 static PreparedStatement preparestatement;

	public static Connection connectionJM()
	{
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  String url ="jdbc:mysql://127.0.0.1:3306/gestionDetaches";
		  String user ="root";
		  String mdp ="";
	
	 	  connection = (Connection) DriverManager.getConnection(url,user,mdp);
	 	  
	 	 // System.out.println("Connexion reussie !");
	 
	 }catch(Exception e){
	 
	       JOptionPane.showMessageDialog(null, "La connexion à  la base de données à échouer:\n Veuillez contacter l'administrateur système.");
	 }
	  		return connection;
	 }
	 public ResultSet connecte_membre(ConnexionMembre con)
	 {
	    try{
	        preparestatement = (PreparedStatement) connection.prepareStatement("SELECT idMembre,type FROM login INNER JOIN membre WHERE login = ? AND motdepasse = ? AND etat = 1");
	            
	        preparestatement.setString(1, con.getLogin());
	        preparestatement.setString(2, con.getMdp());
	            
	        resultat = preparestatement.executeQuery();
	            			
	    }catch(Exception e){
				
	        JOptionPane.showMessageDialog(null, "Echec connexion");
	    }
	    return resultat;
	  }
	  public int nbrMembre(){
	    	int nbr = 0;
	    	
	    	try{
	            preparestatement = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) AS nbr FROM membre");
	            
	            resultat = preparestatement.executeQuery();
	            
	            if(resultat.next()){
	                
	                nbr = resultat.getInt("nbr");
	            
	            }
	        }catch(Exception e){
	            
	            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'execution de la requete\n");
	     
	        }
	    	return nbr;
	    }
	  	public int nbrMembreActif(){
	    	int nbr = 0;
	    	
	    	try{
	            preparestatement = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) AS nbr FROM membre WHERE etat = 1");
	            
	            resultat = preparestatement.executeQuery();
	            
	            if(resultat.next()){
	                
	                nbr = resultat.getInt("nbr");
	            
	            }
	        }catch(Exception e){
	            
	            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'execution de la requete\n");
	     
	        }
	    	return nbr;
	    }
	    public Object getListeMembre(){
	        
	        Object listeMembre[][] = new Object[nbrMembreActif()][7];
	        
	        try{
	            String query = "SELECT id, nom, prenom, tel, email, adresse, type FROM membre WHERE etat = 1 ORDER BY id ASC";
	            
	            statement = (Statement) connection.createStatement();
	            resultat = statement.executeQuery(query);
	            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
	            int nbr_column = meta.getColumnCount();
	            
	            int i = 0;
	            while(resultat.next()){
	                
	                listeMembre[i][0]= resultat.getInt("id");
	                listeMembre[i][1]= resultat.getString("nom");
	                listeMembre[i][2]= resultat.getString("prenom");
	                listeMembre[i][3]= resultat.getString("tel");
	                listeMembre[i][4]= resultat.getString("email");
	                listeMembre[i][5]= resultat.getString("adresse");
	                listeMembre[i][6]= resultat.getString("type");
	                i++;
	            }
	        }catch(Exception e){
	            
	            JOptionPane.showMessageDialog(null,"La connexion à  la Base de données à  échouée :\n" +e);
	        
	        }
	        return listeMembre;
	    }
	    public Object getInfoMembre(String email){
	        
	        Object infoMembre[][] = new Object[1][7];
	        
	        try{
	        	preparestatement = (PreparedStatement) connection.prepareStatement("SELECT id, nom, prenom, tel, email, adresse, type FROM membre WHERE etat = 1 AND email = ? ORDER BY id ASC");
	            
	            preparestatement.setString(1, email);
	            resultat = preparestatement.executeQuery();
	            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
	            
	            while(resultat.next()){
	                
	                infoMembre[0][0]= resultat.getInt("id");
	                infoMembre[0][1]= resultat.getString("nom");
	                infoMembre[0][2]= resultat.getString("prenom");
	                infoMembre[0][3]= resultat.getString("tel");
	                infoMembre[0][4]= resultat.getString("email");
	                infoMembre[0][5]= resultat.getString("adresse");
	                infoMembre[0][6]= resultat.getString("type");    
	            }
	        }catch(Exception e){
	            
	            JOptionPane.showMessageDialog(null,"Une erreur se produite lors de la l'execution de la demande");
	        
	        }
	        return infoMembre;
	    }
	    public Object getInfoMembreByNom(String nom, String prenom){
	        
	        Object infoMembre[][] = new Object[1][7];
	        
	        try{
	        	preparestatement = (PreparedStatement) connection.prepareStatement("SELECT id, nom, prenom, tel, email, adresse, type FROM membre WHERE etat = 1 AND nom = ? AND prenom = ?");
	            
	        	preparestatement.setString(1, nom);
		        preparestatement.setString(2, prenom);
	        	resultat = preparestatement.executeQuery();
	            
	            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
	            
	            while(resultat.next()){
	                
	                infoMembre[0][0]= resultat.getString("id");
	                infoMembre[0][1]= resultat.getString("nom");
	                infoMembre[0][2]= resultat.getString("prenom");
	                infoMembre[0][3]= resultat.getString("tel");
	                infoMembre[0][4]= resultat.getString("email");
	                infoMembre[0][5]= resultat.getString("adresse");
	                infoMembre[0][6]= resultat.getString("type");    
	            }
	        }catch(Exception e){
	            
	            JOptionPane.showMessageDialog(null,"Une erreur se produite lors de la l'execution de la demande" + e);
	        
	        }
	        return infoMembre;
	    }
	    public int getLastID(){
	    	int nbr = 0;
	    	
	    	try{
	            preparestatement = (PreparedStatement) connection.prepareStatement("SELECT COUNT(id) AS nbr FROM membre");
	            
	            resultat = preparestatement.executeQuery();
	            
	            if(resultat.next()){
	                
	                nbr = resultat.getInt("nbr");
	            
	            }
	        }catch(Exception e){
	            
	            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'execution de la requete\n");
	     
	        }
	    	return nbr;
	    }
    public boolean setMembre(Membre membre){
	        
	        boolean set = false;
	        try{
	            preparestatement = (PreparedStatement) connection.prepareStatement("INSERT INTO membre(id,nom,prenom,tel,email,adresse,type,lastEdit) VALUES(?,?,?,?,?,?,?,NOW())");
	        
	            preparestatement.setInt(1, membre.getId());
	            preparestatement.setString(2, membre.getNom());
	            preparestatement.setString(3, membre.getPrenom());
	            preparestatement.setString(4, membre.getTel());
	            preparestatement.setString(5, membre.getEmail());
	            preparestatement.setString(6,membre.getAdresse());
	            preparestatement.setString(7, membre.getType());
	                
	            int j = preparestatement.executeUpdate();
	            if(j > 0){
	                
	                set = true;
	            }
	        }catch(Exception e){
	            
	            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'insertion de données \n" + e);
	        }
	        return set;
	    }
    public boolean setLogin(int id, String login, String password){
        
        boolean set = false;
        try{
            preparestatement = (PreparedStatement) connection.prepareStatement("INSERT INTO login(idMembre,login,motDePasse) VALUES(?,?,?)");
        
            preparestatement.setInt(1, id);
            preparestatement.setString(2, login);
            preparestatement.setString(3, password);
                
            int j = preparestatement.executeUpdate();
            if(j > 0)
            {    
                set = true;
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'insertion de données \n" + e);
        }
        return set;
    }
    public boolean updateMembre(Membre membre)
    {
        boolean updateMembre = false;
        
        try{
            preparestatement = (PreparedStatement) connection.prepareStatement("UPDATE membre SET nom = ?, prenom = ?, tel = ?, email = ?, adresse = ?, type = ?, lastEdit = NOW() WHERE id = ?");
        
            preparestatement.setString(1, membre.getNom());
            preparestatement.setString(2, membre.getPrenom());
            preparestatement.setString(3, membre.getTel());
            preparestatement.setString(4, membre.getEmail());
            preparestatement.setString(5, membre.getAdresse());
            preparestatement.setString(6, membre.getType());
            preparestatement.setInt(7, membre.getId());
                
            int j = preparestatement.executeUpdate();
            if(j > 0){
            	
                updateMembre = true;
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de la mise info voyageur \n" + e);

        }
        return updateMembre;
    }
    public boolean deleteMembre(String email)
    {
        boolean deleteMembre = false;
        
        try{
            preparestatement = (PreparedStatement) connection.prepareStatement("UPDATE membre SET etat = 0 WHERE email = ?");
        
            preparestatement.setString(1, email);
                
            int j = preparestatement.executeUpdate();
            if(j > 0){
            	
                deleteMembre = true;
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de la mise info voyageur \n" + e);

        }
        return deleteMembre;
    }
    public int nbrTacheActif(){
    	int nbr = 0;
    	
    	try{
            preparestatement = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) AS nbr FROM tache WHERE etat != 'DEL'");
            
            resultat = preparestatement.executeQuery();
            
            if(resultat.next()){
                
                nbr = resultat.getInt("nbr");
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'execution de la requete\n");
     
        }
    	return nbr;
    }
    public Object getListeTache(){
        
        Object listeTache[][] = new Object[nbrTacheActif()][6];
        
        try{
            String query = "SELECT tache.id AS id, designation, description, dateDebut, dateFin, etat FROM tache WHERE tache.etat != 'DEL' ORDER BY id ASC";
            
            statement = (Statement) connection.createStatement();
            resultat = statement.executeQuery(query);
            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
            int nbr_column = meta.getColumnCount();
            
            int i = 0;
            while(resultat.next()){
                
                listeTache[i][0]= resultat.getInt("id");
                listeTache[i][1]= resultat.getString("designation");
                listeTache[i][2]= resultat.getString("description");
                listeTache[i][3]= resultat.getString("dateDebut");
                listeTache[i][4]= resultat.getString("dateFin");
                listeTache[i][5]= resultat.getString("etat");
             
                i++;
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"La connexion à  la Base de données à  échouée :\n" +e);
        
        }
        return listeTache;
    }
    public int nbrTacheNonAssigne(){
    	
    	int nbr = 0;
    	
    	try{
            preparestatement = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) AS nbr FROM tache WHERE etat != 'DEL' AND id NOT IN (SELECT idTache FROM assignation)");
            
            resultat = preparestatement.executeQuery();
            
            if(resultat.next()){
                
                nbr = resultat.getInt("nbr");
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'execution de la requete\n" + e);
     
        }
    	return nbr;
    }
    public Object getListeTacheNonAssigner(){
        
        Object listeTacheNoAssigner[][] = new Object[nbrTacheNonAssigne()][1];
        
        try{
            String query = "SELECT designation FROM tache WHERE etat != 'DEL' AND id NOT IN (SELECT idTache FROM assignation) ORDER BY id ASC";
            
            statement = (Statement) connection.createStatement();
            resultat = statement.executeQuery(query);
            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
            int nbr_column = meta.getColumnCount();
            
            int i = 0;
            while(resultat.next()){
                
            	listeTacheNoAssigner[i][0]= resultat.getString("designation");
       
                i++;
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"La connexion à  la Base de données à  échouée :\n" +e);
        
        }
        return listeTacheNoAssigner;
    }
    public int getLastIdTache(){
    	
    	int nbr = 0;
    	
    	try{
            preparestatement = (PreparedStatement) connection.prepareStatement("SELECT COUNT(id) AS nbr FROM tache");
            
            resultat = preparestatement.executeQuery();
            
            if(resultat.next()){
                
                nbr = resultat.getInt("nbr");
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'execution de la requete\n");
     
        }
    	return nbr;
    }
    public boolean setTache(Tache tache){
        
        boolean set = false;
        try{
            preparestatement = (PreparedStatement) connection.prepareStatement("INSERT INTO tache(id,designation,description,dateDebut,dateFin,etat) VALUES(?,?,?,?,?,?)");
        
            preparestatement.setInt(1, tache.getId());
            preparestatement.setString(2, tache.getDesignation());
            preparestatement.setString(3, tache.getDescription());
            preparestatement.setString(4, tache.getDateDebut());
            preparestatement.setString(5, tache.getDateFin());
            preparestatement.setString(6, tache.getEtat());
                
            int j = preparestatement.executeUpdate();
            if(j > 0){
                
                set = true;
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'insertion de données \n" + e);
        }
        return set;
    }
    public Object getInfoTache(int id){
        
        Object infoTache[][] = new Object[1][6];
        
        try{
        	preparestatement = (PreparedStatement) connection.prepareStatement("SELECT id, designation, description, dateDebut, dateFin, etat FROM tache WHERE id = ?");
            
            preparestatement.setInt(1, id);
            resultat = preparestatement.executeQuery();
            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
            
            while(resultat.next()){
                
                infoTache[0][0]= resultat.getInt("id");
                infoTache[0][1]= resultat.getString("designation");
                infoTache[0][2]= resultat.getString("description");
                infoTache[0][3]= resultat.getObject("dateDebut");
                infoTache[0][4]= resultat.getObject("dateFin");
                infoTache[0][5]= resultat.getString("etat");
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Une erreur se produite lors de la l'execution de la demande" + e);
        
        }
        return infoTache;
    }
    public Object getInfoTacheByDesignation(String designation){
        
        Object infoTache[][] = new Object[1][6];
        
        try{
        	preparestatement = (PreparedStatement) connection.prepareStatement("SELECT id, designation, description, dateDebut, dateFin, etat FROM tache WHERE designation = ?");
            
            preparestatement.setString(1, designation);
            resultat = preparestatement.executeQuery();
            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
            
            while(resultat.next()){
                
                infoTache[0][0]= resultat.getString("id");
                infoTache[0][1]= resultat.getString("designation");
                infoTache[0][2]= resultat.getString("description");
                infoTache[0][3]= resultat.getObject("dateDebut");
                infoTache[0][4]= resultat.getObject("dateFin");
                infoTache[0][5]= resultat.getString("etat");
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Une erreur se produite lors de la l'execution de la demande" + e);
        
        }
        return infoTache;
    }
    public boolean updateTache(Tache tache)
    {
        boolean updateTache = false;
        
        try{
            preparestatement = (PreparedStatement) connection.prepareStatement("UPDATE tache SET designation = ?, description = ?, dateDebut = ?, dateFin = ?, etat = ? WHERE id = ?");
        
            preparestatement.setString(1, tache.getDesignation());
            preparestatement.setString(2, tache.getDescription());
            preparestatement.setString(3, tache.getDateDebut());
            preparestatement.setString(4, tache.getDateFin());
            preparestatement.setString(5, tache.getEtat());
            preparestatement.setInt(6, tache.getId());
      
            int j = preparestatement.executeUpdate();
            if(j > 0){
            	
                updateTache = true;
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de la mise info voyageur \n" + e);

        }
        return updateTache;
    }
    public boolean deleteTache(int id)
    {
        boolean deleteTache = false;
        
        try{
            preparestatement = (PreparedStatement) connection.prepareStatement("UPDATE tache SET etat = 'DEL' WHERE id = ?");
        
            preparestatement.setInt(1, id);
                
            int j = preparestatement.executeUpdate();
            if(j > 0){
            	
                deleteTache = true;
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de la suppression d'une tâche");

        }
        return deleteTache;
    }
    public int nbrAssignation(){
    	int nbr = 0;
    	
    	try{
            preparestatement = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) AS nbr FROM assignation");
            
            resultat = preparestatement.executeQuery();
            
            if(resultat.next()){
                
                nbr = resultat.getInt("nbr");
            
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'execution de la requete\n");
     
        }
    	return nbr;
    }

    public Object getListeAssignation(){
        
        Object listeAssignation[][] = new Object[nbrAssignation()][8];
        
        try{
            String query = "SELECT idTache, idMembre, dateAssigne, nom, prenom, designation, dateDebut, dateFin, tache.etat FROM assignation INNER JOIN tache ON tache.id = idTache INNER JOIN membre ON membre.id = idMembre ORDER BY idTache ASC";
            
            statement = (Statement) connection.createStatement();
            resultat = statement.executeQuery(query);
            ResultSetMetaData  meta = (ResultSetMetaData) resultat.getMetaData();
            int nbr_column = meta.getColumnCount();
            
            int i = 0;
            while(resultat.next()){
                
                listeAssignation[i][0]= resultat.getInt("idTache");
                listeAssignation[i][1]= resultat.getString("designation");
                listeAssignation[i][2]= resultat.getString("nom");
                listeAssignation[i][3]= resultat.getString("prenom");
                listeAssignation[i][4]= resultat.getString("dateAssigne");
                listeAssignation[i][5]= resultat.getString("dateDebut");
                listeAssignation[i][6]= resultat.getString("dateFIn");
                listeAssignation[i][7]= resultat.getString("etat");
                i++;
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"La connexion à  la Base de données à  échouée :\n" +e);
        
        }
        return listeAssignation;
    }
    public boolean setAssignation(int idTache, int idMembre){
        
        boolean set = false;
        try{
            preparestatement = (PreparedStatement) connection.prepareStatement("INSERT INTO assignation(idTache,idMembre,dateAssigne) VALUES(?,?,NOW())");
        
            preparestatement.setInt(1, idTache);
            preparestatement.setInt(2, idMembre);
                
            int j = preparestatement.executeUpdate();
            if(j > 0){
                
                set = true;
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Une erreur se produite lors de l'insertion de données \n" + e);
        }
        return set;
    }
}
