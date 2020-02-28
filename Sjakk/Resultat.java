import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.control.ComboBox;


public class Resultat extends Application {

	private final int  WIDTH = 440;
	private final int  HEIGHT = 440;


		Brukere bruker;
		ResultatParti resultatParti;

		ArrayList<TextField> textFieldSamling = new ArrayList<TextField>();	
		ArrayList<TextField> textFieldSamlingKommentarKode = new ArrayList<TextField>();
		ArrayList<String> trekkArray = new ArrayList<String>();
		ArrayList<String> kommentarArray = new ArrayList<String>();	
	    // ArrayList<Brukere> brukerSamling = new ArrayList<Brukere>(); // Gjør om til teksttrekk 
		Serialize serialize = new Serialize();

		Label datoLabel = new Label("Dato");
		Label klokkeSlettLabel = new Label("Klokkeslett");
		Label spiller1Label = new Label("Spiller 1:");
		Label spiller2Label = new Label("Spiller 2:");
		Label vinnerLabel = new Label("Vinner: ");
		Label antTrekkLabel = new Label("Trekk: "); 
		Label turneringIDLabel = new Label("Turnering ID: ");
		// Label resultatLabel = new Label("Resultat");

		Label trekkLabel = new Label("Trekk");
		Label kommentarKodeLabel = new Label("Kommentar kode");

		TextField datoTekstBoks = new TextField();
		TextField klokkeSlettTekstBoks = new TextField();
		TextField spiller1TekstBoks = new TextField();
		TextField spiller2TekstBoks = new TextField();
		TextField vinnerTekstBoks = new TextField();
		TextField antTrekk = new TextField();
		TextField turneringIDtekstBoks = new TextField();

		TextField tekstTrekk = new TextField();
		TextField tekstKommentarKode = new TextField();

		Button antTrekkKnapp = new Button("Velg");
		Button registrerKnapp = new Button("Registrer");



	public void start(Stage primaryStage) {
		

		BorderPane bp = new BorderPane();
		GridPane gp = new GridPane(); 
		GridPane gpMidten = new GridPane();  	
		ScrollPane scrollPane = new ScrollPane();

		scrollPane.setPrefSize(120, 120);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	 
		HBox hboxButtom = new HBox(); 
	    gp.setAlignment(Pos.CENTER);

		ComboBox comboBox = new ComboBox();
		comboBox.getItems().addAll("Spiller 1","Spiller 2","Remis");
		// comboBox.setItems(options);


		turneringIDtekstBoks.setOnAction((ActionEvent e) -> {
            turneringIDtekstBoks.setDisable(true);
            turneringIDtekstBoks.setEditable(false);
        });

       
		
			// Legg til trekk i applikasjon 
	    antTrekkKnapp.setOnMousePressed(e-> {

			int value = Integer.parseInt(antTrekk.getText());
			gpMidten.getChildren().clear();
			textFieldSamling.clear();
			textFieldSamlingKommentarKode.clear();

			if (value > 0 ) {
			gpMidten.add(trekkLabel,0,0);
			gpMidten.add(kommentarKodeLabel,1,0);
			}
	
			 for (int i=1; i<=value; i++) {
			 	tekstTrekk = new TextField("" + (i));
			 	tekstKommentarKode = new TextField("" + (i));
			 	textFieldSamling.add(tekstTrekk);
			 	textFieldSamlingKommentarKode.add(tekstKommentarKode);
			 	gpMidten.add(tekstTrekk,0,i);
			 	gpMidten.add(tekstKommentarKode,1,i);
			 } 
		
			 	scrollPane.setContent(gpMidten);

		});



	    	// Registrer resultat 
		registrerKnapp.setOnMousePressed(e-> {

			trekkArray.clear();
			kommentarArray.clear();

			  for (int i=0; i<textFieldSamling.size(); i++) {

			  	trekkArray.add(textFieldSamling.get(i).getText());
			  	kommentarArray.add(textFieldSamlingKommentarKode.get(i).getText());
				//bruker = new Brukere(textFieldSamling.get(i).getText());
				// brukerSamling.add(bruker);

			}  

			String dato = datoTekstBoks.getText();
			String tidspunkt = klokkeSlettTekstBoks.getText();
			String spiller1 = spiller1TekstBoks.getText();
			String spiller2 = spiller2TekstBoks.getText();
			String turneringID = turneringIDtekstBoks.getText();
			String vinner = (comboBox.getValue().toString());

			resultatParti = new ResultatParti(dato,tidspunkt,spiller1,spiller2,turneringID,vinner,trekkArray,kommentarArray);

			// serialize.serializeResultatParti(resultatParti);
			resultatParti.skrivTilFil(resultatParti);
			resultatParti.skrivTilFilTekst(resultatParti);


			System.out.println(resultatParti.getFilNavn());
		// 	System.out.println(kommentarArray);
			// resultatParti = new ResultatParti();

		});

		// TOPP 

		gp.add(datoLabel,0,0);
		gp.add(datoTekstBoks,1,0);
		datoTekstBoks.setMaxWidth(100);

		gp.add(klokkeSlettLabel,2,0);
		gp.add(klokkeSlettTekstBoks,3,0);
		klokkeSlettTekstBoks.setMaxWidth(100);

		gp.add(spiller1Label,0,1);
		gp.add(spiller1TekstBoks,1,1);
		spiller1TekstBoks.setMaxWidth(100);

		gp.add(spiller2Label,2,1);
		gp.add(spiller2TekstBoks,3,1);
		spiller2TekstBoks.setMaxWidth(100);

		gp.add(antTrekkLabel,0,2);
		gp.add(antTrekk,1,2);
		antTrekk.setMaxWidth(100);

		gp.add(turneringIDLabel,2,2);
		gp.add(turneringIDtekstBoks,3,2);
		turneringIDtekstBoks.setMaxWidth(100);

		gp.add(antTrekkKnapp,0,3);
		gp.add(vinnerLabel,2,3);
		gp.add(comboBox,3,3);

		// gp.setHgap(10);
	
		hboxButtom.getChildren().addAll(registrerKnapp);

		bp.setTop(gp);
		bp.setCenter(scrollPane);
		bp.setBottom(hboxButtom);



		// Padding

		gp.setPadding(new Insets(10,10,10,10)); // Topp 
		bp.setPadding(new Insets(10,10,10,10));  // Bp 
		scrollPane.setPadding(new Insets(10,40,10,40)); // Midten
		hboxButtom.setPadding(new Insets(10,10,10,10)); // Buttom 

		// Scene 

		Scene scene = new Scene(bp,WIDTH,HEIGHT);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Trekk Registrering");



	}


	public static void main(String[] args) {
		launch(args);
	}

}