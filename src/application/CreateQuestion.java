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


public class CreateQuestion extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//icon de l'application
		Image image = new Image("/image/sololearn.png");
		stage.getIcons().add(image);
		stage.setTitle("Création d'une Question");
		//grid de la page
		GridPane question=createquestionsPane();
		//controle de grid 
		addUIControls(question);
		//la scène
		Scene scene = new Scene(question, 800, 500);
        //la scène 
        stage.setScene(scene);
        stage.show();
				
	}
	
//gridpane pour création des questions 	
		private GridPane createquestionsPane() {
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
		
//contole de grid 
		 private void addUIControls(GridPane gridPane) {
		        // Add Header
		        Label headerLabel = new Label("Créer Question ");
		        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		        gridPane.add(headerLabel, 0,0,2,1);
		        GridPane.setHalignment(headerLabel, HPos.CENTER);
		        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

		        // Add qcm bouton
		        Button qcm = new Button("QCM");
		        //gridPane.add(qcm, 0,1);
		        qcm.setPrefHeight(90);
		        qcm.setDefaultButton(true);
		        qcm.setPrefWidth(200);
		        gridPane.add(qcm, 0, 1, 2, 1);
		        GridPane.setHalignment(qcm, HPos.CENTER);
		        GridPane.setMargin(qcm, new Insets(20, 0,20,0));
		        //handler du QCM

		        //add qcu bouton
		        Button qcu=new Button("QCU");
		        //gridPane.add(qcu,0,2);
		        qcu.setPrefHeight(90);
		        qcu.setDefaultButton(true);
		        qcu.setPrefWidth(200);
		        gridPane.add(qcu, 0, 2, 2, 1);
		        GridPane.setHalignment(qcu, HPos.CENTER);
		        GridPane.setMargin(qcu, new Insets(20, 0,20,0));
		        //handler du QCU
		      
		        // Add qo 
		        Button qo = new Button("QO");
		        //gridPane.add(qo, 0, 3);
		        qo.setPrefHeight(90);
		        qo.setDefaultButton(true);
		        qo.setPrefWidth(200);
		        gridPane.add(qo, 0, 3, 2, 1);
		        GridPane.setHalignment(qo, HPos.CENTER);
		        GridPane.setMargin(qo, new Insets(20, 0,20,0));
                //handler du QO !!
		
		    }
		 
		 //lancement du stage
		 public static void main(String[] args) {
		        launch(args);
		    }

}
