package nl.ing.java.guild.harbor.api.person;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonDTO {
    private String firstName;
    private List<CarDTO> cars;
}
