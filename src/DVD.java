

public class DVD extends Medium{
	String regisseur;
	String hauptdarsteller;
	
	public DVD(int mediumID, String titel, boolean verfuegbarkeit, float leihgebuehr, String regisseur, String hauptdarsteller, String medientyp) {
		super(mediumID, titel,verfuegbarkeit, leihgebuehr, medientyp);
		this.regisseur= regisseur;
		this.hauptdarsteller= hauptdarsteller;
	}
	
	public DVD(String titel, boolean verfuegbarkeit, float leihgebuehr, String regisseur, String hauptdarsteller, String medientyp) {
		super(titel, verfuegbarkeit, leihgebuehr, medientyp);
		this.regisseur= regisseur;
		this.hauptdarsteller= hauptdarsteller;
	}

}
