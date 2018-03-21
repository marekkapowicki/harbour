package nl.ing.java.guild.core.api.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.guild.core.domain.order.CustomerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static nl.ing.java.guild.core.api.Specification.ROOT;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = ROOT + "/customers")
public class CustomerController {

    private final CustomerFacade customerFacade;

    @GetMapping(value = "/{email}")
    public CustomerResponse retrieve(@PathVariable("email") String email) {
        log.info("searching the information for {}", email);
        return customerFacade.retrieveByEmail(email);
    }
}
