package nl.ing.java.guild.harbor.domain.person;

import nl.ing.java.guild.harbor.api.person.PersonCreateRequest;

class PersonFactory {
    PersonEntity create(PersonCreateRequest createRequest) {
        return new PersonEntity(createRequest.getFirstName(), null);
    }
}
