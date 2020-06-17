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

public class RegistrationFormApplication extends Application {
private final GridPane gridPane;
    public RegistrationFormApplication()
    {
    	// Create the registration form grid pane
        this.gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bienvenu Dans ESI Quiz");
        Image image = new Image("/image/sololearn.png");
		primaryStage.getIcons().add(image);
        // Add UI controls to the registration form grid pane
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);
        
        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("S'inscrire ");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 42));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Prénom: ");
        nameLabel.setFont(Font.font("Arial",FontWeight.BOLD,20));
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        //add Family Name text Field 
        Label famlabel=new Label("Nom : ");
        famlabel.setFont(Font.font("Arial",FontWeight.BOLD,20));
        gridPane.add(famlabel,0,2);
        
        //add family name text field 
        TextField familyname=new TextField();
        familyname.setPrefHeight(40);
        gridPane.add(familyname,1,2);
        
        // Add Username Label
        Label usernamelabel = new Label("Pseudo : ");
        usernamelabel.setFont(Font.font("Arial",FontWeight.BOLD,20));
        gridPane.add(usernamelabel, 0, 3);

        // Add username Text Field
        TextField username = new TextField();
        username.setPrefHeight(40);
        gridPane.add(username, 1, 3);

        // Add Password Label
        Label passwordLabel = new Label("Mot de Passe : ");
        passwordLabel.setFont(Font.font("Arial",FontWeight.BOLD,20));
        gridPane.add(passwordLabel, 0, 4);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 4);

        // Add Submit Button
        Button submitButton = new Button("S'inscrire");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(170);
        gridPane.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
 
                //création du fichier
            	//Ecriture des objets
            	ObjectInputStream in;
            	ObjectOutputStream out;
            	//création du nouveau formateur
            	Formateur prof=new Formateur();
                // traitment d'alerte
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Entrez Votre Prenom");
                    return;
                }
                else 
                { 
                	prof.setPrenom(nameField.getText()); //le prénom 
                }
                if(familyname.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Entrez votre Nom de Famille");
                    return;
                }
                else {
                	 prof.setNom(familyname.getText()); //le nom de famille
                }
                	
                if(username.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Entrez un Username ");
                    return;
                } 
             
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Entrez un Mot de Passe");
                    return;
                }
                prof.creerCompte(username.getText(),passwordField.getText());
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration avec Succès!", "Bienvenu" + familyname.getText()+" "+nameField.getText());
                try {
                out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("formateur.dat"))));
                out.writeObject(prof);
              //Fermer le flux
                out.close();
              //Récupération des objets stockés

                in = new ObjectInputStream(
                new BufferedInputStream(
                new FileInputStream(
                new File("formateur.dat"))));
                try {
                System.out.println("*************************\n");
                ((Formateur)in.readObject()).afficher();
                }

                catch (ClassNotFoundException e)
                {
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "Class Non Existante");
                }
                in.close();
                return;
                }
                catch(FileNotFoundException e)
                {
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "Fichier Non Existant");
                	return;
                }
                catch(IOException e)
                {
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "Input/Output Exception");
                                 
                }
                                
            }
            });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
	public GridPane getGridPane() {
		return gridPane;
	}
}