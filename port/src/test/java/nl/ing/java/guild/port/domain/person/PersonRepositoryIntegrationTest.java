package nl.ing.java.guild.port.domain.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PersonRepositoryIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    private Long storedId;

    @Before
    public void setUp() {
        CarEntity audi = new CarEntity("audi");
        PersonEntity person = new PersonEntity("marek", Collections.singleton(audi));
        storedId = personRepository.save(person).getId();
    }

    @Test
    public void shouldFindById() {
        //When
        Optional<PersonEntity> found = personRepository.findById(storedId);
        //Then
        assertThat(found).isPresent();
    }

    @Test
    public void shouldFindByName() {
        //When
        Optional<PersonEntity> marek = personRepository.findByFirstName("marek");
        //Then
        assertThat(marek).isPresent();
    }

    @Test
    public void shouldNotFindNotExistingPersonByName() {
        //When
        Optional<PersonEntity> glen = personRepository.findByFirstName("glen");
        //Then
        assertThat(glen).isEmpty();
    }
}