package modelo.bin;
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

public class reservas {

	//ATRIBUTOS
	
	private int id;
	private int id_habitacion;
	private String dni;
	private String desde;
	private String hasta;
	
	//CONSTRUCTORES 
	
	public reservas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public reservas(int id, int id_habitacion, String dni, String desde, String hasta) {
		super();
		this.id = id;
		this.id_habitacion = id_habitacion;
		this.dni = dni;
		this.desde = desde;
		this.hasta = hasta;
	}
	
	//GETTERS Y SETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_habitacion() {
		return id_habitacion;
	}
	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	
	//METODOS
	
	//METODO TO STRING
	@Override
	public String toString() {
		return "Reservas [id=" + id + ", id_habitacion=" + id_habitacion + ", dni=" + dni + ", desde=" + desde
				+ ", hasta=" + hasta + "]";
	}
	
}
