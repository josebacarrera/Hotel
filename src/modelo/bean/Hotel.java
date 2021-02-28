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

public class Hotel {

	//ATRIBUTOS
	
	private String id;
	private String cif;
	private String nombre;
	private String gerente;
	private int estrellas;
	private String compania;
	
	//CONSTRUCTORES
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(String id, String cif, String nombre, String gerente, int estrellas, String compania) {
		super();
		this.id = id;
		this.cif = cif;
		this.nombre = nombre;
		this.gerente = gerente;
		this.estrellas = estrellas;
		this.compania = compania;
	}

	//GETTERS Y SETTERS
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}
	
	//METODOS
	
	//METODO TO STRING

	@Override
	public String toString() {
		return "Hoteles [id=" + id + ", cif=" + cif + ", nombre=" + nombre + ", gerente=" + gerente + ", estrellas="
				+ estrellas + ", compania=" + compania + "]";
	}
	
	
}
