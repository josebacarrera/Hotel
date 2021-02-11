package modelo.dao;
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
import java.sql.PreparedStatement;

public class HabitacionModelo extends Conector {

	//METODOS
	
	//1ºMETEDO
	public ArrayList<Habitacion> selectAllhabitaciones() {

		ArrayList<Habitacion> Lista = new ArrayList<Habitacion>();
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from habitaciones");

			while (rs.next()) {

				Habitacion habitaciones = new Habitacion();

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

		
	//2ºMETEDO
	
	public ArrayList<Habitacion> buscarHabitaciones() {

		ArrayList<Habitacion> Lista = new ArrayList<Habitacion>();

		try {

			System.out.println("Escribe el id de una habitación");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from habitaciones where id like '%" + elegir + "%'");

			while (rs.next()) {
				
				Habitacion habitaciones = new Habitacion();

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
	
	
	//3ºMETEDO
	
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
	
	//4ºMETEDO
	
	public void actualizarHabitaciones(int id,int id_hotel,String numero,String descripcion,Double precio) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update clientes set id_hotel=? where dni=?");
			pst.setInt(1, id_hotel);
			pst.setInt(2, id);
			
			pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set numero=? where dni=?");
			pst.setString(1, numero);
			pst.setInt(2, id);
			
			pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set descripcion=? where dni=?");
			pst.setString(1, descripcion);
			pst.setInt(2, id);
		
			pst.executeUpdate();

			pst = super.conexion.prepareStatement("update clientes set precio=? where dni=?");
			pst.setDouble(1, precio);
			pst.setInt(2, id);
		
			pst.executeUpdate();
			
			System.out.println("Los datos de la habitación se han modificado correctamente");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//5ºMETEDO

	public void borrarHabitaciones(int id) {

		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from habitaciones where id=?");
			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
	


