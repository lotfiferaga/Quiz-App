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

public class CreateQuiz extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image("/image/sololearn.png");
		stage.getIcons().add(image);
		stage.setTitle("Génération d'un Quiz");
		//grid 
		GridPane gri=createquizsPane();
		//CTRL
		addUIControls(gri);
		//scene
		Scene s=new Scene(gri,800,500);
		stage.setScene(s);
		stage.show();
	}
	//gridpane pour création des quizs 	
			private GridPane createquizsPane() {
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
			        columnTwoConstrains.setHalignment(HPos.CENTER);

			        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

			        return gridPane;
			    }
//controle du grid 
private void addUIControls(GridPane gridPane) {
			        // Add Header
			        Label headerLabel = new Label("Quiz ");
			        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
			        gridPane.add(headerLabel, 0,0,2,1);
			        GridPane.setHalignment(headerLabel, HPos.CENTER);
			        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
		            
			       // Add Label
			        Label q = new Label("Titre: ");
			        q.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			        gridPane.add(q,0,1);
			        //quiz field 
			        TextField quiz = new TextField();
			        quiz.setPrefHeight(40);
			        quiz.setMaxWidth(310);
			        gridPane.add(quiz, 1,1);
			         
			        // Add Label
			        Label date1 = new Label(" Date  d'Ouverture: ");
			        date1.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			        gridPane.add(date1,0,2);

			        // Add les  Text Field 
			        //1
			        TextField nameField = new TextField();
			        nameField.setPrefHeight(40);
			        nameField.setMaxWidth(310);
			        gridPane.add(nameField, 1,2);
			        	        
			        //add label
			        Label vrai=new Label("Date d'Expiration : ");
			        vrai.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			        gridPane.add(vrai,0,3);
			        //
			        TextField nameField2 = new TextField();
			        nameField2.setPrefHeight(40);
			        nameField2.setMaxWidth(310);
			        gridPane.add(nameField2, 1,3);
			        //label
			        Label v=new Label("Ouverte : ");
			        v.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			        gridPane.add(v,0,4);
			        
			        //
			        TextField pvrai=new TextField();
			        pvrai.setPrefHeight(40);
			        pvrai.setMaxWidth(310);
			        gridPane.add(pvrai,1,4);

			        // Add Submit Button
			        Button submitButton = new Button("Suivant");
			        submitButton.setPrefHeight(40);
			        submitButton.setDefaultButton(true);
			        submitButton.setPrefWidth(100);
			        gridPane.add(submitButton, 0, 6, 2, 1);
			        GridPane.setHalignment(submitButton, HPos.CENTER);
			        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

			        submitButton.setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent event) {
			            	if(quiz.getText().isEmpty()) {
			                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Saisir le titre de quiz");
			                    return;
			                }
			            	if(nameField.getText().isEmpty()) {
			                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Saisir la date d'ouverture");
			                    return;
			                }
			                if(nameField2.getText().isEmpty()) {
			                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP Saisir la date d'expiration");
			                    return;
			                }
			                
			                if(pvrai.getText().isEmpty()) {
			                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), " Erreur!", "SVP dit est-ce que le quiz est ouvert ?");
			                    return;
			                }

			                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration avec Succès!", "Continuer Pour Créer D'autres Quiz");
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
	 
	//lancement 
		public static void main(String[] args) {
	        launch(args);
	    }


}
