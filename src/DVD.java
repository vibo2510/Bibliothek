import java.util.Date;

public class DVD extends Medium{
	String regisseur;
	String hauptdarsteller;
	
	public DVD(String mediumID, String titel, String genere, String isbn, Date erscheinungsdatum, int leihgebuehr, String regisseur, String hauptdarsteller) {
		super(mediumID, titel, genere, isbn, erscheinungsdatum, leihgebuehr);
		this.regisseur= regisseur;
		this.hauptdarsteller= hauptdarsteller;
	}

}
