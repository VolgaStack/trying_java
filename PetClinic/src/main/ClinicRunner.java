package main;

import pets.Cat;
import pets.Dog;
import pets.Pet;

/**
 * Created by kdm on 03.04.16.
 */
public class ClinicRunner {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        long petId = 0;
        long clientId = 0;

        Client susan = new Client(clientId++, "Susan", new Pet[]{new Cat(petId++, "Beauty")});
        Client mary = new Client(clientId++, "Mary", new Pet[]{new Dog(petId++, "Max")});

        // добавление клиентов
        clinic.addClient(susan);
        clinic.addClient(mary);

        // поиск клиентов
        Client someClient = clinic.getClient(mary.getName());

        // добавление животных
        someClient.addPet(new Cat(petId++, "Nyan"));

        // Меняем имя у клиента
        someClient.setName("Mary Jane");

        // Меняем имя у питомца
        Pet max = someClient.getPet("Max");
        max.setName("Cool Max");

        // Удаляем питомца
        someClient.deletePet("Max");

        // удаляем клиента
        clinic.removeClient(someClient);

    }
}
