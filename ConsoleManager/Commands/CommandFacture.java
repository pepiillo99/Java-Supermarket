package me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands;

import java.io.IOException;

import me.pepe.ExamenCarrera.Ejercicio10.Supermercado;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Command;
import me.pepe.ExamenCarrera.Ejercicio10.Facture.Facture;
import me.pepe.ExamenCarrera.Ejercicio10.Utils.Utils;

public class CommandFacture extends Command {
	public CommandFacture() {
		super("facture");
	}
	@Override
	public String getDescription() {
		return "Te da la opcion de abrir una nueva factura, cerrarla, imprimirlas y borrarlas";
	}

	@Override
	public void execute(String[] args) {
		if (args.length == 0) {
			System.out.println("Usa: 'facture open/close/print'");
		} else {
			if (args[0].equalsIgnoreCase("open")) {
				if (args.length == 2) {
					String dni = args[1];	
					if (Utils.isDNIValid(dni)) {
						if (Supermercado.getInstance().getClientManager().hasClient(dni)) {
							int id = Supermercado.getInstance().getFactureManager().open(new Facture(dni));
							System.out.println("La factura se ha creado con la ID: " + id);
						} else {
							System.out.println("El usuario con el DNI introducido no existe");
						}
					} else {
						System.out.println("El DNI introducido no es valido");
					}
				} else {
					System.out.println("Argumentos invalido, usa: 'facture open <dni>'");
				}
			} else if (args[0].equalsIgnoreCase("close")) {
				if (args.length == 2) {
					try {
						int id = Integer.valueOf(args[1]);
						if (Supermercado.getInstance().getFactureManager().hasFacture(id)) {
							Facture facture = Supermercado.getInstance().getFactureManager().getFacture(id);
							if (!facture.isClosed()) {
								facture.close();
								System.out.println("Has cerrado correctamente la factura, para imprimirla use 'facture print " + id + "'");
							} else {
								System.out.println("La factura ya estaba cerrada.");
							}
						} else {
							System.out.println("La factura " + id + " no existe");
						}
					} catch (NumberFormatException ex) {
						System.out.println(args[1] + " no es un numero valido");
					}
				} else {
					System.out.println("Uso incorrecto, usa 'facture close <id>'");
				}
			} else if (args[0].equalsIgnoreCase("print")) {
				if (args.length == 3) {
					try {
						int id = Integer.valueOf(args[1]);
						if (Supermercado.getInstance().getFactureManager().hasFacture(id)) {
							Facture facture = Supermercado.getInstance().getFactureManager().getFacture(id);
							if (facture.isClosed()) {
								facture.print(args[2]);
							} else {
								System.out.println("Antes de imprimir la factura debes cerrarla, usa 'facture close " + id + "'");
							}
						} else {
							System.out.println("La factura " + id + " no existe");
						}
					} catch (NumberFormatException ex) {
						System.out.println(args[1] + " no es un numero valido");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Uso incorrecto, usa 'facture print <id> <path>'");
				}
			} else {
				System.out.println("Usa: 'facture open/close/print'");
			}
		}
	}
}
