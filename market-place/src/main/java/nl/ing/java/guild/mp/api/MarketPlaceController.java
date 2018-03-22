package nl.ing.java.guild.mp.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.offers.OffersResponse;
import nl.ing.java.guild.mp.domain.mp.MarketPlaceFacade;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/market/api/offers")
public class MarketPlaceController {

    private final MarketPlaceFacade marketFacade;

    @GetMapping(value = "/{destination}")
    public OffersResponse quote(@PathVariable("destination") String destination) {
        log.info("new request arrived {}", destination);
        return marketFacade.offerByDestination(destination);

    }

    @GetMapping
    public OffersResponse allOffers() {
        log.info("new request arrived {}");
        return marketFacade.allOffers();
    }

}
