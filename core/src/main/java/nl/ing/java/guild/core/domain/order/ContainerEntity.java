package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "container")
@NoArgsConstructor
@AllArgsConstructor
@Getter
class ContainerEntity extends BaseEntity {
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private ClientEntity client;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "container_id")
    private Set<DocumentEntity> documents;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Setter
    private StatusEntity status;

    private BigDecimal price;

    private String finalDestination;

    private String size;

    private String description;

    private String name;

}
