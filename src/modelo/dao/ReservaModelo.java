package modelo.dao;
import java.util.*;

import modelo.dao.*;
import modelo.*;
import modelo.bean.*;
import java.util.Date;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

			reserva.setId(rs.getInt("id"));
			reserva.setId_habitacion(rs.getInt("id_habitacion"));
			reserva.setDni(rs.getString("dni"));
			reserva.setDesde(rs.getDate("desde"));
			reserva.setHasta(rs.getDate("hasta"));

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

				reserva.setId(rs.getInt("id"));
				reserva.setId_habitacion(rs.getInt("id_habitacion"));
				reserva.setDni(rs.getString("dni"));
				reserva.setDesde(rs.getDate("desde"));
				reserva.setHasta(rs.getDate("hasta"));

				lista.add(reserva);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	//3튝ETODO
	
	public Reserva verReserva(int id) {

		Reserva reserva = new Reserva();
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from reservas where dni='" + id + "'");

			if (rs.next()) {
			
				reserva.setId(rs.getInt("ID"));
				reserva.setId_habitacion(rs.getInt("id_habitacion"));
				reserva.setDni(rs.getString("dni"));
				reserva.setDate(rs.getString("desde"));
				reserva.setDate(rs.getString("hasta"));
				

			} 

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return reserva;
		
	}
	
	//4튝ETODO
	
	public void actualizarReserva(int id,Date hasta) {
		
		java.sql.Date sqlFecha = new java.sql.Date (hasta.getTime());
		
		PreparedStatement pst;
		try {
				
			pst = super.conexion.prepareStatement("update reservas set fin=? where id=?");
			pst.setDate(1, sqlFecha);
			pst.setInt(2, id);
		
			pst.executeUpdate();
			
			System.out.println("Los datos de la reserva se han modificado correctamente");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//5튝ETODO
	
	public void borrarReserva(int id) {

		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from reservas where id=?");
			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
}
