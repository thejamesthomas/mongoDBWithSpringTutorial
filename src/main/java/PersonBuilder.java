import java.util.Map;

public class PersonBuilder {

    private String id;
    private String firstName;
    private String lastName;

    PersonBuilder() {}

    public static PersonBuilder aPerson() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.id = "1";
        personBuilder.firstName = "Harry";
        personBuilder.lastName = "Potter";
        return personBuilder;
    }

    public Person build() {
        return new Person(id, firstName, lastName);
    }

    public PersonBuilder withId(String id) {
        this.id = id;
        return this;
    }
}
