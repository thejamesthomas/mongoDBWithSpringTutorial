package app;

import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;

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
        HashMap<Object,Object> data = newHashMap();
        data.put(Person.ID, id);
        data.put(Person.FIRST_NAME, firstName);
        data.put(Person.LAST_NAME, lastName);
        data.put(Person.EYE_COLOR, "blue");
        data.put(Person.DOMINANT_HAND, "right");
        data.put(Person.WEARS_GLASSES, false);

        return new Person(data);
    }

    public PersonBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
