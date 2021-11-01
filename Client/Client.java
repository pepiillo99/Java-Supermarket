package me.pepe.ExamenCarrera.Ejercicio10.Client;

import java.util.Date;

public class Client {
	private String name;
	private String secondName;
	private String dni;
	private long birthdate;
	private ClientType clientType = ClientType.NORMAL;
	public Client(String name, String secondName, String dni, long birthdate, ClientType clientType) {
		this.name = name;
		this.secondName = secondName;
		this.dni = dni;
		this.birthdate = birthdate;
	}
	public Client(String name, String secondName, String dni, long birthdate) {
		this(name, secondName, dni, birthdate, ClientType.NORMAL);
	}
	public String getName() {
		return name;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getDNI() {
		return dni;
	}
	public Date getBirthDate() {
		return new Date(birthdate);
	}
	public ClientType getClientType() {
		return clientType;
	}
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
}
