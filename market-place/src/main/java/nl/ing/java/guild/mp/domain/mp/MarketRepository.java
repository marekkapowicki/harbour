package nl.ing.java.guild.mp.domain.mp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface   MarketRepository extends JpaRepository<OfferEntity, Long> {

    List<OfferEntity> findByDestination(String destination);

}
