package migrations;

import app.Person;
import app.PersonRepository;
import com.mongodb.DBCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class CreateLotsOfPeople_090220142030 {

    private final PersonRepository repository;

    public CreateLotsOfPeople_090220142030(DBCollection collection) {
        this.repository = new PersonRepository(collection);
    }

    public void run() {
        for (int id = 0; id < 10000; id++) {
            Person person = new Person(String.valueOf(id), firstName(), lastName());
            repository.create(person);
        }
    }

    private String firstName() {
        ArrayList<String> firstNames = newArrayList("Harry", "Ron", "Hermoine", "Ginny", "Albus", "Severus", "Percy", "Neville", "Myrtle", "Professor");
        Collections.shuffle(firstNames);
        return firstNames.get(0);
    }

    private String lastName() {
        ArrayList<String> lastNames = newArrayList("Potter", "Weasley", "Granger", "Dumbledore", "McGonagal", "Snape", "Longbottom", "Hagrid", "Moaning", "Hufflepuff");
        Collections.shuffle(lastNames);
        return lastNames.get(0);
    }
}
