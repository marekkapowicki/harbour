package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "container")
@NoArgsConstructor
@AllArgsConstructor
class ContainerEntity extends BaseEntity {
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private ClientEntity client;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "container_id")
    private Set<DocumentEntity> documents;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StatusEntity status;

    private BigDecimal price;

    private String finalDestination;

}
