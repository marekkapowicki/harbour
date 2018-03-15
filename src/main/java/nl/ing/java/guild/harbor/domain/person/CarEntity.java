package nl.ing.java.guild.harbor.domain.person;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.harbor.api.person.CarDTO;
import nl.ing.java.guild.harbor.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CarEntity extends BaseEntity{

    private String name;

    CarEntity(String name) {
        this.name = name;
    }

    CarDTO toDTO() {
        return new CarDTO(name);
    }
}
