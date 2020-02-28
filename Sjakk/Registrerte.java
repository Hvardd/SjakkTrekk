import java.util.ArrayList;
import java.io.*;

public class Registrerte {

	ArrayList<Brukere> brukerListe;
	ArrayList<Brukere> returArray = new ArrayList<Brukere>();
	String turneringID;

	public Registrerte(ArrayList<Brukere> brukerListe, String turneringID) {
		this.brukerListe = brukerListe;
		this.turneringID = turneringID;
		skrivTilFil();
		skrivTilFilText();
	}

	// Serialsering 
	private void skrivTilFil() {
		try {
			FileOutputStream fileOut = new FileOutputStream(turneringID +".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(brukerListe);
			out.close();
			fileOut.close();		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void skrivTilFilText() {

	    try {
			FileWriter fw = new FileWriter(turneringID + ".txt");
				fw.write("Registrerte Brukere: " + "\n");
				for(int i=0; i<brukerListe.size(); i++) {
					fw.write(i+1 + ": " + brukerListe.get(i).getNavn() +" \n");
				}
				fw.close();
			} 
		
		catch(IOException e) {
			System.out.println("Error");
			}
		

	}

	// Error 
	public ArrayList<Brukere> deserialiserArrayListe(String tekst) {

		try {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(tekst));
		returArray = (ArrayList<Brukere>) in.readObject();
		in.close();

		} catch(Exception e) {
			System.out.println("Error");
		} 
		return returArray;
	}



}