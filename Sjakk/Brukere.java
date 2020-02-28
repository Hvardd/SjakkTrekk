import java.io.Serializable;

public class Brukere implements Serializable{

	private String navn; 


	public Brukere(String navn) {
		this.navn = navn; 
	}

	public String getNavn() {
		return navn;
	}
	
}