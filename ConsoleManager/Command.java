package me.pepe.ExamenCarrera.Ejercicio10.ConsoleManager;

public abstract class Command {
	private String name;
	public Command(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public abstract String getDescription();
	public abstract void execute(String[] args);
}
