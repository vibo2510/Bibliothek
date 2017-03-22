import java.util.Date;

public class Medium {
	String mediumID;
	String titel;
	String genre;
	String isbn;
	Date erscheinungsdatum;
	boolean verfuegbarkeit;
	float Leihgebuehr;
	
	public Medium(String mediumID, String titel, String genere, String isbn, Date erscheinungsdatum, float leihgebuehr){
		this.mediumID= mediumID;
		this.titel= titel;
		this.genre= genere;
		this.isbn= isbn;
		this.erscheinungsdatum= erscheinungsdatum;
		this.verfuegbarkeit= true;
		this.Leihgebuehr= leihgebuehr;
	}
	public Medium( String titel, String genere, String isbn, Date erscheinungsdatum, float leihgebuehr){
		this.titel= titel;
		this.genre= genere;
		this.isbn= isbn;
		this.erscheinungsdatum= erscheinungsdatum;
		this.verfuegbarkeit= true;
		this.Leihgebuehr= leihgebuehr;
	}
	
	
	
}
