package principal;
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
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CLIENTES
		ArrayList <clientes> cli = new ArrayList<clientes>();
		
		clientesModelo cm = new clientesModelo();
		
		//HABITACIONES
		ArrayList <habitaciones> hab = new ArrayList<habitaciones>();
		
		habitacionesModelo hm = new habitacionesModelo();
		
		
		//HOTELES
		ArrayList <hoteles> hot = new ArrayList<hoteles>();
				
		hotelesModelo hom = new hotelesModelo();
		
		//RESERVAS
		ArrayList <reservas> res = new ArrayList<reservas>();
		
		reservasModelo rm = new reservasModelo();
		
		
		Scanner sc = new Scanner(System.in);
		//TODO realizar la conexi√≥n a la base de datos
		
		//LOGIN
		int cont=0;
		
		
		while (cont<3) {
			
			
		boolean elegir=false;
		
		elegir=login();
		
		cont++;
		
			if(elegir == true) {
		
		int opcion;
		
		do { 
			System.out.println("Escoge una opciÛn");
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

				break;
				
			case 8:
				quitar20e();
				break;
		
			case 9:
				
				break;
		
			case 10:
				
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
			
			ArrayList<clientes> Lista = new ArrayList<clientes>();
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
	
	//1∫METODO
	
	public static void todosClientes(){
		
		ArrayList <clientes> cli = new ArrayList<clientes>();
		clientesModelo cm = new clientesModelo();
		
		System.out.println("TODOS LOS CLIENTES");
		cli = cm.selectAllclientes();
		for (int i = 0; i < cli.size(); i++) {
			
			System.out.println(cli.get(i).toString());
		} 
	}
	
	//2∫METODO
	
	public static void buscarClientes() {
		
		ArrayList <clientes> Lista;
		clientesModelo cm = new clientesModelo();
		
		Lista=cm.buscarClientes();
		
		for (int i = 0; i < Lista.size(); i++) {
			
			System.out.println(Lista.get(i).toString());
		} 
		
	}
	
	//3∫METODO
	
	public static void verClientes() {
		
		clientesModelo cm = new clientesModelo();
		cm.verClientes();
	}
	
	//4∫METODO
	
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
	
	//5∫METODO
	
	public static void borrarClientes() {
		
		clientesModelo cm = new clientesModelo();
		String dni;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el dni");
		dni= sc.nextLine();
		cm.borrarClientes(dni);
		
		}
	
	//HABITACIONES
	
	//1∫METODO
	
	public static void todasHabitaciones(){
		
		ArrayList <habitaciones> hab = new ArrayList<habitaciones>();
		habitacionesModelo hm = new habitacionesModelo();
		
		System.out.println("TODOS LAS HABITACIONES");
		hab = hm.selectAllhabitaciones();
		for (int i = 0; i < hab.size(); i++) {
			
			System.out.println(hab.get(i).toString());
		} 
	}
	
	//2∫METODO
	
	public static void buscarHabitaciones() {}
	
	//3∫METODO
	
	public static void quitar20e() {
		
		habitacionesModelo hm = new habitacionesModelo();
		int id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el id");
		id = Integer.parseInt(sc.nextLine());
		hm.restar20(id);
	}
	
	//4∫METODO
	
	public static void editarHabitaciones() {}
	
	//5∫METODO
	
	public static void eliminarHabitaciones() {}
	
	//HOTELES
	
	//1∫METODO
	
	public static void todosHoteles(){}
		
	//2∫METODO
		
	public static void buscarHoteles() {}
		
	//3∫METODO
		
	public static void verHoteles() {}
		
	//4∫METODO
		
	public static void editarHoteles() {}
		
	//5∫METODO
		
	public static void eliminarHoteles() {}
	
	//RESERVAS
	
	//1∫METODO
		
	public static void todasReservas(){}
		
	//2∫METODO
		
	public static void buscarReservas() {}
		
	//3∫METODO
		
	public static void verReservas() {}
		
	//4∫METODO
		
	public static void editarReservas() {}
		
	//5∫METODO
		
	public static void eliminarReservas() {}
}
