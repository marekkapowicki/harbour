package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.customer.ActionDTO;
import nl.ing.java.client.customer.Container;
import nl.ing.java.client.customer.ContainerDetail;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.guild.core.domain.error.ResourceNotFound;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@AllArgsConstructor
public class CustomerFacade {
    private final ClientRepository clientRepository;
    private final ContainerRepository containerRepository;
    private final StatusRepository statusRepository;

    @Transactional
    public Long store(String email, Container container) {
        log.info("adding the {} for client {}", container, email);
        ClientEntity client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFound(email));
        client.getContainers().add(toContainerEntity(client, container));
        clientRepository.save(client); //is it necessary
        return client.getId();
    }

    @Transactional(readOnly = true)
    public CustomerResponse retrieveByEmail(String email) {
        log.info("client data request");
        return clientRepository.findByEmail(email)
                .map(CustomerFacade::toResponse)
                .orElseThrow(() -> new ResourceNotFound(email));
    }

    public Container getContainerDetails(String email, String containerId) {
        retrieveByEmail(email);
        log.info("client containers data request");
        return containerRepository.findById(Long.valueOf(containerId))
                .map(CustomerFacade::toContainerDetail)
                .orElseThrow(() -> new ResourceNotFound(containerId));
    }


    private static Container toContainerDetail(ContainerEntity container) {
        return Container.builder()
                .containerId(container.getId().toString())
                .info(container.getDescription())
                .location(container.getFinalDestination())
                .name(container.getName())
                .size(container.getSize())
                .containerDetail(ContainerDetail.builder()
                        .status(container.getStatus().getName())
                        .actions(fakeActions())
                        .build())
                .build();

    }

    private static List<ActionDTO> fakeActions() {
        ActionDTO action1 = ActionDTO.builder()
                .completed(true)
                .description("Summary Declarations").build();

        ActionDTO action2 = ActionDTO.builder()
                .completed(false)
                .description("Inspection").build();

        return Arrays.asList(action1,action2);
    }

    private static CustomerResponse toResponse(ClientEntity client) {
        List<Container> containers = client.getContainers().stream()
                .map(CustomerFacade::toContainer)
                .collect(Collectors.toList());
        return new CustomerResponse(containers);
    }

    private  ContainerEntity toContainerEntity(ClientEntity client, Container container) {
        StatusEntity status_sea = statusRepository.findBy(Status.sea)
                .orElseThrow(() -> new ResourceNotFound("status sea"));
        return new ContainerEntity(client, null, status_sea, BigDecimal.ZERO,
                container.getLocation(), container.getSize(), container.getInfo(), container.getName());
    }

    private static Container toContainer(ContainerEntity container) {
        return Container.builder()
                .containerId(container.getId().toString())
                .info(container.getDescription())
                .name(container.getName())
                .location(container.getFinalDestination())
                .size(container.getSize()).build();

    }
}
