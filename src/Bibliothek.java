import java.sql.Connection;
import java.sql.Date;
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
	PreparedStatement delteMedium;
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
		 	delteMedium= connection.prepareStatement("delete from Medium where mediumid=?");
		 	updateMedium= connection.prepareStatement("update Medium set titel=?, verfuegbarkeit=?,  leihgebuehr=?, autor=?, regisseur=?, hauptdarsteller=?, medientyp=? where mediumid=?");
		 	searchMediumById= connection.prepareStatement("select * from Medium where mediumid=?");
		 	searchMediumByTitle= connection.prepareStatement("select * from Medium where title=?");
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
					medien.add(new Medium());
				}
			break;
		}
			return medien;

		}
		
		
	
	
	public boolean mediumHinzufuegen(Medium medium) throws SQLException{
		
		
		insertMedium.setString(1, medium.titel);
		insertMedium.setBoolean(2, medium.verfuegbarkeit);
		insertMedium.setFloat(3, medium.Leihgebuehr);

		if(medium instanceof Buch){
			Buch buch = (Buch) medium;
			insertMedium.setString(4,buch.autor);
			insertMedium.setString(5,null);
			insertMedium.setString(6,null);
			insertMedium.setString(7,buch.medientyp);
		}
		if(medium instanceof DVD){
			DVD dvd = (DVD) medium;
			insertMedium.setString(4,null);
			insertMedium.setString(5, dvd.regisseur);
			insertMedium.setString(6, dvd.hauptdarsteller);
			insertMedium.setString(7,dvd.medientyp);
		}
		
		return insertMedium.execute();
	}
	
	public boolean mediumEntfernen(Medium medium) throws SQLException{
		delteMedium.setInt(1, medium.mediumID);
		return delteMedium.execute();
	}
	
	/*
	public boolean mediumAendern(Medium medium) throws SQLException{
		
			updateMedium.setInt(1, medium.mediumID);
			
		
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
		Buch buch = new Buch(2,"harry potter 2",0.5F,"J.K.Roling","Buch");
		/*
		try {
			bib.mediumHinzufuegen(buch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		bib.mediumEntfernen(buch);
	
	}
		
		
		
	
}
