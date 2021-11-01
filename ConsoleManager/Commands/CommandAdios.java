package me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands;

import me.pepe.ExamenCarrera.Ejercicio10.Supermercado;
import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Command;

public class CommandAdios extends Command {
	public CommandAdios() {
		super("adios");
	}
	@Override
	public String getDescription() {
		return "po pa cerra el programa pa q va a se";
	}
	@Override
	public void execute(String[] args) {
		Supermercado.getInstance().getConsoleManager().setExecute(false);
		System.out.println("Hasta nunca saborio");
	}
}
