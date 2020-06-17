package application;

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

public class CreatNotion extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image("/image/sololearn.png");
		stage.getIcons().add(image);
          stage.setTitle("Création d'une Notion ");
          //création du grid avec ses alignement 
          GridPane notion=createnotionPane();
          //ajout des controles de grid 
          addUIControls(notion);
          Scene scene = new Scene(notion, 800, 500);
          //la scène 
          stage.setScene(scene);
          stage.show();
	
	}
	
//gridpane pour création des notions 	
	private GridPane createnotionPane() {
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
	        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	        columnOneConstraints.setHalignment(HPos.RIGHT);

	        // columnTwoConstraints will be applied to all the nodes placed in column two.
	        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	        columnTwoConstrains.setHgrow(Priority.ALWAYS);

	        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

	        return gridPane;
	    }
// controle de la grid des notions 
	private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Créer Notion");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Titre : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField titre = new TextField();
        titre.setPrefHeight(40);
        titre.setMaxWidth(500);
        gridPane.add(titre, 1,1);


        //add Nombre de question text Field 
        Label famlabel=new Label("Nombre \r\n Des Question : ");
        gridPane.add(famlabel,0,2);
        
        //add nombre de question text field 
        TextField nombre=new TextField();
        nombre.setPrefHeight(40);
        nombre.setMaxWidth(500);
        gridPane.add(nombre,1,2);
        


        // Add Submit Button
        Button submitButton = new Button("Suivant");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(titre.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Entrez le titre de la notion");
                    return;
                }
                
                if(nombre.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Entrez le nombre de question !!");
                    return;
                }
 
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration avec Succès!", "Vous allez créer les question   " );
            }
        });
    }
// message d'alert au cas où le champs de formumlaire est vide 
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
	
	//lancement 
	public static void main(String[] args) {
        launch(args);
    }

}
