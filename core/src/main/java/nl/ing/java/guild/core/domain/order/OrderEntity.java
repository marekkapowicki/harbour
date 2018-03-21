package nl.ing.java.guild.core.domain.order;

import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private ClientEntity client;

    private String orderDescription;
    private Double orderValue;

}
