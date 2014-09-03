import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller(value = "/person")
public class PersonController {

    private PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = GET, value = "/{id}")
    public Person get(@PathVariable String id) {
        return repository.get(id);
    }

    @RequestMapping(method = GET, value = "/")
    public List<Person> list() {
        return repository.list();
    }

    @RequestMapping(method = POST, value = "/")
    public Person create(Map data) {
        return repository.create(new Person(data));
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public void delete(@PathVariable String id) {
        repository.remove(id);
    }
}
