package nl.ing.java.guild.core.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByEmail(String email);
    Optional<ClientEntity> findByEmailAndContainersId(String email,Long containerId);
}
