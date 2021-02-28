package modelo.dao;
import java.util.*;

import modelo.dao.*;
import principal.Comprobar;
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

			if (rs.next()) {

				Habitacion habitaciones = new Habitacion();

				habitaciones.setId(rs.getString("id"));
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
	
	public Habitacion buscarHabitaciones(String pk) {

		Habitacion habitacion = new Habitacion();

		try {



			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from habitaciones where id like '%" + pk + "%'");

			if (rs.next()) {
				
				habitacion.setId(rs.getString("id"));
				habitacion.setId_hotel(rs.getInt("id_hotel"));
				habitacion.setNumero(rs.getString("numero"));
				habitacion.setDescripcion(rs.getString("descripcion"));
				habitacion.setPrecio(rs.getDouble("precio"));

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return habitacion;
	}
	
	
	//3ºMETEDO
	
	public Habitacion restar20(String id) {
		
		Habitacion habitacion = new Habitacion();
			PreparedStatement pst;
		
		try {
				pst =super.conexion.prepareStatement("update habitaciones set precio=precio-20 where id=?");
				pst.setString(1, id);
				pst.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return habitacion;
	}
	
	//4ºMETEDO
	
	public int actualizarHabitaciones(int id,int id_hotel,String numero,String descripcion,Double precio) {

		int i = 0;
		
		PreparedStatement pst;
		try {
			
			pst = super.conexion.prepareStatement("update clientes set id_hotel=? where dni=?");
			pst.setInt(1, id_hotel);
			pst.setInt(2, id);
			
			i=pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set numero=? where dni=?");
			pst.setString(1, numero);
			pst.setInt(2, id);
			
			i=pst.executeUpdate();
			
			pst = super.conexion.prepareStatement("update clientes set descripcion=? where dni=?");
			pst.setString(1, descripcion);
			pst.setInt(2, id);
		
			i=pst.executeUpdate();

			pst = super.conexion.prepareStatement("update clientes set precio=? where dni=?");
			pst.setDouble(1, precio);
			pst.setInt(2, id);
		
			i=pst.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	//5ºMETEDO

	public int borrarHabitaciones(String id) {

		int i = 0 ;
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from habitaciones where id=?");
			pst.setString(1, id);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
	
}
	

/*
//1ºMETODO

public static void todosClientes(){
	
	ArrayList <Cliente> cli = new ArrayList<Cliente>();
	ClienteModelo cm = new ClienteModelo();
	String cont;
	
	System.out.println("TODOS LOS CLIENTES");
	cli = cm.selectAllclientes();
	for (int i = 0; i < cli.size(); i++) {
		
		System.out.println(cli.get(i).toString());
	} 
	
	System.out.println(cli.size());
}

//2ºMETODO

public static void buscarCliente() {
	
Comprobar com = new Comprobar();
ClienteModelo cm = new ClienteModelo();
String pk;
Scanner sc = new Scanner(System.in);
System.out.println("Introduce el dni del cliente");
pk=sc.nextLine();
if (com.com("clientes","dni",pk)==false) {
	System.out.println("Cliente no encontrado");
}
else {
	System.out.println(cm.buscarCliente(pk));
	}
}

//3ºMETODO

public static void verCliente() {
	

	Scanner sc = new Scanner(System.in);
	Cliente cliente = new Cliente();
	ArrayList <Cliente> lista;
	String elegir;
	int dni = 0;
	ClienteModelo cm = new ClienteModelo();
	System.out.println("Que dni quieres?Escribelo");
	dni = Integer.parseInt(sc.nextLine());
	cliente=cm.verCliente(dni);
	
	if(cliente.getDni()==null) {
		
		System.out.println("No existe este dato,inténtalo otra vez");
	}
	
	else {
	cliente=cm.verCliente(dni);
	System.out.println(cliente);

	
	}
}

//4ºMETODO

public static void editarCliente() {
	
	Comprobar com = new Comprobar();
	ClienteModelo cm = new ClienteModelo();
	String pk,direccion,nombre,apellidos,localidad;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Escribe el dni");
	pk = sc.nextLine();
	
	if (com.com("clientes","dni",pk)==false) {
		System.out.println("Cliente(dni) no encontrado");
	}
	else {
		
		System.out.println("Escribe nombre");
		nombre = sc.nextLine();
		System.out.println("Escribe el apellido");
		apellidos = sc.nextLine();
		System.out.println("Escribe la direccion");
		direccion = sc.nextLine();
		System.out.println("Escribe la localidad");
		localidad = sc.nextLine();
		
		System.out.println("Los datos del cliente se han modificado correctamente");
		System.out.println("------------------------------------------------------");
		System.out.println("Se han modificado "+ cm.actualizarCliente(pk,direccion,nombre,apellidos,localidad) + " dato/s");
		}

	}

//5ºMETODO

public static void borrarCliente() {
	
	Comprobar com = new Comprobar();
	ClienteModelo cm = new ClienteModelo();
	String dni;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce el dni");
	dni= sc.nextLine();
	
	if (com.com("clientes","dni",dni)==false) {
		System.out.println("Cliente no encontrado");
	}
		
		System.out.println("Se han modificado "+ cm.borrarCliente(dni) + " dato/s");
	
	}
*/