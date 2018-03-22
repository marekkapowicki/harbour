package nl.ing.java.guild.core.api.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.customer.Container;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.guild.core.domain.order.CustomerFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(value = "/{email}/containers/{containerId}")
    public Container retrieve(@PathVariable("email") String email, @PathVariable("containerId") String containerId) {
        log.info("searching the information for {}", email);
        return customerFacade.getContainerDetails(email, containerId);
    }

    @PutMapping(value = "/{email}/containers/{containerId}/{newStatus}")
    public ResponseEntity<?> changeStatus(@PathVariable("email") String email,
                                          @PathVariable("containerId") String containerId,
                                          @PathVariable("newStatus") String newStatus) {
        log.info("searching the information for {}", email);
        customerFacade.changeStatus(email, containerId, newStatus);
        return ResponseEntity.noContent().build();
    }
}
