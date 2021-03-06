package pets;

/**
 * Created by kdm on 03.04.16.
 */
public class Dog implements Pet {
    private final long id;
    private String name;

    public Dog(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
