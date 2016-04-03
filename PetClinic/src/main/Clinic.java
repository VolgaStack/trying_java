package main;

import java.util.HashMap;

/**
 * Created by kdm on 03.04.16.
 */
public class Clinic {
    private HashMap<Long, Client> idToClient;
    private HashMap<String, Client> nameToClient;


    public Clinic() {
        this.idToClient = new HashMap<>();
        this.nameToClient = new HashMap<>();
    }

    public void addClient(Client client) {
        idToClient.put(client.getId(), client);
        nameToClient.put(client.getName(), client);
    }

    public void removeClient(Client client) {
        idToClient.remove(client.getId());
        nameToClient.remove(client.getName());
    }

    public Client getClient(long id) {
        return idToClient.get(id);
    }

    public Client getClient(String name) {
        return nameToClient.get(name);
    }
}
