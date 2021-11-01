package me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands;

import java.util.Date;

import me.pepe.ExamenCarrera.Ejercicio10.Supermercado;
import me.pepe.ExamenCarrera.Ejercicio10.Article.Article;
import me.pepe.ExamenCarrera.Ejercicio10.Client.Client;
import me.pepe.ExamenCarrera.Ejercicio10.Client.ClientType;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Command;
import me.pepe.ExamenCarrera.Ejercicio10.Utils.Utils;

public class CommandRegister extends Command {
	public CommandRegister() {
		super("register");
	}
	@Override
	public String getDescription() {
		return "Nos da la opcion de poder registrar tanto un articulo como un cliente";
	}
	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			System.out.println("Uso incorrecto, usa: 'register client/article'");
		} else {
			if (args[0].equalsIgnoreCase("client")) {
				if (args.length >= 5 && args.length <= 6) {
					if (!Supermercado.getInstance().getClientManager().hasClient(args[3])) {
						if (Utils.isDNIValid(args[3])) {
							String[] dateValues = args[4].split("/");
							if (dateValues.length == 3) {
								boolean dateValid = true;
								for (String s : dateValues) {
									try {
										int val = Integer.valueOf(s);
									} catch (NumberFormatException ex) {
										dateValid = false;
										System.out.println(s + " no es un numero valido en la fecha que has metido...");
									}
								}
								if (dateValid && Utils.isDateValid(Integer.valueOf(dateValues[0]), Integer.valueOf(dateValues[1]), Integer.valueOf(dateValues[2]))) {
									Date date = new Date(args[4]);
									ClientType clientType = ClientType.NORMAL;
									if (args.length == 6) {
										if (ClientType.valueOf(args[5]) != null) {
											Supermercado.getInstance().getClientManager().registerClient(new Client(args[1], args[2], args[3], date.getTime(), clientType));
											System.out.println("Cliente registrado correctamente");
										} else {
											System.out.println("El tipo de cliente " + args[5] + " no es valido, tipos de clientes validos:");
											for (ClientType ct : ClientType.values()) {
												System.out.println(ct.name());
											}
										}
									} else {
										Supermercado.getInstance().getClientManager().registerClient(new Client(args[1], args[2], args[3], date.getTime(), clientType));
										System.out.println("Cliente registrado correctamente");
									}
								} else {
									System.out.println("La fecha introducida es invalida.");
								}
							} else {
								System.out.println("La fecha es invalida, has metido " + dateValues.length + " valores y debes de meter 3. (d/m/y)");
							}
						} else {
							System.out.println("El DNI " + args[3] + " no es valido");
						}
					} else {
						System.out.println("El usuario con el DNI " + args[3] + " ya existe!");
					}
				} else {
					System.out.println("Argumentos invalidos, usa: 'register client <name> <secondName> <dni> <birthDate(d/m/y)> [clientType(Default:Normal)]'");
				}
			} else if (args[0].equalsIgnoreCase("article")) {
				if (args.length == 3) {
					try {
						double price = Double.valueOf(args[2]);
						if (!Supermercado.getInstance().getArticleManager().hasArticle(args[1])) {
							int id = Supermercado.getInstance().getArticleManager().registerArticle(new Article(args[1], price));
							System.out.println("Articulo " + args[1] + " con la ID: " + id);
						} else {
							System.out.println("El articulo " + args[1] + " ya está registrado");
						}
					} catch (NumberFormatException ex) {
						System.out.println(args[2] + " no es un numero valido");
					}
				} else {
					System.out.println("Argumentos invalidos, usa: 'register article <name> <price>'");
				}
			} else {
				System.out.println("No puedes registrar un " + args[0] + " porque no existe!");
			}
		}
	}
}
