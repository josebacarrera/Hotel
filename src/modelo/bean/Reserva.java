package modelo.bean;
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

public class Reserva {

	//ATRIBUTOS
	
	private int id;
	private int id_habitacion;
	private String dni;
	private Date desde;
	private Date hasta;
	
	//CONSTRUCTORES 
	
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reserva(int id, int id_habitacion, String dni, Date desde, Date hasta) {
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
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
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
