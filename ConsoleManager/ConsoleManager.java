package me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager;

import java.util.HashMap;
import java.util.Scanner;

import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands.CommandAdios;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands.CommandBuy;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands.CommandFacture;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands.CommandRegister;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands.CommandTest;

public class ConsoleManager extends Thread {
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	private boolean execute = false;
	public ConsoleManager() {
		registerCommands();
	}
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		while (execute) {
			String allCommand = scan.nextLine();
			String command = allCommand.split(" ", 2)[0];
			String[] args = (allCommand.split(" ", 2).length == 1 ? new String[]{} : allCommand.split(" ", 2)[1].split(" "));
			if (command.equalsIgnoreCase("help")) {
				if (commands.isEmpty()) {
					System.out.println("No hay comandos con los que te pueda ayudar ;(");
				} else {
					System.out.println("Ayuda para los siguientes comandos:");
					System.out.println("---------------------------------------");
					for (Command c : commands.values()) {
						System.out.println(c.getName() + " - " + c.getDescription());
					}
					System.out.println("---------------------------------------");	
				}
			} else if (commands.containsKey(command.toLowerCase())) {
				enterCommand(command, args);
			} else {
				System.out.println("Ese comando no existe, usa help si necesitas ayuda");
			}
		}
		scan.close();
	}
	public boolean isExecuted() {
		return execute;
	}
	public void setExecute(boolean executed) {
		this.execute = executed;
	}
	private void registerCommands() {
		registerCommand(new CommandAdios());
		registerCommand(new CommandTest());
		registerCommand(new CommandRegister());
		registerCommand(new CommandFacture());
		registerCommand(new CommandBuy());
	}
	public void registerCommand(Command command) {
		commands.put(command.getName(), command);
	}
	private void enterCommand(String command, String[] args) {
		Command cmd = commands.get(command);
		cmd.execute(args);
	}
}
