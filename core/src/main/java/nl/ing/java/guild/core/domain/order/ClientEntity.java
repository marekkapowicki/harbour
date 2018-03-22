package nl.ing.java.guild.core.domain.order;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name="client")
@AllArgsConstructor
@NoArgsConstructor
class ClientEntity extends BaseEntity {
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client" )
    private Set<ContainerEntity> containers;
    private String email;

    public Set<ContainerEntity> getContainers() {
        return containers == null ? Collections.emptySet() : containers;
    }
}
