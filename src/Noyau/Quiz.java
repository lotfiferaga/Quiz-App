package Noyau;
import java.util.*;
public class Quiz {
	// liste d'attributs 
	private String titre;
	private String dateouvert;
	private String dateexpiration;
	private ArrayList<Notion> notionscouvert=new ArrayList<Notion>(); 
	private ArrayList<Question> quest=new ArrayList<Question>(); //modifié 
	private boolean open; //si un apprenant ouvre la quiz open est changé directement à vrai et le formateur ne pourra jamais modifier la quizz
	private boolean satisfaite; // indique si la quiz est satisfaite ou non 
	private boolean expire;   //indique si la quiz a expiré ou non 
	private boolean soumis; // indicateur que l'apprenant a soumettre le quiz pour evaluation
	private boolean sauve;  //indicateur pour effectuer les sauvegards des quiz
	private ArrayList<Reponse> reponseSoumises=new ArrayList<Reponse>(); // tableau de reponses pour chaque questions une reponse soumise par l'apprenant 
	private int nbrequestions=quest.size(); // nbre questions total du quiz
    private ArrayList<Apprenant> appRenant=new ArrayList<Apprenant>(); // liste des apprenants qui ont choisi une quiz précise 
    private double tauxprocess; //taux d'accomplissement pour chaque quiz varie avec l'activité de l'apprenant 
    private double tauxsuccess; //taux de réussite de chaque quiz final après évaluation
    //liste methodes et des accesseurs/constructeurs 
    public Quiz(String titre,String dateouvert,String dateexpiration)
    {   
    	this.titre=titre;
    	this.dateouvert=dateouvert;
    	this.dateexpiration=dateexpiration;
    	this.tauxprocess=0;
    	this.tauxsuccess=0;
    	open=false;
    	satisfaite=false;
    	expire=false;
    	soumis=false;
    	sauve=false;
    }
    /* ***************************************/ 
    //setters and getters 
    // getters 
    public double getTauxProcess()
    {
    	return tauxprocess;
    }
    public double getTauxSuccess()
    {
    	return tauxsuccess;
    }
    public ArrayList<Reponse> getReponseSoumises()
    {
    	return reponseSoumises;
    }
    public ArrayList<Apprenant> getListApprenantQuiz()
    {
    	return appRenant;
    }
    public boolean getOpen()
    {
    	return open;
    }
    public ArrayList<Question> getQuestionQuiz()
    {
    	return quest;
    }
    public ArrayList<Notion> getNotionCOuverte()
    {
    	return  notionscouvert;
    }
    public String getQuiz()
    {
    	return titre;
    }
    
    public String getDateOuverture()
    {            
    	return dateouvert;
    }
    
    public String getDateExpiration()
    {
    	return dateexpiration;
    }
    
    public int getNbrequestion()
    {
    	return nbrequestions;
    }
    
    public boolean getSatisfaite()
    {
    	return satisfaite;
    }
    
    public boolean getSoumis()
    {
    	return soumis;
    }
    
    public boolean getSauve()
    {
    	return sauve;
    }
    
    public boolean getExpire()
    {
    	return expire;
    }
    /* ********************************************* */
    // setters
    public void setTauxProcess(double taux)
    {
    	this.tauxprocess=taux;
    }
    public void setTauxSuccess(double taux)
    {
    	this.tauxsuccess=taux;
    }
    public void setReponseSoumises(ArrayList<Reponse> Rep)
    {
    	this.reponseSoumises=Rep;
    }
    public void setApprenantQuiz(ArrayList<Apprenant> App)
    {
    	this.appRenant=App;
    }
    public void setOpen(boolean open)
    {
    	this.open=open;
    }
    public void setQuiz(String titre)
    {
    	this.titre=titre;
    }
    
    public void setDateOuverture(String date)
    {            
    	this.dateouvert=date;
    }
    
    public void setDateExpiration(String date)
    {
    	this.dateexpiration=date;
    }
    
    public void setSatisfaite(boolean bool)
    {
    	this.satisfaite=bool;
    }
    
    public void setSoumis(boolean bool)
    {
    	this.soumis=bool;
    }
    
    public void setSauve(boolean bool)
    {
    	this.sauve=bool;
    }
    
    public void setExpire(boolean bool)
    {
    	this.expire=bool;
    }
    
    public void setNotionsCouvert(ArrayList<Notion> notion)
    {
    	this.notionscouvert=notion;
    }
    
    public void setQuestionQuiz(ArrayList<Question> question)
    {
    	this.quest=question;
    }
    
    public void setNbreQuestion()
    {
    	this.nbrequestions=quest.size(); //la taille de quest
    }
    
    //methodes 
    //méthode pour afficher les notions couvertes
    public void afficherNotionsCouv()
    {
    	for(int i=0;i<notionscouvert.size();i++)
    	{
    		System.out.println(notionscouvert.get(i).getTitre());
    	}
    }
    //affichage des questions de quiz 
    public void afficherQuestionQuiz()
    {
    	for(int i=0;i<quest.size();i++)
    	{
    		System.out.println(quest.get(i).getQuestion());//affichage de question
    	}
    }
    //affichage de quiz pour la vérification des informations et la consulter
    public void visualiserQuiz(Quiz quiz)
    {
    	System.out.println(quiz.getQuiz());
    	System.out.println(quiz.getDateOuverture());
    	System.out.println(quiz.getDateExpiration());
    	quiz.afficherNotionsCouv();
    	quiz.afficherQuestionQuiz();	
    }
    // suppression d'une question choisi de la liste des question selon le nombre de la question 
    public void supprimerQuestion(String titre)
    {
       Iterator<Question> questIterateur=quest.iterator();
       
       while(questIterateur.hasNext())
       {
    	   Question q=questIterateur.next();
    	   if(q.getQuestion().equalsIgnoreCase(titre))
    	   {
    		  questIterateur.remove(); //supression de la question choisi !!
    	   }  
       }  
    }
    //ajouter une question à une quiz  
    public void ajouterQuestion(Question q)
     {
    	 quest.add(q);
     }
    
    //méthode d'évaluation de quiz 
    public void evaluerQuiz()
    {
    	
    	for(int i=0;i<quest.size();i++)
    	{
    		if(quest.get(i) instanceof QCM)
    		{
    			QCM ref;
    			ref= ((QCM)quest.get(i));
    			ref.evaluer(); //evaluation QCM
    			if(ref.getEvaluationQCM())
    			{
    				tauxsuccess++;
    			}
    		} 
    		else if(quest.get(i) instanceof QCU)
    		{
    			QCU refer;
    			refer=((QCU)quest.get(i));
    			refer.evaluerQCU();
    			if(refer.getEvalue())
    			{
    				tauxsuccess++;
    			}
    		}
    		else if(quest.get(i) instanceof QO)
    		{
    			QO reference;
    			reference=((QO)quest.get(i));
    			reference.evaluerQO();
    			if(reference.getEvaluation())
    			{
    				tauxsuccess++;
    			}
    		}  
    	}
    }
    
    
     
    
    
    
    
}
