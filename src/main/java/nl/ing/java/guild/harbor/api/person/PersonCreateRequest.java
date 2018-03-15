package nl.ing.java.guild.harbor.api.person;

import lombok.ToString;

@ToString
public class PersonCreateRequest {
    private final String firstName;

    public PersonCreateRequest(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
