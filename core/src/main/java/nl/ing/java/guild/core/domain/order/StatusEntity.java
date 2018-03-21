package nl.ing.java.guild.core.domain.order;

import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "status")
public class StatusEntity extends BaseEntity {

    private int status;



}
