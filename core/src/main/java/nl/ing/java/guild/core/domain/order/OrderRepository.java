package nl.ing.java.guild.core.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<ContainerEntity, Long>{

}
