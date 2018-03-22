package nl.ing.java.guild.mp.domain.mp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.Offers.OfferResponse;
import nl.ing.java.client.Offers.OffersResponse;
import nl.ing.java.client.customer.Container;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.guild.mp.domain.error.ResourceNotFound;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@AllArgsConstructor
@Component
public class MarketPlaceFacade {

    private final MarketRepository marketRepository;

    @Transactional(readOnly = true)
    public OffersResponse offerByDestination(String destination) {
        log.info("offer data request");
        return toResponse(marketRepository.findByDestination(destination));

    }
    private static OffersResponse toResponse (List<OfferEntity> offerEntities){
        List<OfferResponse> offers = offerEntities.stream()
                .map(MarketPlaceFacade::toOffer)
                .collect(Collectors.toList());
        return new OffersResponse(offers);

    }

    private static OfferResponse toOffer (OfferEntity offerEntity){
        return new OfferResponse(offerEntity.getId(),offerEntity.getDestination());
    }


}
