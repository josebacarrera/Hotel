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

public class clientesModelo extends Conector {

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
	
	//1튝ETODO
	public ArrayList<clientes> selectAllclientes() {

	ArrayList<clientes> Lista = new ArrayList<clientes>();
	
	try {

		Statement st = super.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from clientes");

		while (rs.next()) {

			clientes clientes = new clientes();

			clientes.setDni(rs.getString("dni"));
			clientes.setNombre(rs.getString("nombre"));
			clientes.setApellidos(rs.getString("apellidos"));
			clientes.setDireccion(rs.getString("direccion"));
			clientes.setLocalidad(rs.getString("localidad"));

			Lista.add(clientes);

		}

	}

	catch (SQLException e) {
		e.printStackTrace();
	}

	return Lista;
	}
	
	//2튝ETODO
	
	public ArrayList<clientes> buscarClientes() {

		ArrayList<clientes> Lista = new ArrayList<clientes>();

		try {

			System.out.println("Escribe una parte de un cliente");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes where nombre like '%" + elegir + "%'");

			while (rs.next()) {

				clientes clientes = new clientes();

				clientes.setDni(rs.getString("dni"));
				clientes.setNombre(rs.getString("nombre"));
				clientes.setApellidos(rs.getString("apellidos"));
				clientes.setDireccion(rs.getString("direccion"));
				clientes.setLocalidad(rs.getString("localidad"));

				Lista.add(clientes);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
	}
	
	//3튝ETODO
	
	public void verClientes() {

		try {

			System.out.println("Escribe el dni del cliente");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes where dni='" + elegir + "'");

			if (rs.next()) {
				clientes clientes = new clientes();

				clientes.setDni(rs.getString("dni"));
				clientes.setNombre(rs.getString("nombre"));
				clientes.setApellidos(rs.getString("apellidos"));
				clientes.setDireccion(rs.getString("direccion"));
				clientes.setLocalidad(rs.getString("localidad"));
				
				System.out.println(clientes.toString());

			} else {

				System.out.println("No existe ningun usuario con ese dni");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//4튝ETODO
	
	public void actualizarClientes(String dni,String nombre,String apellidos,String direccion,String localidad) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update clientes set nombre=? where dni=?");
			pst.setString(1, nombre);
			pst.setString(2, dni);
			
			pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set apellidos=? where dni=?");
			pst.setString(1, apellidos);
			pst.setString(2, dni);
			
			pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set direccion=? where dni=?");
			pst.setString(1, direccion);
			pst.setString(2, dni);
		
			pst.executeUpdate();

			pst = super.conexion.prepareStatement("update clientes set localidad=? where dni=?");
			pst.setString(1, localidad);
			pst.setString(2, dni);
		
			pst.executeUpdate();
			
			System.out.println("Los datos del cliente se han modificado correctamente");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//5튝ETODO
	
	public void borrarClientes(String dni) {

		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from clientes where dni=?");
			pst.setString(1, dni);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
}
	

