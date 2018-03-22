package nl.ing.java.guild.port.api;

import nl.ing.java.client.customer.Container;

public class Cointainers {
    static Container apples = Container.builder()
            .containerId("someId_1")
            .name("apples")
            .size("10")
            .location("Utrecht")
            .info("some apples")
            .build();
    static Container plums = Container.builder()
            .containerId("someId_2")
            .name("plums")
            .size("10")
            .location("Warsaw")
            .info("some plums")
            .build();
}
