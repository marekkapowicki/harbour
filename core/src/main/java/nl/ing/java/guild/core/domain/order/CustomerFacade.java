package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.customer.CustomerRequest;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.guild.core.domain.error.ResourceNotFound;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@AllArgsConstructor
public class CustomerFacade {
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public CustomerResponse retrieveByEmail(CustomerRequest request) {
        log.info("client data request");
        return clientRepository.findByEmail(request.getEmail())
                .map(CustomerFacade::toResponse)
                .orElseThrow(() -> new ResourceNotFound(request.getEmail()));
    }

    private static CustomerResponse toResponse(ClientEntity client) {
        return null;
    }
}
