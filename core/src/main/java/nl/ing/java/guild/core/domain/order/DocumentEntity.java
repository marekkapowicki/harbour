package nl.ing.java.guild.core.domain.order;

import lombok.NoArgsConstructor;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
@NoArgsConstructor

public class DocumentEntity extends BaseEntity {
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private ContainerEntity container;

//    private String documentType;
//    private String documentRemark;
//    private Blob documentBlob;

}
