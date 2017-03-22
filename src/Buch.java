import java.util.Date;

public class Buch extends Medium{
	String autor;
	
	
	public Buch( String titel, String genere, float leihgebuehr, String isbn, Date erscheinungsdatum,  String autor) {
		super(titel, genere, isbn, erscheinungsdatum, leihgebuehr);
		this.autor= autor;
	}

}
