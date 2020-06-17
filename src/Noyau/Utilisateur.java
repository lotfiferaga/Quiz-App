package Noyau;

public abstract class Utilisateur {
	  // liste des méthodes 
	//méthode d’authentification pour la connexion au compte formateur ou bien l’apprenant
	abstract boolean authentifier(Compte compte);
	//méthode pour effectuer les modifications et renvoie un booléen pour connaitre si l’opération est bien effectuée
	abstract boolean modifier(Compte compte,String modifier,String input);
	//méthode pour effectuer la sauvegarde des ajouts et des modifications
	abstract void sauvegarder();
	//méthode pour effectuer l’ajout dans un quiz ou bien un compte
	abstract void ajouter();
	//méthode pour affichage et visualiser les objets entrée en paramètre
	abstract void visualiser();
    //méthode pour validation des informations concernant les objets
	abstract void valider();
      
}
