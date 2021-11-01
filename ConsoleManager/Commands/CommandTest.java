package me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Commands;

import me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager.Command;
import me.pepe.ExamenCarrera.Ejercicio10.Utils.Utils;

public class CommandTest extends Command {
	public CommandTest() {
		super("test");
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "ninguna utilidad, simplemete es una prueba";
	}

	@Override
	public void execute(String[] args) {
		System.out.println("el test funciona, comando ejecutado con los argumentos: " + Utils.printArray(args) + "(" + args.length + ")");
	}
}
