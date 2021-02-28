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

			reserva.setId(rs.getString("id"));
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
	
	public Reserva buscarReserva(String id) {

	Reserva reserva = new Reserva();

		try {


			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from reservas where nombre like '%" + id + "%'");

			if (rs.next()) {

				reserva.setId(rs.getString("id"));
				reserva.setId_habitacion(rs.getInt("id_habitacion"));
				reserva.setDni(rs.getString("dni"));
				reserva.setDesde(rs.getDate("desde"));
				reserva.setHasta(rs.getDate("hasta"));



			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return reserva;
	}
	
	//3튝ETODO
	
	public Reserva verReserva(String id) {

		Reserva reserva = new Reserva();
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from reservas where id='" + id + "'");

			if (rs.next()) {
			
				reserva.setId(rs.getString("Id"));
				reserva.setId_habitacion(rs.getInt("id_habitacion"));
				reserva.setDni(rs.getString("dni"));
				reserva.setDesde(rs.getDate("desde"));
				reserva.setHasta(rs.getDate("hasta"));
				

			} 

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return reserva;
		
	}
	
	//4튝ETODO
	
	public int actualizarReserva(String id,Date hasta) {
		
		java.sql.Date sqlFecha = new java.sql.Date (hasta.getTime());
		
		int i = 0;
		
		PreparedStatement pst;
		try {
				
			pst = super.conexion.prepareStatement("update reservas set fin=? where id=?");
			pst.setDate(1, sqlFecha);
			pst.setString(2, id);
		
			i=pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	//5튝ETODO
	
	public int borrarReserva(String id) {

		int i = 0;
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from reservas where id=?");
			pst.setString(1, id);
			i=pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i ;
	}

	
}
