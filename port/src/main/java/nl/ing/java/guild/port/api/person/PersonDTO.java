package nl.ing.java.guild.port.api.person;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonDTO {
    private String firstName;
    private List<CarDTO> cars;
}
