package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class PersonController {

    private PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = GET, value = "/person/{id}", produces = "application/json")
    @ResponseBody
    public Person get(@PathVariable String id) {
        return repository.get(id);
    }

    @RequestMapping(method = GET, value = "/person/", produces = "application/json")
    @ResponseBody
    public List<Person> list() {
        return repository.list();
    }

    @RequestMapping(method = POST, value = "/person/", produces = "application/json")
    @ResponseBody
    public Person create(@RequestBody Map data) {
        return repository.create(new Person(data));
    }

    @RequestMapping(method = DELETE, value = "/person/{id}", produces = "application/json")
    public void delete(@PathVariable String id) {
        repository.remove(id);
    }

    @RequestMapping(method = PUT, value = "/person/", produces = "application/json")
    public void update(@RequestBody Map data) {
        repository.update(data);
    }

    @RequestMapping(method = GET, value = "/person/", produces = "application/json")
    public List<Person> search(HttpServletRequest request) {
        return newArrayList();
    }
}
