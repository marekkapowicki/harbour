package nl.ing.java.guild.core.domain.order;

import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "statusHistory")
public class StatusHistoryEntity extends BaseEntity {
    @OneToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private int status;



}
