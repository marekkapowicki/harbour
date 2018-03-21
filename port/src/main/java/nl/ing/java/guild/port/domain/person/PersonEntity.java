package nl.ing.java.guild.port.domain.person;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.port.api.person.CarDTO;
import nl.ing.java.guild.port.api.person.PersonDTO;
import nl.ing.java.guild.port.domain.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Table(name = "person")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PersonEntity extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;

    @OneToMany(fetch= FetchType.EAGER , cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "owner_id")
    private Set<CarEntity> cars;

    PersonEntity(String firstName, Set<CarEntity> cars) {
        this.firstName = firstName;
        this.cars = cars;
    }

    PersonDTO toDTO() {
        List<CarDTO> carDTOs = cars == null ? null :
                cars.stream()
                        .map(CarEntity::toDTO)
                        .collect(Collectors.toList());
        return new PersonDTO(firstName, carDTOs);
    }
}
