package me.pepe.ExamenCarrera.Ejercicio10.Client;

import java.util.Collection;
import java.util.HashMap;

public class ClientManager {
	private HashMap<String, Client> clients = new HashMap<String, Client>();
	public ClientManager() {}
	public Collection<Client> getClients() {
		return clients.values();
	}
	public boolean hasClient(String dni) {
		return clients.containsKey(dni);
	}
	public Client getClient(String dni) {
		if (hasClient(dni)) {
			return clients.get(dni);
		} else {
			return null;
		}
	}
	public void registerClient(Client client) {
		clients.put(client.getDNI(), client);
	}
}
