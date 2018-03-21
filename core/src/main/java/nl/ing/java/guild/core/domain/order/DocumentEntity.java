package nl.ing.java.guild.core.domain.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.ing.java.guild.core.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@Getter
class DocumentEntity extends BaseEntity {

    private String documentType;
    private String documentRemark;
    private Blob documentBlob;

}
