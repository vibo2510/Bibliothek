
public class Buch extends Medium{
	String autor;
	
	
	public Buch(int medienID,String titel, boolean verfuegbarkeit, float leihgebuehr, String autor, String medientyp) {
		super(medienID, titel, verfuegbarkeit, leihgebuehr, medientyp);
		this.autor= autor;
	}
	
	public Buch( String titel, boolean verfuegbarkeit, float leihgebuehr, String autor, String medientyp) {
		super(titel, verfuegbarkeit, leihgebuehr, medientyp);
		this.autor= autor;
	}

}
