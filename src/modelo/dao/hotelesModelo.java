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

public class hotelesModelo extends Conector {

	//METODOS
	
	//1튝ETODO
	public ArrayList<Hoteles> selectAllhoteles() {

	ArrayList<Hoteles> lista = new ArrayList<Hoteles>();
	
	try {

		Statement st = super.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from clientes");

		while (rs.next()) {

			Hoteles hotel = new Hoteles();

			hotel.setId(rs.getInt("id"));
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
	//2튝ETODO
	
		public ArrayList<Hoteles> buscarHoteles(String nombre) {

			ArrayList<Hoteles> lista = new ArrayList<Hoteles>();

			try {


				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("select * from hoteles where id like '%" + nombre + "%'");

				while (rs.next()) {

					Hoteles hotel = new Hoteles();

					hotel.setId(rs.getInt("id"));
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
		
		//3튝ETODO
		
		public void verHoteles(int id) {

			try {

				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("select * from hoteles where id='" + id + "'");

				if (rs.next()) {
					Hoteles hotel = new Hoteles();

					hotel.setId(rs.getInt("id"));
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

		}
		
		//4튝ETODO
		
		public void actualizarHoteles(int id,String cif,String nombre,String gerente,int estrellas,String compania) {

			PreparedStatement pst;
			try {
				pst = super.conexion.prepareStatement("update hoteles set cif=? where id=?");
				pst.setString(1, cif);
				pst.setInt(2, id);
				
				pst.executeUpdate();
				
				pst = super.conexion.prepareStatement("update hoteles set nombre=? where id=?");
				pst.setString(1, nombre);
				pst.setInt(2, id);
				
				pst.executeUpdate();
				
				pst = super.conexion.prepareStatement("update hoteles set gerente=? where id=?");
				pst.setString(1, gerente);
				pst.setInt(2, id);
			
				pst.executeUpdate();

				pst = super.conexion.prepareStatement("update hoteles set estrellas=? where id=?");
				pst.setInt(1, estrellas);
				pst.setInt(2, id);
			
				pst.executeUpdate();
				
				pst = super.conexion.prepareStatement("update hoteles set compania=? where id=?");
				pst.setString(1, compania);
				pst.setInt(2, id);
				
				System.out.println("Los datos del hotel se han modificado correctamente");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		//5튝ETODO
		
		public void borrarHoteles(int id) {

			PreparedStatement pst;
			try {
				pst = (PreparedStatement) super.conexion.prepareStatement("delete from hoteles where id=?");
				pst.setInt(1, id);
				pst.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	
}
