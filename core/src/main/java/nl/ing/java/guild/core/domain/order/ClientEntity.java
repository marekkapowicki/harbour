package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="client")
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity extends BaseEntity {
    private String clientName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client" )
    //@JoinColumn(name = "client_id")
    private Set<OrderEntity> orders;

}
