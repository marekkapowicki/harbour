package nl.ing.java.guild.port.api;

import nl.ing.java.client.customer.Container;

public class Cointainers {
    static Container apples = Container.builder()
            .containerId("someId_1")
            .name("Shipment # 1")
            .size("40 ft")
            .location("Utrecht")
            .info("some apples")
            .build();
    static Container plums = Container.builder()
            .containerId("someId_2")
            .name("Shipment # 2")
            .size("50 ft")
            .location("Warsaw")
            .info("some plums")
            .build();
    static Container mangos = Container.builder()
            .containerId("someId_3")
            .name("Shipment # 3")
            .size("60 ft")
            .location("Warsaw")
            .info("some plums")
            .build();
}
