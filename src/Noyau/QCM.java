package Noyau;
import java.util.*;
import java.io.*;

public class QCM extends Question implements Serializable{
	private ArrayList<String> repCorrectes=new ArrayList<String>(); //liste des reponses correctes 
	private ArrayList<String> repFausses=new ArrayList<String>(); //liste des reponses fausses
	private ArrayList<String> repMix=new ArrayList<String>();  // liste des propositions
    private int nbrePropo; //le nombre de proposition que contient le QCM
    private boolean evaluation; //booléen indique si la Répponse de QCM est Vrai ou non
	private ArrayList<String> repApprenant=new ArrayList<String>(); //liste des réponses de QCM
    private double score; //le score d'évaluation de la quiz 
    //liste des réponses d'aprenants 
    
	//constructeur de QCM
	public QCM(String q) 
	{
		super.setQuetsion(q); //appel du constrcuteur de la classe mère
		this.score=0;
		this.evaluation=false;
		//appel des méthodes de remplissage des propositions
		remplirPropoVrai();
		remplirPropoFaux();
		mixReponses(); //mix des réponses
		this.nbrePropo=repMix.size();
		
	}
	
	//les setters et les getters 
	//getters 
	public double getScoreQCM()
	{
		return score;
	}
	
	public int getNbrePropo()
	{
		return nbrePropo;
	}
	public ArrayList<String> getRepCorrectes()
	{
		return repCorrectes;
	}
	
	public ArrayList<String> getRepFausses()
	{
		return repFausses;
	}
	
	public ArrayList<String> getRepMix()
	{
		return repMix;
	}
	
	public boolean getEvaluationQCM()
	{
		return evaluation;
	}
	//setters 
	public void setEvaluation(boolean ev)
	{
		this.evaluation=ev;
	}
	public void setScoreQCM(double score)
	{
		this.score=score;
	}
	
	public void setRepCorrectes(ArrayList<String> tab)
	{
		this.repCorrectes=tab;
	}
	
	public void setRepFausses(ArrayList<String> tab)
	{
		this.repFausses=tab;
	}
	
	public void setNbrePropo(int p)
	{
		this.nbrePropo=p;
	}
	//méthodes pour former les propositions de la question en mélangeant les reponses correctes et les fausses au hasard 
	public void mixReponses()
	{
		repMix.addAll(repCorrectes);
		repMix.addAll(repFausses);
		Collections.shuffle(repMix); //melanger les reponses au hasard 		
	}
	//methode pour remplir les propositions fausses 
	public void remplirPropoFaux()
	{
		System.out.println("Vous allez saisir les propositions fausses du QCM \n");
		Scanner sc=new Scanner(System.in); 
		Scanner scan=new Scanner(System.in);
		System.out.println("Saisir le nombre de propositions fausses \n");
		int faux;
		faux=sc.nextInt();
		for(int i=0;i<faux;i++)
		{
			System.out.println("Saisir votre Proposition ici :");
			String input;
			input=scan.nextLine();
			repFausses.add(input); //ajout de l'input dans la list des propositions 
		}
		
	}
	//methodes pour remplir les propostions vraies
	public void remplirPropoVrai()
	{
		System.out.println("Vous allez saisir les propositions vraies du QCM \n");
		Scanner sc=new Scanner(System.in);
		Scanner scan=new Scanner(System.in);
		System.out.println("Saisir le nombre de propositions vraies ");
		int vrai;
		vrai=sc.nextInt();
		for(int i=0;i<vrai;i++)
		{
			System.out.println("Saisir votre Proposition ici :");
			String input;
			input=scan.nextLine();
			repCorrectes.add(input); //ajout de l'input dans la list des propositions 
		}
		
	}
	
	//methode de reponse aux QCM 
	public void repondreQCM()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Vous allez repondre au qcm Saisir vrai pour la reponse :"+super.getQuestion());
		String repu;
		for(int i=0;i<repMix.size();i++)
		{
			System.out.println(repMix.get(i));
			repu=input.nextLine(); 
			if(repu.equalsIgnoreCase("vrai"))
			{
				repApprenant.add(repMix.get(i));
			}
		}
	}
	
	//affichage des reponses soumises 
	public void afficherReponses()
	{
		for(int i=0;i<repApprenant.size();i++)
		{
			System.out.println(repApprenant.get(i));
		}
	}
	
	//méthode d'évaluation d'une question à choix multiple 
	public void evaluer()
	{
		int p=nbrePropo; //nombre de proposition total dans la quiz 
		for(int i=0;i<repApprenant.size();i++)
		{
			for(int j=0;j<repCorrectes.size();j++)
			{
			if(repCorrectes.get(j).equalsIgnoreCase(repApprenant.get(i)))
			{
				score+=1/p; //il a choisi une réponse 
			}
			else 
			{
				score-=1/p; //il n'a pas choisir une réponse correcte 
			}
			}
			for(int s=0;s<repFausses.size();s++)
			{
				if(repFausses.get(s).equalsIgnoreCase(repApprenant.get(i)))
				{
					score-=1/p;
				} 
				else
				{
					score+=1/p;
				}
			}
		}
		if(score<0) //vérification de négativité de score 
		{
			score=0;
			evaluation=false;  
		}
	}
	
}
