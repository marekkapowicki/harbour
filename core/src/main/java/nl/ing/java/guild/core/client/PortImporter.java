package nl.ing.java.guild.core.client;

import lombok.AllArgsConstructor;
import nl.ing.java.client.customer.PortClient;
import nl.ing.java.client.customer.Shipment;
import nl.ing.java.guild.core.domain.order.CustomerFacade;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class PortImporter {
    private PortClient portClient;
    private CustomerFacade customerFacade;

    public void importData() throws IOException {
        List<Shipment> shipments = portClient.getAll();
        shipments
                .forEach(shipment -> customerFacade.store(shipment.getEmail(), shipment.getContainer()));
    }
}
