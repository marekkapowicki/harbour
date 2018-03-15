package nl.ing.java.guild.harbor.domain.person;

import lombok.extern.slf4j.Slf4j;
import nl.ing.java.guild.harbor.api.person.PersonCreateRequest;
import nl.ing.java.guild.harbor.api.person.PersonDTO;
import nl.ing.java.guild.harbor.domain.exception.ResourceNotFound;
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
    public PersonDTO findById(Long id) {
        log.info("finding person by id={}", id);
        return personRepository.findById(id)
                .map(PersonEntity::toDTO)
                .orElseThrow(() -> new ResourceNotFound("person does not exists"));
    }
}
