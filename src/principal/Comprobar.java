package principal;
import java.util.*;
import modelo.dao.*;
import modelo.*;
import modelo.bean.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Comprobar extends Conector {

	public Conector conector = new Conector();
	
	public boolean com(String tabla,String tipo,String pk) {
		
		Statement st;
		
		boolean elegir = false;
		
		try {
			st = conexion.createStatement();
			ResultSet rs  =st.executeQuery("SELECT * FROM "+tabla+" WHERE "+tipo+"="+pk+"");
		
			elegir=rs.next();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return elegir;
	}
	
}
