package nl.ing.java.guild.mp.domain.mp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import nl.ing.java.guild.mp.domain.BaseEntity;

import java.math.BigDecimal;

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

    private BigDecimal price;

    private Integer durationInDays;

    @Enumerated(EnumType.STRING)
    private TransportType transportType;


}
