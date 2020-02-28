import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.event.ActionEvent;
import java.io.*;


public class AdMapp extends Application {

	private final int WIDTH = 440;
	private final int HEIGHT = 440;

	TextField tekstBrukere = new TextField();
	// Label test2 = new Label();
	ArrayList<TextField> textFieldSamling = new ArrayList<TextField>();
	ArrayList<Brukere> brukerSamling = new ArrayList<Brukere>();
	ScrollPane scrollPane = new ScrollPane();
	Brukere bruker;
	Registrerte registrerteBrukere;

	public void start(Stage primaryStage) {

		
		// Panes
 


 	 	// Topp 
 	 	Label tekstTurneringID = new Label("Turnering ID: ");
 	 	TextField turneringID = new TextField();
		Label tekstAntSpillere = new Label("Skriv inn antall spillere: "); 
		TextField antSpillere = new TextField();  

		turneringID.setOnAction((ActionEvent e) -> {
            turneringID.setDisable(true);
            turneringID.setEditable(false);
        });

		Button antSpillereKnapp = new Button("Velg");

		// Nederst. 
		Button registrerKnapp = new Button("Registrer");

		// Pane size adjustment
		turneringID.setMaxWidth(100);
		antSpillere.setMaxWidth(40);

		// Layout 

		BorderPane bp = new BorderPane();

		VBox vbox = new VBox(4); // Topp
		VBox vboxSpillere = new VBox(4);  // Liste av spillere, Midten

		scrollPane = new ScrollPane();
		scrollPane.setPrefSize(120, 120);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		 

		HBox hboxButtom = new HBox();  // Nederst samling av knapper 
		// Layout posisjonering 

		vbox.setAlignment(Pos.CENTER);

		// Knapp funksjon 

		antSpillereKnapp.setOnMousePressed(e-> {

			int value = Integer.parseInt(antSpillere.getText());
			vboxSpillere.getChildren().clear();
			textFieldSamling.clear();

			
			 for (int i=0; i<value; i++) {
			 	tekstBrukere = new TextField("" + (i+1));
			 	textFieldSamling.add(tekstBrukere);
			 	vboxSpillere.getChildren().add(tekstBrukere);
			 } 
		
		// for (int y=0; y<textFieldSamling.size(); y++) {
			 	scrollPane.setContent(vboxSpillere);
	// 		 System.out.println(textFieldSamling.size());
			

		});

		registrerKnapp.setOnMousePressed(e-> {

			for (int i=0; i<textFieldSamling.size(); i++) {

				bruker = new Brukere(textFieldSamling.get(i).getText());
				brukerSamling.add(bruker);
				// System.out.println(bruker.navn);

			}

			 registrerteBrukere = new Registrerte(brukerSamling, turneringID.getText());

		});



		// Add Children 
		vbox.getChildren().addAll(tekstTurneringID, turneringID);
		vbox.getChildren().addAll(tekstAntSpillere,antSpillere,antSpillereKnapp);
		hboxButtom.getChildren().addAll(registrerKnapp);


		bp.setTop(vbox);
		bp.setCenter(scrollPane);
		bp.setBottom(hboxButtom);



		// Padding

		vbox.setPadding(new Insets(10,10,10,10)); // Topp 
		bp.setPadding(new Insets(10,10,10,10));  // Bp 
		scrollPane.setPadding(new Insets(10,40,10,40)); // Midten
		hboxButtom.setPadding(new Insets(10,10,10,10)); // Buttom 

		// Scene 

		Scene scene = new Scene(bp,WIDTH,HEIGHT);

	    //ArrayList<Brukere> returListe = registrerteBrukere.deserialiserArrayListe("test.ser");
	    //System.out.println(returListe.get(0).getNavn());

	    Serialize test = new Serialize();
	    // ArrayList<Brukere> returListe =  test.deserialiserArrayListe("Haavard_Peder_10.10.10_21.39.ser");
	    // System.out.println(returListe.get(0).getNavn());

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("AdMapp");




	}


	public static void main(String[] args) {
		launch(args);
	} 
}
