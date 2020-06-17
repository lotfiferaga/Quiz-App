package Noyau;
import java.util.*;
import java.io.*;

public class QO extends Question implements Serializable{
       //liste d'attributs 
	   private ArrayList<String> repCorrecte=new ArrayList<String>(); //les reponse correcte à la question ouverte 
	   private boolean evaluation; //vrai si la reponse est vrai faux sinon 
	   private String repQO; //la reponse soumise par l'apprenant si la question est un QO 
		  
	   //Constructeur de QO
	   public QO(String question)
	   {
		   super.setQuetsion(question); //saisie d'une nouvelle QO 
		   this.evaluation=false;
		   remplirCorrecte(); //remplissage des réponses correctes 
	   }
	   
	   //les setters et les getters 
	   // les getters
	   public boolean getEvaluation()
	   {
		   return evaluation;
	   }
	   
	   public ArrayList<String> getRepCorrecte()
	   {
		   return repCorrecte;
	   }
	   //les setters
	   
	   public void setRepCorrecte(ArrayList<String> Correcte)
	   {
		   this.repCorrecte=Correcte;
	   }
	   
	   public void setEvaluation(boolean e)
	   {
		   this.evaluation=e;
	   }
	 //methodes pour remplir les réponses correctes 
		public void remplirCorrecte()
		{
			System.out.println("Vous allez saisir les reponses correctes du QO \n");
			Scanner sc=new Scanner(System.in);
			int propo;
			System.out.println("Saisir le nombre de reponses correctes ");
            propo=sc.nextInt();
			Scanner scan=new Scanner(System.in);
			for(int i=0;i<propo;i++)
			{
				System.out.println("Saisir votre Proposition ici :");
				String input;
				input=scan.nextLine();
				repCorrecte.add(input); //ajout de l'input dans la list des propositions 
			}
			
		}
		//methode pour repondre au QO
		public void repondreQO()
		{
			Scanner mot=new Scanner(System.in);
			System.out.println("saisir la reponse du QO :"+super.getQuestion());
			repQO=mot.nextLine();
		}
		//méthode d'évaluation de la question QO 
		public void evaluerQO()
		{
			for(int i=0;i<repCorrecte.size();i++) 
			{  //ask teacher about it :/ 
			if(repQO.equalsIgnoreCase(repCorrecte.get(i))) //si la reponse soumise est contenu dans la liste des reponses correctes 
			{
			   evaluation=true; //evaluation à vrai 
			} 
			}
		}
	   
	   
}
