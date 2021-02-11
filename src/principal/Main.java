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
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CLIENTES
		ArrayList <Clientes> cli = new ArrayList<Clientes>();
		
		clientesModelo cm = new clientesModelo();
		
		//HABITACIONES
		ArrayList <Habitaciones> hab = new ArrayList<Habitaciones>();
		
		habitacionesModelo hm = new habitacionesModelo();
		
		
		//HOTELES
		ArrayList <Hoteles> hot = new ArrayList<Hoteles>();
				
		hotelesModelo hom = new hotelesModelo();
		
		//RESERVAS
		ArrayList <Reservas> res = new ArrayList<Reservas>();
		
		reservasModelo rm = new reservasModelo();
		
		
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
				buscarClientes();
				break;
				
			case 3:				
				verClientes();
				break;
				
			case 4:
				editarClientes();
				break;
	
			case 5:
				borrarClientes();
				break;
	
			//HABITACIONES
				
			case 6:
				todasHabitaciones();
				break;
				
			case 7:
				buscarHabitaciones();
				break;
				
			case 8:
				quitar20e();
				break;
		
			case 9:
				editarHabitaciones();
				break;
		
			case 10:
				eliminarHabitaciones();
				break;
				
			//HOTELES
				
			case 11:
				
				break;
				
			case 12:
				
				break;
				
			case 13:
				
				break;
		
			case 14:
				
				break;
		
			//RESERVAS
				
			case 15:
				
				break;
			
			case 16:
				
				break;
				
			case 17:
	
				break;
	
			case 18:
	
				break;
	
			case 19:
	
				break;
	
			case 20:
	
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
			
			ArrayList<Clientes> Lista = new ArrayList<Clientes>();
			clientesModelo cm = new clientesModelo();
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
		
		ArrayList <Clientes> cli = new ArrayList<Clientes>();
		clientesModelo cm = new clientesModelo();
		
		System.out.println("TODOS LOS CLIENTES");
		cli = cm.selectAllclientes();
		for (int i = 0; i < cli.size(); i++) {
			
			System.out.println(cli.get(i).toString());
		} 
	}
	
	//2ºMETODO
	
	public static void buscarClientes() {
		

		
		ArrayList <Clientes> lista;
		clientesModelo cm = new clientesModelo();
		
		System.out.println("Escribe una parte de un cliente");
		Scanner sc = new Scanner(System.in);
		String elegir;
		elegir = sc.nextLine();
		
		lista=cm.buscarClientes(elegir);
		
		for (int i = 0; i < lista.size(); i++) {
			
			System.out.println(lista.get(i).toString());
		} 
		
	}
	
	//3ºMETODO
	
	public static void verClientes() {
		
		System.out.println("Escribe el dni del cliente");
		Scanner sc = new Scanner(System.in);
		String elegir;
		elegir = sc.nextLine();
		int dni = 0;
		clientesModelo cm = new clientesModelo();
		cm.verClientes(dni);
	}
	
	//4ºMETODO
	
	public static void editarClientes() {
		
		clientesModelo cm = new clientesModelo();
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
		cm.actualizarClientes(dni, nombre, apellidos, direccion, localidad);
	}
	
	//5ºMETODO
	
	public static void borrarClientes() {
		
		clientesModelo cm = new clientesModelo();
		String dni;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el dni");
		dni= sc.nextLine();
		cm.borrarClientes(dni);
		
		}
	
	//HABITACIONES
	
	//1ºMETODO
	
	public static void todasHabitaciones(){
		
		ArrayList <Habitaciones> hab = new ArrayList<Habitaciones>();
		habitacionesModelo hm = new habitacionesModelo();
		
		System.out.println("TODOS LAS HABITACIONES");
		hab = hm.selectAllhabitaciones();
		for (int i = 0; i < hab.size(); i++) {
			
			System.out.println(hab.get(i).toString());
		} 
	}
	
	//2ºMETODO
	
	public static void buscarHabitaciones() {}
	
	//3ºMETODO
	
	public static void quitar20e() {
		
		habitacionesModelo hm = new habitacionesModelo();
		int id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el id");
		id = Integer.parseInt(sc.nextLine());
		hm.restar20(id);
	}
	
	//4ºMETODO
	
	public static void editarHabitaciones() {
		
		habitacionesModelo hm = new habitacionesModelo();
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
	
	public static void eliminarHabitaciones() {
		
		habitacionesModelo hm = new habitacionesModelo();
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
			
			ArrayList <Hoteles> hot = new ArrayList<Hoteles>();
			hotelesModelo hom = new hotelesModelo();
			
			System.out.println("TODOS LOS HOTELES");
			hot = hom.selectAllhoteles();
			for (int i = 0; i < hot.size(); i++) {
				
				System.out.println(hot.get(i).toString());
			} 
		}
		
		//2ºMETODO
		
		public static void buscarHoteles() {
			

			
			ArrayList <Hoteles> lista;
			hotelesModelo hom = new hotelesModelo();
			
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
		
		public static void verHoteles() {
			
			System.out.println("Escribe el id del hotel");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();
			int id = 0;
			hotelesModelo hom = new hotelesModelo();
			hom.verHoteles(id);
		}
		
		//4ºMETODO
		
		public static void editarHoteles() {
			
			hotelesModelo hom = new hotelesModelo();
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
		
		public static void borrarHoteles() {
			
			hotelesModelo hom = new hotelesModelo();
			int id;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el dni");
			id= Integer.parseInt(sc.nextLine());
			hom.borrarHoteles(id);
			
			}
	
	//RESERVAS
	
	//1ºMETODO
		
	public static void todasReservas(){}
		
	//2ºMETODO
		
	public static void buscarReservas() {}
		
	//3ºMETODO
		
	public static void verReservas() {}
		
	//4ºMETODO
		
	public static void editarReservas() {}
		
	//5ºMETODO
		
	public static void eliminarReservas() {}
}
