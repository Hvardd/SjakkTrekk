import java.util.ArrayList;
import java.io.*;

import java.io.Serializable;

public class Serialize { // implements Serializable 

	ArrayList<Brukere> brukerListe;
	ArrayList<Brukere> returArray = new ArrayList<Brukere>();
	 ResultatParti resultatSer;

	// ResultatParti resultatParti;

		public Serialize() {

		}

	public void serializeResultatParti(ResultatParti resultatParti) {



		try {
			FileOutputStream fileOut = new FileOutputStream(resultatParti.getFilNavn() +".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(resultatParti);
			out.close();
			fileOut.close();	

		} catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}	

	public ResultatParti deserialiserResultatParti(String filNavn) throws Exception {
		
		// try {
				ObjectInputStream inR = new ObjectInputStream(new FileInputStream(filNavn));
				resultatSer = (ResultatParti) inR.readObject();
				inR.close();
		// } catch(Exception e) {
			// System.out.println(e.getMessage());
	//	} finally {
				return resultatSer;
	// 	} 
	}

	public ResultatParti deserialiserResultatParti2(String filNavn) {
		 ResultatParti e = null;
      try {
         FileInputStream fileIn = new FileInputStream(filNavn);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (ResultatParti) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return null;
      } catch (ClassNotFoundException c) {
         System.out.println("ResultatParti class not found");
         c.printStackTrace();
         return null;
      }
      
      System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.dato);
      System.out.println("Address: " + e.klokkeslett);
      System.out.println("SSN: " + e.spiller1);
      System.out.println("Number: " + e.spiller2);

      return e;
	}

	 // ArrayList
	public ArrayList<Brukere> deserialiserArrayListe(String tekst) {

		try {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(tekst));
		returArray = (ArrayList<Brukere>) in.readObject();
		in.close();

		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return returArray;
	}




}