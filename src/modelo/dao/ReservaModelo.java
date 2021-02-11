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

public class ReservaModelo extends Conector {

	//1튝ETODO
	public ArrayList<Reserva> selectAllreservas() {

	ArrayList<Reserva> lista = new ArrayList<Reserva>();
	
	try {

		Statement st = super.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from reservas");

		while (rs.next()) {

			Reserva reserva = new Reserva();

			reserva.setId(rs.getInt("Id"));
			reserva.setId_habitacion(rs.getInt("id_habitacion"));
			reserva.setDni(rs.getString("apellidos"));
			reserva.setDesde(rs.getString("direccion"));
			reserva.setHasta(rs.getString("localidad"));

			lista.add(reserva);

		}

	}

	catch (SQLException e) {
		e.printStackTrace();
	}

	return lista;
	}
	
	//2튝ETODO
	
	public ArrayList<Reserva> buscarReserva(String dni) {

		ArrayList<Reserva> lista = new ArrayList<Reserva>();

		try {


			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from reservas where nombre like '%" + dni + "%'");

			while (rs.next()) {

				Reserva reserva = new Reserva();

				reserva.setId(rs.getInt("Id"));
				reserva.setId_habitacion(rs.getInt("id_habitacion"));
				reserva.setDni(rs.getString("apellidos"));
				reserva.setDesde(rs.getString("direccion"));
				reserva.setHasta(rs.getString("localidad"));

				lista.add(reserva);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	//3튝ETODO
	
	public Reserva verReserva(String dni) {

		Reserva reserva = new Reserva();
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from reservas where dni='" + dni + "'");

			if (rs.next()) {
				

				reserva.setId(rs.getInt("Id"));
				reserva.setId_habitacion(rs.getInt("id_habitacion"));
				reserva.setDni(rs.getString("apellidos"));
				reserva.setDesde(rs.getString("direccion"));
				reserva.setHasta(rs.getString("localidad"));
				
		

			} 

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return reserva;
		
	}
	
	//4튝ETODO
	
	public void actualizarReserva(int id,int id_hoteles,String dni,String desde,String fin) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update reservas set id_habitacion=? where id=?");
			pst.setInt(1, id_hoteles);
			pst.setInt(2, id);
			
			pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update reservas set dni=? where id=?");
			pst.setString(1, dni);
			pst.setInt(2, id);
			
			pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update reservas set desde=? where id=?");
			pst.setString(1, desde);
			pst.setInt(2, id);
		
			pst.executeUpdate();

			pst = super.conexion.prepareStatement("update reservas set fin=? where id=?");
			pst.setString(1, fin);
			pst.setInt(2, id);
		
			pst.executeUpdate();
			
			System.out.println("Los datos de la reserva se han modificado correctamente");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//5튝ETODO
	
	public void borrarReserva(String dni) {

		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from reservas where dni=?");
			pst.setString(1, dni);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
}
