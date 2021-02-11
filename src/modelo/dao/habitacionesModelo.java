package modelo.dao;
import java.util.*;
import modelo.bin.*;
import modelo.dao.*;
import modelo.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class habitacionesModelo extends Conector {

	//METODOS
	
	//1튝ETEDO
	public ArrayList<habitaciones> selectAllhabitaciones() {

		ArrayList<habitaciones> Lista = new ArrayList<habitaciones>();
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from habitaciones");

			while (rs.next()) {

				habitaciones habitaciones = new habitaciones();

				habitaciones.setId(rs.getInt("id"));
				habitaciones.setId_hotel(rs.getInt("id_hotel"));
				habitaciones.setNumero(rs.getString("numero"));
				habitaciones.setDescripcion(rs.getString("descripcion"));
				habitaciones.setPrecio(rs.getDouble("precio"));

				Lista.add(habitaciones);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
		}

		
	//2튝ETEDO
	
	//3튝ETEDO
	
	public void restar20(int id) {
		
			PreparedStatement pst;
		
		try {
				pst =super.conexion.prepareStatement("update habitaciones set precio=precio-20 where id=?");
				pst.setInt(1, id);
				pst.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//4튝ETEDO
	

	//5튝ETEDO

}
	


