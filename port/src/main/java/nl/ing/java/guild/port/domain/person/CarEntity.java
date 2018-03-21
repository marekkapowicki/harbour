package nl.ing.java.guild.port.domain.person;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.port.api.person.CarDTO;
import nl.ing.java.guild.port.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CarEntity extends BaseEntity {

    private String name;

    CarEntity(String name) {
        this.name = name;
    }

    CarDTO toDTO() {
        return new CarDTO(name);
    }
}
