package nl.ing.java.guild.core.domain.order;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StatusRepository extends CrudRepository<StatusEntity, Long> {

    Optional<StatusEntity> findByName(String name);

    default Optional<StatusEntity> findBy(Status status) {
        return findByName(status.name());
    }
}
