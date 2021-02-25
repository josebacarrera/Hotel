package principal;
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
import java.text.SimpleDateFormat;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		//CLIENTES
		ArrayList <Cliente> cli = new ArrayList<Cliente>();
		
		ClienteModelo cm = new ClienteModelo();
		
		//HABITACIONES
		ArrayList <Habitacion> hab = new ArrayList<Habitacion>();
		
		HabitacionModelo hm = new HabitacionModelo();
		
		
		//HOTELES
		ArrayList <Hotel> hot = new ArrayList<Hotel>();
				
		HotelModelo hom = new HotelModelo();
		
		//RESERVAS
		ArrayList <Reserva> res = new ArrayList<Reserva>();
		
		ReservaModelo rm = new ReservaModelo();
		
		
		Scanner sc = new Scanner(System.in);
		
		
		//LOGIN
		int cont=0;
		
		
		while (cont<3) {
			
			
		boolean elegir=false;
		
		elegir=login();
		
		cont++;
		
			if(elegir == true) {
		
		int opcion;
		
		do { 
			System.out.println("Escoge una opción");
			System.out.println("1-Listar clientes");
			System.out.println("2-Buscar clientes");
			System.out.println("3-Ver clientes");
			System.out.println("4-Editar clientes");
			System.out.println("5-Eliminar clientes");
			System.out.println("6-Listar habitaciones");
			System.out.println("7-Buscar habitaciones");
			System.out.println("8-Ver habitaciones");
			System.out.println("9-Editar habitaciones");
			System.out.println("10-Eliminar habitaciones");
			System.out.println("11-Listar hoteles");
			System.out.println("12-Buscar hoteles");
			System.out.println("13-Ver hoteles");
			System.out.println("14-Editar hoteles");
			System.out.println("15-Eliminar hoteles");
			System.out.println("16-Listar reservas");
			System.out.println("17-Buscar reservas");
			System.out.println("18-Ver reservas");
			System.out.println("19-Editar reservas");
			System.out.println("20-Eliminar reservas");
			System.out.println("0-Para cerrar el programa");
			

			opcion = Integer.parseInt(sc.nextLine());

			
			switch (opcion) {
			
			
			//CLIENTES
			
			case 1:
				todosClientes();
				break;
				
			case 2:
				buscarCliente();
				break;
				
			case 3:				
				verCliente();
				break;
				
			case 4:
				editarCliente();
				break;
	
			case 5:
				borrarCliente();
				break;
	
			//HABITACIONES
				
			case 6:
				todasHabitaciones();
				break;
				
			case 7:
				buscarHabitacion();
				break;
				
			case 8:
				quitar20e();
				break;
		
			case 9:
				editarHabitacion();
				break;
		
			case 10:
				eliminarHabitacion();
				break;
				
			//HOTELES
				
			case 11:
				todosHoteles();
				break;
				
			case 12:
				buscarHotel();
				break;
				
			case 13:
				verHotel();
				break;
		
			case 14:
				editarHotel();
				break;
				
			case 15:
				borrarHotel();
				break;
			
			//RESERVAS
				
			case 16:
				todasReservas();
				break;
				
			case 17:
				buscarReserva();
				break;
	
			case 18:
				verReserva();
				break;
	
			case 19:
				editarReserva();
				break;
	
			case 20:
				borrarReserva();
				break;
				
			case 0:
				System.out.println("El programa se ha cerrado....");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
				
			}

		} while (opcion !=0);
	
			}
		}
	}

	//METODOS
	
	//LOGIN
		
		public static boolean login() {
			
			ArrayList<Cliente> Lista = new ArrayList<Cliente>();
			ClienteModelo cm = new ClienteModelo();
			Scanner sc = new Scanner(System.in);
			String dni,nombre;
			System.out.println("Introduce un dni");
			dni= sc.nextLine();
			System.out.println("Introduce un nombre");
			nombre=sc.nextLine();
			
			boolean elegir=false;
			elegir=cm.registrarse(dni, nombre);
			
			return elegir;

	}
	
	//CLIENTES
	
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
		
		
	}
	
	//2ºMETODO
	
	public static void buscarCliente() {
		
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();
		ArrayList <Cliente> lista;
		ClienteModelo cm = new ClienteModelo();
	
			
		System.out.println("Escribe una parte de un cliente");
		String elegir;
		elegir = sc.nextLine();
		
		lista=cm.buscarCliente(elegir);
			
		for (int i = 0; i < lista.size(); i++) {
				
		System.out.println(lista.get(i).toString());
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
		
		ClienteModelo cm = new ClienteModelo();
		String dni,direccion,nombre,apellidos,localidad;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Escribe el dni");
		dni = sc.nextLine();
		System.out.println("Escribe nombre");
		nombre = sc.nextLine();
		System.out.println("Escribe el apellido");
		apellidos = sc.nextLine();
		System.out.println("Escribe la direccion");
		direccion = sc.nextLine();
		System.out.println("Escribe la localidad");
		localidad = sc.nextLine();
		
		cm.actualizarCliente(dni, nombre, apellidos, direccion, localidad);
		
		}
	
	//5ºMETODO
	
	public static void borrarCliente() {
		
		ClienteModelo cm = new ClienteModelo();
		String dni;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el dni");
		dni= sc.nextLine();
		cm.borrarCliente(dni);
		
		}
	
	//HABITACIONES
	
	//1ºMETODO
	
	public static void todasHabitaciones(){
		
		ArrayList <Habitacion> hab = new ArrayList<Habitacion>();
		HabitacionModelo hm = new HabitacionModelo();
		
		System.out.println("TODOS LAS HABITACIONES");
		hab = hm.selectAllhabitaciones();
		for (int i = 0; i < hab.size(); i++) {
			
			System.out.println(hab.get(i).toString());
		} 
	}
	
	//2ºMETODO
	
	public static void buscarHabitacion() {}
	
	//3ºMETODO
	
	public static void quitar20e() {
		
		HabitacionModelo hm = new HabitacionModelo();
		int id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el id");
		id = Integer.parseInt(sc.nextLine());
		hm.restar20(id);
	}
	
	//4ºMETODO
	
	public static void editarHabitacion() {
		
		HabitacionModelo hm = new HabitacionModelo();
		int id,id_hotel;
		String numero,descripcion;
		double precio;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el id");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Escribe id del hotel");
		id_hotel = Integer.parseInt(sc.nextLine());
		System.out.println("Escribe el numero");
		numero = sc.nextLine();
		System.out.println("Escribe la descripcion");
		descripcion = sc.nextLine();
		System.out.println("Escribe la precio");
		precio = Double.parseDouble(sc.nextLine());
		
	}
	
	//5ºMETODO
	
	public static void eliminarHabitacion() {
		
		HabitacionModelo hm = new HabitacionModelo();
		String elegir;
		int id=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el dni");
		id= Integer.parseInt(sc.nextLine());
		hm.borrarHabitaciones(id);
	}
	
	//HOTELES
	
	//1ºMETODO
	
		public static void todosHoteles(){
			
			ArrayList <Hotel> hot = new ArrayList<Hotel>();
			HotelModelo hom = new HotelModelo();
			
			System.out.println("TODOS LOS HOTELES");
			hot = hom.selectAllhoteles();
			for (int i = 0; i < hot.size(); i++) {
				
				System.out.println(hot.get(i).toString());
			} 
		}
		
		//2ºMETODO
		
		public static void buscarHotel() {
			

			
			ArrayList <Hotel> lista;
			HotelModelo hom = new HotelModelo();
			
			System.out.println("Escribe parte del nombre un hotel");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();
			
			lista=hom.buscarHoteles(elegir);
			
			for (int i = 0; i < lista.size(); i++) {
				
				System.out.println(lista.get(i).toString());
			} 
			
		}
		
		//3ºMETODO
		
		public static void verHotel() {
			
			System.out.println("Escribe el id del hotel");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();
			int id = 0;
			HotelModelo hom = new HotelModelo();
			hom.verHoteles(id);
		}
		
		//4ºMETODO
		
		public static void editarHotel() {
			
			HotelModelo hom = new HotelModelo();
			String cif,nombre,gerente,compania;
			int id,estrellas;
			Scanner sc = new Scanner(System.in);
			System.out.println("Escribe el id");
			id = Integer.parseInt(sc.nextLine());
			System.out.println("Escribe nombre");
			cif = sc.nextLine();
			System.out.println("Escribe nombre");
			nombre = sc.nextLine();
			System.out.println("Escribe el apellido");
			gerente = sc.nextLine();
			System.out.println("Escribe la direccion");
			estrellas = Integer.parseInt(sc.nextLine());
			System.out.println("Escribe la localidad");
			compania = sc.nextLine();
			hom.actualizarHoteles(id,cif,nombre,gerente,estrellas,compania);
		}
		
		//5ºMETODO
		
		public static void borrarHotel() {
			
			HotelModelo hom = new HotelModelo();
			int id;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el dni");
			id= Integer.parseInt(sc.nextLine());
			hom.borrarHoteles(id);
			
			}
	
		//RESERVAS
	
		//1ºMETODO
		
		public static void todasReservas(){
			
			ArrayList <Reserva> res = new ArrayList<Reserva>();
			ReservaModelo rm = new ReservaModelo();
			
			System.out.println("TODOS LAS RESERVAS");
			res = rm.selectAllreservas();
			for (int i = 0; i < res.size(); i++) {
				
				System.out.println(res.get(i).toString());
			} 
		}
		
		//2ºMETODO
		
		public static void buscarReserva() {
			

			
			ArrayList <Reserva> lista;
			ReservaModelo rm = new ReservaModelo();
			
			System.out.println("Escribe el dni que está asociado a la reserva");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();
			
			lista=rm.buscarReserva(elegir);
			
			for (int i = 0; i < lista.size(); i++) {
				
				System.out.println(lista.get(i).toString());
			} 
			
		}
		
		//3ºMETODO
		
		public static void verReserva() {
			
			System.out.println("Escribe el id asociado a la reserva");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();
			int id=0;
			ReservaModelo rm = new ReservaModelo();
			rm.verReserva(id);
			
		}
		
		//4ºMETODO
		
		public static void editarReserva() {
			
			Date fechaFin = new Date();
			SimpleDateFormat formatoFecha1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Scanner sc = new Scanner(System.in);
			
			
			
			ReservaModelo cm = new ReservaModelo();
			int id;
			System.out.println("Escribe la id");
			id = Integer.parseInt(sc.nextLine());
			try {
				
				System.out.println("Escribe el fin de la reserva");
				fechaFin = formatoFecha1.parse(sc.nextLine());
				
				
			} catch (Exception e) {
				
			}
			cm.actualizarReserva(id,fechaFin);
		}
		
		//5ºMETODO
		
		public static void borrarReserva() {
			
			ReservaModelo rm = new ReservaModelo();
			int id = 0 ;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el id");
			id= Integer.parseInt(sc.nextLine());
			rm.borrarReserva(id);
			
			}
}
