package application;

import java.io.*;
import Noyau.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.Image;

public class AutentificationForm extends Application {
private final GridPane gridd;
public AutentificationForm()
{
	//creation d'une grid pour contenir les champs textes 
	this.gridd=createloginPane();
	//le controle de la grid les champs et les erreurs 
	controlGrid(gridd);
}

public GridPane getGridPane()
{
	return gridd;
}
	@Override
	public void start(Stage loginStage) throws Exception {
		loginStage.setTitle("Bienvenu dans Esi Quiz ! ");
		Image image = new Image("/image/sololearn.png");
		loginStage.getIcons().add(image);
		//la scène
		Scene s=new Scene(gridd,800,500);
		//le stage 
		loginStage.setScene(s);
		loginStage.show();
		
		
	}
	//methode de création de la grid 
	private GridPane createloginPane()
	{
		//creation de la grid de sign in pour un apprenant 
		GridPane grido=new GridPane();
		//alignement de la gride 
		// Positionnement toute au centre 
        grido.setAlignment(Pos.CENTER);
        grido.setPadding(new Insets(40, 40, 40, 40));
        // Set les gapes (espaces entre les champs )
        grido.setHgap(10);
        grido.setVgap(10);
		
        //modification des colonnes de la gride 
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        grido.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
		
		return grido;
	}
	
	//methode de controle de cette interface 
	private void controlGrid(GridPane grid)
	{
		//entete de sign in 
        Label headerLabel = new Label("Se Connecter ");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 42));
        grid.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        
        //l'ajout des champs utilisée dans le sign in 
        // username champs 
        Label usernamelabel = new Label("Pseudo : ");
        usernamelabel.setFont(Font.font("Arial",FontWeight.BOLD,20));
        grid.add(usernamelabel, 0, 3);
        //  champs de nom d'utilisateur 
        TextField username = new TextField();
        username.setPrefHeight(40);
        grid.add(username, 1, 3);
        //mot de passe Label
        Label passwordLabel = new Label("Mot de Passe : ");
        passwordLabel.setFont(Font.font("Arial",FontWeight.BOLD,20));
        grid.add(passwordLabel, 0, 4);
        // mot de passe
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        grid.add(passwordField, 1, 4);
        // enregistrement boutoun 
        Button submitButton = new Button("Se Connecter");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        grid.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        // gestion de bouton 
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//traitement d'alert
            	//Ecriture des objets
            	ObjectInputStream in;
            	 //Récupération des objets stockés
            	
                if(username.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), " Erreur!", "SVP Entrez un Username ");
                    return;
                }
                
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), " Erreur!", "SVP Entrez un Mot de Passe");
                    return;
                }
                 //comparaison des données
                try {
                    //Récupération des objets stockés
                      in = new ObjectInputStream(
                      new BufferedInputStream(
                      new FileInputStream(
                      new File("formateur.dat"))));
                      try {
                    	  Formateur f=(Formateur)in.readObject();
                         if(f.getCompte()!=null)
                         {
                        	 if(f.getCompte().getLogin()==username.getText() && f.getCompte().getPassword()==passwordField.getText())
                        	 {
                        		 System.out.println("connecté");
                                 showAlert(Alert.AlertType.CONFIRMATION, grid.getScene().getWindow(), "Registration avec Succès!", "Bienvenu M."+f.getNom()+" "+f.getPrenom() );
                        	 }
                         }
                         else
                         {
                        	  showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), " Erreur!","Vous devez Créer Un Compte");
                         }
                      }
                      catch (ClassNotFoundException e)
                      {
                      	showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), " Erreur!", "Class Non Existante");
                      }
                      in.close();
                      return;
                      }
                      catch(FileNotFoundException e)
                      {
                      	showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), " Erreur!", "Fichier Non Existant");
                      	return;
                      }
                      catch(IOException e)
                      {
                      	showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), " Erreur!", "Input/Output Exception");
                                       
                      }
            }
        });
		
	}
	//methode d'alerts 
	 private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.initOwner(owner);
	        alert.show();
	    }
    //lancement de notre interface 
	    public static void main(String[] args) {
	        launch(args);
	    }

}
