package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.customer.Container;
import nl.ing.java.client.customer.CustomerRequest;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.guild.core.domain.error.ResourceNotFound;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@AllArgsConstructor
public class CustomerFacade {
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public CustomerResponse retrieveByEmail(String email) {
        log.info("client data request");
        return clientRepository.findByEmail(email)
                .map(CustomerFacade::toResponse)
                .orElseThrow(() -> new ResourceNotFound(email));
    }

    private static CustomerResponse toResponse(ClientEntity client) {
        List<Container> containers = client.getContainers().stream()
                .map(CustomerFacade::toContainer)
                .collect(Collectors.toList());
        return new CustomerResponse(containers);
    }

    private static Container toContainer(ContainerEntity container) {
        return Container.builder()
                .containerId(container.getId().toString())
                .info(container.getDescription())
                .location(container.getFinalDestination())
                .name("someName")
                .size(container.getSize()).build();

    }
}
