package Noyau;
import java.io.*;

public class Compte implements Serializable{
     // liste d'attributs 
	private String login;   //l'identificateur de compte/username 
	private String password; // le mot de passe 
	
	//liste des méthodes
	//constructeur qui sera invoqué par une classe d'utilisation 
	//constructeur pour les comptes des apprenants 
	public Compte(Apprenant app)
	{
		this.login=app.firstchar(app.getPrenom())+app.getNom(); //generation de login first time
		this.password=app.getNom()+app.getDatebirth();// le mot de passe 
	}
	//constructeur pour les comptes des formateurs 
	public Compte(String login,String password)
	{
		this.login=login;
		this.password=password;
	}
	// Setters et Getters pour les modifications 
	public String getLogin()
	{
		return login;
	}
	
	public void setLogin(String log)
	{
		this.login=log;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	/* Cette classe est finalisée */
}
