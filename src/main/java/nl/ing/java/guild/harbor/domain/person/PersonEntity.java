package nl.ing.java.guild.harbor.domain.person;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.harbor.api.person.CarDTO;
import nl.ing.java.guild.harbor.api.person.PersonDTO;
import nl.ing.java.guild.harbor.domain.BaseEntity;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
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
