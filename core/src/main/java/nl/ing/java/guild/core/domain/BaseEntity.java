package nl.ing.java.guild.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@MappedSuperclass
@FieldDefaults(level = PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue
    Long id;

    @Version
    Long version;

    @CreatedDate
    @Getter
    LocalDateTime creationTime;

}
