package migrations;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class RunMigrations {

    public static void main(String[] args) throws Exception {
        MongoClient localhost = new MongoClient("localhost");
        DB database = localhost.getDB("lunchAndLearn");
        database.dropDatabase();

        DBCollection personCollection = database.getCollection("person");
        CreateLotsOfPeople_090220142030 createPeople = new CreateLotsOfPeople_090220142030(personCollection);
        createPeople.run();
    }
}
