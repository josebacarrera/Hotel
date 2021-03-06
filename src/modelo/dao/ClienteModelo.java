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

public class ClienteModelo extends Conector {

	//METODOS
	
	//LOGIN
	
	public boolean registrarse(String dni,String nombre) {
		
		Scanner sc = new Scanner(System.in);
		int cont;
		boolean elegir=false;
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes where dni='" + dni + "' and nombre='" + nombre + "'");

			if (rs.next()) {
				
				elegir=true;

			} else {

				System.out.println("No existe ningun usuario con ese dni o nombre");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
 		return elegir;
		
	}
	
	//1�METODO
	public ArrayList<Cliente> selectAllclientes() {

	ArrayList<Cliente> lista = new ArrayList<Cliente>();
	
	try {

		Statement st = super.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from clientes");
		

		while (rs.next()) {

			Cliente cliente = new Cliente();

			cliente.setDni(rs.getString("dni"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setDireccion(rs.getString("direccion"));
			cliente.setLocalidad(rs.getString("localidad"));

			lista.add(cliente);

		}
		

	}

	catch (SQLException e) {
		e.printStackTrace();
	}

	return lista;
	}
	
	//2�METODO
	
	public Cliente buscarCliente(String dni) {

		Cliente cliente = new Cliente();
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes where dni like '%" + dni + "%'");

			if (rs.next()) {

				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setLocalidad(rs.getString("localidad"));

			}
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}
	
	//3�METODO
	
	public Cliente verCliente(int dni) {

		Cliente cliente = new Cliente();
		
		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes where dni='" + dni + "'");

			if (rs.next()) {
				

				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setLocalidad(rs.getString("localidad"));

			} 

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
		
	}
	
	//4�METODO
	
	public int actualizarCliente(String dni,String nombre,String apellidos,String direccion,String localidad) {
		
		int i = 0;
		
		PreparedStatement pst;
		try {
			
			pst = super.conexion.prepareStatement("update clientes set nombre=? where dni=?");
			pst.setString(1, nombre);
			pst.setString(2, dni);
			
			i=pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set apellidos=? where dni=?");
			pst.setString(1, apellidos);
			pst.setString(2, dni);
			
			i=pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set direccion=? where dni=?");
			pst.setString(1, direccion);
			pst.setString(2, dni);
		
			i=pst.executeUpdate();

			pst = super.conexion.prepareStatement("update clientes set localidad=? where dni=?");
			pst.setString(1, localidad);
			pst.setString(2, dni);
		
			i=pst.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//5�METODO
	
	public int borrarCliente(String dni) {
		
		int i = 0;
		PreparedStatement pst;
		
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from clientes where dni=?");
			pst.setString(1, dni);
			i=pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	
}
	

