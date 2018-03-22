package nl.ing.java.guild.core.client;

import lombok.AllArgsConstructor;
import nl.ing.java.client.customer.PortClient;
import nl.ing.java.guild.core.domain.order.CustomerFacade;

@AllArgsConstructor
public class PortImporter {
    private PortClient portClient;
    private CustomerFacade customerFacade;
}
