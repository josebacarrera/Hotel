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

public class HotelModelo extends Conector {

	//METODOS
	
	//1�METODO
	public ArrayList<Hotel> selectAllhoteles() {

	ArrayList<Hotel> lista = new ArrayList<Hotel>();
	
	try {

		Statement st = super.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from clientes");

		while (rs.next()) {

			Hotel hotel = new Hotel();

			hotel.setId(rs.getString("id"));
			hotel.setCif(rs.getString("cif"));
			hotel.setNombre(rs.getString("nombre"));
			hotel.setGerente(rs.getString("gerente"));
			hotel.setEstrellas(rs.getInt("estrellas"));
			hotel.setCompania(rs.getString("compania"));

			lista.add(hotel);

		}

	}

	catch (SQLException e) {
		e.printStackTrace();
	}

	return lista;
	}
	//2�METODO
	
		public Hotel buscarHoteles(String nombre) {

			Hotel hotel = new Hotel();

			try {


				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("select * from hoteles where id like '%" + nombre + "%'");

				if (rs.next()) {

					hotel.setId(rs.getString("id"));
					hotel.setCif(rs.getString("cif"));
					hotel.setNombre(rs.getString("nombre"));
					hotel.setGerente(rs.getString("gerente"));
					hotel.setEstrellas(rs.getInt("estrellas"));
					hotel.setCompania(rs.getString("compania"));

				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}

			return hotel;
		}
		
		//3�METODO
		
		public Hotel verHoteles(int id) {

			Hotel hotel = new Hotel();
			
			try {

				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("select * from hoteles where id='" + id + "'");

				if (rs.next()) {
					

					hotel.setId(rs.getString("id"));
					hotel.setCif(rs.getString("cif"));
					hotel.setNombre(rs.getString("nombre"));
					hotel.setGerente(rs.getString("gerente"));
					hotel.setEstrellas(rs.getInt("estrellas"));
					hotel.setCompania(rs.getString("compania"));


				} else {

					System.out.println("No existe ningun usuario con ese id");
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
			return hotel;
		}
		
		//4�METODO
		
		public int actualizarHoteles(int id,String cif,String nombre,String gerente,int estrellas,String compania) {

			int i = 0;
			
			PreparedStatement pst;
			try {
				pst = super.conexion.prepareStatement("update hoteles set cif=? where id=?");
				pst.setString(1, cif);
				pst.setInt(2, id);
				
				i=pst.executeUpdate();
				
				pst = super.conexion.prepareStatement("update hoteles set nombre=? where id=?");
				pst.setString(1, nombre);
				pst.setInt(2, id);
				
				i=pst.executeUpdate();
				
				pst = super.conexion.prepareStatement("update hoteles set gerente=? where id=?");
				pst.setString(1, gerente);
				pst.setInt(2, id);
			
				i=pst.executeUpdate();

				pst = super.conexion.prepareStatement("update hoteles set estrellas=? where id=?");
				pst.setInt(1, estrellas);
				pst.setInt(2, id);
			
				i=pst.executeUpdate();
				
				pst = super.conexion.prepareStatement("update hoteles set compania=? where id=?");
				pst.setString(1, compania);
				pst.setInt(2, id);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
		}
		
		//5�METODO
		
		public int borrarHoteles(String id) {

			int i = 0;
			PreparedStatement pst;
			try {
				pst = (PreparedStatement) super.conexion.prepareStatement("delete from hoteles where id=?");
				pst.setString(1, id);
				pst.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
		}
	
}
