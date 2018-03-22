package nl.ing.java.guild.mp.domain;

import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
