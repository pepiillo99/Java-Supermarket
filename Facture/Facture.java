package me.pepe.ExamenCarrera.Ejercicio10.Facture;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import me.pepe.ExamenCarrera.Ejercicio10.Supermercado;
import me.pepe.ExamenCarrera.Ejercicio10.Article.Article;
import me.pepe.ExamenCarrera.Ejercicio10.Client.Client;
import me.pepe.ExamenCarrera.Ejercicio10.Client.ClientType;

public class Facture {
	private int id;
	private String client; // dni
	private HashMap<Article, Integer> articles = new HashMap<Article, Integer>();
	private boolean closed = false;
	public Facture(String client) {
		this.client = client;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public boolean hasArticle(Article article) {
		return articles.containsKey(article);
	}
	public int getAmount(Article article) {
		return articles.get(article);
	}
	public void setAmount(Article article, int amount) {
		articles.put(article, amount);
	}
	public void addAmount(Article article, int amount) {
		if (hasArticle(article)) {
			setAmount(article, getAmount(article) + amount);
		} else {
			setAmount(article, amount);
		}
	}
	public boolean isClosed() {
		return closed;
	}
	public void close() {
		this.closed = true;
	}
	public void print(String path) throws IOException {
		System.out.println("Intentando imprimir la factura...");
		File folder = new File(path);
		if (folder.exists()) {
			if (folder.isDirectory()) {
				File file = new File(path + "facture-" + id + ".txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write("Factura del cliente " + client);
				writer.newLine();
				writer.newLine();
				double total = 0;
				for (Entry<Article, Integer> arts : articles.entrySet()) {
					total = total + (arts.getKey().getPrice() * arts.getValue());
					writer.write(arts.getValue() + " " + arts.getKey().getName() + " - " + String.format("%,.2f", (arts.getKey().getPrice() * arts.getValue())));
					writer.newLine();
				}
				writer.newLine();
				writer.newLine();
				writer.write("Total: " + String.format("%,.2f", total));
				writer.newLine();
				writer.newLine();
				Client c = Supermercado.getInstance().getClientManager().getClient(client);
				if (!c.getClientType().equals(ClientType.NORMAL)) {
					writer.write("Descuento de cliente: " + c.getClientType().getDiscount());
					writer.newLine();
					double discount = total * c.getClientType().getDiscount() / 100;
					total -= discount;
					writer.write("Total descontado: " + String.format("%,.2f", total));
					writer.newLine();
					writer.newLine();
				}
				writer.close();
				System.out.println("Factura creada correctamente en " + file.getPath());
			} else {
				System.out.println(path + " no es una carpeta");
			}
		} else {
			System.out.println(path + " no existe como dirección");
		}
		
	}
}
