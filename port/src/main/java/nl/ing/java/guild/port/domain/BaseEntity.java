package nl.ing.java.guild.port.domain;

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
public class BaseEntity {
    @Id
    @GeneratedValue
    Long id;

    @Version
    Long version;

    @CreatedDate
    private LocalDateTime createdDate;

}
