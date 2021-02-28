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
public class Habitacion {

	//ATRIBUTOS
	
	private String id;
	private int id_hotel; 
	private String numero;
	private String descripcion;
	private double precio;
	
	//CONSTRUCTORES
	
	public Habitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Habitacion(String id, int id_hotel, String numero, String descripcion, double precio) {
		super();
		this.id = id;
		this.id_hotel = id_hotel;
		this.numero = numero;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	//GETTERS Y SETTERES

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	//METODOS
	
	//METODO TO STRING
	
	@Override
	public String toString() {
		return "Habitaciones [id=" + id + ", id_hotel=" + id_hotel + ", numero=" + numero + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}
	
}
