package Noyau;
import java.io.*;

public  abstract class Question implements Serializable {
	// liste d'attributs 
	private String question; //question définit par le formateur l'énoncé de la question
	//setters and getters 
	//getters
	
	public String getQuestion()
	{
		return question;
	}
	//setters 
	public void setQuetsion(String q)
	{
		this.question=q; 
	}
	//remplir les classes des questions par les méthodes de réponses /récupération/evaluation des questions qui sera invoqué plus tard par la méthode autoEvaluation du quiz 
    
    
}
