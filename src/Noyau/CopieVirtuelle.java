package Noyau;
import java.util.*;
public class CopieVirtuelle {
	//liste d'attributs 
	private Quiz quizz; // la quiz que l'apprenant a soumis 
	private Apprenant apprenant;  // l'apprenant qui a repondu au quiz 
	private ArrayList<Reponse> reponses=new ArrayList<Reponse>(); //reponses de l'apprenant
	private boolean soumettre; //indique si la copie est soumise à evaluation ou non 
	/// evaluation des quiz 
	
	//setters and getters 
	//getters 
	public boolean getSoumettre()
	{
		return soumettre;
	}
	public Apprenant getApprenantReponse()
	{
		return apprenant;
	}
	
	public Quiz getQuizz()
	{
		return quizz;
	}
	
	public ArrayList<Reponse>  getReponses()
	{
		return reponses;
	}
	//setters 
	public void setSoumettre(boolean s)
	{
		this.soumettre=s;
	}
	
	public void setQuiz(Quiz quiz)
	{
		this.quizz=quiz;
	}
	
	public void setReponse(ArrayList<Reponse> rep)
	{
		this.reponses=rep;
	}
	
    //remplir de telle sort on aura evaluation/affichage/recupération/ cette copie sera traité dans une page tout seul 
    //autoevaluation de la copie si soumettre==vrai
	
}
