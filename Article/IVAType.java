package me.pepe.ExamenCarrera.Ejercicio10.Article;

public enum IVAType {
	SUPER_REDUCED(5),
	REDUCED(15),
	NORMAL(21);
	
	private int iva;
	
	IVAType(int iva) {
		this.iva = iva;
	}
	public int getIVA() {
		return iva;
	}
}
