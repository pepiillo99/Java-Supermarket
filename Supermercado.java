package me.pepe.ExamenCarrera.Ejercicio10;

import me.pepe.ExamenCarrera.Ejercicio10.Article.ArticleManager;
import me.pepe.ExamenCarrera.Ejercicio10.Client.ClientManager;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.ConsoleManager;
import me.pepe.ExamenCarrera.Ejercicio10.Facture.FactureManager;

public class Supermercado {
	public static void main(String[] args) {
		new Supermercado();
	}
	private static Supermercado instance;
	private ClientManager clientManager;
	private ArticleManager articleManager;
	private FactureManager factureManager;
	private ConsoleManager consoleManager;
	public Supermercado() {
		instance = this;
		clientManager = new ClientManager();
		articleManager = new ArticleManager();
		factureManager = new FactureManager();
		consoleManager = new ConsoleManager();
		consoleManager.setExecute(true);
		consoleManager.start();
		System.out.println("Programa ejecutado, usa 'help' para obtener ayuda");
	}
	public static Supermercado getInstance() {
		return instance;
	}
	public ClientManager getClientManager() {
		return clientManager;
	}
	public ArticleManager getArticleManager() {
		return articleManager;
	}
	public FactureManager getFactureManager() {
		return factureManager;
	}
	public ConsoleManager getConsoleManager() {
		return consoleManager;
	}
}
