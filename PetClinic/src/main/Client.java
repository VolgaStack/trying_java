package main;

import pets.Pet;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by kdm on 03.04.16.
 */
public class Client {
    private long id;
    private String name;
    private HashMap<Long, Pet> idToPet;
    private HashMap<String, Pet> nameToPet;

    public Client(long id, String name, Pet[] pets) {
        this.id = id;
        this.name = name;
        this.idToPet = new HashMap<>();
        this.nameToPet = new HashMap<>();

        for (Pet pet : pets) {
            this.idToPet.put(pet.getId(), pet);
            this.nameToPet.put(pet.getName(), pet);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPet(Pet pet) {
        idToPet.put(pet.getId(), pet);
        nameToPet.put(pet.getName(), pet);
    }

    public void deletePet(Pet pet) {
        idToPet.remove(pet.getId());
        nameToPet.remove(pet.getName());
    }

    public void deletePet(String name) {
        Pet pet = nameToPet.get(name);
        idToPet.remove(pet.getId());
        nameToPet.remove(pet.getName());
    }

    public Pet getPet(String name) {
        return nameToPet.get(name);
    }

    public Collection<Pet> getPets() {
        return idToPet.values();
    }
}
