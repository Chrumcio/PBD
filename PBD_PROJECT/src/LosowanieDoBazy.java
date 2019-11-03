import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import Entity.Recepcjonistka;
import datafiles.Cities;
import datafiles.Names;
import datafiles.Streets;
import datafiles.Surnames;

public class LosowanieDoBazy {
	 private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
	        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	        return sDate;
	    }

	public static void addRecepcjonistka( int ile, String url, String user, String password) throws IOException {
		try (Connection con = DriverManager.getConnection(url, user, password)){
			for(int id=1;id<=ile;id++ ) {
				Recepcjonistka recepcjonistka = randRecepcjonistka(id);
				recepcjonistka.addRecepcjonistka(con);
			}
		}
		catch (SQLException ex) {
            ex.printStackTrace();
		}
		
		
			
	}
	
	public static Recepcjonistka randRecepcjonistka(int id) throws IOException {
		List<String> imiona=(new Names()).setListOfNames();
		List<String> nazwiska=(new Surnames()).setListOfSurnames();
		List<String> miasta=(new Cities()).setListOfCities();
		List<String> ulice=(new Streets()).setListOfStreets();
		
			
		String nazwisko;
	    String imie;
	    Date dataUrodzenia;
	    String adres = "";
	    String pesel="";
		
		
		
			
			
			Random r = new Random();
			int a = r.nextInt(imiona.size());	
			imie = imiona.get(a);
			
			a = r.nextInt(nazwiska.size());
			nazwisko = nazwiska.get(a);
			
			a = r.nextInt(miasta.size());
			adres+= miasta.get(a) + " ";
			a = r.nextInt(ulice.size());
			adres+= ulice.get(a) + " ";
			a = r.nextInt(100);
			adres+= a;
			
			String s="1950-01-01";
			Date firstDate = Date.valueOf(s);
			Calendar c = Calendar.getInstance();
			c.setTime(firstDate);
			
			a = r.nextInt(18250);
			c.add(Calendar.DATE, a);
			
			//dataUrodzenia = java.sql.Date.valueOf( (c.getTime()).toString() );
			dataUrodzenia = convertUtilToSql(c.getTime());
			//dataUrodzenia = c.getTime();
			
			
			
			int rok=dataUrodzenia.getYear();
			
			
			pesel+=(dataUrodzenia.toString()).substring(2,4) + (dataUrodzenia.toString()).substring(5,7) + (dataUrodzenia.toString()).substring(8,10);
			a = r.nextInt(1000);
			if(a<100)
				pesel+="0";
			if(a<10)
				pesel+="0";
			pesel+=(new Integer(a)).toString();
			
			a = r.nextInt(5);
			
			if(imie.charAt(imie.length()-1)=='a') {
				a = 2*a;
				String koncowka = nazwisko.substring(nazwisko.length()-3,nazwisko.length());
				System.out.println(koncowka);
				if(koncowka=="ski"||koncowka=="cki") {	
					System.out.println("XXXXXXXXXXXX");
					nazwisko = nazwisko.substring(0,nazwisko.length()-1) + "a";
				}
			}
			else {
				a=2*a+1;
				String koncowka = nazwisko.substring(nazwisko.length()-3,nazwisko.length());
				System.out.println(koncowka);
				if(koncowka=="ska"||koncowka=="cka") {
					System.out.println("XXXXXXXXXXXX");
					nazwisko = nazwisko.substring(0,nazwisko.length()-1) + "i";
				}
			}

			pesel+=(new Integer(a).toString());			
			int last=0;
			int[] value= {9,7,3,1,9,7,3,1,9,7};
			for(int i=0;i<10;i++) {
				last+=value[i]*(Integer.parseInt(pesel.substring(i,i+1)));
			}
			
			last=last%10;
			pesel+=(new Integer(last)).toString();

			Recepcjonistka recepcjonistka = new Recepcjonistka(id, nazwisko, imie, dataUrodzenia, adres, pesel);
			
		return recepcjonistka;
		
    }
}
