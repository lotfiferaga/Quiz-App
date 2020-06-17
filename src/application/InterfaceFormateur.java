package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.Image;

public class InterfaceFormateur extends Application {

	@Override
	public void start(Stage stageformateur) throws Exception {
          //entete pour afficher ses infos 
		 stageformateur.setTitle("Profile de Formateur");
		 Image image = new Image("/image/sololearn.png");
		 stageformateur.getIcons().add(image);
		 //créer le gride des boutons 
		 
		 
		 //création d'un vbox pour contenir les boutons 
		 
		//le stage 
		//stageformateur.setScene();
		stageformateur.show();
		
		
	}
	
	private GridPane gridformateur()
	{
		//creation de la grid de sign in pour un apprenant 
				GridPane grido=new GridPane();
				//alignement de la gride 
				// Positionnement toute au centre 
		        grido.setAlignment(Pos.CENTER);
		        grido.setPadding(new Insets(40, 40, 40, 40));
		        // Set les gapes (espaces entre les champs )
		        grido.setHgap(5);
		        grido.setVgap(5);
				
		        //modification des colonnes de la gride 
		        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		        columnOneConstraints.setHalignment(HPos.RIGHT);
		        grido.getColumnConstraints().addAll(columnOneConstraints);
		       
				
				return grido;
	}
	
	//creation des boutons et leurs alignement 
	private VBox lesboutonsvbox()
	{
		//creer formation
		Button b1=new Button();
		b1.setPrefHeight(80);
		b1.setText("Apprenant");
		b1.setPrefWidth(200);
		//creer groupe 
		Button b2=new Button();
		b2.setPrefHeight(80);
		b2.setText("Visualiser Quiz");
		b2.setPrefWidth(200);
		//visualiser formation
		Button b3=new Button();
		b3.setPrefHeight(80);
		b3.setText("Créer Formation");
		b3.setPrefWidth(200);
		//Consulter un apprenant 
		Button b4=new Button();
		b4.setPrefHeight(80);
		b4.setText("Générer Quiz");
		b4.setPrefWidth(200);
		//creation du vbox 
		VBox vb=new VBox(b1,b2,b3,b4);
		//alignement duu VBox 
		vb.setAlignment(Pos.BASELINE_LEFT);
		vb.setPadding(new Insets(40,40,40,40));
		return  vb;
		
	}
	
	//lancement de notre interface 
    public static void main(String[] args) {
        launch(args);
    }

}
