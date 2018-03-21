package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity {
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private ClientEntity client;

    private String orderDescription;
    private Double orderValue;

}
