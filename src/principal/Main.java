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
			
			System.out.println("Se ha borrado "+ cm.borrarCliente(dni) + " dato/s");
		
		}
	
	//HABITACIONES
	
	//1ºMETODO
	
	public static void todasHabitaciones(){
		
		ArrayList <Habitacion> hab = new ArrayList<Habitacion>();
		HabitacionModelo cm = new HabitacionModelo();
		String cont;
		
		
		System.out.println("TODOS LAS HABITACIONES");
		hab = cm.selectAllhabitaciones();
		for (int i = 0; i < hab.size(); i++) {
			
			System.out.println(hab.get(i).toString());
		} 
		
		System.out.println(hab.size());
	}
	
	//2ºMETODO
	
	public static void buscarHabitacion() {
		
		Comprobar com = new Comprobar();
		HabitacionModelo hab = new HabitacionModelo();
		String pk;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de la habitacion");
		pk=sc.nextLine();
		if (com.com("habitaciones","id",pk)==false) {
			System.out.println("Cliente no encontrado");
		}
		else {
			System.out.println(hab.buscarHabitaciones(pk));
			}
		}
	
	
	//3ºMETODO
	
	public static void quitar20e() {
		
		HabitacionModelo hm = new HabitacionModelo();
		Habitacion habitacion = new Habitacion();
		String id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el id");
		id = sc.nextLine();
		
		if(habitacion.getId()==null) {
			
			System.out.println("No existe este dato,inténtalo otra vez");
		}
		
		else {
		habitacion=hm.restar20(id);
		System.out.println(habitacion);

		
		}
	}
	
	//4ºMETODO
	
	public static void editarHabitacion() {
		
		Comprobar com = new Comprobar();
		HabitacionModelo hm = new HabitacionModelo();
		int id_hotel;
		String numero,descripcion,id;
		double precio;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el id");
		id =sc.nextLine();
		
		if (com.com("habitaciones","id",id)==false) {
			System.out.println("Habitacion(id) no encontrado");
		
		}
		
		else {
		System.out.println("Escribe id del hotel");
		id_hotel = Integer.parseInt(sc.nextLine());
		System.out.println("Escribe el numero");
		numero = sc.nextLine();
		System.out.println("Escribe la descripcion");
		descripcion = sc.nextLine();
		System.out.println("Escribe la precio");
		precio = Double.parseDouble(sc.nextLine());
		
		System.out.println("Los datos de la habitación se han modificado correctamente");
		System.out.println("------------------------------------------------------");
		System.out.println("Se han modificado "+ hm.actualizarHabitaciones(id_hotel, id_hotel, numero, descripcion, null) + " dato/s");

		}
	}
	
	//5ºMETODO
	
	public static void eliminarHabitacion() {
		
		Comprobar com = new Comprobar();
		HabitacionModelo hm = new HabitacionModelo();
		String elegir,id;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el id");
		id= sc.nextLine();
		
		if (com.com("habitaciones","id",id)==false) {
			System.out.println("Habitacion no encontrada");
		}
			
			System.out.println("Se ha borrado"+ hm.borrarHabitaciones(id) + " dato/s");
		
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
			
			System.out.println(hot.size());
		}
		
		//2ºMETODO
		
		public static void buscarHotel() {
			
			Comprobar com = new Comprobar();
			HotelModelo hm = new HotelModelo();
			String pk;
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el id del hotel");
			pk=sc.nextLine();
			if (com.com("hoteles","id",pk)==false) {
				System.out.println("Hotel no encontrado");
			}
			else {
				System.out.println(hm.buscarHoteles(pk));
				}
			}
		
		//3ºMETODO
		
		public static void verHotel() {
			
			Scanner sc = new Scanner(System.in);
			Hotel hotel = new Hotel();
			ArrayList <Hotel> lista;
			String elegir;
			int id = 0;
			HotelModelo hm = new HotelModelo();
			System.out.println("Que id quieres?Escribelo");
			id = Integer.parseInt(sc.nextLine());
			hotel=hm.verHoteles(id);
			
			if(hotel.getId()==null) {
				
				System.out.println("No existe este dato,inténtalo otra vez");
			}
			
			else {
			hotel=hm.verHoteles(id);
			System.out.println(hotel);
			
			}
			
		}
		
		//4ºMETODO
		
		public static void editarHotel() {
			
			Comprobar com = new Comprobar();
			HotelModelo hom = new HotelModelo();
			String cif,nombre,gerente,compania,id,pk;
			int estrellas;
			Scanner sc = new Scanner(System.in);
			System.out.println("Escribe el id");
			pk = sc.nextLine();
			
			if (com.com("hoteles","id",pk)==false) {
				System.out.println("Hotel(id) no encontrado");
			}
			
			else {
			
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
			
			System.out.println("Los datos del cliente se han modificado correctamente");
			System.out.println("------------------------------------------------------");
			System.out.println("Se han modificado "+ hom.actualizarHoteles(estrellas, cif, nombre, gerente, estrellas, compania) + " dato/s");
		
			
			}
		}
		
		//5ºMETODO
		
		public static void borrarHotel()  {
			
			Comprobar com = new Comprobar();
			HotelModelo hm = new HotelModelo();
			String id;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Introduce el id");
			id= sc.nextLine();
			
			if (com.com("hoteles","id",id)==false) {
				System.out.println("Hotel no encontrado");
			}
				
				System.out.println("Se ha borrado "+ hm.borrarHoteles(id) + " dato/s");
			
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
			
			System.out.println(res.size());
		}
		
		//2ºMETODO
		
		public static void buscarReserva() {
			
			Comprobar com = new Comprobar();
			String pk;
			Scanner sc = new Scanner(System.in);
			ReservaModelo rm = new ReservaModelo();
			System.out.println("Escribe el id que está asociado a la reserva");
			pk=sc.nextLine();
			if (com.com("reservas","id",pk)==false) {
				System.out.println("Reserva no encontrado");
			}
			else {
				System.out.println(rm.buscarReserva(pk));
				}
			}
		
		//3ºMETODO
		
		public static void verReserva() {
			
			Scanner sc = new Scanner(System.in);
			Reserva reserva = new Reserva();
			ArrayList <Reserva> lista;
			String elegir;
			String id ;
			ReservaModelo rm = new ReservaModelo();
			System.out.println("Que id quieres?Escribelo");
			id =sc.nextLine();
			reserva=rm.verReserva(id);
			
			if(reserva.getId()==null) {
				
				System.out.println("No existe este dato,inténtalo otra vez");
			}
			
			else {
			reserva=rm.verReserva(id);
			System.out.println(reserva);

			
			}
			
		}
		
		//4ºMETODO
		
		public static void editarReserva() {
			
			Date fechaFin = new Date();
			SimpleDateFormat formatoFecha1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Scanner sc = new Scanner(System.in);
			
			ReservaModelo cm = new ReservaModelo();
			String id;
			System.out.println("Escribe la id");
			id = sc.nextLine();
			try {
				
				System.out.println("Escribe el fin de la reserva");
				fechaFin = formatoFecha1.parse(sc.nextLine());
				
				
			} catch (Exception e) {
				
			}
			cm.actualizarReserva(id,fechaFin);
			System.out.println("Los datos de la reserva se han modificado correctamente");
		}
		
		//5ºMETODO
		
		public static void borrarReserva() {
			
			Comprobar com = new Comprobar();
			ReservaModelo rm = new ReservaModelo();
			String id;
			Scanner sc = new Scanner(System.in);

			System.out.println("Introduce el id");
			id= sc.nextLine();
			
			if (com.com("reservas","id",id)==false) {
				System.out.println("Reserva no encontrado");
			}
			
			System.out.println("Se han borrado "+ rm.borrarReserva(id) + " dato/s");
			
			}
}
