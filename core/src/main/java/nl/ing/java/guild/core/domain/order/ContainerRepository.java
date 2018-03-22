package nl.ing.java.guild.core.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ContainerRepository extends JpaRepository<ContainerEntity, Long> {
    Optional<ContainerEntity> findById(Long containerId);
}
