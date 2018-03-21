package nl.ing.java.guild.port.api.person;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarAddRequest {
    private final String name;
    private final Long ownerId;
}
