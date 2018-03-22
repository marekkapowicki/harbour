package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "status")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "name", callSuper = false)
class StatusEntity extends BaseEntity {
    private String name;
    private String description;
    private long durationInDays;
}
