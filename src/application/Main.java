package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;
import java.io.*;
import Noyau.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Image image = new Image("/image/sololearn.png");
			primaryStage.getIcons().add(image);
			primaryStage.setTitle("ESI Quiz");
			GridPane root =createPane();
			addUIControls(root,primaryStage);
			root.setId("pane");
			Scene scene = new Scene(root,800,500);
			scene.setFill(Color.DARKSALMON);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
//grid du main
	 private GridPane createPane() {
	        // Instantiate a new Grid Pane
	        GridPane gridPane = new GridPane();

	        // Position the pane at the center of the screen, both vertically and horizontally
	        gridPane.setAlignment(Pos.TOP_CENTER);

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
//
//contole de grid 
private void addUIControls(GridPane gridPane,Stage prim) {
	        // Add Header
	        Label headerLabel = new Label("ESI Quiz");
	        headerLabel.setTextFill(Color.STEELBLUE);
	        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 42));

	        gridPane.add(headerLabel, 0,0,2,1);
	        GridPane.setHalignment(headerLabel, HPos.CENTER);
	        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

	        // Add bouton
	        Button nouv = new Button("S'inscrire");
	        nouv.setPrefHeight(90);
	        nouv.setFont(Font.font("Arial",FontWeight.BOLD,18));
	        nouv.setDefaultButton(true);
	        nouv.setPrefWidth(200);
	        gridPane.add(nouv, 0, 1, 2, 1);
	        GridPane.setHalignment(nouv, HPos.CENTER);
	        GridPane.setMargin(nouv, new Insets(20, 0,20,0));
	        nouv.setOnAction(e->{
	        	RegistrationFormApplication form=new RegistrationFormApplication();
	        	prim.getScene().setRoot(form.getGridPane());
	        
	        }
	        );

	        //add bouton
	        Button con=new Button("Se Connecter");
            con.setFont(Font.font("Arial",FontWeight.BOLD,18));
	        con.setPrefHeight(90);
	        con.setDefaultButton(true);
	        con.setPrefWidth(200);
	        gridPane.add(con, 0, 2, 2, 1);
	        GridPane.setHalignment(con, HPos.CENTER);
	        GridPane.setMargin(con, new Insets(20, 0,20,0));
	        con.setOnAction(e->{
	        	AutentificationForm f=new AutentificationForm();
	        	prim.getScene().setRoot(f.getGridPane());
	        });
	        
	    }
	 
	
	public static void main(String[] args) {
		launch(args);
	}
}
