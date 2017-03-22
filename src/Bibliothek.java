import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bibliothek {
	String name;
	String anschrift;
	Connection connection;
	PreparedStatement insertMedium;
	PreparedStatement deleteMedium;
	PreparedStatement updateMedium;
	PreparedStatement searchMediumById;
	PreparedStatement searchMediumByTitle;
	
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
		 	insertMedium= connection.prepareStatement("insert into Medium(titel, verfuegbarkeit, leihgebuehr,  autor, regisseur, hauptdarsteller, medientyp) values(?,?,?,?,?,?,?)");
		 	deleteMedium= connection.prepareStatement("delete from Medium where mediumid=?");
		 	updateMedium= connection.prepareStatement("update Medium set titel=?, verfuegbarkeit=?,  leihgebuehr=?, autor=?, regisseur=?, hauptdarsteller=?, medientyp=? where mediumid=?");
		 	searchMediumById= connection.prepareStatement("select * from Medium where mediumid=?");
		 	searchMediumByTitle= connection.prepareStatement("select * from Medium where titel=?");
	}
	
	public ArrayList<Medium> sucheMedium(String suchbegriff, Suchtyp s) throws SQLException{
		ResultSet result;
		ArrayList<Medium> medien= new ArrayList<>();
		
		switch(s){
			case MEDIUM_ID:  
				searchMediumById.setInt(1, Integer.parseInt(suchbegriff));
				result=searchMediumById.executeQuery();
				while(result.next()){	
					medien.add(new Buch(result.getInt("mediumid"),result.getString("titel"), result.getBoolean("verfuegbarkeit"), result.getFloat("leihgebuehr"), result.getString("autor"), result.getString("medientyp")));
				}
			break;
			
			case MEDIUM_TITLE: 
				searchMediumByTitle.setString(1, suchbegriff);
				result=searchMediumById.executeQuery();
				while(result.next()){	
					medien.add(new DVD(result.getInt("mediumid"),result.getString("titel"), result.getBoolean("verfuegbarkeit"), result.getFloat("leihgebuehr"), result.getString("regisseur"), result.getString("hauptdarsteller"), result.getString("medientyp")));
				}
			break;
		}
			return medien;

		}
		
		
	
	
	public boolean mediumHinzufuegen(Medium medium) throws SQLException{
		
		
		insertMedium.setString(1, medium.titel);
		insertMedium.setBoolean(2, medium.verfuegbarkeit);
		insertMedium.setFloat(3, medium.leihgebuehr);

		if(medium instanceof Buch){
			Buch buch = (Buch) medium;
			insertMedium.setString(4,buch.autor);
			insertMedium.setString(5,null);
			insertMedium.setString(6,null);
		}
		if(medium instanceof DVD){
			DVD dvd = (DVD) medium;
			insertMedium.setString(4,null);
			insertMedium.setString(5, dvd.regisseur);
			insertMedium.setString(6, dvd.hauptdarsteller);
		}
			insertMedium.setString(7, medium.medientyp);
		
		return insertMedium.execute();
	}
	
	public boolean mediumEntfernen(Medium medium) throws SQLException{
		deleteMedium.setInt(1, medium.mediumID);
		return deleteMedium.execute();
	}
	
	
	public boolean mediumAendern(Medium mediumGeaendert) throws SQLException{
			updateMedium.setString(1, mediumGeaendert.titel);
			updateMedium.setBoolean(2, mediumGeaendert.verfuegbarkeit);
			updateMedium.setFloat(3, mediumGeaendert.leihgebuehr);
			if(mediumGeaendert instanceof Buch){
				Buch buch= (Buch) mediumGeaendert;
				updateMedium.setString(4, buch.autor);
				updateMedium.setString(5, null);
				updateMedium.setString(6, null);
			}
			
			if(mediumGeaendert instanceof DVD){
				DVD dvd= (DVD) mediumGeaendert;
				updateMedium.setString(4, null);
				updateMedium.setString(5, dvd.regisseur);
				updateMedium.setString(6, dvd.hauptdarsteller);
			}
			updateMedium.setString(7, mediumGeaendert.medientyp);
			
			//für where-Anweisung
			updateMedium.setInt(8, mediumGeaendert.mediumID);
			
			
		return updateMedium.execute();
	}
	/*
	
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
		Buch buch = new Buch(3,"harry potter 2",true,0.5F,"J.K.Roling","Buch");
		
		
		//bib.mediumHinzufuegen(buch);
	
		bib.mediumEntfernen(buch);
	
	}
		
		
		
	
}
