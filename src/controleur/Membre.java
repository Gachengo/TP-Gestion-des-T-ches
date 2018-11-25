package controleur;

public class Membre {
		
		private int id;
		private String nom;
		private String prenom;
		private String adresse;
		private String tel;
		private String email;
		private String type;
		
		public Membre(int id, String nom, String prenom, String tel, String email, String adresse, String type) {
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.tel = tel;
			this.email = email;
			this.type = type;
		}
		//**************************Accesseur***********************
		public int getId(){
			return this.id;
		}
		public String getNom(){
			return this.nom;
		}
		public String getPrenom() {
			return this.prenom;
		}
		public String getAdresse(){
			return this.adresse;
		}
		public String getTel() {
			return this.tel;
		}
		public String getEmail() {
			return this.email;
		}
		public String getType() {
			return this.type;
		}
		
		//******************************Mutateur********************
		public void setId(int id){
			this.id = id;
		}
		public void setNom(String nom){
			this.nom = nom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public void setAdresse(String adresse){
			this.adresse = adresse;
		}
		public void setTel(String tel){
			this.tel = tel;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setType(String type) {
			this.type = type;
		}
	}