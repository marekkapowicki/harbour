package nl.ing.java.guild.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ClientFacade {
    private final ClientRepository clientRepository;

    public Long retrieveByEmail(String email) {
        return null;
    }
}
