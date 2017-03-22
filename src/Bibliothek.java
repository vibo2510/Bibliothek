import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bibliothek {
	String name;
	String anschrift;
	Connection connection;
	PreparedStatement insertMedium;
	
	public Bibliothek(String name, String anschrift) throws ClassNotFoundException, SQLException{
		this.name = name;
		this.anschrift= anschrift;
		
		Class.forName("org.h2.Driver");
			try {
				connection= DriverManager.getConnection("jdbc:h2:~/bibliothekdb","sa","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	insertMedium= connection.prepareStatement("insert into Medium(titel, verfuegbarkeit, genre, leihgebuehr, isbn, erscheinungsdatum,   autor, regisseur, hauptdarsteller) values(?,?,?,?,?,?,?,?,?)");
		
	}
	
	//public Medium sucheMedium(Medium medium){
		
	//}
	
	public boolean mediumHinzufuegen(Medium medium) throws SQLException{
		
		
		insertMedium.setString(1, medium.titel);
		insertMedium.setBoolean(2, medium.verfuegbarkeit);
		insertMedium.setString(3, medium.genre);
		insertMedium.setFloat(4, medium.Leihgebuehr);
		insertMedium.setString(5, medium.isbn);
		insertMedium.setDate(6, (Date) medium.erscheinungsdatum);
		
		
		if(medium instanceof Buch){
			Buch buch = (Buch) medium;
			insertMedium.setString(7,buch.autor);
			insertMedium.setString(8,null);
			insertMedium.setString(9,null);
		}
		if(medium instanceof DVD){
			DVD dvd = (DVD) medium;
			insertMedium.setString(7,null);
			insertMedium.setString(8, dvd.regisseur);
			insertMedium.setString(9, dvd.hauptdarsteller);
		}
		
		return insertMedium.execute();
	}
	
	/*public boolean mediumEntfernen(){
	
	}
	
	public boolean mediumAendern(){
		
	}
	
	public boolean verleihEintragen(){
		
	}
	
	public boolean rueckgabeEintragen(){
		
	}
	
	public boolean neuesMitglied(){
		
	}
	
	public boolean mitgliedIDpruefen(){
		
	}*/
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Bibliothek bib = new Bibliothek("HFU","Furtwangen");
		Date d = new Date(2016,10,3);
		Buch buch = new Buch("harry potter","fantasy",0.5F,"hif43-556",d,"J.K.Roling");
		try {
			bib.mediumHinzufuegen(buch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
		
		
	
}
