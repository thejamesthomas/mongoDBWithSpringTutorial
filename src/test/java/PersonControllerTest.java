import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class PersonControllerTest {

    private PersonController controller;
    private PersonRepository personRepository;

    @Before
    public void given() {
        personRepository = mock(PersonRepository.class);
        controller = new PersonController(personRepository);
    }

    @Test
    public void shouldCallRepositoryForCreatingUser() {
        controller.create(PersonBuilder.aPerson().build());
        verify(personRepository, times(1)).create(any(Person.class));
    }

    @Test
    public void shouldCallRepositoryWithIdWhenRetrievingUser() {
        String id = "2";
        controller.get(id);
        verify(personRepository, times(1)).get(id);
    }
}
