package nl.ing.java.guild.harbor.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByFirstName(String firstName);
}
