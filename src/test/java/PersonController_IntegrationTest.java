import app.Person;
import app.PersonController;
import app.PersonRepository;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.Random;

import static app.PersonBuilder.aPerson;
import static org.junit.Assert.assertEquals;

public class PersonController_IntegrationTest {

    private PersonController personController;
    private PersonRepository repository;
    private DBCollection collection;

    @Before
    public void given() throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost");
        DB database = mongo.getDB("lunchAndLearn");
        collection = database.getCollection("person");

        repository = new PersonRepository(collection);
        personController = new PersonController(repository);
    }

    @Test
    public void shouldCreateNewUser() {
        String id = new Random(777777777).toString();
        Person person = aPerson().withId(id).withFirstName("Theon").withLastName("Greyjoy").build();

        personController.create(person);

        Person retrievedPerson = personController.get(id);
        assertEquals(person, retrievedPerson);
    }
}
