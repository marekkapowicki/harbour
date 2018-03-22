package nl.ing.java.guild.core.client;

import nl.ing.java.client.customer.PortClient;
import nl.ing.java.guild.core.domain.order.CustomerFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public PortImporter portImporter(CustomerFacade customerFacade) {
        return new PortImporter(PortClient.build("http://localhost:8888/port/api/"), customerFacade);
    }
}
