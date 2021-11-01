package me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands;

import me.pepe.ExamenCarrera.Ejercicio10.Supermercado;
import me.pepe.ExamenCarrera.Ejercicio10.Article.Article;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Command;
import me.pepe.ExamenCarrera.Ejercicio10.Facture.Facture;

public class CommandBuy extends Command {
	public CommandBuy() {
		super("buy");
	}
	@Override
	public String getDescription() {
		return "Añade un articulo a la factura actual con la cantidad indicada";
	}
	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			System.out.println("Uso incorrecto, usa 'buy <article> <amount>'");
			System.out.println("Para ejecutar este comando es necesario previamente tener una factura abierta.");
		} else {
			if (args.length == 2) {
				try {
					int amount = Integer.valueOf(args[1]);
					if (Supermercado.getInstance().getArticleManager().hasArticle(args[0])) {
						buy(Supermercado.getInstance().getArticleManager().getArticle(args[0]), amount);
					} else {
						try { 
							int id = Integer.valueOf(args[1]);
							if (Supermercado.getInstance().getArticleManager().hasArticle(id)) {
								buy(Supermercado.getInstance().getArticleManager().getArticle(id), amount);
							} else {
								System.out.println("El articulo " + args[0] + " no existe");
							}
						} catch (NumberFormatException ex) {
							System.out.println("El articulo " + args[0] + " no existe");
						}
					}
				} catch (NumberFormatException ex) {
					System.out.println("La cantidad " + args[1] + " no es un numero valido");
				}
			} else {
				System.out.println("Uso incorrecto, usa 'buy <article> <amount>'");
				System.out.println("Para ejecutar este comando es necesario previamente tener una factura abierta.");	
			}
		}
	}
	private void buy(Article article, int amount) {
		if (Supermercado.getInstance().getFactureManager().hasFactureOpenned()) {
			Facture facture = Supermercado.getInstance().getFactureManager().getFactureOpenned();
			facture.addAmount(article, amount);
			System.out.println("Comprado y añadido a la factura");
		} else {
			System.out.println("No tienes ninguna factura abierta, por favor abre una factura.");
		}
	}
}
