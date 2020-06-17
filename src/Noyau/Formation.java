package Noyau;
import java.util.*;
import java.io.*;

public class Formation implements Serializable {
	//liste d'attributs 
	private String nom;
	private String description;
	private String datedebut; // 'jj/mm/aaaa' 
	private String datefin;
	private boolean open; //indique si la formation est ouverte ou non toute est traité avec les dates d'ouverture et de fermeture
	private ArrayList<Notion> notions=new ArrayList<Notion>(); //les notions enseingées dans la formation
	private ArrayList<Quiz> quiz=new ArrayList<Quiz>(); //les quiz proposées par le formateur 
	// liste des méthodes et des accesseurs /constructeur 
	// constructeur pour la creation de formation /il sera ivoqué par le créateur de from
	public Formation(String nom,String datedebut,String datefin)
	{
		// simplement pour créer une formation vide pour que le formateur le modifie après 
		this.nom=nom;
		this.datedebut=datedebut;
		this.datefin=datefin;
	}
	//setters and getters 
	//getters 
	public boolean getOpen()
	{
		return open;
	}
	public ArrayList<Quiz> getQuizRef()
	{
	       return quiz;
	}
	 
	public ArrayList<Notion> getNotionRef()
	{
		
		return notions;
	}

	public String getNom ()
	{
		return nom;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getDatedebut()
	{
		return datedebut;
	}
	
	public String getDatefin()
	{
		return datefin;
	}
	
	//setters 
	public void setOpen(boolean open)
	{
		this.open=open;
	}

	public void setDescription(String d)
	{
		this.description=d;
	}
	
	public void setDatefin(String date)
	{
		this.datefin=date;
	}
	
	public void setDatedebut(String date)
	{
		this.datedebut=date;
	}
	
	public void setTitre(String titre)
	{
		this.nom=titre;
	}
	
	//setters 
	public void setNotions(ArrayList<Notion> notion)
	{
		this.notions=notion; //notions enseignées 
	}
	
	public void setQuiz(ArrayList<Quiz> quiz)
	{
		this.quiz=quiz;
	}
	
	// methode pour afficher les notions enseignées 
	public void afficherNotion()
	{
		for(int i=0;i<notions.size();i++)
		{
			System.out.println(notions.get(i).getTitre());  //getting les notions 
		}
	}
	// methode pour afficher les quizz 
	public void afficherQuiz()
	{
		for(int i=0;i<quiz.size();i++)
		{
			System.out.println(quiz.get(i).getQuiz()); //titre de la quiz
			System.out.println(quiz.get(i).getDateOuverture()); //date d'ouverture 
			System.out.println(quiz.get(i).getDateExpiration()); //date d'expiration
		}
	}
    

}
