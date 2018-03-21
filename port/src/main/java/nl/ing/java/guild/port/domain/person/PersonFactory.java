package nl.ing.java.guild.port.domain.person;

import nl.ing.java.guild.port.api.person.PersonCreateRequest;

class PersonFactory {
    PersonEntity create(PersonCreateRequest createRequest) {
        return new PersonEntity(createRequest.getFirstName(), null);
    }
}
