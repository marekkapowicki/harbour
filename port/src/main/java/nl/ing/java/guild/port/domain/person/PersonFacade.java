package nl.ing.java.guild.port.domain.person;

import lombok.extern.slf4j.Slf4j;
import nl.ing.java.guild.port.api.person.PersonCreateRequest;
import nl.ing.java.guild.port.api.person.PersonDTO;
import nl.ing.java.guild.port.domain.exception.ResourceNotFound;
import org.springframework.transaction.annotation.Transactional;

/**
 * gateway to the package
 * all functionalities from package are available here
 * also used to manage the transactions
 */
@Slf4j
public class PersonFacade {

    private final PersonRepository personRepository;
    private final PersonFactory personFactory;

    public PersonFacade(PersonRepository personRepository, PersonFactory personFactory) {
        this.personRepository = personRepository;
        this.personFactory = personFactory;
    }

    @Transactional
    public Long create(PersonCreateRequest createRequest) {
        log.info("create the person entity from request = {}", createRequest);
        PersonEntity entity = personFactory.create(createRequest);
        return personRepository.save(entity).getId();
    }

    @Transactional(readOnly = true)
    public PersonDTO retrieve(String id) {
        log.info("finding person by id={}", id);
        return personRepository.findById(Long.valueOf(id))
                .map(PersonEntity::toDTO)
                .orElseThrow(() -> new ResourceNotFound("person does not exists"));
    }
}