package Noyau;
import java.util.*;
import java.util.Scanner;
// dans toute le TP la date est de forme 'jj/mm/aaaa'
public class EsiQuiz {
    //liste d'attributs qu'on va utilisé dans l'acceuil de l'application
	public static ArrayList<Formateur> formateurs=new ArrayList<Formateur>() ; // liste des formations disponible 
	public static ArrayList<Apprenant> groupe=new ArrayList<Apprenant>() ; //groupe d'apprenants  
	public static ArrayList<Notion> notions=new ArrayList<Notion>(); //liste des notions 
	public static ArrayList<Quiz> ListeQuiz=new ArrayList<Quiz>(); //liste des quiz 
	public static ArrayList<Question> listeQuestion=new ArrayList<Question>(); //liste de question
	//Main-Acceuil
	public static void main(String[] args) {
		/****** TEST *********/
		Scanner sc=new Scanner(System.in);
		//création de formateur 
		Formateur f1=new Formateur("Taylor","Swift");
		//création des comptes pour les formateurs
		f1.creerCompte("taylor","1989");
		//groupe d'apprenants 
		Apprenant a1=new Apprenant("feraga","lotfi","23/09/1999","guelma");
		Apprenant a2=new Apprenant("kherbach","ismail","12/07/1998","mazuona");
		Apprenant a3=new Apprenant("maizi","abderrahman","08/03/2001","guelma");
		groupe.add(a1);
		groupe.add(a2);
		groupe.add(a3);
		f1.setGroupe(groupe);
		System.out.println("************ ajout d'un apprenant ***************");
		f1.nouveauApprenant("lefza","ahmed","29/06/1996","jijel");
		System.out.println("****************affichage apprenant ***************");
		f1.visualiserListapp();
		System.out.println("************ supression d'un apprenant ***************");
		f1.deleteApprenant("feraga");
		System.out.println("****************affichage apprenant ***************");
		f1.visualiserListapp();
		System.out.println("****************mise a jour apprenant ses méthodes dans la classe apprenant ***************");
		System.out.println("****************Start des Quiz/Notions/Questions ***************");
		//creation d'une quiz 
		Quiz java=new Quiz("Java Test","25/06/2019","29/06/2019"); //creation
		//création des notions enseigné dans la formation java
		System.out.println("************Notions***************");
		System.out.println("************Notion  1 ***************");
	    Notion n1=new Notion("Encapsulation",3);
	    System.out.println("************Questions ***************");
	    Question q11=new QCM("saisir les propriétes de l'encapsulation correctes");
	    Question q22=new QCU("lesquels des ces propos est un concept de l'encapsulation","tous les champs privés");
	    Question q33=new QO("donner un mode d'accès à un apprenant");
		System.out.println("************Notion  2 ***************");
	    Notion n2=new Notion("Abstraction",3);
		System.out.println("************Questions ***************");
	    Question q1=new QCM("saisir les propriétes de l'abstraction correctes");
	    Question q2=new QCU("lesquels des ces propos est un concept de l'abstraction","méthodes abstraites");
	    Question q3=new QO("donner une classe abstraite de JAVA API pour les collections");
	    Question q4=new QO("donner une classe abstraite qui fonctionne differement ");
	    System.out.println("************Ajout des questions aux notions***************");
	    n2.getRefQuestion().add(q1);
	    n2.getRefQuestion().add(q2);
	    n2.getRefQuestion().add(q3);
	    n1.getRefQuestion().add(q11);
	    n1.getRefQuestion().add(q22);
	    n1.getRefQuestion().add(q33);	     
		//création des formations 
		System.out.println("****************** Formation *****************");
		f1.creerFormation("Java", "24/06/2019","29/06/2019");
		//affichage notion question 
		f1.getFormation().getNotionRef().add(n1);
		f1.getFormation().getNotionRef().add(n2);
		System.out.println("****************** Les Notions  *****************");
		f1.getFormation().afficherNotion();
		System.out.println("****************** Question de la notion 1 *****************");
		n1.afficheQuest();
		System.out.println("****************** Question de la notion 2 *****************");
		n2.afficheQuest();
		System.out.println("************ Creation de Quiz ***************");
		Quiz quizz=new Quiz("Java","25/06/2019","30/06/2019");
		System.out.println("************Liste des notion couvertes ***************");
		ArrayList<Notion> liste=new ArrayList<Notion>();
		liste.add(n1);
		liste.add(n2);
		System.out.println("****************** Question de la quiz *****************");
		quizz.setNotionsCouvert(liste);
		listeQuestion.add(q1);
		listeQuestion.add(q2);
		listeQuestion.add(q3);
		listeQuestion.add(q11);
		listeQuestion.add(q22);
		listeQuestion.add(q33);
		//ajout des questions aux quiz
		quizz.setQuestionQuiz(listeQuestion);
		quizz.afficherQuestionQuiz();
		ListeQuiz.add(quizz);
		//affectation des formation //sans modification
		f1.getFormation().setQuiz(ListeQuiz);
		System.out.println("****************** les Quiz dans la formation  *****************");
		f1.getFormation().afficherQuiz();
		f1.affecterFormation();
		System.out.println("************ Suppression d'une question  de la quiz**************");
        f1.deleteQuestion(f1.getFormation().getQuizRef().get(0),"saisir les propriétes de l'encapsulation correctes");
        System.out.println("************ Apres Suppression d'une question de la quiz **************");
        f1.ajouterQuiz(f1.getFormation(), quizz);
        f1.getFormation().getQuizRef().get(0).afficherQuestionQuiz();
        f1.getListeQuiz().add(quizz);
        System.out.println("************ Ajout d'une question a la quiz **************");
        f1.getFormation().getQuizRef().get(0).ajouterQuestion(q4);
        f1.getFormation().afficherQuiz();
        f1.getFormation().getQuizRef().get(0).afficherQuestionQuiz();
        System.out.println("************* Remplacement d'une question dans la quiz *************");
        //
        System.out.println("************** Affichage Formation ********************");
		//affichage de formation 
		System.out.println("Mr/Mrs :"+f1.getNom()+" Formation en :"+f1.getFormation().getNom()+" Debut en :"+f1.getFormation().getDatedebut()+" Fin En :"+f1.getFormation().getDatefin());
		if(f1.getFormation().getOpen())
		{
				System.out.println("Formation ouverte");
		}
		else 
		{
				System.out.println("Formation fermée");
		}
		System.out.println("*************** Apprenant repondent aux quiz *************");
		a2.ajouter();//ajouter les quiz pour que l'apprenant peut répondre
		a3.ajouter();
        a2.repondre();
        a3.repondre();
        
		System.out.println("*************** Classement et process *************");
		//
	    f1.progressApprenant("kherbach","ismail");
		f1.progressGroupe();
	    
		
		 
		
		 
		 
	}

}
