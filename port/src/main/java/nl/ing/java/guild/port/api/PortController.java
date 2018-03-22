package nl.ing.java.guild.port.api;

import com.google.common.collect.Lists;
import nl.ing.java.client.customer.Shipment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static nl.ing.java.guild.port.api.Cointainers.apples;
import static nl.ing.java.guild.port.api.Cointainers.mangos;
import static nl.ing.java.guild.port.api.Cointainers.plums;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/port/api/shipments")
public class PortController {

    @GetMapping(consumes = APPLICATION_JSON_VALUE , produces = APPLICATION_JSON_VALUE)
    public List<Shipment> ports() {
        Shipment applesShipment = new Shipment("ashish.jain@ing.com", apples);
        Shipment plumShipment = new Shipment("ashish.jain@ing.com", plums);
        Shipment mangoShipment = new Shipment("ashish.jain@ing.com", mangos);
        return Lists.newArrayList(applesShipment, plumShipment,mangoShipment);
    }
}
