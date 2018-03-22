package nl.ing.java.guild.mp.domain.mp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import nl.ing.java.guild.mp.domain.BaseEntity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String destination;





}
