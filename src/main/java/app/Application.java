package app;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.UnknownHostException;

@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public MongoClient mongo() throws UnknownHostException {
        return new MongoClient("localhost");
    }

    public DB database() throws UnknownHostException {
        return mongo().getDB("lunchAndLearn");
    }

    @Bean(name = "personCollection")
    public DBCollection personCollection() {
        try {
            return database().getCollection("person");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
