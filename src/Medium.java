
public class Medium {
	int mediumID;
	String titel;
	boolean verfuegbarkeit;
	float leihgebuehr;
	String medientyp;
	
	public Medium(int mediumID, String titel, boolean verfuegbarkeit, float leihgebuehr, String medientyp){
		this.mediumID= mediumID;
		this.titel= titel;
		this.verfuegbarkeit= verfuegbarkeit;
		this.leihgebuehr= leihgebuehr;
		this.medientyp= medientyp;
	}
	public Medium( String titel, boolean verfuegbarkeit, float leihgebuehr, String medientyp){
		this.titel= titel;
		this.verfuegbarkeit= verfuegbarkeit;
		this.leihgebuehr= leihgebuehr;
		this.medientyp= medientyp;
	}
	
	
	
}
