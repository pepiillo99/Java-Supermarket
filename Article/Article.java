package me.pepe.ExamenCarrera.Ejercicio10.Article;

public class Article {
	private String name;
	private double price;
	private IVAType ivaType = IVAType.NORMAL;
	public Article(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public IVAType getIVAType() {
		return ivaType;
	}
	public void setIVAType(IVAType ivaType) {
		this.ivaType = ivaType;
	}
}
