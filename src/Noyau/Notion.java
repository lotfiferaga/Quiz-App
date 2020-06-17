package Noyau;
import java.util.*;
import java.io.*;


public class Notion implements Serializable{
	// Attributs 
	private String titre; //titre de la notion 
	private ArrayList<Question> questions=new ArrayList<Question>() ; //les questions de la notion dans un tableau  
	private int nbreQuestion; // nombre de questions total de chaque notion 
	private int nbreQrelatif;  // nombre de question relatif choisi dans le quiz 
	
	//constructeur de la notion 
	public Notion(String titre,int Q)
	{
		this.titre=titre; // saisir le titre
		this.nbreQuestion=Q; //nombre de question 
		//saisirQuestions(Q); // ajout question
	}
	//setters and getters 
	// getters 
	public String getTitre()
	{
		return titre;
	}
	//getting le nombre de question total pour la notion 
	public int getQuestNotion()
	{
		return nbreQuestion;	
	}
	//getting le nombre de question total pour la notion 
	public int getQuestionRelatif()
	{
		return nbreQrelatif;	
	}
	
	public ArrayList<Question> getRefQuestion()
	{
		return questions;  //retourne la reference de la table des questions de la notion
	} 
	// affichage des questions dans la notion 
	public void afficheQuest()
	{
		for(int i=0;i<questions.size();i++)
		{
			System.out.println(questions.get(i).getQuestion()); 
		}
		
	}
	//setters 
	public void setQuestNotion()
	{
		this.nbreQuestion=questions.size();
	}
	
	public void setQuestionRelatif(int x)
	{
		this.nbreQrelatif=x;
	}
	
	public void setQuestionNotion(ArrayList<Question> tab)
	{
		this.questions=tab;
	}
	// methode pour remplir/ajouter des questions pour chaque notions avec x comme nombre de questions totale pour chaque notions et le type QCM/QO/QCU 	
	public void saisirQuestions(int x)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Les questions sont de type : QCU , QCM , QO");
		for(int i=0;i<x;i++)
		{
		
		System.out.println("Saisir le Type de question");
		String type=sc.next();//input du type pour effectuer l'ajout du question
		
		//traitement des différents cas de figure 
		if(type.equals("QCM"))// cas du QCM
		{
			System.out.println("Saisir la question :) ");
			String qcm=sc.next();
			Question q=new QCM(qcm); //appel du constructeur QCM
			questions.add(q); //ajout de QCM
		} 
		else if(type.equals("QCU"))//cas du QCU
		{
			System.out.println("Saisir la question :) ");
			String qcu=sc.next();
			System.out.println("Saisir la reponse correcte du QCU ^^");
			String reponse=sc.next();
			Question q=new QCU(qcu,reponse);//appel du constructeur QCU
			questions.add(q); //ajout du QCU
		}
		else if(type.equals("QO"))//cas du QO
		{
			System.out.println("Saisir la question :) ");
			String qo=sc.next();
			Question q=new QO(qo);//appel du constructeur QO
			questions.add(q); //ajout du QO
		}
		
	}
		setQuestNotion(); //mise à jour du nombre de questions de la notion
	    
	}

	      
}
