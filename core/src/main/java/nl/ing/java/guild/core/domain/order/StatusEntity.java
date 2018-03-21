package nl.ing.java.guild.core.domain.order;

import lombok.Getter;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "status")
@Getter
class StatusEntity extends BaseEntity {
    private String name;
    private String description;
}
