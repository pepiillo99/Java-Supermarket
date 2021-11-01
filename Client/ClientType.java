package me.pepe.ExamenCarrera.Ejercicio10.Client;

public enum ClientType {
	FRIEND(20),
	KNOW(10),
	NORMAL(0);
	
	private int discount;
	
	ClientType(int discount) {
		this.discount = discount;
	}
	public int getDiscount() {
		return discount;
	}
}
