package controleur;

public class ConnexionMembre {
	
	private String login;
	private String mdp;
	
	//**************************Accesseur***********************
	public String getLogin(){
		return this.login;
	}
	
	public String getMdp(){
		return this.mdp;
	}
	
	//******************************Mutateur********************
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public void setMdp(String mdp){
		this.mdp = mdp;
	}

}
