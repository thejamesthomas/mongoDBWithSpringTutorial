package app;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PersonRepository {

    private DBCollection collection;

    @Autowired
    public PersonRepository(@Qualifier("personCollection") DBCollection collection) {
        this.collection = collection;
    }

    Person get(String id) {
        DBObject person = collection.findOne(queryById(id));
        return new Person(person.toMap());
    }

    public List<Person> list() {
        DBCursor people = collection.find();
        return Lists.transform(people.toArray(), new Function<DBObject, Person>() {
            @Override
            public Person apply(DBObject data) {
                return new Person(data.toMap());
            }
        });
    }

    public Person create(Person userToCreate) {
        collection.insert(new BasicDBObject(userToCreate));
        return userToCreate;
    }

    public void remove(String id) {
        collection.remove(queryById(id));
    }

    private BasicDBObject queryById(String id) {
        return new BasicDBObject(ImmutableMap.of(Person.ID, id));
    }

    public void update(Map data) {
        collection.update(queryById(String.valueOf(data.get(Person.ID))), new BasicDBObject(data));
    }
}
