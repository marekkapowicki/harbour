package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "container")
@NoArgsConstructor
@AllArgsConstructor
public class ContainerEntity extends BaseEntity {
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private ClientEntity client;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "container_id")
    private Set<DocumentEntity> documents;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "container_id")
    private int status;

    private String description;
    private Double value;

//    private String consignee;
//    private String notifyParty;
//    private String vesselName;
//    private String portOfLoading;
//    private String portOfDischarge;
//    private String containerSize;

// BELOW VARIABLES ARE PROBABLY NOT NEEDED ANYMORE
//    private int orderTranspID;
//    private int orderStatusID;
//    private int containerID:
//    private int shipID;
//    private String orderCurrency;
//    private Boolean orderPaid;
//    private String orderDestCountry;
//    private String orderDestCity;
//    private String orderDestAddress;
//    private String orderDestZip;
//    private String orderDestNameReceiver;

}
