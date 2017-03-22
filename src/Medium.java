
public class Medium {
	int mediumID;
	String titel;
	boolean verfuegbarkeit;
	float Leihgebuehr;
	String medientyp;
	
	public Medium(int mediumID, String titel, boolean verfuegbarkeit, float leihgebuehr, String medientyp){
		this.mediumID= mediumID;
		this.titel= titel;
		this.verfuegbarkeit= verfuegbarkeit;
		this.Leihgebuehr= leihgebuehr;
		this.medientyp= medientyp;
	}
	public Medium( String titel, boolean verfuegbarkeit, float leihgebuehr, String medientyp){
		this.titel= titel;
		this.verfuegbarkeit= verfuegbarkeit;
		this.Leihgebuehr= leihgebuehr;
		this.medientyp= medientyp;
	}
	
	
	
}
