import java.util.Date;

public class Ausleihe {
	Date ausleihTag;
	Date spaetesteRueckgabe;
	int gesamtGebuehr;
	Medium medium;
	
	public Ausleihe(Date ausleihTag, Date spaetesteRueckgabe, int gesamtGebuehr, Medium medium){
		this.ausleihTag= ausleihTag;
		this.spaetesteRueckgabe= spaetesteRueckgabe;
		this.gesamtGebuehr= gesamtGebuehr;
		this.medium= medium;
	}
}
