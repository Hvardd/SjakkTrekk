import java.util.ArrayList;
import java.io.*;

import java.io.Serializable;


public class ResultatParti implements Serializable {

// 	Serialize serialize = new Serialize();

	String dato;
	String klokkeslett;

	String spiller1;
	String spiller2;

	String turneringID;
	String vinner;

	ArrayList<String> trekk;
	ArrayList<String> kommentarkode;


	public ResultatParti(String dato, String klokkeslett, String spiller1, String spiller2,
						 String turneringID, String vinner, ArrayList<String> trekk, ArrayList<String> kommentarkode ) {

						 this.dato = dato;
						 this.klokkeslett = klokkeslett;
						 this.spiller1 = spiller1;
						 this.spiller2 = spiller2;
						 this.turneringID = turneringID;
						 this.vinner = vinner;
						 this.trekk = trekk;
						 this.kommentarkode = kommentarkode; 

						 
	}

	public void skrivTilFil(ResultatParti resultatParti) {
		try {
			FileOutputStream fileOut = new FileOutputStream(resultatParti.getFilNavn() +".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(resultatParti);
			out.close();
			fileOut.close();		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void skrivTilFilTekst(ResultatParti resultatParti) {

		 try {
			FileWriter fw = new FileWriter(resultatParti.getFilNavn() + ".txt");
				fw.write("Turnering: " );
				fw.write(turneringID + "\n");
				fw.write("Klokkeslett: " + klokkeslett);
				fw.write(" Dato: " + dato + "\n");
				fw.write("Spiller1 : " + spiller1 + " Spiller 2: " + spiller2 + "\n");
				fw.write("Vinner: " + vinner + "\n");
				fw.write("Trekk" + "\n");


				for(int i=0; i<trekk.size(); i++) {
					fw.write(i+1 + " " + trekk.get(i) + " Kommentarkode: " + kommentarkode.get(i) + " \n");
				}
				fw.close();
			} 
		
		catch(IOException e) {
			System.out.println("Error");
			}

	}

	public String getFilNavn() {
		String filnavn; 
		filnavn = spiller1 + "_" + spiller2 + "_" + dato + "_" + klokkeslett; 
		return filnavn;
	}


}